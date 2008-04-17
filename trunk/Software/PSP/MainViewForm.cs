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
			tabControlDisplay.Visible = false;
			refreshTimer = null;
		}
		#endregion

		#region Get readings
		private void GetReadings()
		{
			List<ReadingStationDTO> dtos = new List<ReadingStationDTO>();
			dtos.AddRange(userService.getNewestReadings());
			stations = new List<Station>();
			foreach (ReadingStationDTO dto in dtos)
			{
				stations.Add(new Station(dto));
			}
		}
		private void GetReadings(TimeSpan time)
		{
			List<ReadingStationDTO> dtos = new List<ReadingStationDTO>();
			dtos.AddRange(userService.getReadings(DateTime.Now, DateTime.Now.Subtract(time)));
			stations = new List<Station>();
			foreach (ReadingStationDTO dto in dtos)
			{
				stations.Add(new Station(dto));
			}
		}
		private void GetReadings(DateTime from, DateTime to)
		{
			List<ReadingStationDTO> dtos = new List<ReadingStationDTO>();
			dtos.AddRange(userService.getReadings(from, to));
			stations = new List<Station>();
			foreach (ReadingStationDTO dto in dtos)
			{
				stations.Add(new Station(dto));
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
			GetReadings();
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
		}
		private void RefreshGraph(Station station, Probe probe)
		{
			GraphPane myPane = zedGraphLastHour.GraphPane;

			List<MeasurementDTO> measurements = new List<MeasurementDTO>();
			MeasurementDTO[] mandms = userService.getLastHourOfReadings(station.Name, probe.Id);
			if (mandms != null)
			{
				measurements.AddRange(mandms);
			}
			else
			{
				MeasurementDTO bla;
				bla = new MeasurementDTO();
				bla.timestamp = new DateTime(1990, 1, 1);
				bla.value = 5;
				measurements.Add(bla);
				bla = new MeasurementDTO();
				bla.timestamp = new DateTime(1990, 1, 2);
				bla.value = 6;
				measurements.Add(bla);
				bla = new MeasurementDTO();
				bla.timestamp = new DateTime(1990, 1, 3);
				bla.value = 7;
				measurements.Add(bla);
				bla = new MeasurementDTO();
				bla.timestamp = new DateTime(1990, 1, 4);
				bla.value = 8;
				measurements.Add(bla);
				bla = new MeasurementDTO();
				bla.timestamp = new DateTime(1990, 1, 5);
				bla.value = 9;
				measurements.Add(bla);
			}

			myPane.Title.IsVisible = false;
			myPane.XAxis.Title.IsVisible = false;
			myPane.YAxis.Title.IsVisible = false;

			// Build a PointPairList with points based on Sine wave
			PointPairList list = new PointPairList();
			foreach (MeasurementDTO m in measurements)
			{
				list.Add(m.timestamp.Value.ToOADate(), m.value);
			}

			// Hide the legend
			myPane.Legend.IsVisible = false;

			// Add a curve
			LineItem curve = myPane.AddCurve("label", list, Color.Red, SymbolType.Circle);
			curve.Line.Width = 2.0F;
			curve.Line.IsAntiAlias = true;
			curve.Symbol.Fill = new Fill(Color.White);
			curve.Symbol.Size = 7;

			// Fill the axis background with a gradient
			//myPane.Chart.Fill = new Fill(Color.White, Color.FromArgb(255, Color.ForestGreen), 45.0F);

			// Offset Y space between point and label
			// NOTE:  This offset is in Y scale units, so it depends on your actual data
			//const double offset = 1.0;

			// Loop to add text labels to the points
			/*
			for (int i = 0; i < count; i++)
			{
				// Get the pointpair
				PointPair pt = curve.Points[i];

				// Create a text label from the Y data value
				TextObj text = new TextObj(pt.Y.ToString("f2"), pt.X, pt.Y + offset, CoordType.AxisXYScale, AlignH.Left, AlignV.Center);
				text.ZOrder = ZOrder.A_InFront;
				// Hide the border and the fill
				text.FontSpec.Border.IsVisible = false;
				text.FontSpec.Fill.IsVisible = false;
				//text.FontSpec.Fill = new Fill( Color.FromArgb( 100, Color.White ) );
				// Rotate the text to 90 degrees
				text.FontSpec.Angle = 90;

				myPane.GraphObjList.Add(text);
			}
			*/

			// Leave some extra space on top for the labels to fit within the chart rect
			//myPane.YAxis.Scale.MaxGrace = 0.2;
			myPane.XAxis.Type = AxisType.Date;

			// Calculate the Axis Scale Ranges
			zedGraphLastHour.AxisChange();
			zedGraphLastHour.Refresh();
		}
		#endregion

		#region Summary
		private void RefreshSummaryView()
		{




			return;






			SummaryDTO dto = userService.getHistoricalData(dateTimePickerSummaryFrom.Value, dateTimePickerSummaryTo.Value);

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
		#endregion
	}
}