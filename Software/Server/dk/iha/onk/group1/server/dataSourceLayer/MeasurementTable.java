package dk.iha.onk.group1.server.dataSourceLayer;

import java.sql.ResultSet;
import java.sql.Date;

public class MeasurementTable
{
	private MySQLConnector connection;

	public MeasurementTable()
	{
		connection = MySQLConnector.getInstance();
	}

	public boolean addMeasure(int probeID, Date date, double data )
	{
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("measures", "TimeStamp", String.valueOf(date));

            if(connection.next(resultset))
            {
                connection.insertInto2ValuesCondition("measures", "TimeStamp", date, "Data", data, "`ProbeID` = '" + probeID + "'");
                return false;
            }
            else
            {
                connection.insertInto2ValuesCondition("measures", "TimeStamp", date, "Data", data, "`ProbeID` = '" + probeID + "'");

                resultset = connection.selectFromWhereEquals("measures", "TimeStamp", String.valueOf(date));

                return true;
            }
	}

	public double getMeasure(int probeID, Date date)
	{
            ResultSet result = null;
            double tempdouble = 0;
            result = connection.selectFromWhereEquals("measures", "TimeStamp", String.valueOf(date));
            try
            {
                tempdouble = result.getDouble(probeID);
            }
            catch (Exception ex)
            {
                
            }
            return tempdouble;
//            result = connection.selectFromWhereEquals("measures", "ProbeID", String.valueOf(probeID), "TimeStamp", String.valueOf(date));
         
            //return Float.parseFloat(connection.getString(result, "Data"));
	}
}
