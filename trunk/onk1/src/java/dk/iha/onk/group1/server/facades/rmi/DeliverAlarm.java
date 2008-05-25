/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades.rmi;

import dk.iha.onk.group1.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.server.AlarmController;
import dk.iha.onk.group1.server.MeasurementMapper;

/**
 *
 * @author dk021998
 */
public class DeliverAlarm implements Runnable
{
	private MeasurementMapper mapper;
	private AlarmController alarmController;
	private MeasurementDTO alarm;

	public DeliverAlarm(MeasurementMapper mapper, AlarmController alarmController, MeasurementDTO alarm)
	{
		this.mapper = mapper;
		this.alarmController = alarmController;
		this.alarm = alarm;
	}
	
	public void run()
	{
		mapper.saveAlarm(alarm);
		alarmController.raiseAlarm(alarm);
	}

}
