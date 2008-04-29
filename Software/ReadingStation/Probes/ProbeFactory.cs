using System;
using System.Collections.Generic;
using System.Text;
using ReadingStation.TSSServer;

namespace ReadingStation.Probes
{
	class ProbeFactory
	{
		static public IProbe CreateProbeFromProbeDTO(ProbeDTO probeDto)
		{
			switch (probeDto.units)
			{
				case "bar":
					return new PressureProbe(probeDto.id, probeDto.data, probeDto.lowerAlarm, probeDto.upperAlarm);
				case "celsius":
					return new TemperatureProbe(probeDto.id, probeDto.data, probeDto.lowerAlarm, probeDto.upperAlarm);
				default:
					throw new Exception("Unknown probe type");
			}
		}

		static public IProbe CreateProbe(string type, int id,double lowerAlarm, double upperAlarm)
		{
			IProbe probe = null;

			switch (type)
			{
				case "bar":
					probe = new PressureProbe(id, 0.0, lowerAlarm, upperAlarm);
					break;
				case "celsius":
					probe = new TemperatureProbe(id, 0.0, lowerAlarm, upperAlarm);
					break;
				default:
					throw new Exception("Unknown probe type");
			}

			return probe;
		}
	}
}
