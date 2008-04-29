using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using PSP.TSSServer;

namespace PSP
{
	public partial class LoginDialog : Form
	{
		public LoginDialog()
		{
			InitializeComponent();
		}

		private UserFacadeService userService = null;
		public UserFacadeService UserService
		{
			get { return userService; }
			set { userService = value; }
		}

		public string Username
		{
			get { return textBoxUsername.Text; }
		}

		private void buttonLogin_Click(object sender, EventArgs e)
		{
			UserDTO user = new UserDTO();
			user.username = textBoxUsername.Text;
			user.password = textBoxPassword.Text;
			user.accountType = "user";
			try
			{
				if (userService.login(user))
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
			catch(Exception ex)
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