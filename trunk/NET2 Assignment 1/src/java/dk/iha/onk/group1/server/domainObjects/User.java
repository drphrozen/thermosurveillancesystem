package dk.iha.onk.group1.server.domainObjects;

/**
 *
 * @author dk021998
 */
public class User implements Comparable<User> {

    private String username;
    private String password;
    private String accountType;
    private int id;

    public User() {
        this(null, null, null, -1);
    }

    public User(String username, String accountType) {
        this(username, null, accountType, -1);
    }

    public User(String username, String password, String accountType, int id) {
        setUsername(username);
        setPassword(password);
        setAccountType(accountType);
        setId(id);
    }

    public int compareTo(User u) {
        return this.getUsername().compareTo(u.getUsername());
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
