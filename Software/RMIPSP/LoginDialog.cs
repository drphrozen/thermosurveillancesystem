using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

using java.rmi;
using dk.iha.onk.group1.interfaces;
using dk.iha.onk.group1.dataTransferObjects;

namespace PSP
{
	public partial class LoginDialog : Form
	{
		public LoginDialog()
		{
			InitializeComponent();
		}

		private IUserFacade userService = null;
		public IUserFacade UserService
		{
			get { return userService; }
			set { userService = value; }
		}

		private ITssFacadeFactory facadeFactory = null;
		public ITssFacadeFactory FacadeFactory
		{
			get { return facadeFactory; }
			set { facadeFactory = value; }
		}

		public string Username
		{
			get { return textBoxUsername.Text; }
		}

		private void buttonLogin_Click(object sender, EventArgs e)
		{
			try
			{
				userService = (IUserFacade)facadeFactory.createFacade("UserFacade", textBoxUsername.Text, textBoxPassword.Text);

				if (userService != null)
				{
					DialogResult = DialogResult.OK;
				}
				else
				{
					MessageBox.Show("Invalid username or password", "That's a no go", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
					buttonLogin.Focus();
					textBoxUsername.Focus();
				}
			}
			catch (Exception ex)
			{
				MessageBox.Show(ex.Message);
				MessageBox.Show("Unable to communicate with server", "Oh ohh", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
			}
		}

		private void textBoxUsername_Enter(object sender, EventArgs e)
		{
			textBoxUsername.SelectAll();
		}

		private void textBoxPassword_Enter(object sender, EventArgs e)
		{
			textBoxPassword.SelectAll();
		}
	}
}