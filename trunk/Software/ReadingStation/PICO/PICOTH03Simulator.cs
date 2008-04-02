using System;
using System.Collections.Generic;
using System.Text;

namespace ReadingStation.PICO
{
	class PICOTH03Simulator : IPICOTH03
	{
		public PICOTH03Simulator()
		{ }

		public bool Connect()
		{
			return true;
		}

		public void Disconnect()
		{

		}

		public double GetTemperatur(int channel)
		{
			return DateTime.Now.Second;
		}
	}
}
