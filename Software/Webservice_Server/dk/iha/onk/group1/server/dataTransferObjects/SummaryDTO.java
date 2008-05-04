/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.dataTransferObjects;

/**
 *
 * @author dk021998
 */
public class SummaryDTO 
{
    private double periodHighestTemp;
    private double periodLowestTemp;
    private double periodHighestPressure;
    private double periodLowestPressure;
    private String[] alarms;
    
    public SummaryDTO()
    {

    }

    public double getPeriodHighestTemp()
    {
        return periodHighestTemp;
    }

    public void setPeriodHighestTemp(double periodHighestTemp)
    {
        this.periodHighestTemp = periodHighestTemp;
    }

    public double getPeriodLowestTemp()
    {
        return periodLowestTemp;
    }

    public void setPeriodLowestTemp(double periodLowestTemp)
    {
        this.periodLowestTemp = periodLowestTemp;
    }

    public double getPeriodHighestPressure()
    {
        return periodHighestPressure;
    }

    public void setPeriodHighestPressure(double periodHighestPressure)
    {
        this.periodHighestPressure = periodHighestPressure;
    }

    public double getPeriodLowestPressure()
    {
        return periodLowestPressure;
    }

    public void setPeriodLowestPressure(double periodLowestPressure)
    {
        this.periodLowestPressure = periodLowestPressure;
    }

    public String[] getAlarms()
    {
        return alarms;
    }

    public void setAlarms(String[] alarms)
    {
        this.alarms = alarms;
    }
}
