/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.dataTransferObjects.UserDTO;
import dk.iha.onk.group1.server.facades.*;
import java.rmi.Naming;


public class TssClient 
{
	private static final int PORT = 1099;
	private static final String IP = "172.21.186.14";
	private static final String SERVER = "TssServer";
	
	public TssClient()
	{
		try
		{ 
			ITssFacadeFactory obj = (ITssFacadeFactory)Naming.lookup("rmi://"+IP+":"+PORT+"/"+SERVER); 
		
			IAdminFacade adminFacade = (IAdminFacade)obj.createFacade("AdminFacade","onk","kaffekande");
			for (UserDTO user: adminFacade.getUsers())
			{
				System.out.println("User: "+ user.getUsername());
			}
			IUserFacade userFacade = (IUserFacade)obj.createFacade("UserFacade","user","");
			
		} 
		catch (Exception e)
		{ 
			System.out.println("TssClient exception: " +e.getMessage()); 
			e.printStackTrace(); 
		} 
	}
	
    public static void main(String[] args)
	{ 
		new TssClient();
    } 
}
