/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.OC;

/**
 *
 * @author Martin
 */
public class Unit implements Comparable<Unit>,Transformable
{
    private int unitID;
    private String UnitText;
    
    public int compareTo(Unit u)
    {
        if (this.getUnitID() < u.getUnitID())
            return -1;
        else if (this.getUnitID() > u.getUnitID())
            return 1;
        return 0;
    }

    public Object toDTO()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Transformable fromDTO()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getUnitID() 
    {
        return unitID;
    }

    public void setUnitID(int unitID) 
    {
        this.unitID = unitID;
    }

    public String getUnitText() 
    {
        return UnitText;
    }

    public void setUnitText(String UnitText) 
    {
        this.UnitText = UnitText;
    }
}
