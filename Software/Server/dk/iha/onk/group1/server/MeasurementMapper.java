/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataSourceLayer.RSTable;
import dk.iha.onk.group1.server.dataSourceLayer.MeasuresTable;
import dk.iha.onk.group1.server.pojo.Measurement;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author dk021998
 */
public class MeasurementMapper 
{
    private MeasuresTable measuresTable;
    
    public MeasurementMapper()
    {
        measuresTable = new MeasuresTable();
    }
    
    public MeasurementDTO[] getLastHourOfReadings(String rsName,int probeId)
    {
        LinkedList<MeasurementDTO> measureDTOs = new LinkedList<MeasurementDTO>();
        Calendar oneHourAgo = Calendar.getInstance();
        oneHourAgo.roll(Calendar.HOUR, -1);
    //    LinkedList<Measurement> measurements = measuresTable.getMeasurements(rsName,probeId,oneHourAgo, Calendar.getInstance());
        LinkedList<Measurement> measurements = new LinkedList<Measurement>();
        for (Measurement m : measurements)
        {
            measureDTOs.add(transformToDTO(m));
        }
        return measureDTOs.toArray(new MeasurementDTO[0]);
    }
    
    private Measurement transformFromDTO(MeasurementDTO m)
    {
        return new Measurement(m.getProbeId(), m.getTimestamp(),m.getReadingStationName(),m.getValue(),m.getUpperAlarm() ,m.getLowerAlarm());
    }
    
    private MeasurementDTO transformToDTO(Measurement m)
    {
        MeasurementDTO measurement = new MeasurementDTO();
        measurement.setProbeId(m.getProbeId());
        measurement.setValue(m.getValue());
        measurement.setReadingStationName(m.getReadingStationName());
        measurement.setUpperAlarm(m.getUpperAlarm());
        measurement.setLowerAlarm(m.getLowerAlarm());
        return measurement;
    }

}
