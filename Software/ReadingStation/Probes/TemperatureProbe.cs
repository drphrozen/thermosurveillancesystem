using System;
using System.Collections.Generic;
using System.Text;
using ReadingStation.TSSServer;
using System.Windows.Forms;
using System.Drawing;

namespace ReadingStation.Probes
{
	class TemperatureProbe : IProbe
	{
		private int id;
		public int Id
		{
			get { return id; }
			set { id = value; }
		}

		private double data;
		public double Data
		{
			get { return data; }
			set { data = value; }
		}

		private double lowerAlarm;
		public double LowerAlarm
		{
			get { return lowerAlarm; }
			set { lowerAlarm = value; }
		}

		private double upperAlarm;
		public double UpperAlarm
		{
			get { return upperAlarm; }
			set { upperAlarm = value; }
		}

		private string units;
		public string Units
		{
			get { return units; }
			set { units = value; }
		}

		public TemperatureProbe()
		{ }

		public bool AlarmRaised()
		{
			return (LowerAlarmRaised() || UpperAlarmRaised());
		}

		public bool UpperAlarmRaised()
		{
			return (data > upperAlarm);
		}

		public bool LowerAlarmRaised()
		{
			return (lowerAlarm > data);
		}

		public void TakeSample()
		{
			data = DateTime.Now.Millisecond % 23;
		}

		public double GetValue()
		{
			return data;
		}

		public string GetUnits()
		{
			return units;
		}

		public ProbeDTO GetAsProbeDTO()
		{
			ProbeDTO dto = new ProbeDTO();

			dto.data = Data;
			dto.id = id;
			dto.lowerAlarm = lowerAlarm;
			dto.upperAlarm = upperAlarm;
			dto.units = units;

			return dto;
		}
	}
}
