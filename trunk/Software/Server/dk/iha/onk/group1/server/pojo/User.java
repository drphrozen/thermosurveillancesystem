/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.pojo;

/**
 *
 * @author dk021998
 */
public class User implements Comparable<User>
{
    private String username;
    private String password;
    private int accountTypeId;

    public User()
    {
        setUsername("Unknown");
        setPassword("");
        setAccountTypeId(0);
    }
    
    public User(String username, String password, int accountTypeId)
    {
        setUsername(username);
        setPassword(password);
        setAccountTypeId(accountTypeId);
    }
    
    public int compareTo(User u)
    {
        return this.getUsername().compareTo(u.getUsername());
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getAccountTypeId()
    {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId)
    {
        this.accountTypeId = accountTypeId;
    }

}
