package dk.iha.onk.group1.server;

public class UserDTO 
{
    private String username;
    private String password;
    private int accountTypeId;
    
    public UserDTO()
    {
        setUsername("Unknown");
        setPassword("0");
        setAccountTypeId(-1);
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
