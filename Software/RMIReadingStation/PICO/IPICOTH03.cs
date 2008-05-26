using System;
using System.Collections.Generic;
using System.Text;

namespace ReadingStation.PICO
{
	interface IPICOTH03
	{
		bool Connect();
		void Disconnect();
		double GetCelcius(int channel);
		double GetFahrenheit(int channel);
	}
}
