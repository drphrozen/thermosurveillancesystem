/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataSourceLayer.MeasuresTable;
import dk.iha.onk.group1.server.dataSourceLayer.UserTable;
import dk.iha.onk.group1.server.pojo.User;
import java.util.LinkedList;

public class UserMapper 
{
    private UserTable userTable;
    
    public UserMapper()
    {
        userTable = new UserTable();
    }
    
    public boolean addUser(UserDTO user)
    {
        return userTable.addUser(transformFromDTO(user));
        
    }
    
    public boolean removeUser(String username)
    {
        return userTable.removeUser(username);
    }
    
    public boolean updateUser(UserDTO oldUser, UserDTO newUser)
    {
        return userTable.updateUser(transformFromDTO(oldUser), transformFromDTO(newUser));
    }
            
    public UserDTO[] getUsers()
    {
        LinkedList<User> users = userTable.getUsers();
        LinkedList<UserDTO> userDTOs = new LinkedList<UserDTO>();
        
        for(User u: users)
        {
            userDTOs.add(transformToDTO(u));
        }
        return userDTOs.toArray(new UserDTO[0]);
    }
    
    
    private User transformFromDTO(UserDTO user)
    {
        return new User(user.getUsername(), user.getPassword(), user.getAccountTypeId());
    }
    
    private UserDTO transformToDTO(User user)
    {
        UserDTO u = new UserDTO();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setAccountTypeId(user.getAccountTypeId());
        return u;
        
    }
    

}
