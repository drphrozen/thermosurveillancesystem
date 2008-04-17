package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.pojo.Measurement;
import dk.iha.onk.group1.server.pojo.Probe;
import dk.iha.onk.group1.server.pojo.ReadingStation;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.jdbc.odbc.JdbcOdbcPreparedStatement;

public class MeasuresTable
{

    MySQLConnector connection;

    public MeasuresTable()
    {
        connection = MySQLConnector.getInstance();
        boolean isConnected = connection.connect("misc.lir.dk", "onk", "onk", "kaffekande");
        System.out.println("Connected: " + isConnected);
    }

    public boolean addMeasure(int probeID, java.util.Date date, double data, double upAlarmLvl, double lowAlarmLvl, String RSName)
    {
        ResultSet resultset = null;
        resultset = connection.selectFromWhereEquals("measures", "TimeStamp", String.valueOf(date));

        // INSERT INTO `measures` ( `ProbeID` , `TimeStamp` , `Data` ) VALUES ( '2', '2008-04-15 20:05:37', '-17.3' );
        connection.insertInto6Values("measures", "ProbeID", probeID, "TimeStamp", date, "Data", data, "UpperAlarmLevel", upAlarmLvl, "LowerAlarmLevel", lowAlarmLvl, "RSName", RSName);
        return true;
    }
    
    public boolean addMeasure(ReadingStation station)
    {
        java.util.Date date = new java.util.Date();

        for(Probe p : station.getProbes())
        {
            connection.insertInto6Values("measures", "ProbeID", p.getId(), "TimeStamp", date, "Data", p.getData(), "UpperAlarmLevel", p.getUpperAlarm(), "LowerAlarmLevel", p.getLowerAlarm(), "RSName", station.getName());
        }

        return true;
    }

    public LinkedList<Measurement> getAlarms(Calendar from, Calendar to)
    {
        LinkedList<Measurement> ms = new LinkedList<Measurement>();
        try
        {
            PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM measures WHERE Timestamp > ? AND Timestamp < ? AND (Data > UpperAlarmLevel OR Data < LowerAlarmLevel);");
            statement.setTimestamp(0, new Timestamp(from.getTimeInMillis()));
            statement.setTimestamp(1, new Timestamp(to.getTimeInMillis()));
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                ms.add(new Measurement(result.getInt("ProbeID"), getCalendarFromTimestamp(result.getTimestamp("TimeStamp")), result.getString("RSName"), result.getDouble("Data"), result.getDouble("UpperAlarmLevel"), result.getDouble("LowerAlarmLevel")));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(MeasuresTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ms;
    }
    
    private Calendar getCalendarFromTimestamp(Timestamp stamp)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(stamp.getTime());
        return cal;
    }

    public double[] getTemperatures(Calendar from, Calendar to)
    {
        LinkedList<Double> temps = new LinkedList<Double>();
        try
        {
            ResultSet result;
            Timestamp ts1 = new Timestamp(from.getTimeInMillis());
            Timestamp ts2 = new Timestamp(to.getTimeInMillis());


            result = getMeasure(ts1, ts2);

            while (result.next())
            {
                temps.add(result.getDouble("Data"));
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            Logger.getLogger(MeasuresTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        double[] t = new double[temps.size()];
        for (int i = 0; i < t.length; i++)
        {
            t[i] = temps.get(i);
        }
        return t;
    }

    public ResultSet getMeasure(int probeID, java.sql.Timestamp ts)
    {
        return connection.selectFromWhereEquals("measures", "ProbeID", probeID, "TimeStamp", ts);
    }

    public ResultSet getMeasure(java.sql.Timestamp ts1, java.sql.Timestamp ts2)
    {
        // SELECT * FROM `measures` WHERE `TimeStamp` > '2008-04-15 21:00:00' AND `TimeStamp` < '2008-04-16 21:00:00';
        return connection.selectFromWhereFromTo("measures", "TimeStamp", ts1, "TimeStamp", ts2);
    }
}
