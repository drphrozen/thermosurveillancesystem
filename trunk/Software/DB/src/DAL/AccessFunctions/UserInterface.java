/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.AccessFunctions;

import java.util.Calendar;
import java.sql.ResultSet;
import DAL.database.*;
import java.sql.Timestamp;

/**
 *
 * @author Martin
 */
public class UserInterface
{
    MySQLConnector connection;
    MeasuresTable measures;
    UserTable users;
    ProbeTable probes;
    UnitsTable units;
    RSTable rs;
    ResultSet tempresult;
    ProbeDTO pDTO;
    ProbeDTO[] pDTOArray;
    ReadingStationDTO rsDTO;
    ReadingStationDTO[] rsDTOArray;
    Calendar now;
        
    public UserInterface()
    {
        connection = MySQLConnector.getInstance();
        measures = new MeasuresTable();
        probes = new ProbeTable();
        users = new UserTable();
        units = new UnitsTable();
        rs = new RSTable();
        now = Calendar.getInstance();
    }
    
    public String getHistoricalData(Calendar from, Calendar to)
    {
        java.sql.Timestamp ts1 = Timestamp.valueOf(from.toString());
        java.sql.Timestamp ts2 = Timestamp.valueOf(to.toString());

        tempresult = measures.getMeasure(ts1, ts2);
        int count = 0;
        while(connection.next(tempresult))
        {
            count++;
        }
        return "In the periode " + from.toString() + " - " + to.toString() + " there has been " + count + " measurements.";
    }
    
    public ReadingStationDTO[] getReadings(Calendar from, Calendar to)
    {
        ResultSet measureresult;
        ResultSet proberesult;
        ResultSet unitresult;
        ResultSet rsresult;
        
        pDTO = new ProbeDTO();
        int numberOfRows = 0;
        int currentRow = 0;
        int probeID = 0;
        int rsID = 0;
        Calendar temptimestamp = Calendar.getInstance();
        java.sql.Timestamp ts1 = Timestamp.valueOf(from.toString());
        java.sql.Timestamp ts2 = Timestamp.valueOf(to.toString());

        try
        {
            measureresult = measures.getMeasure(ts1, ts2);
        
            if(measureresult.last())
            {
                numberOfRows = measureresult.getRow();
                
                measureresult.first();
            }
            else
            {
                return null;
            }

            rsDTOArray = new ReadingStationDTO[numberOfRows];

            while(connection.next(measureresult))
            {
                probeID = measureresult.getInt("ProbeID");
                pDTO.setId(probeID);
                pDTO.setData(measureresult.getDouble("Data"));

                proberesult = probes.getProbe(probeID);                
                pDTO.setUpperAlarm(proberesult.getDouble("UpperAlarmLevel"));
                pDTO.setLowerAlarm(proberesult.getDouble("LowerAlarmLevel"));
                
                pDTO.setUnits(units.getUnitText(probeID));
                
//                rsDTOArray[currentRow].
//                rsDTOArray[currentRow].setEnabled(enabled)
//                rsDTOArray[currentRow].setProbeId(tempresult.getInt("ProbeID"));
//
//                rsDTOArray[currentRow].setReadingStationName(connection.getString(tempresult, "RSName"));
//
//                temptimestamp.setTime(tempresult.getDate("TimeStamp"));
//                rsDTOArray[currentRow].setTimestamp(temptimestamp);

                currentRow++;
            }
            
            
        }
        catch(Exception ex)
        {
            
        }
        finally
        {
            return rsDTOArray;
        }
    }
    
    public MeasurementDTO[] getLastHourOfReadings()
    {
        return null;
//        int numberOfRows = 0;
//        int currentRow = 0;
//        Calendar temptimestamp = Calendar.getInstance();
//        java.sql.Timestamp ts1 = Timestamp.valueOf(temptimestamp.toString());
//        temptimestamp.roll(Calendar.HOUR_OF_DAY, false);
//        java.sql.Timestamp ts2 = Timestamp.valueOf(temptimestamp.toString());
//
//        try
//        {
//            tempresult = measures.getMeasure(ts1, ts2);
//        
//            if(tempresult.last())
//            {
//                numberOfRows = tempresult.getRow();
//                tempresult.first();
//            }
//            else
//            {
//                return null;
//            }
//
//            mDTOArray = new MeasurementDTO[numberOfRows];
//
//            while(connection.next(tempresult))
//            {
//                mDTOArray[currentRow].setProbeId(tempresult.getInt("ProbeID"));
//
//                mDTOArray[currentRow].setReadingStationName(tempresult.getString("RSName"));
//
//                temptimestamp.setTime(tempresult.getDate("TimeStamp"));
//                mDTOArray[currentRow].setTimestamp(temptimestamp);
//
//                currentRow++;
//            }
//        }
//        catch(Exception ex)
//        {
//            
//        }
//        finally
//        {
//            return mDTOArray;
//        }
    }
    
    public boolean login(UserDTO in0)
    {
        tempresult = users.getUser(in0.getUsername());
        boolean result = false;
        
        try
        {
            // If(users exist && password matches && user is type 2(User))
            if(connection.next(tempresult) && connection.getString(tempresult, "Pwd").matches(in0.getPassword()) && tempresult.getInt("Type") == 2)
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
