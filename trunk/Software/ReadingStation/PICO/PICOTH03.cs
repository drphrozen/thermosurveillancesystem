using System;
using System.Collections.Generic;
using System.Text;
using System.IO.Ports;

namespace ReadingStation.PICO
{
	class PICOTH03 : IPICOTH03
	{
		private enum Command : byte { GetVersion = 1, GetLowReference = 2, GetHighReference = 3, Channel1 = 4, Channel2 = 8, Channel3 = 12 };

		private const ushort LOWER_LIMIT = 29219;
		private const ushort UPPER_LIMIT = 19360;
		private const double LOWEST_VALUE = 0;
		private const double HIGHEST_VALUE = 40;

		private double[] ConversionTable = new double[] { 29219, 28840, 28467, 28099, 27738, 27380, 27031, 26690, 26355, 26027, 25705, 25392, 25087, 24789, 24498, 24214, 23939, 23671, 23411, 23158, 22911, 22673, 22442, 22218, 22002, 21790, 21587, 21390, 21200, 21016, 20837, 20665, 20499, 20339, 20184, 20034, 19889, 19750, 19616, 19486, 19360 };

		private string portName;
		private SerialPort port;
		private DateTime connectionTime;

		private double lowReferenceValue = 20082;
		private double highReferenceValue = 43773;

		public PICOTH03(string comPort)
		{
			this.portName = comPort;
		}

		public bool Connect()
		{
			try
			{
				port = new SerialPort(portName, 2400, Parity.None, 8, StopBits.One);
				port.Open();
				port.DtrEnable = false; // DTR < -7 v
				port.RtsEnable = true; // RTS > 7 v
				port.ReadTimeout = 1000;
				connectionTime = DateTime.Now;
			}
			catch (Exception)
			{
				return false;
			}

			return true;
		}

		public void Disconnect()
		{
			if (port.IsOpen)
			{
				port.Close();
			}
		}

		public double GetCelcius(int channel)
		{
			Command command;

			switch (channel)
			{
				case 1:
					command = Command.Channel1;
					break;
				case 2:
					command = Command.Channel2;
					break;
				case 3:
					command = Command.Channel3;
					break;
				default:
					throw new Exception("Invalid channel");
			}

			try
			{
				//byte[] reply = SendCommand(command);
				//byte[] reply = new byte[] { 0x64, 0x69 };
				byte[] reply = new byte[] { 0x4d, 0xb1 };
				double measured = reply[0] * 256 + reply[1];
				return ConvertSampleToCelsius(measured);
			}
			catch (Exception)
			{
				return 0.0;
			}
		}

		public double GetFahrenheit(int channel)
		{
			Command command;

			switch (channel)
			{
				case 1:
					command = Command.Channel1;
					break;
				case 2:
					command = Command.Channel2;
					break;
				case 3:
					command = Command.Channel3;
					break;
				default:
					throw new Exception("Invalid channel");
			}

			try
			{
				//byte[] reply = SendCommand(command);
				//byte[] reply = new byte[] { 0x64, 0x69 };
				byte[] reply = new byte[] { 0x4d, 0xb1 };
				double measured = reply[0] * 256 + reply[1];
				return ConvertSampleToFahrenheit(measured);
			}
			catch (Exception)
			{
				return 0.0;
			}
		}

		private byte[] SendCommand(Command command)
		{
			if ((DateTime.Now - connectionTime) < new TimeSpan(0, 0, 1))
			{
				throw new Exception("Pico TH-03 is not ready yet");
			}

			byte[] buffer = new byte[2];

			buffer[0] = (byte)command;
			port.DiscardInBuffer();
			port.Write(buffer, 0, 1);
			port.Read(buffer, 0, 2);

			return buffer;
		}

		private double ConvertSampleToCelsius(double sample)
		{
			double corrected = 20082.0 + (sample - lowReferenceValue) * (43773.0 - 20082.0) / (highReferenceValue - lowReferenceValue);

			// y = -2,25829464154132E-11x3 + 1,8563710858826E-06x2 - 5,37118694853148E-02x + 5,47651985730826E+02
			return ((-2.25829464154132 * Math.Pow(10.0, -11.0) * corrected * corrected * corrected) + (1.8563710858826 * Math.Pow(10.0, -6.0) * corrected * corrected) - 0.0537118694853148 * corrected + 547.651985730826);
		}

		private double ConvertSampleToFahrenheit(double sample)
		{
			return (ConvertSampleToCelsius(sample) * (9.0 / 5.0)) + 32.0;
		}
	}
}
