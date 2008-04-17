using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using ReadingStation.TSSServer;
using ReadingStation.Probes;

namespace ReadingStation
{
	public partial class MainForm : Form
	{
		List<IProbe> probes = new List<IProbe>();
		Timer sampleTimer = new Timer();
		Timer deliverTimer = new Timer();
		ReadingStationFacadeService stationService;

		public MainForm()
		{
			InitializeComponent();
			stationService = new ReadingStationFacadeService();
			sampleTimer.Tick += TakeSample;

			PressureProbe pres = new PressureProbe();
			pres.Id = 3;
			pres.LowerAlarm = 0;
			pres.UpperAlarm = 5;
			pres.Units = "bar";
			probes.Add(pres);

			TemperatureProbe temp = new TemperatureProbe();
			temp.Id = 1;
			temp.LowerAlarm = 14;
			temp.UpperAlarm = 37;
			temp.Units = "C";
			probes.Add(temp);

			sampleTimer.Interval = 345;
			sampleTimer.Tick += TakeSample;
			sampleTimer.Enabled = true;

			deliverTimer.Tick += DeliverSamples;

			stationService = new ReadingStationFacadeService();
			stationService.CookieContainer = new System.Net.CookieContainer();
			ReadingStationDTO dto = new ReadingStationDTO();
			dto.name = "abc";
			stationService.login(dto);
		}

		private void TakeSample(object sender, EventArgs e)
		{
			foreach (IProbe probe in probes)
			{
				probe.TakeSample();
			}
		}

		private void DeliverSamples(object sender, EventArgs e)
		{
			ReadingStationDTO dto = new ReadingStationDTO();

			dto.name = textBoxStationName.Text;

			List<ProbeDTO> probeDtos = new List<ProbeDTO>();
			labelDisplay.Text = "";
			foreach (IProbe probe in probes)
			{
				probeDtos.Add(probe.GetAsProbeDTO());
				labelDisplay.Text += string.Format("{0:0.0}", probe.GetValue()) + probe.GetUnits() + "\n";
			}

			dto.probes = probeDtos.ToArray();

			try
			{
				stationService.deliverAlarmAsync(dto);
				//stationService.deliverReading(dto);
			}
			catch
			{
				System.Diagnostics.Debug.WriteLine("BANG");
			}
		}

		private void buttonSetSampleInterval_Click(object sender, EventArgs e)
		{
			int interval;
			if (int.TryParse(textBoxSampleInterval.Text, out interval))
			{
				deliverTimer.Interval = interval * 1000;
				deliverTimer.Enabled = true;
				DeliverSamples(null, null);
			}
		}
	}
}