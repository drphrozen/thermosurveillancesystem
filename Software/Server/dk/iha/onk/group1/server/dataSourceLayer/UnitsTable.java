/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.server.dataSourceLayer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Martin
 */
public class UnitsTable {

    private MySQLConnector connection;

    public UnitsTable()
    {
            connection = MySQLConnector.getInstance();
    }
    
    public ResultSet getAllUnits()
    {
        return connection.selectFrom("units");
    }
    
    public int addUnit(String unitname)
    {
        ResultSet resultset = null;
        resultset = connection.selectFromWhereEquals("units", "UnitText", unitname);
        
        if(connection.next(resultset))
        {
            return 0;
        }
        else
        {
            connection.insertInto1Value("units", "UnitText", unitname);
            
            resultset = connection.selectFromWhereEquals("units", "UnitText", unitname);

            return 1;
        }
    }
    
    public boolean removeUnit(String unitname)
    {
        ResultSet resultset = null;
        resultset = connection.selectFromWhereEquals("units", "UnitText", unitname);
        
        connection.deleteFromWhere("units", "UnitText", unitname);
        return true;
    }
    
    public String getUnitText(int unitID)
    {
        ResultSet result;
        String stringresult = "";
        result = connection.selectFromWhereEquals("units", "Unit", unitID);
        
        try
        {
            stringresult = result.getString("UnitText");
        }
        catch (Exception ex)
        {
            
        }
        return stringresult;
    }
    
    public ResultSet getUnit(int unitID)
    {
        return connection.selectFromWhereEquals("units", "Unit", unitID);
    }
    
    public int getUnitID(String unitname)
    {
        // TBD
        return 0;
    }
}
