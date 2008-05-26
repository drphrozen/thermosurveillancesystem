using System;
using System.Collections.Generic;
using System.Text;
using dk.iha.onk.group1.dataTransferObjects;

namespace ReadingStation.Probes
{
	class ProbeFactory
	{
		static public IProbe CreateProbeFromProbeDTO(ProbeDTO probeDto)
		{
			switch (probeDto.getUnits())
			{
				case "bar":
					return new PressureProbe(probeDto.getId(), probeDto.getData(), probeDto.getLowerAlarm(), probeDto.getUpperAlarm());
				case "celsius":
					return new TemperatureProbe(probeDto.getId(), probeDto.getData(), probeDto.getLowerAlarm(), probeDto.getUpperAlarm());
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
