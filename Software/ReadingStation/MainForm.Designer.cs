namespace ReadingStation
{
	partial class MainForm
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
			this.textBoxSampleInterval = new System.Windows.Forms.TextBox();
			this.label4 = new System.Windows.Forms.Label();
			this.buttonSetSampleInterval = new System.Windows.Forms.Button();
			this.labelDisplay = new System.Windows.Forms.Label();
			this.panel1 = new System.Windows.Forms.Panel();
			this.SuspendLayout();
			// 
			// buttonSetStationName
			// 
			this.buttonSetStationName.Location = new System.Drawing.Point(118, 120);
			this.buttonSetStationName.Name = "buttonSetStationName";
			this.buttonSetStationName.Size = new System.Drawing.Size(75, 23);
			this.buttonSetStationName.TabIndex = 1;
			this.buttonSetStationName.Text = "Set";
			this.buttonSetStationName.UseVisualStyleBackColor = true;
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(12, 106);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(72, 13);
			this.label1.TabIndex = 6;
			this.label1.Text = "Station name:";
			// 
			// textBoxStationName
			// 
			this.textBoxStationName.Location = new System.Drawing.Point(12, 122);
			this.textBoxStationName.Name = "textBoxStationName";
			this.textBoxStationName.Size = new System.Drawing.Size(100, 20);
			this.textBoxStationName.TabIndex = 0;
			this.textBoxStationName.Text = "RS1";
			// 
			// textBoxSampleInterval
			// 
			this.textBoxSampleInterval.Location = new System.Drawing.Point(12, 169);
			this.textBoxSampleInterval.Name = "textBoxSampleInterval";
			this.textBoxSampleInterval.Size = new System.Drawing.Size(100, 20);
			this.textBoxSampleInterval.TabIndex = 4;
			this.textBoxSampleInterval.Text = "3";
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Location = new System.Drawing.Point(12, 153);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(82, 13);
			this.label4.TabIndex = 12;
			this.label4.Text = "Sample interval:";
			// 
			// buttonSetSampleInterval
			// 
			this.buttonSetSampleInterval.Location = new System.Drawing.Point(118, 167);
			this.buttonSetSampleInterval.Name = "buttonSetSampleInterval";
			this.buttonSetSampleInterval.Size = new System.Drawing.Size(75, 23);
			this.buttonSetSampleInterval.TabIndex = 5;
			this.buttonSetSampleInterval.Text = "Set";
			this.buttonSetSampleInterval.UseVisualStyleBackColor = true;
			this.buttonSetSampleInterval.Click += new System.EventHandler(this.buttonSetSampleInterval_Click);
			// 
			// labelDisplay
			// 
			this.labelDisplay.Font = new System.Drawing.Font("Jokerman", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.labelDisplay.Location = new System.Drawing.Point(12, 9);
			this.labelDisplay.Name = "labelDisplay";
			this.labelDisplay.Size = new System.Drawing.Size(181, 88);
			this.labelDisplay.TabIndex = 15;
			this.labelDisplay.Text = "?";
			this.labelDisplay.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// panel1
			// 
			this.panel1.Location = new System.Drawing.Point(1, 0);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(16, 16);
			this.panel1.TabIndex = 16;
			// 
			// MainForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(205, 202);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.labelDisplay);
			this.Controls.Add(this.textBoxSampleInterval);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.buttonSetSampleInterval);
			this.Controls.Add(this.textBoxStationName);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.buttonSetStationName);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "MainForm";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Reading Station";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button buttonSetStationName;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox textBoxStationName;
		private System.Windows.Forms.TextBox textBoxSampleInterval;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Button buttonSetSampleInterval;
		private System.Windows.Forms.Label labelDisplay;
		private System.Windows.Forms.Panel panel1;
	}
}

