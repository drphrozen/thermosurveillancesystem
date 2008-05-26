using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using ReadingStation.Probes;

using java.rmi;
using dk.iha.onk.group1.interfaces;
using dk.iha.onk.group1.dataTransferObjects;

using System.Threading;

namespace ReadingStation
{
	public partial class MainForm : Form
	{
		List<IProbe> probes = new List<IProbe>();
		System.Windows.Forms.Timer sampleTimer = new System.Windows.Forms.Timer();
		System.Windows.Forms.Timer deliverTimer = new System.Windows.Forms.Timer();
		System.Windows.Forms.Timer blinkTimer = new System.Windows.Forms.Timer();
		IReadingStationFacade stationService = null;
		ReadingStationDTO station = null;
		Color panelOffColor;
		Color panelOnColor = Color.Green;

		Thread alarmDeliveranceThread;
		List<MeasurementDTO> alarmDtos = new List<MeasurementDTO>();

		public MainForm()
		{
			InitializeComponent();

			panelOffColor = panel1.BackColor;
			blinkTimer.Tick += BlinkTimerEvent;

			ITssFacadeFactory fag = (ITssFacadeFactory)Naming.lookup("rmi://172.21.186.14:1099/TssServer");
			stationService = (IReadingStationFacade)fag.createFacade("ReadingStationFacade", "", "");

			ReadingStationDTO dto = new ReadingStationDTO();

			dto.setName(textBoxStationName.Text);

			List<ProbeDTO> probeDTOs = new List<ProbeDTO>();
			probeDTOs.Add(ProbeFactory.CreateProbe("bar", 0, 1, 3).GetAsProbeDTO());
			probeDTOs.Add(ProbeFactory.CreateProbe("celsius", 0, 14, 37).GetAsProbeDTO());

			dto.setProbes(probeDTOs.ToArray());

			station = stationService.login(dto);
			if (station != null)
			{
				probes = new List<IProbe>();
				foreach (ProbeDTO probe in station.getProbes())
				{
					probes.Add(ProbeFactory.CreateProbeFromProbeDTO(probe));
				}

				sampleTimer.Interval = 3000;
				sampleTimer.Tick += TakeSample;
				sampleTimer.Enabled = true;

				deliverTimer.Tick += DeliverSamples;
				deliverTimer.Enabled = false;
				buttonSetSampleInterval_Click(null, null);

				System.Diagnostics.Debug.WriteLine("Connected :)");
			}
			else
			{
				MessageBox.Show("Unable to connect");
			}

			alarmDeliveranceThread = new Thread(DeliverAlarms);
		}

		private void TakeSample(object sender, EventArgs e)
		{
			System.Diagnostics.Debug.Write("Sampling...");
			foreach (IProbe probe in probes)
			{
				System.Diagnostics.Debug.WriteLine(probe.GetType().ToString());
				probe.TakeSample();
				if (probe.AlarmRaised())
				{
					System.Diagnostics.Debug.WriteLine("Alarm for probe: " + probe.Id);
					stationService.deliverAlarm(probe.GetAsMeasurementDTO());
				}
			}
			System.Diagnostics.Debug.WriteLine("Done :)");
		}

		private void DeliverSamples(object sender, EventArgs e)
		{
			System.Diagnostics.Debug.Write("Sending measurements...");

			ReadingStationDTO dto = new ReadingStationDTO();
			List<MeasurementDTO> measurements = new List<MeasurementDTO>();

			dto.setName(textBoxStationName.Text);

			labelDisplay.Text = "";
			foreach (IProbe probe in probes)
			{
				measurements.Add(probe.GetAsMeasurementDTO());
				labelDisplay.Text += string.Format("{0:0.0}", probe.GetValue()) + probe.GetUnits() + "\n";
				System.Diagnostics.Debug.WriteLine(probe.Id.ToString());
			}

			try
			{
				stationService.deliverMeasurements(measurements.ToArray());
				System.Diagnostics.Debug.WriteLine("Done :)");
			}
			catch
			{
				System.Diagnostics.Debug.Write("*BANG*");
			}

			panel1.BackColor = panelOnColor;
			blinkTimer.Interval = 500;
			blinkTimer.Enabled = true;
		}

		private void BlinkTimerEvent(object sender, EventArgs e)
		{
			panel1.BackColor = panelOffColor;
			blinkTimer.Enabled = false;
		}

		private void buttonSetSampleInterval_Click(object sender, EventArgs e)
		{
			int interval;
			if (int.TryParse(textBoxSampleInterval.Text, out interval))
			{
				deliverTimer.Interval = interval * 1000;
			}
		}

		private void DeliverAlarms()
		{
			while (true)
			{
				lock (alarmDtos)
				{

					//		System.Diagnostics.Debug.WriteLine("Alarm for probe: " + probe.Id);
					//		stationService.deliverAlarm(probe.GetAsMeasurementDTO());
				}
			}
		}
	}
}