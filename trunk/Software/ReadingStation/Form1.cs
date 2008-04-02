using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using ReadingStation.PICO;

namespace ReadingStation
{
	public partial class Form1 : Form
	{
		IPICOTH03 pico;
		Timer SampleTimer = new Timer();

		public Form1()
		{
			InitializeComponent();
			SampleTimer.Tick += UpdateDisplay;
		}

		private void buttonConnect_Click(object sender, EventArgs e)
		{
			Connect();
		}

		private void buttonDisconnect_Click(object sender, EventArgs e)
		{
			Disconnect();
		}

		private void SetInterval()
		{
			int interval;
			if (int.TryParse(textBoxSampleInterval.Text, out interval))
			{
				SampleTimer.Interval = interval * 1000;
			}
		}

		private void UpdateDisplay(object sender, EventArgs e)
		{
			labelTemperatur.Text = pico.GetTemperatur(0).ToString() + " C";
		}

		private void buttonSetSampleInterval_Click(object sender, EventArgs e)
		{
			SetInterval();
		}

		private void Connect()
		{
			pico = PICOFactory.Create(textBoxConnectionString.Text);
			if (pico.Connect())
			{
				SetInterval();
				SampleTimer.Start();
				buttonConnect.Visible = false;
				buttonDisconnect.Visible = true;
				UpdateDisplay(null, null);
			}
		}

		private void Disconnect()
		{
			SampleTimer.Stop();
			buttonConnect.Visible = true;
			buttonDisconnect.Visible = false;
		}
	}
}