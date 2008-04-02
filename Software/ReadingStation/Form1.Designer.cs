namespace ReadingStation
{
	partial class Form1
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
			this.buttonSetStationName = new System.Windows.Forms.Button();
			this.label1 = new System.Windows.Forms.Label();
			this.textBoxStationName = new System.Windows.Forms.TextBox();
			this.textBoxConnectionString = new System.Windows.Forms.TextBox();
			this.label2 = new System.Windows.Forms.Label();
			this.buttonConnect = new System.Windows.Forms.Button();
			this.textBoxSampleInterval = new System.Windows.Forms.TextBox();
			this.label4 = new System.Windows.Forms.Label();
			this.buttonSetSampleInterval = new System.Windows.Forms.Button();
			this.labelTemperatur = new System.Windows.Forms.Label();
			this.buttonDisconnect = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// buttonSetStationName
			// 
			this.buttonSetStationName.Location = new System.Drawing.Point(118, 109);
			this.buttonSetStationName.Name = "buttonSetStationName";
			this.buttonSetStationName.Size = new System.Drawing.Size(75, 23);
			this.buttonSetStationName.TabIndex = 1;
			this.buttonSetStationName.Text = "Set";
			this.buttonSetStationName.UseVisualStyleBackColor = true;
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(12, 95);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(72, 13);
			this.label1.TabIndex = 6;
			this.label1.Text = "Station name:";
			// 
			// textBoxStationName
			// 
			this.textBoxStationName.Location = new System.Drawing.Point(12, 111);
			this.textBoxStationName.Name = "textBoxStationName";
			this.textBoxStationName.Size = new System.Drawing.Size(100, 20);
			this.textBoxStationName.TabIndex = 0;
			this.textBoxStationName.Text = "RS1";
			// 
			// textBoxConnectionString
			// 
			this.textBoxConnectionString.Location = new System.Drawing.Point(12, 163);
			this.textBoxConnectionString.Name = "textBoxConnectionString";
			this.textBoxConnectionString.Size = new System.Drawing.Size(100, 20);
			this.textBoxConnectionString.TabIndex = 2;
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(12, 147);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(92, 13);
			this.label2.TabIndex = 9;
			this.label2.Text = "Connection string:";
			// 
			// buttonConnect
			// 
			this.buttonConnect.Location = new System.Drawing.Point(118, 161);
			this.buttonConnect.Name = "buttonConnect";
			this.buttonConnect.Size = new System.Drawing.Size(75, 23);
			this.buttonConnect.TabIndex = 3;
			this.buttonConnect.Text = "Connect";
			this.buttonConnect.UseVisualStyleBackColor = true;
			this.buttonConnect.Click += new System.EventHandler(this.buttonConnect_Click);
			// 
			// textBoxSampleInterval
			// 
			this.textBoxSampleInterval.Location = new System.Drawing.Point(12, 215);
			this.textBoxSampleInterval.Name = "textBoxSampleInterval";
			this.textBoxSampleInterval.Size = new System.Drawing.Size(100, 20);
			this.textBoxSampleInterval.TabIndex = 4;
			this.textBoxSampleInterval.Text = "1";
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Location = new System.Drawing.Point(12, 199);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(82, 13);
			this.label4.TabIndex = 12;
			this.label4.Text = "Sample interval:";
			// 
			// buttonSetSampleInterval
			// 
			this.buttonSetSampleInterval.Location = new System.Drawing.Point(118, 213);
			this.buttonSetSampleInterval.Name = "buttonSetSampleInterval";
			this.buttonSetSampleInterval.Size = new System.Drawing.Size(75, 23);
			this.buttonSetSampleInterval.TabIndex = 5;
			this.buttonSetSampleInterval.Text = "Set";
			this.buttonSetSampleInterval.UseVisualStyleBackColor = true;
			this.buttonSetSampleInterval.Click += new System.EventHandler(this.buttonSetSampleInterval_Click);
			// 
			// labelTemperatur
			// 
			this.labelTemperatur.Font = new System.Drawing.Font("Jokerman", 40F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelTemperatur.Location = new System.Drawing.Point(12, 9);
			this.labelTemperatur.Name = "labelTemperatur";
			this.labelTemperatur.Size = new System.Drawing.Size(181, 88);
			this.labelTemperatur.TabIndex = 15;
			this.labelTemperatur.Text = "?";
			this.labelTemperatur.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// buttonDisconnect
			// 
			this.buttonDisconnect.Location = new System.Drawing.Point(118, 160);
			this.buttonDisconnect.Name = "buttonDisconnect";
			this.buttonDisconnect.Size = new System.Drawing.Size(75, 23);
			this.buttonDisconnect.TabIndex = 16;
			this.buttonDisconnect.Text = "Disconnect";
			this.buttonDisconnect.UseVisualStyleBackColor = true;
			this.buttonDisconnect.Click += new System.EventHandler(this.buttonDisconnect_Click);
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(205, 248);
			this.Controls.Add(this.labelTemperatur);
			this.Controls.Add(this.textBoxSampleInterval);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.buttonSetSampleInterval);
			this.Controls.Add(this.textBoxConnectionString);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.buttonConnect);
			this.Controls.Add(this.textBoxStationName);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.buttonSetStationName);
			this.Controls.Add(this.buttonDisconnect);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "Form1";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Reading Station";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button buttonSetStationName;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox textBoxStationName;
		private System.Windows.Forms.TextBox textBoxConnectionString;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Button buttonConnect;
		private System.Windows.Forms.TextBox textBoxSampleInterval;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Button buttonSetSampleInterval;
		private System.Windows.Forms.Label labelTemperatur;
		private System.Windows.Forms.Button buttonDisconnect;
	}
}

