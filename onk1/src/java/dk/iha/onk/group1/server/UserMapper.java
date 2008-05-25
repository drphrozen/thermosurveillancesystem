/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.iha.onk.group1.server;

import dk.iha.onk.group1.dataTransferObjects.UserDTO;
import dk.iha.onk.group1.server.dataSourceLayer.DataSourceFacade;
import dk.iha.onk.group1.server.domainObjects.User;
import java.util.LinkedList;

public class UserMapper {

    private DataSourceFacade dataSource;

    public UserMapper() {
        dataSource = new DataSourceFacade();
    }

    public boolean addUser(UserDTO user) {
        return dataSource.addUser(transformFromDTO(user));

    }

    public boolean removeUser(String username) {
        return dataSource.removeUser(username);
    }

    public boolean updateUser(int id, UserDTO newUser) {
        if (dataSource.getUser(id) != null) {
            return dataSource.updateUser(id, transformFromDTO(newUser));
        }
        return false;
    }

    public UserDTO[] getUsers() {
        LinkedList<User> users = dataSource.getUsers();
        LinkedList<UserDTO> userDTOs = new LinkedList<UserDTO>();

        for (User u : users) {
            userDTOs.add(transformToDTO(u));
        }
        return userDTOs.toArray(new UserDTO[0]);
    }

    public User transformFromDTO(UserDTO user) {
        return new User(user.getUsername(), user.getPassword(), user.getAccountType(), user.getId());
    }

    private UserDTO transformToDTO(User user) {
        UserDTO u = new UserDTO();
        u.setId(user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setAccountType(user.getAccountType());
        return u;

    }
}
