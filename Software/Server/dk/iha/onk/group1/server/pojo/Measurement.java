/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.pojo;

import java.util.Calendar;

/**
 *
 * @author dk021998
 */
public class Measurement implements Comparable<Measurement>
{
    private int probeId;
    private Calendar timestamp;
    private String readingStationName;
    private double value;
    private double upperAlarm;
    private double lowerAlarm;
    
    public Measurement(int probeId, Calendar timeStamp, String readingStationName, double value, double upperAlarm, double lowerAlarm)
    {
        setProbeId(probeId);
        setTimestamp(timestamp);
        setReadingStationName(readingStationName);
        setValue(value);
        setUpperAlarm(upperAlarm);
        setLowerAlarm(lowerAlarm);
    }   
    
    public int compareTo(Measurement m)
    {
        if (this.getValue() < m.getValue())
            return -1;
        else if (this.getValue() > m.getValue())
            return 1;
        return 0;
    }


    //<editor-fold>
    public int getProbeId()
    {
        return probeId;
    }

    public void setProbeId(int probeId)
    {
        this.probeId = probeId;
    }

    public Calendar getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getReadingStationName()
    {
        return readingStationName;
    }

    public void setReadingStationName(String readingStationName)
    {
        this.readingStationName = readingStationName;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public double getUpperAlarm()
    {
        return upperAlarm;
    }

    public void setUpperAlarm(double upperAlarm)
    {
        this.upperAlarm = upperAlarm;
    }

    public double getLowerAlarm()
    {
        return lowerAlarm;
    }

    public void setLowerAlarm(double lowerAlarm)
    {
        this.lowerAlarm = lowerAlarm;
    }
    //</editor-fold>
}
