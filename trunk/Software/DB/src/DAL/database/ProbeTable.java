package DAL.database;

import java.sql.ResultSet;

public class ProbeTable
{
	MySQLConnector connection;

	public ProbeTable()
	{
		connection = MySQLConnector.getInstance();
	}
        
        public ResultSet getAllProbes()
        {
            return connection.selectFrom("probe");
        }

	public int addProbe(int probe, String rsName, int unit, double upALvl, double loALvl)
	{
            ResultSet resultset = null;
            ResultSet resultset2 = getProbe(probe, rsName);
            try
            {
                resultset = connection.selectFromWhereEquals("probe", "ProbeID", resultset2.getInt("Probe"), "RSID", resultset2.getInt("RSID"));
            }
            catch (Exception ex)
            {
                
            }

            if(connection.next(resultset))
            {
                return 0;
            }
            else
            {
                connection.insertInto5Values("probe", "Probe", probe, "RSName", rsName, "Unit", unit, "UpperAlarmLevel", upALvl, "LowerAlarmLevel", loALvl);
                    
                try
                {
                    resultset = connection.selectFromWhereEquals("probe", "ProbeID", resultset2.getInt("Probe"), "RSID", resultset2.getInt("RSID"));
                }
                catch(Exception ex)
                {
                    
                }

                return 1;
            }
	}

	public boolean removeProbe(int probeID)
	{
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("probe", "ProbeID", String.valueOf(probeID));

            if(connection.next(resultset))
            {
                return false;
            }
            else
            {
                connection.deleteFromWhere("probe", "ProbeID", String.valueOf(probeID));

                resultset = connection.selectFromWhereEquals("probe", "ProbeID", String.valueOf(probeID));

                return true;
            }
	}

	public boolean changeUnit(int probeID, int newUnit)
	{
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("probe", "ProbeID", probeID);

            if(connection.next(resultset))
            {
                resultset = connection.updateSetWhere("probe", "Unit", String.valueOf(newUnit), "ProbeID = " + String.valueOf(probeID));
                return true;
            }
            else
            {
                return true;
            }
	}
        
        public boolean changeRSName(int probeID, String rsName)
	{
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("probe", "ProbeID", probeID);

            if(connection.next(resultset))
            {
                resultset = connection.updateSetWhere("probe", "RSName", rsName, "ProbeID = " + probeID);
                return true;
            }
            else
            {
                return false;
            }
	}

        public boolean setUpperAlarmLevel(int probeID, double alarmLevel)
        {
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("probe", "ProbeID", probeID);

            if(connection.next(resultset))
            {
                resultset = connection.updateSetWhere("probe", "UpperAlarmLevel", alarmLevel, "ProbeID = " + probeID);
                return true;
            }
            else
            {
                return false;
            }
        }
        
        public boolean disableUpperAlarmLevel(int probeID)
        {
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("probe", "ProbeID", probeID);

            if(connection.next(resultset))
            {
                resultset = connection.updateSetWhere("probe", "UpperAlarmLevel", "NULL", "ProbeID = " + probeID);
                return true;
            }
            else
            {
                return false;
            }
        }
        
        public boolean setLowerAlarmLevel(int probeID, double alarmLevel)
        {
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("probe", "ProbeID", probeID);

            if(connection.next(resultset))
            {
                resultset = connection.updateSetWhere("probe", "LowerAlarmLevel", alarmLevel, "ProbeID = " + probeID);
                return true;
            }
            else
            {
                return false;
            }
        }
        
        public boolean disableLowerAlarmLevel(int probeID)
        {
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("probe", "ProbeID", probeID);

            if(connection.next(resultset))
            {
                resultset = connection.updateSetWhere("probe", "LowerAlarmLevel", "NULL", "ProbeID = " + probeID);
                return true;
            }
            else
            {
                return false;
            }
        }
        
	private ResultSet getProbeFromProbeID(int probeID)
	{
		return connection.selectFromWhereEquals("probe", "ProbeID", probeID);
	}
        
        private ResultSet getProbes(String rsName)
	{
            return connection.selectFromWhereEquals("probe", "RSName", rsName);
	}
        
        private ResultSet getProbe(int probe, String rsName)
	{
            return connection.selectFromWhereEquals("probe", "Probe", probe, "RSName", rsName);
	}
        
        private ResultSet getProbeFromRSID(int RSID)
	{
            return connection.selectFromWhereEquals("probe", "RSID", RSID);
	}
        
        public ResultSet getProbe(int probeID, int RSID)
        {
            return connection.selectFromWhereEquals("probe", "ProbeID", probeID, "RSID", RSID);
        }
}
