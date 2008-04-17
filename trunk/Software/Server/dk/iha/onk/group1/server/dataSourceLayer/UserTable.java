package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.UserDTO;
import dk.iha.onk.group1.server.pojo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserTable
{
	private MySQLConnector connection;

	public UserTable()
        {
            connection = MySQLConnector.getInstance();
	}
        
        public LinkedList<User> getUsers()
        {
            User user = null;
            LinkedList<User> users = new LinkedList<User>();
            
            try
            {
                ResultSet resultset = connection.selectFrom("accounts");
                while (resultset.next())
                {
                    user = new User();
                    user.setUsername(resultset.getString("UserID"));
                    user.setUsername(resultset.getString("Type"));
                    users.add(user);
                }
            } catch (SQLException ex)
            {
                Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
            }
            return users;
        }
        
	public boolean addUser(User user)
	{
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("accounts", "UserID", user.getUsername());

            if(connection.next(resultset))
            {
                return false;
            }
            else
            {
                connection.insertInto3Values("accounts", "UserID", user.getUsername(), "Pwd", user.getPassword(), "Type", String.valueOf(user.getAccountTypeId()));

                resultset = connection.selectFromWhereEquals("accounts", "UserID", user.getUsername());

                return true;
            }
	}

	public boolean removeUser(String username)
	{
            connection.deleteFromWhere("accounts", "UserID", username);
            return true;
	}

        public boolean updateUser(User oldUser, User newUser)
        {
            //connection.updateSetWhere("accounts", "Pwd", , condition);
            return false;
        }
        
	public boolean changePassword(String username, String oldPassword, String newPassword)
	{
            connection.updateSetWhere("accounts", "Pwd", newPassword, "`UserID` = '" + username + "' and `Pwd` = '" + oldPassword + "'");
            return true;
	}
        
        public boolean changeType(String username, String password, String newType)
	{
            connection.updateSetWhere("accounts", "Type", newType, "`UserID` = '" + username + "' and `Pwd` = '" + password + "'");
            return true;
	}
        
        public boolean changeUsername(String oldUsername, String password, String newUsername)
	{
            connection.updateSetWhere("accounts", "UserID", newUsername, "`UserID` = '" + oldUsername + "' and `Pwd` = '" + password + "'");
            return true;
	}

	public UserDTO getUser(UserDTO usr)
	{
            UserDTO user = null;
            try
            {
                ResultSet resultset = connection.selectFromWhereEquals("accounts", "username", usr.getUsername());
                if (resultset.next())
                {
                    user = new UserDTO();
                    user.setUsername(resultset.getString("UserID"));
                }
            } catch (SQLException ex)
            {
                Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
            }
            return user;
	}
        
        public boolean authenticate(UserDTO user)
        {
            // needs implementation
            return false;
        }
}
