using System;
using System.Collections.Generic;
using System.Text;
using System.IO.Ports;

namespace ReadingStation.PICO
{
	class PICOTH03 : IPICOTH03
	{
		SerialPort port;

		public PICOTH03(string comPort)
		{
			port = new SerialPort(comPort, 115200, Parity.None, 8, 1);
		}

		public bool Connect()
		{
			return false;
		}

		public void Disconnect()
		{

		}

		public double GetTemperatur(int channel)
		{
			return 0;
		}
	}
}
