using System;
using System.Collections.Generic;
using System.Text;
using dk.iha.onk.group1.dataTransferObjects;

namespace ReadingStation.Probes
{
	interface IProbe
	{
		int Id { get;set;}
		bool AlarmRaised();
		bool UpperAlarmRaised();
		bool LowerAlarmRaised();
		void TakeSample();
		double GetValue();
		string GetUnits();
		ProbeDTO GetAsProbeDTO();
		MeasurementDTO GetAsMeasurementDTO();
	}
}
