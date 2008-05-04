/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataTransferObjects.MeasurementDTO;
import dk.iha.onk.group1.server.dataSourceLayer.DataSourceFacade;
import dk.iha.onk.group1.server.domainObjects.Measurement;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author dk021998
 */
public class MeasurementMapper 
{
    private DataSourceFacade dataSource;
        
    public MeasurementMapper()
    {
        dataSource = new DataSourceFacade();
    }
    
    public MeasurementDTO[] getLastHourOfReadings(int probeId)
    {
        Calendar oneHourAgo = Calendar.getInstance();
        oneHourAgo.roll(Calendar.HOUR_OF_DAY, false);
        LinkedList<MeasurementDTO> measureDTOs = new LinkedList<MeasurementDTO>();
        LinkedList<Measurement> measurements = dataSource.getMeasurements(probeId,oneHourAgo, Calendar.getInstance());
        System.out.println("Last hour: " + measurements.size() + "\t" + oneHourAgo.getTime() + "\t" + Calendar.getInstance().getTime());
        for (Measurement m : measurements)
        {
            measureDTOs.add(transformToDTO(m));
        }
        System.out.println("Last hour size: " + measureDTOs.size());
        return measureDTOs.toArray(new MeasurementDTO[0]);
    }
    
    public MeasurementDTO[] getNewestMeasurements()
    {
        LinkedList<MeasurementDTO> measurementDTOs = new LinkedList<MeasurementDTO>();
        LinkedList<Measurement> measurements = dataSource.getNewestMeasurements();
        for (Measurement measurement:measurements)
        {
            measurementDTOs.add(transformToDTO(measurement));
        }
        return measurementDTOs.toArray(new MeasurementDTO[0]);
    }
    
    public MeasurementDTO[] getMeasurements(Calendar from, Calendar to)
    {
        LinkedList<MeasurementDTO> measurementDTOs = new LinkedList<MeasurementDTO>();
        LinkedList<Measurement> measurements = dataSource.getMeasurements(from, to);
        for (Measurement measurement:measurements)
        {
            measurementDTOs.add(transformToDTO(measurement));
        }
        return measurementDTOs.toArray(new MeasurementDTO[0]);
    }
    
    public void saveMeasurements(MeasurementDTO[] measurements)
    {
        for (MeasurementDTO measurement: measurements)
        {
            saveMeasurement(measurement);
        }
    }
    
    public void saveMeasurement(MeasurementDTO ms)
    {
        Measurement measurement = transformFromDTO(ms);
        
        if (dataSource.isReadingStationEnabled(ms.getReadingStationId()) && measurement.getProbeId() > 0)
        {
            dataSource.saveMeasurement(measurement);
        }
    }
    
    public void saveAlarm(MeasurementDTO alarm)
    {
        Measurement measurement = transformFromDTO(alarm);
        
        if (dataSource.isReadingStationEnabled(alarm.getReadingStationId()))
        {
            dataSource.saveAlarm(measurement);
        }           
    }

    
    private Measurement transformFromDTO(MeasurementDTO m)
    {
        return new Measurement(m.getProbeId(), m.getTimestamp(),m.getValue(),m.getUpperAlarm() ,m.getLowerAlarm());
    }
    
    private MeasurementDTO transformToDTO(Measurement m)
    {
        MeasurementDTO measurement = new MeasurementDTO();
        measurement.setProbeId(m.getProbeId());
        measurement.setValue(m.getValue());
        measurement.setTimestamp(m.getTimestamp());
        measurement.setUpperAlarm(m.getUpperAlarm());
        measurement.setLowerAlarm(m.getLowerAlarm());
        return measurement;
    }

}
