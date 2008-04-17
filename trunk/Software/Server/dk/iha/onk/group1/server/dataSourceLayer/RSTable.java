/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.dataSourceLayer;


import dk.iha.onk.group1.server.pojo.Probe;
import dk.iha.onk.group1.server.pojo.ReadingStation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Martin
 */
public class RSTable 
{
    private MySQLConnector connection;
    
    public RSTable()
    {
        connection = MySQLConnector.getInstance();
    }
    
    public boolean isReadingStationEnabled(ReadingStation station)
    {
        try
        {
            PreparedStatement pst = connection.getConnection().prepareStatement("SELECT Enabled FROM rs WHERE RSName = ? AND Enabled = 'true';");
            pst.setString(0, station.getName());
            ResultSet result = pst.executeQuery();
            if (result.next())
                return true;
        } catch (SQLException ex)
        {
            Logger.getLogger(RSTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public LinkedList<ReadingStation> getReadingStations()
    {
        LinkedList<ReadingStation> stations = new LinkedList<ReadingStation>();
        try
        {
            LinkedList<Probe> prbs;
            ResultSet stationsSQL = connection.selectFrom("rs");
            while (stationsSQL.next())
            {
                ResultSet probes = connection.selectFromWhereEquals("probe", "RSID", stationsSQL.getInt("RSID"));
                prbs = new LinkedList<Probe>();
                while(probes.next())
                {
                    prbs.add(new Probe(probes.getInt("ProbeID"), probes.getDouble("Data"),probes.getDouble("UpperAlarmLevel"),probes.getDouble("LowerAlarmLevel")));
                }
                stations.add(new ReadingStation(stationsSQL.getString("RSName"), prbs, stationsSQL.getBoolean("Enabled"),stationsSQL.getInt("RSID") ));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(RSTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stations;
    }
    
    public ResultSet getRS(String RSName)
    {
        return connection.selectFromWhereEquals("rs", "RSName", RSName);
    }
    
    public ResultSet getRS(int RSID)
    {
        return connection.selectFromWhereEquals("rs", "RSID", RSID);
    }
    
   
    public boolean addRS(String RSName, boolean enabled)
    {
        ResultSet result;
        
        if(enabled)
        {
            connection.insertInto2Values("rs", "RSName", RSName, "Enabled", "True");
        }
        else
        {
            connection.insertInto2Values("rs", "RSName", RSName, "Enabled", "False");    
        }
        
        result = connection.selectFromWhereEquals("rs", "RSName", RSName);
        if(connection.next(result))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean enableRS(String RSName)
    {
        ResultSet result;
        connection.updateSetWhere("rs", "Enabled", "True", "`RSName` = '" + RSName + "'");

        result = connection.selectFromWhereEquals("rs", "RSName", RSName, "Enabled", "True");
        if(connection.next(result))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean disableRS(String RSName)
    {
        ResultSet result;
        connection.updateSetWhere("rs", "Enabled", "False", "`RSName` = '" + RSName + "'");

        result = connection.selectFromWhereEquals("rs", "RSName", RSName, "Enabled", "False");
        if(connection.next(result))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean changeRSName(String oldRSName, String newRSName)
    {
        ResultSet result;
        connection.updateSetWhere("rs", "RSName", newRSName, "`RSName` = '" + oldRSName + "'");

        result = connection.selectFromWhereEquals("rs", "RSName", newRSName);
        if(connection.next(result))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean removeRS(String RSName)
    {
        ResultSet result;
        connection.deleteFromWhere("rs", "RSName", RSName);
        
        result = connection.selectFromWhereEquals("rs", "RSName", RSName);
        if(!connection.next(result))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getRSID(String RSName)
    {
        ResultSet result;
        int returnvalue = -1;
        
        result = connection.selectFromWhereEquals("rs", "RSName", RSName);
        if(connection.next(result))
        {
            try
            {
                returnvalue = result.getInt("RSID");
            }
            catch (Exception ex)
            {
                
            }
        }
        return returnvalue;
    }
    
    public String getRSName(int RSID)
    {
        ResultSet result;
        String returnvalue = "";
        
        result = connection.selectFromWhereEquals("rs", "RSID", RSID);
        if(connection.next(result))
        {
            returnvalue = connection.getString(result, "RSName");
        }
        return returnvalue;
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
}
