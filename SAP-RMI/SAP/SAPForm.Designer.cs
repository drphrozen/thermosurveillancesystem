namespace SAP
{
    partial class SAPForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tabControl = new System.Windows.Forms.TabControl();
            this.tabPageLogin = new System.Windows.Forms.TabPage();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxLoginPassword = new System.Windows.Forms.TextBox();
            this.textBoxLoginUsername = new System.Windows.Forms.TextBox();
            this.buttonConnect = new System.Windows.Forms.Button();
            this.tabPageReadingStations = new System.Windows.Forms.TabPage();
            this.buttonRefreshReadingStations = new System.Windows.Forms.Button();
            this.listBoxReadingStations = new System.Windows.Forms.ListBox();
            this.tabPageUsers = new System.Windows.Forms.TabPage();
            this.buttonAddUser = new System.Windows.Forms.Button();
            this.checkBoxIsAdmin = new System.Windows.Forms.CheckBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxUsername = new System.Windows.Forms.TextBox();
            this.textBoxPassword = new System.Windows.Forms.TextBox();
            this.buttonRefreshUsers = new System.Windows.Forms.Button();
            this.listBoxUsers = new System.Windows.Forms.ListBox();
            this.listBoxLog = new System.Windows.Forms.ListBox();
            this.propertyGridReadingStation = new System.Windows.Forms.PropertyGrid();
            this.propertyGridUsers = new System.Windows.Forms.PropertyGrid();
            this.tabControl.SuspendLayout();
            this.tabPageLogin.SuspendLayout();
            this.tabPageReadingStations.SuspendLayout();
            this.tabPageUsers.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl
            // 
            this.tabControl.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.tabControl.Controls.Add(this.tabPageLogin);
            this.tabControl.Controls.Add(this.tabPageReadingStations);
            this.tabControl.Controls.Add(this.tabPageUsers);
            this.tabControl.Location = new System.Drawing.Point(12, 12);
            this.tabControl.Name = "tabControl";
            this.tabControl.SelectedIndex = 0;
            this.tabControl.Size = new System.Drawing.Size(768, 391);
            this.tabControl.TabIndex = 0;
            // 
            // tabPageLogin
            // 
            this.tabPageLogin.Controls.Add(this.label2);
            this.tabPageLogin.Controls.Add(this.label1);
            this.tabPageLogin.Controls.Add(this.textBoxLoginPassword);
            this.tabPageLogin.Controls.Add(this.textBoxLoginUsername);
            this.tabPageLogin.Controls.Add(this.buttonConnect);
            this.tabPageLogin.Location = new System.Drawing.Point(4, 22);
            this.tabPageLogin.Name = "tabPageLogin";
            this.tabPageLogin.Padding = new System.Windows.Forms.Padding(3);
            this.tabPageLogin.Size = new System.Drawing.Size(760, 365);
            this.tabPageLogin.TabIndex = 0;
            this.tabPageLogin.Text = "Login";
            this.tabPageLogin.UseVisualStyleBackColor = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(173, 11);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Password";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 11);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(55, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Username";
            // 
            // textBoxLoginPassword
            // 
            this.textBoxLoginPassword.Location = new System.Drawing.Point(232, 8);
            this.textBoxLoginPassword.Name = "textBoxLoginPassword";
            this.textBoxLoginPassword.PasswordChar = '|';
            this.textBoxLoginPassword.Size = new System.Drawing.Size(100, 20);
            this.textBoxLoginPassword.TabIndex = 3;
            this.textBoxLoginPassword.KeyUp += new System.Windows.Forms.KeyEventHandler(this.textBox2_KeyUp);
            // 
            // textBoxLoginUsername
            // 
            this.textBoxLoginUsername.Location = new System.Drawing.Point(67, 8);
            this.textBoxLoginUsername.Name = "textBoxLoginUsername";
            this.textBoxLoginUsername.Size = new System.Drawing.Size(100, 20);
            this.textBoxLoginUsername.TabIndex = 1;
            this.textBoxLoginUsername.KeyUp += new System.Windows.Forms.KeyEventHandler(this.textBox1_KeyUp);
            // 
            // buttonConnect
            // 
            this.buttonConnect.Location = new System.Drawing.Point(338, 6);
            this.buttonConnect.Name = "buttonConnect";
            this.buttonConnect.Size = new System.Drawing.Size(75, 23);
            this.buttonConnect.TabIndex = 4;
            this.buttonConnect.Text = "Connect";
            this.buttonConnect.UseVisualStyleBackColor = true;
            this.buttonConnect.Click += new System.EventHandler(this.button1_Click);
            // 
            // tabPageReadingStations
            // 
            this.tabPageReadingStations.Controls.Add(this.propertyGridReadingStation);
            this.tabPageReadingStations.Controls.Add(this.buttonRefreshReadingStations);
            this.tabPageReadingStations.Controls.Add(this.listBoxReadingStations);
            this.tabPageReadingStations.Location = new System.Drawing.Point(4, 22);
            this.tabPageReadingStations.Name = "tabPageReadingStations";
            this.tabPageReadingStations.Padding = new System.Windows.Forms.Padding(3);
            this.tabPageReadingStations.Size = new System.Drawing.Size(760, 365);
            this.tabPageReadingStations.TabIndex = 1;
            this.tabPageReadingStations.Text = "Reading stations";
            this.tabPageReadingStations.UseVisualStyleBackColor = true;
            // 
            // buttonRefreshReadingStations
            // 
            this.buttonRefreshReadingStations.Location = new System.Drawing.Point(6, 6);
            this.buttonRefreshReadingStations.Name = "buttonRefreshReadingStations";
            this.buttonRefreshReadingStations.Size = new System.Drawing.Size(75, 23);
            this.buttonRefreshReadingStations.TabIndex = 1;
            this.buttonRefreshReadingStations.Text = "Refresh";
            this.buttonRefreshReadingStations.UseVisualStyleBackColor = true;
            this.buttonRefreshReadingStations.Click += new System.EventHandler(this.button2_Click);
            // 
            // listBoxReadingStations
            // 
            this.listBoxReadingStations.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.listBoxReadingStations.FormattingEnabled = true;
            this.listBoxReadingStations.IntegralHeight = false;
            this.listBoxReadingStations.Location = new System.Drawing.Point(6, 35);
            this.listBoxReadingStations.Name = "listBoxReadingStations";
            this.listBoxReadingStations.Size = new System.Drawing.Size(453, 324);
            this.listBoxReadingStations.TabIndex = 0;
            this.listBoxReadingStations.SelectedIndexChanged += new System.EventHandler(this.listBoxReadingStations_SelectedIndexChanged);
            // 
            // tabPageUsers
            // 
            this.tabPageUsers.Controls.Add(this.buttonAddUser);
            this.tabPageUsers.Controls.Add(this.checkBoxIsAdmin);
            this.tabPageUsers.Controls.Add(this.label4);
            this.tabPageUsers.Controls.Add(this.label3);
            this.tabPageUsers.Controls.Add(this.textBoxUsername);
            this.tabPageUsers.Controls.Add(this.textBoxPassword);
            this.tabPageUsers.Controls.Add(this.propertyGridUsers);
            this.tabPageUsers.Controls.Add(this.buttonRefreshUsers);
            this.tabPageUsers.Controls.Add(this.listBoxUsers);
            this.tabPageUsers.Location = new System.Drawing.Point(4, 22);
            this.tabPageUsers.Name = "tabPageUsers";
            this.tabPageUsers.Padding = new System.Windows.Forms.Padding(3);
            this.tabPageUsers.Size = new System.Drawing.Size(760, 365);
            this.tabPageUsers.TabIndex = 2;
            this.tabPageUsers.Text = "Users";
            this.tabPageUsers.UseVisualStyleBackColor = true;
            // 
            // buttonAddUser
            // 
            this.buttonAddUser.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.buttonAddUser.Location = new System.Drawing.Point(399, 336);
            this.buttonAddUser.Name = "buttonAddUser";
            this.buttonAddUser.Size = new System.Drawing.Size(79, 23);
            this.buttonAddUser.TabIndex = 9;
            this.buttonAddUser.Text = "Add";
            this.buttonAddUser.UseVisualStyleBackColor = true;
            this.buttonAddUser.Click += new System.EventHandler(this.buttonAddUser_Click);
            // 
            // checkBoxIsAdmin
            // 
            this.checkBoxIsAdmin.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.checkBoxIsAdmin.AutoSize = true;
            this.checkBoxIsAdmin.Location = new System.Drawing.Point(338, 340);
            this.checkBoxIsAdmin.Name = "checkBoxIsAdmin";
            this.checkBoxIsAdmin.Size = new System.Drawing.Size(55, 17);
            this.checkBoxIsAdmin.TabIndex = 14;
            this.checkBoxIsAdmin.Text = "Admin";
            this.checkBoxIsAdmin.UseVisualStyleBackColor = true;
            // 
            // label4
            // 
            this.label4.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(173, 341);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(53, 13);
            this.label4.TabIndex = 13;
            this.label4.Text = "Password";
            // 
            // label3
            // 
            this.label3.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 341);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(55, 13);
            this.label3.TabIndex = 12;
            this.label3.Text = "Username";
            // 
            // textBoxUsername
            // 
            this.textBoxUsername.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.textBoxUsername.Location = new System.Drawing.Point(67, 338);
            this.textBoxUsername.Name = "textBoxUsername";
            this.textBoxUsername.Size = new System.Drawing.Size(100, 20);
            this.textBoxUsername.TabIndex = 11;
            // 
            // textBoxPassword
            // 
            this.textBoxPassword.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.textBoxPassword.Location = new System.Drawing.Point(232, 338);
            this.textBoxPassword.Name = "textBoxPassword";
            this.textBoxPassword.Size = new System.Drawing.Size(100, 20);
            this.textBoxPassword.TabIndex = 10;
            this.textBoxPassword.UseSystemPasswordChar = true;
            // 
            // buttonRefreshUsers
            // 
            this.buttonRefreshUsers.Location = new System.Drawing.Point(6, 6);
            this.buttonRefreshUsers.Name = "buttonRefreshUsers";
            this.buttonRefreshUsers.Size = new System.Drawing.Size(75, 23);
            this.buttonRefreshUsers.TabIndex = 7;
            this.buttonRefreshUsers.Text = "Refresh";
            this.buttonRefreshUsers.UseVisualStyleBackColor = true;
            this.buttonRefreshUsers.Click += new System.EventHandler(this.button3_Click);
            // 
            // listBoxUsers
            // 
            this.listBoxUsers.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.listBoxUsers.FormattingEnabled = true;
            this.listBoxUsers.IntegralHeight = false;
            this.listBoxUsers.Location = new System.Drawing.Point(6, 35);
            this.listBoxUsers.Name = "listBoxUsers";
            this.listBoxUsers.Size = new System.Drawing.Size(453, 295);
            this.listBoxUsers.TabIndex = 6;
            this.listBoxUsers.SelectedIndexChanged += new System.EventHandler(this.listBoxUsers_SelectedIndexChanged);
            this.listBoxUsers.KeyUp += new System.Windows.Forms.KeyEventHandler(this.listBoxUsers_KeyUp);
            // 
            // listBoxLog
            // 
            this.listBoxLog.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.listBoxLog.FormattingEnabled = true;
            this.listBoxLog.Location = new System.Drawing.Point(12, 409);
            this.listBoxLog.Name = "listBoxLog";
            this.listBoxLog.ScrollAlwaysVisible = true;
            this.listBoxLog.Size = new System.Drawing.Size(768, 121);
            this.listBoxLog.TabIndex = 0;
            // 
            // propertyGridReadingStation
            // 
            this.propertyGridReadingStation.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.propertyGridReadingStation.Location = new System.Drawing.Point(465, 35);
            this.propertyGridReadingStation.Name = "propertyGridReadingStation";
            this.propertyGridReadingStation.Size = new System.Drawing.Size(289, 324);
            this.propertyGridReadingStation.TabIndex = 2;
            this.propertyGridReadingStation.PropertyValueChanged += new System.Windows.Forms.PropertyValueChangedEventHandler(this.propertyGridReadingStations_PropertyValueChanged);
            // 
            // propertyGridUsers
            // 
            this.propertyGridUsers.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.propertyGridUsers.Location = new System.Drawing.Point(465, 35);
            this.propertyGridUsers.Name = "propertyGridUsers";
            this.propertyGridUsers.Size = new System.Drawing.Size(289, 295);
            this.propertyGridUsers.TabIndex = 8;
            this.propertyGridUsers.PropertyValueChanged += new System.Windows.Forms.PropertyValueChangedEventHandler(this.propertyGridUsers_PropertyValueChanged);
            // 
            // SAPForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(792, 542);
            this.Controls.Add(this.listBoxLog);
            this.Controls.Add(this.tabControl);
            this.MinimumSize = new System.Drawing.Size(726, 576);
            this.Name = "SAPForm";
            this.Text = "SAP";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.Shown += new System.EventHandler(this.SAPForm_Shown);
            this.tabControl.ResumeLayout(false);
            this.tabPageLogin.ResumeLayout(false);
            this.tabPageLogin.PerformLayout();
            this.tabPageReadingStations.ResumeLayout(false);
            this.tabPageUsers.ResumeLayout(false);
            this.tabPageUsers.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl;
        private System.Windows.Forms.TabPage tabPageLogin;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxLoginPassword;
        private System.Windows.Forms.TextBox textBoxLoginUsername;
        private System.Windows.Forms.Button buttonConnect;
        private System.Windows.Forms.TabPage tabPageReadingStations;
        private System.Windows.Forms.ListBox listBoxLog;
        private System.Windows.Forms.ListBox listBoxReadingStations;
        private System.Windows.Forms.Button buttonRefreshReadingStations;
        private System.Windows.Forms.PropertyGrid propertyGridReadingStation;
        private System.Windows.Forms.TabPage tabPageUsers;
        private System.Windows.Forms.ListBox listBoxUsers;
        private System.Windows.Forms.Button buttonRefreshUsers;
        private System.Windows.Forms.PropertyGrid propertyGridUsers;
        private System.Windows.Forms.Button buttonAddUser;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBoxUsername;
        private System.Windows.Forms.TextBox textBoxPassword;
        private System.Windows.Forms.CheckBox checkBoxIsAdmin;


    }
}

