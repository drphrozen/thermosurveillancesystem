package dk.iha.onk.group1.server;

import java.util.Calendar;

public class MeasurementDTO 
{
    private int probeId;
    private Calendar timestamp;
    private String readingStationName;
    private double value;
    private double upperAlarm;
    private double lowerAlarm;

    public MeasurementDTO()
    {
        setProbeId(-1);
        setTimestamp(Calendar.getInstance());
        setReadingStationName("Unknown");
        setValue(0);
        setUpperAlarm(0);
        setLowerAlarm(0);
    }
    
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
}
