/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.database;

import java.sql.ResultSet;
/**
 *
 * @author Martin
 */
public class RSTable 
{
    MySQLConnector connection;
    
    public RSTable()
    {
        connection = MySQLConnector.getInstance();
    }
    
    public ResultSet getAllRSs()
    {
        return connection.selectFrom("rs");
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
}
