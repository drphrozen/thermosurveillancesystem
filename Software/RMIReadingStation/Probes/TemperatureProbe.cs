using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Drawing;
using dk.iha.onk.group1.dataTransferObjects;

namespace ReadingStation.Probes
{
	class TemperatureProbe : IProbe
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

		private string units = "celsius";
		public string Units
		{
			get { return units; }
			//set { units = value; }
		}

		public TemperatureProbe()
		{ }

		public TemperatureProbe(int id, double data, double lowerAlarm, double upperAlarm)
		{
			this.id = id;
			this.data = data;
			this.lowerAlarm = lowerAlarm;
			this.upperAlarm = upperAlarm;
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
			data += (randy.NextDouble() - 0.5) * 2.0;
			data = data % 40.0;
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

			dto.setData(data);
			dto.setId(id);
			dto.setLowerAlarm(lowerAlarm);
			dto.setUpperAlarm(upperAlarm);
			dto.setUnits(units);

			return dto;
		}

		public MeasurementDTO GetAsMeasurementDTO()
		{
			MeasurementDTO dto = new MeasurementDTO();

			dto.setProbeId(id);
			dto.setValue(data);
			dto.setTimestamp(java.util.Calendar.getInstance());
			dto.setUpperAlarm(upperAlarm);
			dto.setLowerAlarm(lowerAlarm);

			return dto;
		}
	}
}
