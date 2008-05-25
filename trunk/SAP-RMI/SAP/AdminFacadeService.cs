using System;
using System.Collections.Generic;
using System.Text;
using dk.iha.onk.group1.dataTransferObjects;
using dk.iha.onk.group1.interfaces;

namespace SAP.AdminFacade
{
    public delegate void loginCompletedEventHandler(object sender, loginCompletedEventArgs args);
    public class AdminFacadeService
    {
        private IAdminFacade adminFacade = null;
        public event loginCompletedEventHandler loginCompleted;

        public void loginAsync(UserDTO user)
        {
            try
            {
                ITssFacadeFactory factory = (ITssFacadeFactory)java.rmi.Naming.lookup("rmi://172.21.186.14:1099/TssServer");
                adminFacade = (IAdminFacade)factory.createFacade("AdminFacade", user.getUsername(), user.getPassword());
                if(adminFacade == null)
                    loginCompleted(this, new loginCompletedEventArgs(new Exception("Username or password is incorrect!"), false));
                else
                    loginCompleted(this, new loginCompletedEventArgs(null, true));
            }
            catch (Exception ex)
            {
                loginCompleted(this, new loginCompletedEventArgs(ex, false));
            }
            
        }

        public ReadingStationDTO[] getReadingStations()
        {
            return adminFacade.getReadingStations();
        }

        public bool setRSName(int id, string name)
        {
            return adminFacade.setRSName(id, name);
        }

        public bool addUser(UserDTO user)
        {
            return adminFacade.addUser(user);
        }

        public bool disableRS(string name)
        {
            return adminFacade.disableRS(name);
        }

        public bool enableRS(string name)
        {
            return adminFacade.enableRS(name);
        }

        public UserDTO[] getUsers()
        {
            return adminFacade.getUsers();
        }
        
        public bool removeUser(string user)
        {
            return adminFacade.removeUser(user);
        }

        public bool setProbeAlarmLevel(int id, double lower, double upper)
        {
            return adminFacade.setProbeAlarmLevel(id, lower, upper);
        }

        public bool updateUserInfo(int id, UserDTO user)
        {
            return adminFacade.updateUserInfo(id, user);
        }

    }

    public class loginCompletedEventArgs
    {
        public loginCompletedEventArgs(Exception error, bool result)
        {
            Error = error;
            Result = result;
        }
        public Exception Error { get; set; }
        public bool Result { get; set; }
    }
}
