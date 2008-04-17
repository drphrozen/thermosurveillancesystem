package DAL.database;

import java.sql.ResultSet;
import java.sql.Date;

public class MeasuresTable
{
	MySQLConnector connection;

	public MeasuresTable()
	{
		connection = MySQLConnector.getInstance();
	}

	public boolean addMeasure(int probeID, java.util.Date date, double data, double upAlarmLvl, double lowAlarmLvl, String RSName )
	{
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("measures", "TimeStamp", String.valueOf(date));

            // INSERT INTO `measures` ( `ProbeID` , `TimeStamp` , `Data` ) VALUES ( '2', '2008-04-15 20:05:37', '-17.3' );
            connection.insertInto6Values("measures", "ProbeID", probeID, "TimeStamp", date, "Data", data, "UpperAlarmLevel", upAlarmLvl, "LowerAlarmLevel", lowAlarmLvl, "RSName", RSName);
            return true;
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
