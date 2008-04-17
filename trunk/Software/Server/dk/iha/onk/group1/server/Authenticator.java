package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataSourceLayer.MeasuresTable;

public class Authenticator 
{
    private MeasuresTable dataSource;
    
    public Authenticator()
    {
        dataSource = new MeasuresTable();
    }
    
    public boolean authenticateUser(UserDTO user)
    {
        return false;
    }
    
    public boolean authenticateAdmin(UserDTO admin)
    {
        return false;
    }
    
    public boolean authenticateReadingStation(ReadingStationDTO rs)
    {
      /*  if (dataSource.authenticateReadingStation(rs))
        {
           
            
        }
        else
        {
            dataSource
        }*/
        return true;
    }
}
