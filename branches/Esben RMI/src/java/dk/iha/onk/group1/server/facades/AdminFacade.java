package dk.iha.onk.group1.server.facades;

import com.sun.xml.ws.developer.servlet.HttpSessionScope;
import dk.iha.onk.group1.server.Authenticator;
import dk.iha.onk.group1.server.ReadingStationMapper;
import dk.iha.onk.group1.server.UserMapper;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import java.io.IOException;
import javax.jws.WebService;

/**
 *
 * @author ESRA
 */
@WebService
@HttpSessionScope
public class AdminFacade {

//    @Resource
//    private WebServiceContext wsContext;
    private ReadingStationMapper rsMapper;
    private UserMapper userMapper;

//    private HttpSession GetSession() {
//        MessageContext mc = wsContext.getMessageContext();
//        HttpSession session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
//        // Get a session property "counter" from context
//        if (session == null)
//            throw new WebServiceException("No session in WebServiceContext");
//        return session;
//    }
    
    public AdminFacade() {
//        HttpSession session = GetSession();
//        rsMapper = (ReadingStationMapper)session.getAttribute("readingStationMapper");
//        userMapper = (UserMapper)session.getAttribute("userMapper");
    }
    
    public boolean login(UserDTO admin) throws IOException {
        Authenticator auth = new Authenticator();
        if (auth.authenticateAdmin(admin)) {
            rsMapper = new ReadingStationMapper();
            userMapper = new UserMapper();
            return true;
        }
//        HttpSession session = GetSession();
//        session.setAttribute("readingStationMapper", rsMapper);
//        session.setAttribute("userMapper", userMapper);
        return false;
    }

    public boolean addUser(UserDTO user) {
        return userMapper.addUser(user);
    }

    public boolean updateUserInfo(int id, UserDTO newUser) {
        return userMapper.updateUser(id, newUser);
    }

    public boolean removeUser(String username) {
        return userMapper.removeUser(username);
    }

    public boolean setRSName(int rsId, String newName) {
        return rsMapper.setRSName(rsId, newName);
    }

    public boolean setProbeAlarmLevel(int probeId, double newLowerLimit, double newUpperLimit) {
        return rsMapper.setProbeAlarmLevel(probeId, newLowerLimit, newUpperLimit);
    }

    public boolean enableRS(String rsName) {
        return rsMapper.enableReadingStation(rsName);
    }

    public boolean disableRS(String rsName) {
        return rsMapper.disableReadingStation(rsName);
    }

    public UserDTO[] getUsers() {
        return userMapper.getUsers();
    }

    public ReadingStationDTO[] getReadingStations() {
        return rsMapper.getReadingStations();
    }

}
