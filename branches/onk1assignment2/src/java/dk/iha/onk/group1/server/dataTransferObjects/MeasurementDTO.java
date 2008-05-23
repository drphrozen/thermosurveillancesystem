package dk.iha.onk.group1.server.dataTransferObjects;

import java.io.Serializable;
import java.util.Calendar;

public class MeasurementDTO implements Serializable {

    private int probeId;
    private Calendar timestamp;
    private int readingStationId;
    private double value;
    private double upperAlarm;
    private double lowerAlarm;

    public MeasurementDTO() {
        setProbeId(-1);
        setTimestamp(Calendar.getInstance());
        setReadingStationId(-1);
        setValue(0);
        setUpperAlarm(0);
        setLowerAlarm(0);
    }

    public int getProbeId() {
        return probeId;
    }

    public void setProbeId(int probeId) {
        this.probeId = probeId;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public int getReadingStationId() {
        return readingStationId;
    }

    public void setReadingStationId(int readingStationId) {
        this.readingStationId = readingStationId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getUpperAlarm() {
        return upperAlarm;
    }

    public void setUpperAlarm(double upperAlarm) {
        this.upperAlarm = upperAlarm;
    }

    public double getLowerAlarm() {
        return lowerAlarm;
    }

    public void setLowerAlarm(double lowerAlarm) {
        this.lowerAlarm = lowerAlarm;
    }
}
