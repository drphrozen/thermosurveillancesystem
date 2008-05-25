/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.server.dataSourceLayer;

import dk.iha.onk.group1.server.domainObjects.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dk021998
 */
public class UserDSL {

    private MySQLConnector connection;

    public UserDSL() {
        connection = MySQLConnector.getInstance();
    }

    public LinkedList<User> getUsers() {
        User user = null;
        LinkedList<User> users = new LinkedList<User>();
        String query = "SELECT * FROM account WHERE accounttype = 'user' OR accounttype = 'admin';";
        try {
            ResultSet resultset = connection.executeQuery(query);
            while (resultset.next()) {
                user = new User();
                user.setId(resultset.getInt("id"));
                user.setUsername(resultset.getString("username"));
                user.setAccountType(resultset.getString("accounttype"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public boolean removeUser(int id) {
        String query = "DELETE FROM account WHERE id = '" + id + "';";
        try {
            connection.executeUpdate(query);
            return true;
        } catch(Exception ex) {
            Logger.getLogger(UserDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean removeUser(String username) {
        String query = "DELETE FROM account WHERE username = '" + username + "';";
        try {
            connection.executeUpdate(query);
            return true;
        } catch(Exception ex) {
            Logger.getLogger(UserDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addUser(String username, String password, String accountType) {
        String query = "SELECT id FROM account WHERE username ILIKE '" + username + "';";
        ResultSet resultset = null;

        resultset = connection.executeQuery(query);

        if (connection.next(resultset)) {
            return false;
        } else {
            query = "INSERT INTO account (username,password,accounttype) VALUES ('" + username + "','" + password + "','" + accountType + "');";
            connection.executeUpdate(query);
            return true;
        }
    }
    
    public boolean addUser(User user) {
        return addUser(user.getUsername(), user.getPassword(), user.getAccountType());
    }

    public boolean updateUser(int userId, User newUser) {
        String query = "UPDATE account SET username = '" + newUser.getUsername() + "', accounttype = '" + newUser.getAccountType() + "' WHERE id = " + userId + " ;";
        connection.executeUpdate(query);
        return true;
    }

    public boolean authenticateUser(User user) {
        return authenticateUser(user.getUsername(), user.getPassword(), user.getAccountType());
    }

    public boolean authenticateUser(String username, String password) {
        return authenticateUser(username, password, "user");
    }

    public boolean authenticateAdmin(String username, String password) {
        return authenticateUser(username, password, "admin");
    }
    
    public boolean authenticateUser(String username, String password, String accountType) {
        System.out.println("Usr: " + username + "\t" + password + "\t" + accountType);
        String query = "SELECT id FROM account WHERE username = '" + username + "' AND password = '" + password + "' AND accounttype = '" + accountType + "';";
        ResultSet userResult = connection.executeQuery(query);
        if(userResult == null)
            return false;
        System.out.println("Query: " + query);
        System.out.println("Usr resultset: " + userResult);
        try {
            return userResult.last();
        } catch (SQLException ex) {
            Logger.getLogger(UserDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User getUser(int userId) {
        try {
            String query = "SELECT * FROM account WHERE id = " + userId + ";";
            ResultSet userResult = connection.executeQuery(query);
            if (userResult.next()) {
                return new User(userResult.getString("username"), userResult.getString("accounttype"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDSL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
