package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataSourceLayer.DataSourceFacade;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.domainObjects.User;

public class Authenticator {

    private DataSourceFacade dataSource;
    private UserMapper userMapper;

    public Authenticator() {
        dataSource = new DataSourceFacade();
        userMapper = new UserMapper();
    }

    public boolean authenticateUser(UserDTO user) {
        User usr = userMapper.transformFromDTO(user);
        return dataSource.authenticateUser(usr);
    }

    public boolean authenticateAdmin(UserDTO admin) {
        System.out.println("Auth: " + admin.getUsername() + "\t" + admin.getPassword() + "\t" + admin.getAccountType());
        User adm = userMapper.transformFromDTO(admin);
        return dataSource.authenticateUser(adm);
    }

    public boolean authenticateReadingStation(ReadingStationDTO rs) {
        /*  if (dataSource.authenticateReadingStation(rs))
        {
        
        
        }
        else
        {
        dataSource
        }*/
        return true;
    }
}
