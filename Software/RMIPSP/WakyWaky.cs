using System;
using System.Collections.Generic;
using System.Text;
using dk.iha.onk.group1.interfaces;
using dk.iha.onk.group1.dataTransferObjects;

namespace PSP
{
	class WakyWaky : java.rmi.server.UnicastRemoteObject, IPSPObserver
	{
		public delegate void AlarmDelgate(MeasurementDTO dto);
		public event AlarmDelgate Alarm;

		public void update(MeasurementDTO dto)
		{
			System.Diagnostics.Debug.WriteLine("ALARM");
			Alarm(dto);
		}
	}
}
