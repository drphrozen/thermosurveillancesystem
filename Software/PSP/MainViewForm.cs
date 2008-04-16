using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using PSP.TSSServer;
using System.Net;
using System.Web;

namespace PSP
{
	public partial class MainViewForm : Form
	{
		#region Snask
		UserFacadeService userService = null;
		List<Station> stations = null;
		Timer refreshTimer = null;

		public MainViewForm()
		{
			InitializeComponent();
			LogOut();
		}
		private void MainViewForm_FormClosing(object sender, FormClosingEventArgs e)
		{
			ExitApplication();
		}
		private void ExitApplication()
		{
			LogOut();
			Application.Exit();
		}
		#endregion

		#region Menues
		private void loginToolStripMenuItem_Click(object sender, EventArgs e)
		{
			userService = new UserFacadeService();
			userService.CookieContainer = new CookieContainer();

			LoginDialog ld = new LoginDialog();
			ld.UserService = userService;
			if (ld.ShowDialog() == DialogResult.OK)
			{
				LogIn(ld.Username);
			}
		}
		private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
		{
			LogOut();
		}
		private void exitToolStripMenuItem_Click(object sender, EventArgs e)
		{
			ExitApplication();
		}
		#endregion

		#region Session control
		private void LogIn(string username)
		{
			this.Text = "PSP - Logged in as " + username;
			tabControlDisplay.SelectTab(0);
			loginToolStripMenuItem.Visible = false;
			logoutToolStripMenuItem.Visible = true;
			tabControlDisplay.Visible = true;
			refreshTimer = new Timer();
			refreshTimer.Interval = 30 * 1000;
			refreshTimer.Tick += RefreshCurrentView;
			refreshTimer.Enabled = true;
			RefreshCurrentView(null, null);
		}
		private void LogOut()
		{
			this.Text = "PSP";
			loginToolStripMenuItem.Visible = true;
			logoutToolStripMenuItem.Visible = false;
			tabControlDisplay.Visible = false;
			refreshTimer = null;
		}
		#endregion

		#region Get readings
		private void GetReadings()
		{
			List<ReadingStationDTO> dtos = new List<ReadingStationDTO>();
			dtos.AddRange(userService.getNewestReadings());
			stations = new List<Station>();
			foreach (ReadingStationDTO dto in dtos)
			{
				stations.Add(new Station(dto));
			}
		}
		private void GetReadings(TimeSpan time)
		{
			List<ReadingStationDTO> dtos = new List<ReadingStationDTO>();
			dtos.AddRange(userService.getReadings(DateTime.Now, DateTime.Now.Subtract(time)));
			stations = new List<Station>();
			foreach (ReadingStationDTO dto in dtos)
			{
				stations.Add(new Station(dto));
			}
		}
		#endregion

		#region Refresh views
		private void RefreshCurrentView(object sender, EventArgs e)
		{
			switch (tabControlDisplay.SelectedTab.Name)
			{
				case "tabPageStations":
					GetReadings();
					RefreshStationsView();
					break;
				case "tabPageSummary":
					RefreshSummaryView();
					break;
			}
		}
		private void treeViewStations_AfterSelect(object sender, TreeViewEventArgs e)
		{
			TreeNode node = treeViewStations.SelectedNode;

			if (node.Tag.GetType() == typeof(Probe))
			{
				RefreshStationsDetailViewFromProbeNode(node);
			}
			else if (node.Tag.GetType() == typeof(Station))
			{
				RefreshStationsDetailViewFromStationNode(node);
			}
		}

		#region Stations view
		private void RefreshStationsView()
		{
			GetReadings();
			treeViewStations.SuspendLayout();
			treeViewStations.Nodes.Clear();
			foreach (Station s in stations)
			{
				treeViewStations.Nodes.Add(s.GetAsTreeNode());
			}
			treeViewStations.ResumeLayout(true);
			labelStationName.Text = "";
			labelProbeId.Text = "";
			labelCurrentTemperatur.Text = "";
			labelUpperAlarm.Text = "";
			labelLowerAlarm.Text = "";
			labelCurrentText.Visible = false;
			labelUpperAlarmText.Visible = false;
			labelLowerAlarmText.Visible = false;
		}
		public void RefreshStationsDetailViewFromProbeNode(TreeNode node)
		{
			Station station = (Station)node.Parent.Tag;
			Probe probe = (Probe)node.Tag;

			labelStationName.Text = station.Name;
			labelProbeId.Text = probe.Id.ToString();
			labelCurrentTemperatur.Text = probe.Data.ToString() + " " + probe.Units;
			if (probe.UpperAlarmRaised())
			{
				labelUpperAlarm.ForeColor = Color.Red;
			}
			else
			{
				labelUpperAlarm.ForeColor = Color.FromKnownColor(KnownColor.ControlText);
			}
			labelUpperAlarm.Text = probe.UpperAlarm.ToString() + " " + probe.Units;
			if (probe.LowerAlarmRaised())
			{
				labelLowerAlarm.ForeColor = Color.Red;
			}
			else
			{
				labelLowerAlarm.ForeColor = Color.FromKnownColor(KnownColor.ControlText);
			}
			labelLowerAlarm.Text = probe.LowerAlarm.ToString() + " " + probe.Units;
			labelCurrentText.Visible = true;
			labelUpperAlarmText.Visible = true;
			labelLowerAlarmText.Visible = true;
		}
		public void RefreshStationsDetailViewFromStationNode(TreeNode node)
		{
			Station station = (Station)node.Tag;

			labelStationName.Text = station.Name;
			labelProbeId.Text = "";
			labelCurrentTemperatur.Text = "";
			labelUpperAlarm.Text = "";
			labelLowerAlarm.Text = "";
			labelCurrentText.Visible = false;
			labelUpperAlarmText.Visible = false;
			labelLowerAlarmText.Visible = false;
		}
		#endregion

		#region Summary
		private void RefreshSummaryView()
		{

		}
		#endregion
		#endregion
	}
}