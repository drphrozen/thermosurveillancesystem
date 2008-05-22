package dk.iha.onk.group1.server.dataTransferObjects;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String username;
    private String password;
    private String accountType;
    private int id;

    public UserDTO() {
        setUsername(null);
        setPassword(null);
        setAccountType(null);
        setId(-1);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
