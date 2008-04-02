using System;
using System.Collections.Generic;
using System.Text;

namespace ReadingStation.PICO
{
	interface IPICOTH03
	{
		bool Connect();
		void Disconnect();
		double GetTemperatur(int channel);
	}
}
