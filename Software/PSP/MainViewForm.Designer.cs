namespace PSP
{
	partial class MainViewForm
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
			this.components = new System.ComponentModel.Container();
			this.menuStripMainViewFormMenu = new System.Windows.Forms.MenuStrip();
			this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.loginToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.logoutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.tabControlDisplay = new System.Windows.Forms.TabControl();
			this.tabPageSummary = new System.Windows.Forms.TabPage();
			this.label6 = new System.Windows.Forms.Label();
			this.label5 = new System.Windows.Forms.Label();
			this.dateTimePickerSummaryTo = new System.Windows.Forms.DateTimePicker();
			this.dateTimePickerSummaryFrom = new System.Windows.Forms.DateTimePicker();
			this.labelSummaryHighestTemperature = new System.Windows.Forms.Label();
			this.labelSummaryLowestTemperature = new System.Windows.Forms.Label();
			this.labelSummaryLowestPressure = new System.Windows.Forms.Label();
			this.labelSummaryHighestPressure = new System.Windows.Forms.Label();
			this.label4 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.listBoxSummaryAlarms = new System.Windows.Forms.ListBox();
			this.label1 = new System.Windows.Forms.Label();
			this.tabPageStations = new System.Windows.Forms.TabPage();
			this.splitContainer1 = new System.Windows.Forms.SplitContainer();
			this.treeViewStations = new System.Windows.Forms.TreeView();
			this.zedGraphLastHour = new ZedGraph.ZedGraphControl();
			this.labelLowerAlarm = new System.Windows.Forms.Label();
			this.labelUpperAlarm = new System.Windows.Forms.Label();
			this.labelCurrentTemperatur = new System.Windows.Forms.Label();
			this.labelLowerAlarmText = new System.Windows.Forms.Label();
			this.labelUpperAlarmText = new System.Windows.Forms.Label();
			this.labelCurrentText = new System.Windows.Forms.Label();
			this.labelProbeId = new System.Windows.Forms.Label();
			this.labelStationName = new System.Windows.Forms.Label();
			this.menuStripMainViewFormMenu.SuspendLayout();
			this.tabControlDisplay.SuspendLayout();
			this.tabPageSummary.SuspendLayout();
			this.tabPageStations.SuspendLayout();
			this.splitContainer1.Panel1.SuspendLayout();
			this.splitContainer1.Panel2.SuspendLayout();
			this.splitContainer1.SuspendLayout();
			this.SuspendLayout();
			// 
			// menuStripMainViewFormMenu
			// 
			this.menuStripMainViewFormMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.exitToolStripMenuItem,
            this.loginToolStripMenuItem,
            this.logoutToolStripMenuItem});
			this.menuStripMainViewFormMenu.Location = new System.Drawing.Point(0, 0);
			this.menuStripMainViewFormMenu.Name = "menuStripMainViewFormMenu";
			this.menuStripMainViewFormMenu.Size = new System.Drawing.Size(532, 24);
			this.menuStripMainViewFormMenu.TabIndex = 0;
			this.menuStripMainViewFormMenu.Text = "menuStrip1";
			// 
			// exitToolStripMenuItem
			// 
			this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
			this.exitToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
			this.exitToolStripMenuItem.Text = "E&xit";
			this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
			// 
			// loginToolStripMenuItem
			// 
			this.loginToolStripMenuItem.Name = "loginToolStripMenuItem";
			this.loginToolStripMenuItem.Size = new System.Drawing.Size(44, 20);
			this.loginToolStripMenuItem.Text = "&Login";
			this.loginToolStripMenuItem.Click += new System.EventHandler(this.loginToolStripMenuItem_Click);
			// 
			// logoutToolStripMenuItem
			// 
			this.logoutToolStripMenuItem.Name = "logoutToolStripMenuItem";
			this.logoutToolStripMenuItem.Size = new System.Drawing.Size(52, 20);
			this.logoutToolStripMenuItem.Text = "&Logout";
			this.logoutToolStripMenuItem.Click += new System.EventHandler(this.logoutToolStripMenuItem_Click);
			// 
			// tabControlDisplay
			// 
			this.tabControlDisplay.Controls.Add(this.tabPageSummary);
			this.tabControlDisplay.Controls.Add(this.tabPageStations);
			this.tabControlDisplay.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tabControlDisplay.Location = new System.Drawing.Point(0, 24);
			this.tabControlDisplay.Name = "tabControlDisplay";
			this.tabControlDisplay.SelectedIndex = 0;
			this.tabControlDisplay.Size = new System.Drawing.Size(532, 355);
			this.tabControlDisplay.TabIndex = 1;
			this.tabControlDisplay.Selecting += new System.Windows.Forms.TabControlCancelEventHandler(this.RefreshCurrentView);
			// 
			// tabPageSummary
			// 
			this.tabPageSummary.Controls.Add(this.label6);
			this.tabPageSummary.Controls.Add(this.label5);
			this.tabPageSummary.Controls.Add(this.dateTimePickerSummaryTo);
			this.tabPageSummary.Controls.Add(this.dateTimePickerSummaryFrom);
			this.tabPageSummary.Controls.Add(this.labelSummaryHighestTemperature);
			this.tabPageSummary.Controls.Add(this.labelSummaryLowestTemperature);
			this.tabPageSummary.Controls.Add(this.labelSummaryLowestPressure);
			this.tabPageSummary.Controls.Add(this.labelSummaryHighestPressure);
			this.tabPageSummary.Controls.Add(this.label4);
			this.tabPageSummary.Controls.Add(this.label3);
			this.tabPageSummary.Controls.Add(this.label2);
			this.tabPageSummary.Controls.Add(this.listBoxSummaryAlarms);
			this.tabPageSummary.Controls.Add(this.label1);
			this.tabPageSummary.Location = new System.Drawing.Point(4, 22);
			this.tabPageSummary.Name = "tabPageSummary";
			this.tabPageSummary.Padding = new System.Windows.Forms.Padding(3);
			this.tabPageSummary.Size = new System.Drawing.Size(524, 329);
			this.tabPageSummary.TabIndex = 0;
			this.tabPageSummary.Text = "Summary";
			this.tabPageSummary.UseVisualStyleBackColor = true;
			// 
			// label6
			// 
			this.label6.AutoSize = true;
			this.label6.Location = new System.Drawing.Point(281, 296);
			this.label6.Name = "label6";
			this.label6.Size = new System.Drawing.Size(23, 13);
			this.label6.TabIndex = 18;
			this.label6.Text = "To:";
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.Location = new System.Drawing.Point(31, 296);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(33, 13);
			this.label5.TabIndex = 17;
			this.label5.Text = "From:";
			// 
			// dateTimePickerSummaryTo
			// 
			this.dateTimePickerSummaryTo.Location = new System.Drawing.Point(310, 292);
			this.dateTimePickerSummaryTo.Name = "dateTimePickerSummaryTo";
			this.dateTimePickerSummaryTo.Size = new System.Drawing.Size(124, 20);
			this.dateTimePickerSummaryTo.TabIndex = 16;
			this.dateTimePickerSummaryTo.ValueChanged += new System.EventHandler(this.dateTimePickerSummaryTo_ValueChanged);
			// 
			// dateTimePickerSummaryFrom
			// 
			this.dateTimePickerSummaryFrom.Location = new System.Drawing.Point(70, 292);
			this.dateTimePickerSummaryFrom.Name = "dateTimePickerSummaryFrom";
			this.dateTimePickerSummaryFrom.Size = new System.Drawing.Size(124, 20);
			this.dateTimePickerSummaryFrom.TabIndex = 15;
			this.dateTimePickerSummaryFrom.ValueChanged += new System.EventHandler(this.dateTimePickerSummaryFrom_ValueChanged);
			// 
			// labelSummaryHighestTemperature
			// 
			this.labelSummaryHighestTemperature.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelSummaryHighestTemperature.Location = new System.Drawing.Point(150, 26);
			this.labelSummaryHighestTemperature.Name = "labelSummaryHighestTemperature";
			this.labelSummaryHighestTemperature.Size = new System.Drawing.Size(97, 23);
			this.labelSummaryHighestTemperature.TabIndex = 12;
			this.labelSummaryHighestTemperature.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
			// 
			// labelSummaryLowestTemperature
			// 
			this.labelSummaryLowestTemperature.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelSummaryLowestTemperature.Location = new System.Drawing.Point(20, 26);
			this.labelSummaryLowestTemperature.Name = "labelSummaryLowestTemperature";
			this.labelSummaryLowestTemperature.Size = new System.Drawing.Size(97, 23);
			this.labelSummaryLowestTemperature.TabIndex = 11;
			this.labelSummaryLowestTemperature.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
			// 
			// labelSummaryLowestPressure
			// 
			this.labelSummaryLowestPressure.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelSummaryLowestPressure.Location = new System.Drawing.Point(280, 26);
			this.labelSummaryLowestPressure.Name = "labelSummaryLowestPressure";
			this.labelSummaryLowestPressure.Size = new System.Drawing.Size(97, 23);
			this.labelSummaryLowestPressure.TabIndex = 10;
			this.labelSummaryLowestPressure.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
			// 
			// labelSummaryHighestPressure
			// 
			this.labelSummaryHighestPressure.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelSummaryHighestPressure.Location = new System.Drawing.Point(410, 26);
			this.labelSummaryHighestPressure.Name = "labelSummaryHighestPressure";
			this.labelSummaryHighestPressure.Size = new System.Drawing.Size(97, 23);
			this.labelSummaryHighestPressure.TabIndex = 9;
			this.labelSummaryHighestPressure.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Location = new System.Drawing.Point(151, 13);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(102, 13);
			this.label4.TabIndex = 4;
			this.label4.Text = "Highest temperature";
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(21, 13);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(100, 13);
			this.label3.TabIndex = 3;
			this.label3.Text = "Lowest temperature";
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(281, 13);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(84, 13);
			this.label2.TabIndex = 2;
			this.label2.Text = "Lowest pressure";
			// 
			// listBoxSummaryAlarms
			// 
			this.listBoxSummaryAlarms.FormattingEnabled = true;
			this.listBoxSummaryAlarms.Location = new System.Drawing.Point(3, 61);
			this.listBoxSummaryAlarms.Name = "listBoxSummaryAlarms";
			this.listBoxSummaryAlarms.Size = new System.Drawing.Size(518, 212);
			this.listBoxSummaryAlarms.TabIndex = 1;
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(411, 13);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(86, 13);
			this.label1.TabIndex = 0;
			this.label1.Text = "Highest pressure";
			// 
			// tabPageStations
			// 
			this.tabPageStations.Controls.Add(this.splitContainer1);
			this.tabPageStations.Location = new System.Drawing.Point(4, 22);
			this.tabPageStations.Name = "tabPageStations";
			this.tabPageStations.Padding = new System.Windows.Forms.Padding(3);
			this.tabPageStations.Size = new System.Drawing.Size(524, 329);
			this.tabPageStations.TabIndex = 1;
			this.tabPageStations.Text = "Stations";
			this.tabPageStations.UseVisualStyleBackColor = true;
			// 
			// splitContainer1
			// 
			this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.splitContainer1.Location = new System.Drawing.Point(3, 3);
			this.splitContainer1.Name = "splitContainer1";
			// 
			// splitContainer1.Panel1
			// 
			this.splitContainer1.Panel1.Controls.Add(this.treeViewStations);
			// 
			// splitContainer1.Panel2
			// 
			this.splitContainer1.Panel2.Controls.Add(this.zedGraphLastHour);
			this.splitContainer1.Panel2.Controls.Add(this.labelLowerAlarm);
			this.splitContainer1.Panel2.Controls.Add(this.labelUpperAlarm);
			this.splitContainer1.Panel2.Controls.Add(this.labelCurrentTemperatur);
			this.splitContainer1.Panel2.Controls.Add(this.labelLowerAlarmText);
			this.splitContainer1.Panel2.Controls.Add(this.labelUpperAlarmText);
			this.splitContainer1.Panel2.Controls.Add(this.labelCurrentText);
			this.splitContainer1.Panel2.Controls.Add(this.labelProbeId);
			this.splitContainer1.Panel2.Controls.Add(this.labelStationName);
			this.splitContainer1.Size = new System.Drawing.Size(518, 323);
			this.splitContainer1.SplitterDistance = 247;
			this.splitContainer1.TabIndex = 0;
			// 
			// treeViewStations
			// 
			this.treeViewStations.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeViewStations.Location = new System.Drawing.Point(0, 0);
			this.treeViewStations.Name = "treeViewStations";
			this.treeViewStations.Size = new System.Drawing.Size(247, 323);
			this.treeViewStations.TabIndex = 0;
			this.treeViewStations.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treeViewStations_AfterSelect);
			// 
			// zedGraphLastHour
			// 
			this.zedGraphLastHour.Location = new System.Drawing.Point(2, 226);
			this.zedGraphLastHour.Name = "zedGraphLastHour";
			this.zedGraphLastHour.ScrollGrace = 0;
			this.zedGraphLastHour.ScrollMaxX = 0;
			this.zedGraphLastHour.ScrollMaxY = 0;
			this.zedGraphLastHour.ScrollMaxY2 = 0;
			this.zedGraphLastHour.ScrollMinX = 0;
			this.zedGraphLastHour.ScrollMinY = 0;
			this.zedGraphLastHour.ScrollMinY2 = 0;
			this.zedGraphLastHour.Size = new System.Drawing.Size(260, 92);
			this.zedGraphLastHour.TabIndex = 9;
			this.zedGraphLastHour.Visible = false;
			// 
			// labelLowerAlarm
			// 
			this.labelLowerAlarm.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelLowerAlarm.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelLowerAlarm.Location = new System.Drawing.Point(129, 190);
			this.labelLowerAlarm.Name = "labelLowerAlarm";
			this.labelLowerAlarm.Size = new System.Drawing.Size(118, 33);
			this.labelLowerAlarm.TabIndex = 7;
			this.labelLowerAlarm.TextAlign = System.Drawing.ContentAlignment.TopRight;
			// 
			// labelUpperAlarm
			// 
			this.labelUpperAlarm.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelUpperAlarm.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelUpperAlarm.Location = new System.Drawing.Point(129, 145);
			this.labelUpperAlarm.Name = "labelUpperAlarm";
			this.labelUpperAlarm.Size = new System.Drawing.Size(118, 33);
			this.labelUpperAlarm.TabIndex = 6;
			this.labelUpperAlarm.TextAlign = System.Drawing.ContentAlignment.TopRight;
			// 
			// labelCurrentTemperatur
			// 
			this.labelCurrentTemperatur.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelCurrentTemperatur.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelCurrentTemperatur.Location = new System.Drawing.Point(129, 100);
			this.labelCurrentTemperatur.Name = "labelCurrentTemperatur";
			this.labelCurrentTemperatur.Size = new System.Drawing.Size(118, 33);
			this.labelCurrentTemperatur.TabIndex = 5;
			this.labelCurrentTemperatur.TextAlign = System.Drawing.ContentAlignment.TopRight;
			// 
			// labelLowerAlarmText
			// 
			this.labelLowerAlarmText.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelLowerAlarmText.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelLowerAlarmText.Location = new System.Drawing.Point(5, 190);
			this.labelLowerAlarmText.Name = "labelLowerAlarmText";
			this.labelLowerAlarmText.Size = new System.Drawing.Size(118, 33);
			this.labelLowerAlarmText.TabIndex = 4;
			this.labelLowerAlarmText.Text = "Lower alarm:";
			// 
			// labelUpperAlarmText
			// 
			this.labelUpperAlarmText.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelUpperAlarmText.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelUpperAlarmText.Location = new System.Drawing.Point(5, 145);
			this.labelUpperAlarmText.Name = "labelUpperAlarmText";
			this.labelUpperAlarmText.Size = new System.Drawing.Size(118, 33);
			this.labelUpperAlarmText.TabIndex = 3;
			this.labelUpperAlarmText.Text = "Upper alarm:";
			// 
			// labelCurrentText
			// 
			this.labelCurrentText.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelCurrentText.Font = new System.Drawing.Font("Microsoft Sans Serif", 13F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelCurrentText.Location = new System.Drawing.Point(5, 100);
			this.labelCurrentText.Name = "labelCurrentText";
			this.labelCurrentText.Size = new System.Drawing.Size(118, 33);
			this.labelCurrentText.TabIndex = 2;
			this.labelCurrentText.Text = "Current:";
			// 
			// labelProbeId
			// 
			this.labelProbeId.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelProbeId.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelProbeId.Location = new System.Drawing.Point(43, 52);
			this.labelProbeId.Name = "labelProbeId";
			this.labelProbeId.Size = new System.Drawing.Size(221, 33);
			this.labelProbeId.TabIndex = 1;
			// 
			// labelStationName
			// 
			this.labelStationName.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
									| System.Windows.Forms.AnchorStyles.Right)));
			this.labelStationName.Font = new System.Drawing.Font("Microsoft Sans Serif", 25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelStationName.Location = new System.Drawing.Point(5, 9);
			this.labelStationName.Name = "labelStationName";
			this.labelStationName.Size = new System.Drawing.Size(259, 43);
			this.labelStationName.TabIndex = 0;
			// 
			// MainViewForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(532, 379);
			this.Controls.Add(this.tabControlDisplay);
			this.Controls.Add(this.menuStripMainViewFormMenu);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
			this.MainMenuStrip = this.menuStripMainViewFormMenu;
			this.MaximizeBox = false;
			this.Name = "MainViewForm";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "MainViewForm";
			this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MainViewForm_FormClosing);
			this.menuStripMainViewFormMenu.ResumeLayout(false);
			this.menuStripMainViewFormMenu.PerformLayout();
			this.tabControlDisplay.ResumeLayout(false);
			this.tabPageSummary.ResumeLayout(false);
			this.tabPageSummary.PerformLayout();
			this.tabPageStations.ResumeLayout(false);
			this.splitContainer1.Panel1.ResumeLayout(false);
			this.splitContainer1.Panel2.ResumeLayout(false);
			this.splitContainer1.ResumeLayout(false);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.MenuStrip menuStripMainViewFormMenu;
		private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem loginToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem logoutToolStripMenuItem;
		private System.Windows.Forms.TabControl tabControlDisplay;
		private System.Windows.Forms.TabPage tabPageSummary;
		private System.Windows.Forms.TabPage tabPageStations;
		private System.Windows.Forms.SplitContainer splitContainer1;
		private System.Windows.Forms.TreeView treeViewStations;
		private System.Windows.Forms.ListBox listBoxSummaryAlarms;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label labelStationName;
		private System.Windows.Forms.Label labelLowerAlarmText;
		private System.Windows.Forms.Label labelUpperAlarmText;
		private System.Windows.Forms.Label labelCurrentText;
		private System.Windows.Forms.Label labelProbeId;
		private System.Windows.Forms.Label labelLowerAlarm;
		private System.Windows.Forms.Label labelUpperAlarm;
		private System.Windows.Forms.Label labelCurrentTemperatur;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label labelSummaryHighestTemperature;
		private System.Windows.Forms.Label labelSummaryLowestTemperature;
		private System.Windows.Forms.Label labelSummaryLowestPressure;
		private System.Windows.Forms.Label labelSummaryHighestPressure;
		private System.Windows.Forms.Label label6;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.DateTimePicker dateTimePickerSummaryTo;
		private System.Windows.Forms.DateTimePicker dateTimePickerSummaryFrom;
		private ZedGraph.ZedGraphControl zedGraphLastHour;
	}
}

