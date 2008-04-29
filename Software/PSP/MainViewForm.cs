using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using PSP.TSSServer;
using System.Net;
using System.Web;
using ZedGraph;

namespace PSP
{
	public partial class MainViewForm : Form
	{
		#region Snask
		UserFacadeService userService = null;
		List<Station> stations = null;
		Timer refreshTimer = null;

		public MainViewForm()
		{
			InitializeComponent();
			LogOut();
		}
		private void MainViewForm_FormClosing(object sender, FormClosingEventArgs e)
		{
			ExitApplication();
		}
		private void ExitApplication()
		{
			LogOut();
			Application.Exit();
		}
		#endregion

		#region Menues
		private void loginToolStripMenuItem_Click(object sender, EventArgs e)
		{
			userService = new UserFacadeService();
			userService.CookieContainer = new CookieContainer();

			LoginDialog ld = new LoginDialog();
			ld.UserService = userService;
			if (ld.ShowDialog() == DialogResult.OK)
			{
				LogIn(ld.Username);
			}
		}
		private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
		{
			LogOut();
		}
		private void exitToolStripMenuItem_Click(object sender, EventArgs e)
		{
			ExitApplication();
		}
		#endregion

		#region Session control
		private void LogIn(string username)
		{
			this.Text = "PSP - Logged in as " + username;
			tabControlDisplay.SelectTab(0);
			loginToolStripMenuItem.Visible = false;
			logoutToolStripMenuItem.Visible = true;
			refreshToolStripMenuItem.Visible = true;
			tabControlDisplay.Visible = true;
			refreshTimer = new Timer();
			refreshTimer.Interval = 30 * 1000;
			refreshTimer.Tick += RefreshCurrentView;
			refreshTimer.Enabled = true;
			RefreshCurrentView(null, null);
		}
		private void LogOut()
		{
			this.Text = "PSP";
			loginToolStripMenuItem.Visible = true;
			logoutToolStripMenuItem.Visible = false;
			refreshToolStripMenuItem.Visible = false;
			tabControlDisplay.Visible = false;
			refreshTimer = null;
		}
		#endregion

		#region Get data from server
		private void GetStations()
		{
			stations = new List<Station>();
			foreach (ReadingStationDTO dto in userService.getReadingStations())
			{
				stations.Add(new Station(dto));
			}
		}
		private void GetNewestMeasurements()
		{
			bool found;
			foreach (MeasurementDTO dto in userService.getNewestMeasurements())
			{
				found = false;
				for (int i = 0; i < stations.Count && found == false; i++)
				{
					for (int j = 0; j < stations[i].Probes.Count && found == false; j++)
					{
						if (dto.probeId == stations[i].Probes[j].Id)
						{
							stations[i].Probes[j].Data = dto.value;
							found = true;
						}
					}
				}
			}
		}
		#endregion

		#region Refresh views
		private void RefreshCurrentView(object sender, EventArgs e)
		{
			switch (tabControlDisplay.SelectedTab.Name)
			{
				case "tabPageStations":
					RefreshStationsView();
					break;
				case "tabPageSummary":
					RefreshSummaryView();
					break;
			}
		}

		#region Stations view
		private void treeViewStations_AfterSelect(object sender, TreeViewEventArgs e)
		{
			TreeNode node = treeViewStations.SelectedNode;

			if (node.Tag.GetType() == typeof(Probe))
			{
				RefreshStationsDetailViewFromProbeNode(node);
			}
			else if (node.Tag.GetType() == typeof(Station))
			{
				RefreshStationsDetailViewFromStationNode(node);
			}
		}
		private void RefreshStationsView()
		{
			GetStations();
			GetNewestMeasurements();
			treeViewStations.SuspendLayout();
			treeViewStations.Nodes.Clear();
			foreach (Station s in stations)
			{
				treeViewStations.Nodes.Add(s.GetAsTreeNode());
			}
			treeViewStations.ResumeLayout(true);
			labelStationName.Text = "";
			labelProbeId.Text = "";
			labelCurrentTemperatur.Text = "";
			labelUpperAlarm.Text = "";
			labelLowerAlarm.Text = "";
			labelCurrentText.Visible = false;
			labelUpperAlarmText.Visible = false;
			labelLowerAlarmText.Visible = false;
			zedGraphLastHour.Visible = false;
		}
		private void RefreshStationsDetailViewFromStationNode(TreeNode node)
		{
			Station station = (Station)node.Tag;

			labelStationName.Text = station.Name;
			labelProbeId.Text = "";
			labelCurrentTemperatur.Text = "";
			labelUpperAlarm.Text = "";
			labelLowerAlarm.Text = "";
			labelCurrentText.Visible = false;
			labelUpperAlarmText.Visible = false;
			labelLowerAlarmText.Visible = false;
			zedGraphLastHour.Visible = false;
		}
		private void RefreshStationsDetailViewFromProbeNode(TreeNode node)
		{
			Station station = (Station)node.Parent.Tag;
			Probe probe = (Probe)node.Tag;

			labelStationName.Text = station.Name;
			labelProbeId.Text = probe.Id.ToString();
			labelCurrentTemperatur.Text = probe.Data.ToString() + " " + probe.Units;
			if (probe.UpperAlarmRaised())
			{
				labelUpperAlarm.ForeColor = Color.Red;
				labelUpperAlarmText.ForeColor = Color.Red;
			}
			else
			{
				labelUpperAlarm.ForeColor = Color.FromKnownColor(KnownColor.ControlText);
				labelUpperAlarmText.ForeColor = Color.FromKnownColor(KnownColor.ControlText);
			}
			labelUpperAlarm.Text = probe.UpperAlarm.ToString() + " " + probe.Units;
			if (probe.LowerAlarmRaised())
			{
				labelLowerAlarm.ForeColor = Color.Red;
				labelLowerAlarmText.ForeColor = Color.Red;
			}
			else
			{
				labelLowerAlarm.ForeColor = Color.FromKnownColor(KnownColor.ControlText);
				labelLowerAlarmText.ForeColor = Color.FromKnownColor(KnownColor.ControlText);
			}
			labelLowerAlarm.Text = probe.LowerAlarm.ToString() + " " + probe.Units;
			labelCurrentText.Visible = true;
			labelUpperAlarmText.Visible = true;
			labelLowerAlarmText.Visible = true;

			RefreshGraph(station, probe);
			zedGraphLastHour.Visible = true;
		}
		private void RefreshGraph(Station station, Probe probe)
		{
			GraphPane myPane = zedGraphLastHour.GraphPane;

			List<MeasurementDTO> measurements = new List<MeasurementDTO>();
			MeasurementDTO[] mandms = userService.getLastHourOfReadings(probe.Id);

			myPane.Title.IsVisible = false;
			myPane.XAxis.Title.IsVisible = false;
			myPane.XAxis.Type = AxisType.Date;
			myPane.YAxis.Title.IsVisible = false;
			myPane.CurveList.Clear();

			// Build a PointPairList with points based on Sine wave
			PointPairList list = new PointPairList();
			foreach (MeasurementDTO m in mandms)
			{
				list.Add(m.timestamp.Value.ToOADate(), m.value);
			}

			// Add a curve
			LineItem curve = myPane.AddCurve("label", list, Color.Blue, SymbolType.Circle);
			curve.Line.Width = 1.5F;
			curve.Line.IsAntiAlias = true;
			curve.Symbol.Fill = new Fill(Color.White);
			curve.Symbol.Size = 7;

			myPane.XAxis.Title.IsVisible = false;
			myPane.YAxis.Title.IsVisible = false;
			myPane.Title.IsVisible = false;
			myPane.Legend.IsVisible = false;

			zedGraphLastHour.AxisChange();
			zedGraphLastHour.Refresh();
		}
		#endregion

		#region Summary
		private void RefreshSummaryView()
		{
			SummaryDTO dto;
			if (dateTimePickerSummaryFrom.Value > dateTimePickerSummaryTo.Value)
			{
				System.Diagnostics.Debug.WriteLine("invalid time");
				return;
			}
			else if (dateTimePickerSummaryFrom.Value == dateTimePickerSummaryTo.Value)
			{
				dto = userService.getHistoricalData(dateTimePickerSummaryFrom.Value.Subtract(new TimeSpan(1, 0, 0)), dateTimePickerSummaryTo.Value);
				System.Diagnostics.Debug.WriteLine("hour");
			}
			else
			{
				dto = userService.getHistoricalData(dateTimePickerSummaryFrom.Value, dateTimePickerSummaryTo.Value);
				System.Diagnostics.Debug.WriteLine("more than an hour");
			}

			labelSummaryLowestTemperature.Text = dto.periodLowestTemp.ToString();
			labelSummaryHighestTemperature.Text = dto.periodHighestTemp.ToString();
			labelSummaryLowestPressure.Text = dto.periodLowestPressure.ToString();
			labelSummaryHighestPressure.Text = dto.periodHighestPressure.ToString();

			listBoxSummaryAlarms.SuspendLayout();
			listBoxSummaryAlarms.Items.Clear();
			listBoxSummaryAlarms.Items.AddRange(dto.alarms);
			listBoxSummaryAlarms.ResumeLayout(true);
		}
		private void dateTimePickerSummaryFrom_ValueChanged(object sender, EventArgs e)
		{
			RefreshSummaryView();
		}
		private void dateTimePickerSummaryTo_ValueChanged(object sender, EventArgs e)
		{
			RefreshSummaryView();
		}
		#endregion

		private void refreshToolStripMenuItem_Click(object sender, EventArgs e)
		{
			RefreshCurrentView(null, null);
		}
		#endregion
	}
}