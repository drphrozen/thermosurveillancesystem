using System;
using System.Collections.Generic;
using System.Text;
using ReadingStation.TSSServer;
using System.Windows.Forms;
using System.Drawing;

namespace ReadingStation.Probes
{
	class PressureProbe : IProbe
	{
		Random randy = new Random();

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

		private string units = "bar";
		public string Units
		{
			get { return units; }
			//set { units = value; }
		}

		public PressureProbe()
		{ }

		public PressureProbe(int id, double data, double lowerAlarm, double upperAlarm)
		{
			this.id = id;
			this.data = data;
			this.lowerAlarm = lowerAlarm;
			this.upperAlarm = upperAlarm;
			//this.units = units;
		}

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
			data += (randy.NextDouble() - 0.5) * 2.0 * randy.NextDouble();
			data = data % 5.0;
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

		public MeasurementDTO GetAsMeasurementDTO()
		{
			MeasurementDTO dto = new MeasurementDTO();

			dto.probeId = id;
			dto.value = data;
			dto.timestamp = DateTime.Now;
			dto.upperAlarm = upperAlarm;
			dto.lowerAlarm = lowerAlarm;

			return dto;
		}
	}
}
