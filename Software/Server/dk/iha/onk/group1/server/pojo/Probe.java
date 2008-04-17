/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.pojo;

/**
 *
 * @author dk021998
 */
public class Probe implements Comparable<Probe>
{
    private int id;
    private double data;
    private double upperAlarm;
    private double lowerAlarm;
    private String units;
    
    public Probe(int id,double data,double upperAlarm, double lowerAlarm, String units)
    {
        setId(id);
        setData(data);
        setLowerAlarm(lowerAlarm);
        setUpperAlarm(upperAlarm);
        setUnits(units);
    }
    
    public Probe(int id,double data,double upperAlarm, double lowerAlarm)
    {
        setId(id);
        setData(data);
        setLowerAlarm(lowerAlarm);
        setUpperAlarm(upperAlarm);
        setUnits("Celsius");
    }
    
    public int compareTo(Probe p)
    {
        if (this.getData() < p.getData())
            return -1;
        else if (this.getData() > p.getData())
            return 1;
        return 0;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getData()
    {
        return data;
    }

    public void setData(double data)
    {
        this.data = data;
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

    public String getUnits()
    {
        return units;
    }

    public void setUnits(String units)
    {
        this.units = units;
    }
}
