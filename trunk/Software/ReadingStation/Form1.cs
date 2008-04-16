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
		WebReference.ReadingStationFacadeService service = new ReadingStation.WebReference.ReadingStationFacadeService();
		bool useCelcius = true;

		public Form1()
		{
			InitializeComponent();
			SampleTimer.Tick += PerformSample;

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

		private void PerformSample(object sender, EventArgs e)
		{
			double temperatur;
			if (useCelcius)
			{
				temperatur = pico.GetCelcius(1);
				labelTemperatur.Text = temperatur.ToString() + " C";
			}
			else
			{
				temperatur = pico.GetFahrenheit(1);
				labelTemperatur.Text = temperatur.ToString() + " F";
			}

			try
			{
				WebReference.TemperatureDTO dto = new ReadingStation.WebReference.TemperatureDTO();
				dto.probeId = 1;
				dto.readingStationName = textBoxStationName.Text;
				dto.timestamp = DateTime.Now;
				dto.data = (int)(temperatur * 1000);
				service.deliverReading(dto);
			}
			catch (Exception)
			{ }
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
				PerformSample(null, null);
			}
		}

		private void Disconnect()
		{
			SampleTimer.Stop();
			buttonConnect.Visible = true;
			buttonDisconnect.Visible = false;
		}

		private void radioButtonCelcius_CheckedChanged(object sender, EventArgs e)
		{
			useCelcius = true;
		}

		private void radioButtonFahrenheit_CheckedChanged(object sender, EventArgs e)
		{
			useCelcius = false;
		}
	}
}