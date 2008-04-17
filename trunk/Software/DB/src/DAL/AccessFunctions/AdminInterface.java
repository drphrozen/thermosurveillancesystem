/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.AccessFunctions;

import DAL.database.*;
import java.sql.ResultSet;
import java.util.Calendar;

/**
 *
 * @author Martin
 */
public class AdminInterface 
{
    MySQLConnector connection;
    MeasuresTable measures;
    UserTable users;
    RSTable rs;
    ResultSet tempresult;
    UserDTO userDTO;
    UserDTO[] userDTOArray;
    ReadingStationDTO rsDTO;
    ReadingStationDTO[] rsDTOArray;
    Calendar now;
    
    public AdminInterface()
    {
        connection = MySQLConnector.getInstance();
        measures = new MeasuresTable();
        users = new UserTable();
        rs = new RSTable();
        now = Calendar.getInstance();
    }
    
    public UserDTO[] getUsers()
    {
        int numberOfRows = 0;
        int currentRow = 0;

        try
        {
            tempresult = users.getAllUsers();
        
            if(tempresult.last())
            {
                numberOfRows = tempresult.getRow();
                tempresult.first();
            }
            else
            {
                return null;
            }

            userDTOArray = new UserDTO[numberOfRows];

            while(connection.next(tempresult))
            {
                userDTOArray[currentRow].setUsername(connection.getString(tempresult, "UserID"));
                userDTOArray[currentRow].setPassword(connection.getString(tempresult, "Pwd"));
                // TODO: setUserType
                currentRow++;
            }
        }
        catch(Exception ex)
        {
            
        }
        finally
        {
            return userDTOArray;
        }
    }

    public boolean removeUser(String in0)
    {
        tempresult = users.getUser(in0);
        if(connection.next(tempresult))
        {
            users.removeUser(connection.getString(tempresult, "UserID"), connection.getString(tempresult, "Pwd"));
            tempresult = users.getUser(in0);
            if(connection.next(tempresult))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean login(UserDTO in0)
    {
        tempresult = users.getUser(in0.getUsername());
        boolean result = false;
        
        try
        {
            // If(users exist && password matches && user is type 1(Admin))
            if(connection.next(tempresult) && connection.getString(tempresult, "Pwd").matches(in0.getPassword()) && tempresult.getInt("Type") == 1)
            {
                result = true;
            }
        }
        catch (Exception ex)
        {
            
        }
        return result;
    }

    public boolean addUser(String in0, String in1)
    {
        // TODO: Er type = 2 == user?
        users.addUser(in0, in1, 2);
        tempresult = users.getUser(in0);
        if(connection.next(tempresult))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean addUser(UserDTO in0)
    {
        String username = in0.getUsername();
        String password = in0.getPassword();
        
        // TODO: Er type = 2 == user?
        users.addUser(username, password, 2);
        tempresult = users.getUser(username);
        if(connection.next(tempresult))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean addAdmin(UserDTO in0)
    {
        String username = in0.getUsername();
        String password = in0.getPassword();
        
        // TODO: Er type = 1 == admin?
        users.addUser(username, password, 1);
        tempresult = users.getUser(username);
        if(connection.next(tempresult))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean addAdmin(String in0, String in1)
    {
        // TODO: Er type = 1 == admin?
        users.addUser(in0, in1, 1);
        tempresult = users.getUser(in0);
        if(connection.next(tempresult))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean updateUserInfo(UserDTO in0, UserDTO in1)
    {
        boolean result = false;
        
        String oldUsername = in0.getUsername();
        String oldPassword = in0.getPassword();
        int oldType = in0.getAccountTypeId();
        
        String newUsername = in1.getUsername();
        String newPassword = in1.getPassword();
        int newType = in1.getAccountTypeId();
        
        if(!oldUsername.matches(newUsername))
        {
            users.changeUsername(oldUsername, oldPassword, newUsername);
        }
        if(!oldPassword.matches(newPassword))
        {
            users.changePassword(oldUsername, oldPassword, newPassword);
        }
        if(oldType != newType)
        {
            users.changeType(oldUsername, oldPassword, newType);
        }
        
        tempresult = users.getUser(newUsername);
        try
        {
            if(connection.next(tempresult))
            {
                if(connection.getString(tempresult, "UserID").matches(newUsername) && connection.getString(tempresult, "Pwd").matches(newPassword) && tempresult.getInt("Type") == newType)
                {
                    result = true;
                }
            }
        }
        catch (Exception ex)
        {
            
        }
        
        return result;
    }

    public boolean setRSName(String in0, String in1)
    {
        return rs.changeRSName(in0, in1);
    }

    public boolean setRSAlarmLevel(String in0, int in1) 
    {
        return false;
    }

    public boolean enableRS(String in0) 
    {
        return rs.enableRS(in0);
    }

    public boolean disableRS(String in0)
    {
        return rs.disableRS(in0);
    }

    public ReadingStationDTO[] getReadingStations() 
    {
        int numberOfRows = 0;
        int currentRow = 0;

        try
        {
            tempresult = rs.getAllRSs();
        
            if(tempresult.last())
            {
                numberOfRows = tempresult.getRow();
                tempresult.first();
            }
            else
            {
                return null;
            }

            rsDTOArray = new ReadingStationDTO[numberOfRows];

            while(connection.next(tempresult))
            {
//                rsDTOArray[currentRow].setStationName(connection.getString(tempresult, "RSName"));
                
                // TODO: setEnabledStatus
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
}
