/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL.OC;

/**
 *
 * @author dk021998
 */
public class User implements Comparable<User>,Transformable
{
    private String username;
    private String password;
    private int accountTypeId;

    public int compareTo(User u)
    {
        return this.getUsername().compareTo(u.getUsername());
    }

    public Object toDTO()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Transformable fromDTO()
    {
        throw new UnsupportedOperationException("Not supported yet.");
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
