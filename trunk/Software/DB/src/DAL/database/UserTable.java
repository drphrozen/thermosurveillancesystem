package DAL.database;

import java.sql.ResultSet;

public class UserTable
{
	MySQLConnector connection;

	public UserTable()
	{
		connection = MySQLConnector.getInstance();
	}

        public ResultSet getAllUsers()
        {
            return connection.selectFrom("accounts");
        }
        
	public boolean addUser(String username, String password, int type)
	{
            ResultSet resultset = null;
            resultset = connection.selectFromWhereEquals("accounts", "UserID", username);

            if(connection.next(resultset))
            {
                return false;
            }
            else
            {
                connection.insertInto3Values("accounts", "UserID", username, "Pwd", password, "Type", String.valueOf(type));

                resultset = connection.selectFromWhereEquals("accounts", "UserID", username);

                return true;
            }
	}

	public boolean removeUser(String username, String password)
	{
            ResultSet result = null;
            connection.deleteFromWhere("accounts", "UserID", username, "Pwd", password);
            return true;
	}

	public boolean changePassword(String username, String oldPassword, String newPassword)
	{
            ResultSet result = null;
            connection.updateSetWhere("accounts", "Pwd", newPassword, "`UserID` = '" + username + "' and `Pwd` = '" + oldPassword + "'");
            return true;
	}
        
        public boolean changeType(String username, String password, int newType)
	{
            ResultSet result = null;
            connection.updateSetWhere("accounts", "Type", newType, "`UserID` = '" + username + "' and `Pwd` = '" + password + "'");
            return true;
	}
        
        public boolean changeUsername(String oldUsername, String password, String newUsername)
	{
            ResultSet result = null;
            
            connection.updateSetWhere("accounts", "UserID", newUsername, "`UserID` = '" + oldUsername + "' and `Pwd` = '" + password + "'");

            return true;
	}

	public ResultSet getUser(String username, String password)
	{
		return connection.selectFromWhereEquals("accounts", "UserID", username, "Pwd", password);
	}
}
