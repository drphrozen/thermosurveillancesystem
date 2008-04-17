package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataSourceLayer.RSTable;
import dk.iha.onk.group1.server.dataSourceLayer.MeasuresTable;
import dk.iha.onk.group1.server.pojo.*;
import java.util.Calendar;
import java.util.LinkedList;

public class SummaryMapper 
{
    private MeasuresTable measTable;
    
    public SummaryMapper()
    {
        measTable = new MeasuresTable();
    }
    
    public SummaryDTO generateSummary(Calendar from,Calendar to)
    {
        SummaryDTO summary = new SummaryDTO();
        LinkedList<String> alarms_summary = new LinkedList<String>();
        LinkedList<Measurement> alarms = new LinkedList<Measurement>();
        String alarmInfo;

        double[] temperatures = measTable.getTemperatures(from,to);
       // double[] pressures = measTable.getPressures(from,to);
        
        summary.setPeriodHighestTemp(getHighest(temperatures));
        summary.setPeriodLowestTemp(getLowest(temperatures));
       // summary.setPeriodHighestPressure(getHighest(pressures));
       // summary.setPeriodLowestPressure(getLowest(pressures));
        
        alarms = measTable.getAlarms(from, to);
        for (Measurement alarm: alarms)
        {
            alarmInfo = alarm.getReadingStationName() + "." + alarm.getProbeId() + " at "
                    +alarm.getTimestamp()+ " raised alarm with value = " + alarm.getValue() + " (upper = "
                    +alarm.getUpperAlarm()+ ", lower = " +alarm.getLowerAlarm()+ ")";
            alarms_summary.add(alarmInfo);
        }
        summary.setAlarms(alarms_summary.toArray(new String[0]));
        
        return summary;
    }
    
    private double getHighest(double[] values)
    {
        double highest = Double.NEGATIVE_INFINITY;
        for(double current:values)
        {
            if (current > highest)
                highest = current;
        } 
        return highest;
    }

    
    private double getLowest(double[] values)
    {
        double lowest = Double.POSITIVE_INFINITY;
        for(double current:values)
        {
            if (current < lowest)
                lowest = current;
        } 
        return lowest;
    }
}
