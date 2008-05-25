/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.dataTransferObjects;

import java.io.Serializable;

/**
 *
 * @author dk021998
 */
public class ProbeDTO implements Serializable {

    private int id;
    private double data;
    private double upperAlarm;
    private double lowerAlarm;
    private String units;

    public ProbeDTO() {
        setId(-1);
        setData(0);
        setUpperAlarm(0);
        setLowerAlarm(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
