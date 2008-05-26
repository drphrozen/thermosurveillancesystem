using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using SAP;
using SAP.AdminFacade;
using System.Diagnostics;
using System.Net;
using dk.iha.onk.group1.dataTransferObjects;

namespace SAP
{
    public partial class SAPForm : Form
    {
        private AdminFacadeService service = null;
        
        public SAPForm()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            changeStatus(false);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            buttonConnect.Enabled = false;
            textBoxLoginUsername.Enabled = false;
            textBoxLoginPassword.Enabled = false;
            Application.DoEvents();
            DialogResult result = DialogResult.Cancel;
            do
            {
                try
                {
                    changeStatus(false);
                    if (service is AdminFacadeService)
                        service.loginCompleted -= new loginCompletedEventHandler(service_loginCompleted);
                    log("Connecting..");
                    service = new AdminFacadeService();

                    User user = new User();
                    user.Username = textBoxLoginUsername.Text;
                    user.Password = textBoxLoginPassword.Text;
                    user.AccountTypeID = User.AccountType.ADMIN;
                    UserDTO userdto = user.GetUserDTO();

                    log("Logging in..");
                    service.loginCompleted += new loginCompletedEventHandler(service_loginCompleted);
                    service.loginAsync(userdto, textBoxURL.Text);
                }
                catch (Exception ex)
                {
                    log("Failed to setup connection: " + ex.Message);
                    result = MessageBox.Show(this, ex.Message, "Failed to login.", MessageBoxButtons.RetryCancel, MessageBoxIcon.Error);
                    buttonConnect.Enabled = true;
                    textBoxLoginUsername.Enabled = true;
                    textBoxLoginPassword.Enabled = true;
                }
            }while(result == DialogResult.Retry);
        }

        void service_loginCompleted(object sender, loginCompletedEventArgs e)
        {
            if (e.Error == null)
            {
                if (e.Result == false)
                    log("Failed to login: Username or password is incorrect.");
                else
                    log("Login succeeded..");
                changeStatus(e.Result);
            }
            else
            {
                log("Failed to login: " + e.Error.Message);
                changeStatus(false);
            }
            buttonConnect.Enabled = true;
            textBoxLoginUsername.Enabled = true;
            textBoxLoginPassword.Enabled = true;
        }

        private void changeStatus(bool isLoggedIn)
        {
            if (isLoggedIn)
            {
                tabControl.TabPages.Add(tabPageReadingStations);
                tabControl.TabPages.Add(tabPageUsers);
                tabControl.SelectTab(tabPageReadingStations);
            }
            else
            {
                if (tabControl.SelectedTab == tabPageReadingStations || tabControl.SelectedTab == tabPageUsers)
                    tabControl.SelectTab(tabPageLogin);
                tabControl.TabPages.Remove(tabPageReadingStations);
                tabControl.TabPages.Remove(tabPageUsers);
                listBoxReadingStations.Items.Clear();
                listBoxUsers.Items.Clear();
                propertyGridReadingStation.SelectedObject = null;
                propertyGridUsers.SelectedObject = null;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                log("Refreshing reading stations..");
                ReadingStation[] rss = ReadingStation.GetReadingStations(service.getReadingStations());
                propertyGridReadingStation.SelectedObject = null;
                listBoxReadingStations.Items.Clear();
                listBoxReadingStations.Items.AddRange(rss);
                log("Got " + rss.Length + " reading stations.");
            }
            catch (Exception ex)
            {
                log("Failed to refresh reading stations: " + ex.Message);
            }
        }

        private void log(string message)
        {
            int index = listBoxLog.Items.Add(message);
            Application.DoEvents();
            listBoxLog.TopIndex = index;
        }

        private void listBoxReadingStations_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(listBoxReadingStations.SelectedIndex >= 0)
                propertyGridReadingStation.SelectedObject = listBoxReadingStations.SelectedItem;
        }

        private void propertyGridReadingStations_PropertyValueChanged(object s, PropertyValueChangedEventArgs e)
        {
            if (propertyGridReadingStation.SelectedObject is ReadingStation)
            {
                ReadingStation rs = (ReadingStation)propertyGridReadingStation.SelectedObject;
                switch (e.ChangedItem.Label)
                {
                    case "Name":
                        try
                        {
                            log(String.Format("Changing \"{0}\" to \"{1}\"", (String)e.OldValue, (String)e.ChangedItem.Value));
                            if (service.setRSName(rs.ID, (String)e.ChangedItem.Value))
                            {
                                log(String.Format("Reading station renamed from \"{0}\" to \"{1}\"", (String)e.OldValue, (String)e.ChangedItem.Value));
                                int index = listBoxReadingStations.Items.IndexOf(rs);
                                listBoxReadingStations.Items[index] = rs;
                            }
                            else
                            {
                                rs.Name = (string)e.OldValue;
                                log(String.Format("Could not rename reading station from \"{0}\" to \"{1}\"", (String)e.OldValue, (String)e.ChangedItem.Value));
                            }
                        }
                        catch (Exception ex)
                        {
                            log("Name change failed: " + ex.Message);
                        }
                        break;
                    case "Enabled":
                        bool enable = ((bool)e.ChangedItem.Value);
                        try
                        {
                            log((enable ? "Enabling" : "Disabling") + " " + rs.Name + "..");
                            if ((enable ? service.enableRS(rs.Name) : service.disableRS(rs.Name)))
                            {
                                log(rs.Name + " is now " + (((bool)e.ChangedItem.Value) ? " enabled." : " disabled."));
                                int index = listBoxReadingStations.Items.IndexOf(rs);
                                listBoxReadingStations.Items[index] = rs;
                            }
                            else
                            {
                                rs.Enabled = (bool)e.OldValue;
                                log("Could not " + (enable ? "enable" : "disable") + " " + rs.Name);
                            }
                        }
                        catch (Exception ex)
                        {
                            log((enable ? "Enabling" : "Disabling") + " failed for " + rs.Name + ": " + ex.Message);
                        }
                        break;
                    case "LowerAlarm":
                        Probe probe = (Probe)e.ChangedItem.Parent.Value;
                        try
                        {
                            log("Setting probe #" + probe.ID + "'s alarm limits to " + probe.LowerAlarm + " - " + probe.UpperAlarm);
                            if(service.setProbeAlarmLevel(probe.ID, probe.LowerAlarm, probe.UpperAlarm))
                            {
                                log("Changed probe #" + probe.ID + "'s alarm limits to " + probe.LowerAlarm + " - " + probe.UpperAlarm + ".");
                            }
                            else
                            {
                                probe.LowerAlarm = (double)e.OldValue;
                                log("Could not change probe #" + probe.ID + "'s alarm limits to " + probe.LowerAlarm + " - " + probe.UpperAlarm + "!");
                            }
                        }
                        catch (Exception ex)
                        {
                            log("Could not change probe #" + probe.ID + "'s alarm limits: " + ex.Message);
                        }
                        break;
                    case "UpperAlarm":
                        probe = (Probe)e.ChangedItem.Parent.Value;
                        try
                        {
                            log("Setting probe #" + probe.ID + "'s alarm limits to " + probe.LowerAlarm + " - " + probe.UpperAlarm);
                            if (service.setProbeAlarmLevel(probe.ID, probe.LowerAlarm, probe.UpperAlarm))
                            {
                                log("Changed probe #" + probe.ID + "'s alarm limits to " + probe.LowerAlarm + " - " + probe.UpperAlarm + ".");
                            }
                            else
                            {
                                probe.UpperAlarm = (double)e.OldValue;
                                log("Could not change probe #" + probe.ID + "'s alarm limits to " + probe.LowerAlarm + " - " + probe.UpperAlarm + "!");
                            }
                        }
                        catch (Exception ex)
                        {
                            log("Could not change probe #" + probe.ID + "'s alarm limits: " + ex.Message);
                        }
                        break;
                }
            }
        }

        private void SAPForm_Shown(object sender, EventArgs e)
        {
            textBoxLoginUsername.Focus();
        }

        private void textBox1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
                button1_Click(sender, e);
        }

        private void textBox2_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
                button1_Click(sender, e);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                log("Refreshing users..");
                User[] users = User.GetUsers(service.getUsers());
                propertyGridUsers.SelectedObject = null;
                listBoxUsers.Items.Clear();
                listBoxUsers.Items.AddRange(users);
                log("Got " + users.Length + " users.");
            }
            catch (Exception ex)
            {
                log("Failed to refresh reading stations: " + ex.Message);
            }
        }

        private void buttonAddUser_Click(object sender, EventArgs e)
        {
            User user = new User();
            user.Username = textBoxUsername.Text;
            user.Password = textBoxPassword.Text;
            if (checkBoxIsAdmin.Checked)
                user.AccountTypeID = User.AccountType.ADMIN;
            else
                user.AccountTypeID = User.AccountType.USER;
            try
            {
                if (service.addUser(user.GetUserDTO()))
                {
                    listBoxUsers.Items.Add(user);
                    log(user.Username + " added.");
                }
                else
                {
                    log("Could not add " + user.Username + "!");
                }
            }
            catch (Exception ex)
            {
                log("Failed to add " + user.Username + ": " + ex.Message);
            }
        }

        private void listBoxUsers_KeyUp(object sender, KeyEventArgs e)
        {
            if (listBoxUsers.SelectedItem is User && e.KeyCode == Keys.Delete)
            {
                User user = (User)listBoxUsers.SelectedItem;
                log("Removing " + user.Username);
                try
                {
                    if (service.removeUser(user.Username))
                    {
                        listBoxUsers.Items.Remove(user);
                        log(user.Username + " removed.");
                    }
                    else
                    {
                        log("Could not remove " + user.Username + "!");
                    }
                }
                catch (Exception ex)
                {
                    log("Failed to remove " + user.Username + ": " + ex.Message);
                }
            }
        }

        private void listBoxUsers_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listBoxUsers.SelectedIndex >= 0)
                propertyGridUsers.SelectedObject = listBoxUsers.SelectedItem;
        }

        private void propertyGridUsers_PropertyValueChanged(object s, PropertyValueChangedEventArgs e)
        {
            if (propertyGridUsers.SelectedObject is User)
            {
                User user = (User)propertyGridUsers.SelectedObject;
                User oldUser = new User(user);
                try
                {
                    switch (e.ChangedItem.Label)
                    {
                        case "Username":
                            oldUser.Username = (string)e.OldValue;
                            break;
                        case "Password":
                            oldUser.Password = (string)e.OldValue;
                            break;
                        case "AccountTypeID":
                            oldUser.AccountTypeID = (User.AccountType)e.OldValue;
                            break;
                        default:
                            throw new Exception("Wrong value change implementation of " + e.ChangedItem.Label + " in " + e.ChangedItem.Parent.Value.GetType().Name);
                    }
                    log("Updating " + user.Username);
                    if (service.updateUserInfo(oldUser.ID, user.GetUserDTO()))
                    {
                        int index = listBoxUsers.Items.IndexOf(user);
                        listBoxUsers.Items[index] = user;
                        log(user.Username + " updated!");
                    }
                    else
                    {
                        switch (e.ChangedItem.Label)
                        {
                            case "Username":
                                user.Username = (string)e.OldValue;
                                break;
                            case "Password":
                                user.Password = (string)e.OldValue;
                                break;
                            case "AccountTypeID":
                                user.AccountTypeID = (User.AccountType)e.OldValue;
                                break;
                        }
                        log(user.Username + " could not be updated!");
                    }
                }
                catch (Exception ex)
                {
                    log("Could not update " + user.Username + ": " + ex.Message + "!");
                }
            }
        }

        private void SAPForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Properties.Settings.Default.Save();
        }
    }
}