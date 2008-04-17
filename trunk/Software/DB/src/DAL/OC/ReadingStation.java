/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.OC;

import java.util.LinkedList;

public class ReadingStation implements Comparable<ReadingStation>, Transformable
{
    private String name;
    private LinkedList<Probe> probes;
    private boolean enabled;
    private int id;

    public int compareTo(ReadingStation r)
    {
        return this.getName().compareTo(r.getName());
    }

    public Object toDTO()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Transformable fromDTO()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LinkedList<Probe> getProbes()
    {
        return probes;
    }

    public void setProbes(LinkedList<Probe> probes)
    {
        this.probes = probes;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}
