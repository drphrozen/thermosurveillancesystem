package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.pojo.*;
import java.util.Calendar;
import java.util.LinkedList;

public class DataSourceFacade 
{

    public boolean addUser(User user)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean authenticateReadingStation(ReadingStation rs)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean disableReadingStation(String rsName)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean enableReadingStation(String rsName)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public LinkedList<Measurement> getAlarms(Calendar from,Calendar to)
    {
        return new LinkedList<Measurement>();
    }

    public LinkedList<Measurement> getMeasurements(String rsName, int probeId, Calendar oneHourAgo, Calendar instance)
    {
        LinkedList<Measurement> m = new LinkedList<Measurement>();
        Calendar c = Calendar.getInstance();
        c.roll(Calendar.MINUTE, -4);
        m.add(new Measurement(1, c, "Esbens BUTT", 42, 20, -20));
        Calendar c1 = Calendar.getInstance();
        c1.roll(Calendar.MINUTE, -3);
        m.add(new Measurement(2, c1, "Esbens BUTT", 23, 45, -20));
        Calendar c2 = Calendar.getInstance();
        c2.roll(Calendar.MINUTE, -2);
        m.add(new Measurement(3, c2, "Esbens BUTT", -35, 50, -20));
        Calendar c3 = Calendar.getInstance();
        c3.roll(Calendar.MINUTE, -1);
        m.add(new Measurement(4, c3, "Esbens BUTT", 22, 22, -3));
        
        Calendar c4 = Calendar.getInstance();
        c4.roll(Calendar.MINUTE, 0);
        m.add(new Measurement(5, c4, "Claus' BUTT", 12, 30, -10));
        Calendar c5 = Calendar.getInstance();
        c5.roll(Calendar.MINUTE, 1);
        m.add(new Measurement(6, c5, "Claus' BUTT", 5, 60, -15));
        Calendar c6 = Calendar.getInstance();
        c6.roll(Calendar.MINUTE, 2);
        m.add(new Measurement(7, c6, "Claus' BUTT", 30, 20, -10));
        
        return m;
    }

    public LinkedList<ReadingStation> getNewestReadings()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public double[] getPressures(Calendar from, Calendar to)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public String getRSName(int id)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ReadingStation getReadingStation(ReadingStation station)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public LinkedList<ReadingStation> getReadingStations()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public LinkedList<ReadingStation> getReadings(Calendar from, Calendar to)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public double[] getTemperatures(Calendar from, Calendar to)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public LinkedList<User> getUsers()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean hasChanged(ReadingStation station)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean isReadingStationEnabled(ReadingStation station)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean removeUser(String username)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void saveAlarm(ReadingStation rsAlarm)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void saveReading(ReadingStation rs)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setRSName(String oldName, String newName)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean updateUser(User oldUser, User newUser)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
