using System;
using System.Collections.Generic;
using System.Text;

namespace ReadingStation.PICO
{
	class PICOFactory
	{
		static public IPICOTH03 Create(string comPort)
		{
			if (comPort == "")
			{
				return new PICOTH03Simulator();
			}
			else
			{
				return new PICOTH03(comPort);
			}
		}
	}
}
