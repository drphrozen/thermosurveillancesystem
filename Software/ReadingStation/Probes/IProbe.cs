using System;
using System.Collections.Generic;
using System.Text;
using ReadingStation.TSSServer;

namespace ReadingStation.Probes
{
	interface IProbe
	{
		bool AlarmRaised();
		bool UpperAlarmRaised();
		bool LowerAlarmRaised();
		void TakeSample();
		double GetValue();
		string GetUnits();
		ProbeDTO GetAsProbeDTO();
	}
}
