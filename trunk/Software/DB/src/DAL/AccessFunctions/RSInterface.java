/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.AccessFunctions;

import DAL.database.*;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Martin
 */
public class RSInterface 
{
    MySQLConnector connection;
    RSTable rs;
    MeasuresTable measures;
    ProbeTable probes;
    UnitsTable units;
    ResultSet tempresult;
    
    public RSInterface()
    {
        connection = MySQLConnector.getInstance();
        rs = new RSTable();
        measures = new MeasuresTable();
        probes = new ProbeTable();
        units = new UnitsTable();
        
        
    }
    
    public ReadingStationDTO getStatus(String in0)
    {
        ReadingStationDTO result = new ReadingStationDTO();
        
        int numberOfRows = 0;
        int currentrow = 0;
        
        try
        {
            tempresult = probes.getProbes(in0);
            if(tempresult.last())
            {
                numberOfRows = tempresult.getRow();
                tempresult.first();
            }
            else
            {
                return null;
            }
            
            ProbeDTO[] probetable = new ProbeDTO[numberOfRows];
            while(currentrow <= numberOfRows)
            {
                // TODO: How to read data?
//                probetable[currentrow].setData("Data");
                probetable[currentrow].setId(tempresult.getInt("ProbeID"));
                probetable[currentrow].setLowerAlarm(tempresult.getDouble("LowerAlarmLevel"));
                probetable[currentrow].setUpperAlarm(tempresult.getDouble("UpperAlarmLevel"));
                probetable[currentrow].setUnits(units.getUnitText(tempresult.getInt("Unit")));
                
                currentrow++;
            }
            
            tempresult = rs.getRS(in0);

            // If(rs exist)
            if(connection.next(tempresult))
            {
                result.setName(connection.getString(tempresult, "RSName"));
                result.setEnabled(tempresult.getBoolean("Enabled"));
//                result.setProbes(probes);
                //TODO: add probes
            }
        }
        catch (Exception ex)
        {
            
        }
        
        return result;
    }

    public boolean login(ReadingStationDTO in0)
    {
        tempresult = rs.getRS(in0.getName());

        boolean result = false;
        
        try
        {
            // If(users exist && user is type 3(ReadingStation))
            if(connection.next(tempresult) && tempresult.getInt("Type") == 3)
            {
                result = true;
            }
        }
        catch (Exception ex)
        {
            
        }
        return result;
    }

    public void deliverReading(ReadingStationDTO in0)
    {
        Calendar date = GregorianCalendar.getInstance();

        for(ProbeDTO pDTO : in0.getProbes())
        {
            // TODO: How to read data?
//            measures.addMeasure(pDTO.getId(), date.getTime(), data, pDTO.getUpperAlarm(), pDTO.getLowerAlarm(), in0.getName());
        }
    }

    public void deliverAlarm(ReadingStationDTO in0)
    {
        deliverReading(in0);
    }

    public boolean present(ReadingStationDTO in0)
    {
        boolean result = false;
        
        try
        {
            tempresult = rs.getRS(in0.getName());

            // If(rs exist && rs enabled)
            if(connection.next(tempresult) && tempresult.getBoolean("Enabled"))
            {
                result = true;
            }
        }
        catch (Exception ex)
        {
            
        }
        
        return result;
    }
}
