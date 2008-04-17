package dk.iha.onk.group1.server.dataSourceLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MySQLConnector
{

    private static MySQLConnector instance = null;
    private Connection connection = null;

    public Connection getConnection()
    {
        return connection;
    }

    static public MySQLConnector getInstance()
    {
        if (instance == null)
        {
            instance = new MySQLConnector();
        }

        return instance;
    }

    private MySQLConnector()
    {
    }

    public boolean connect(String host, String database, String username, String password)
    {
        try
        {
            if (connection == null)
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean close()
    {
        boolean result = false;

        try
        {
            connection.close();
            result = true;
        } catch (Exception ex)
        {
        }

        return result;
    }

    public String getCatalog()
    {
        String result = null;

        try
        {
            result = connection.getCatalog();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFrom(String table)
    {
        ResultSet result = null;

        try
        {
            String sql = "SELECT * FROM `" + table + "`;";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet executeQuery(String query)
    {
        ResultSet result = null;

        try
        {
            PreparedStatement statement = connection.prepareStatement(query);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereEquals(String table, String field, String value)
    {
        ResultSet result = null;

        try
        {
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field + "` = '" + value + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereEquals(String table, String field, Date value)
    {
        ResultSet result = null;

        try
        {
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field + "` = '" + value + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereEquals(String table, String field, int value)
    {
        ResultSet result = null;

        try
        {
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field + "` = " + value + ";";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereEquals(String table, String field1, int value1, String field2, String value2)
    {
        ResultSet result = null;

        try
        {
            // SELECT * FROM `probe` WHERE `Probe` =1 AND `RSName` = 'RS 1';
            // SELECT * FROM `probe` WHERE `Probe` = 1 AND `RSName` = 'RS 1';
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field1 + "` =" + value1 + " AND `" + field2 + "` = '" + value2 + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereEquals(String table, String field1, int value1, String field2, int value2)
    {
        ResultSet result = null;

        try
        {
            // SELECT * FROM `probe` WHERE `Probe` =1 AND `RSName` = 'RS 1';
            // SELECT * FROM `probe` WHERE `Probe` = 1 AND `RSName` = 'RS 1';
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field1 + "` =" + value1 + " AND `" + field2 + "` =" + value2 + ";";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereEquals(String table, String field1, int value1, String field2, java.sql.Timestamp value2)
    {
        ResultSet result = null;

        try
        {
            // SELECT * FROM `probe` WHERE `Probe` =1 AND `RSName` = 'RS 1';
            // SELECT * FROM `probe` WHERE `Probe` = 1 AND `RSName` = 'RS 1';
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field1 + "` =" + value1 + " AND `" + field2 + "` = '" + value2 + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereFromTo(String table, String field1, java.sql.Timestamp value1, String field2, java.sql.Timestamp value2)
    {
        ResultSet result = null;

        try
        {
            // SELECT * FROM `probe` WHERE `Probe` =1 AND `RSName` = 'RS 1';
            // SELECT * FROM `probe` WHERE `Probe` = 1 AND `RSName` = 'RS 1';
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field1 + "` > '" + value1 + "' AND `" + field2 + "` < '" + value2 + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet selectFromWhereEquals(String table, String field1, String value1, String field2, String value2)
    {
        ResultSet result = null;

        try
        {
            // SELECT * FROM `probe` WHERE `Probe` = '1' AND `RSName` = 'RS 1';
            String sql = "SELECT * FROM `" + table + "` WHERE `" + field1 + "` = '" + value1 + "' AND `" + field2 + "` = '" + value2 + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto1Value(String table, String attribute, String value)
    {
        ResultSet result = null;
        try
        {
            String sql = "INSERT INTO `" + table + "` ( `" + attribute + "` ) VALUES ( '" + value + "' );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto2Values(String table, String attribute1, String value1, String attribute2, String value2)
    {
        ResultSet result = null;
        try
        {
            String sql = "INSERT INTO `" + table + "` ( `" + attribute1 + "`, `" + attribute2 + "` ) VALUES ( '" + value1 + "', '" + value2 + "' );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto3Values(String table, String attribute1, String value1, String attribute2, String value2, String attribute3, String value3)
    {
        ResultSet result = null;
        try
        {
            String sql = "INSERT INTO `" + table + "` ( `" + attribute1 + "`, `" + attribute2 + "`, `" + attribute3 + "` ) VALUES ( '" + value1 + "', '" + value2 + "', '" + value3 + "' );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto3Values(String table, String attribute1, int value1, String attribute2, java.util.Date value2, String attribute3, double value3)
    {
        ResultSet result = null;
        try
        {
            java.sql.Timestamp timestamp = new java.sql.Timestamp(value2.getTime());
            // INSERT INTO `measures` (`ProbeID`, `TimeStamp`, `Data`) VALUES ('7', '2008-08-12 09:45:16', '8.9');
            String sql = "INSERT INTO `" + table + "` ( `" + attribute1 + "`, `" + attribute2 + "`, `" + attribute3 + "` ) VALUES ( '" + value1 + "', '" + timestamp + "', '" + value3 + "' );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto5Values(String table, String attribute1, int value1, String attribute2, String value2, String attribute3, int value3, String attribute4, double value4, String attribute5, double value5)
    {
        ResultSet result = null;
        try
        {
            String sql = "INSERT INTO `" + table + "` ( `" + attribute1 + "`, `" + attribute2 + "`, `" + attribute3 + "`, `" + attribute4 + "`, `" + attribute5 + "`) VALUES ( '" + value1 + "', '" + value2 + "', '" + value3 + "', '" + value4 + "', '" + value5 + "');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto6Values(String table, String attribute1, int value1, String attribute2, java.util.Date value2, String attribute3, double value3, String attribute4, double value4, String attribute5, double value5, String attribute6, String value6)
    {
        ResultSet result = null;
        try
        {
            java.sql.Timestamp timestamp = new java.sql.Timestamp(value2.getTime());
            // INSERT INTO `measures` (`ProbeID`, `TimeStamp`, `Data`) VALUES ('7', '2008-08-12 09:45:16', '8.9');
            String sql = "INSERT INTO `" + table + "` ( `" + attribute1 + "`, `" + attribute2 + "`, `" + attribute3 + "`, `" + attribute4 + "`, `" + attribute5 + "`, `" + attribute6 + "` ) VALUES ( '" + value1 + "', '" + timestamp + "', '" + value3 + "', '" + value4 + "', '" + value5 + "', '" + value6 + "' );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto1ValueCondition(String table, String attribute, String value, String condition)
    {
        ResultSet result = null;
        ResultSet temp = null;

        try
        {
            String sql = "INSERT INTO `" + table + "` ( `" + attribute + "` ) VALUES ( '" + value + "' ) WHERE '" + condition + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto2ValuesCondition(String table, String attribute1, String value1, String attribute2, String value2, String condition)
    {
        ResultSet result = null;
        try
        {
            String sql = "INSERT INTO `" + table + "` ( `" + attribute1 + "`, `" + attribute2 + "` ) VALUES ( '" + value1 + "', '" + value2 + "' ) WHERE '" + condition + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet insertInto2ValuesCondition(String table, String attribute1, Date value1, String attribute2, double value2, String condition)
    {
        ResultSet result = null;
        try
        {
            String sql = "INSERT INTO `" + table + "` ( `" + attribute1 + "`, `" + attribute2 + "` ) VALUES ( '" + value1 + "', " + value2 + " ) WHERE " + condition + ";";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet updateSetWhere(String table, String attribute, String value, String condition)
    {
        ResultSet result = null;
        try
        {
            // UPDATE `accounts` SET `UserID` = 'HULLA' WHERE `Type` = '1';
            String sql = "UPDATE `" + table + "` SET `" + attribute + "` = '" + value + "' WHERE " + condition + ";";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet updateSetWhere(String table, String attribute, double value, String condition)
    {
        ResultSet result = null;
        try
        {
            // UPDATE `accounts` SET `UserID` = 'HULLA' WHERE `Type` = '1';
            String sql = "UPDATE `" + table + "` SET `" + attribute + "` = " + value + " WHERE " + condition + ";";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet updateSetWhere(String table, String attribute, int value, String condition)
    {
        ResultSet result = null;
        try
        {
            // UPDATE `accounts` SET `UserID` = 'HULLA' WHERE `Type` = '1';
            String sql = "UPDATE `" + table + "` SET `" + attribute + "` = " + value + " WHERE " + condition + ";";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet updateSet(String table, String attribute, String value)
    {
        ResultSet result = null;
        try
        {
            String sql = "UPDATE `" + table + "` SET `" + attribute + "` = '" + value + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet deleteFromWhere(String table, String attribute, String value)
    {
        ResultSet result = null;
        try
        {
            String sql = "DELETE FROM `" + table + "` WHERE `" + table + "`.`" + attribute + "` = '" + value + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet deleteFromWhere(String table, String attribute, int value)
    {
        ResultSet result = null;
        try
        {
            String sql = "DELETE FROM `" + table + "` WHERE `" + table + "`.`" + attribute + "` = " + value + ";";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public ResultSet deleteFromWhere(String table, String attribute1, String value1, String attribute2, String value2)
    {
        ResultSet result = null;
        try
        {
            String sql = "DELETE FROM `" + table + "` WHERE `" + table + "`.`" + attribute1 + "` = '" + value1 + "' AND `" + table + "`.`" + attribute2 + "` = '" + value2 + "';";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public boolean next(ResultSet resultSet)
    {
        boolean result = false;

        try
        {
            result = resultSet.next();
        } catch (Exception ex)
        {
        }

        return result;
    }

    public String getString(ResultSet resultSet, String field)
    {
        String result = "";

        try
        {
            result = resultSet.getString(field);
        } catch (Exception ex)
        {
        }

        return result;
    }
}
