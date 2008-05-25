/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades.rmi;

import dk.iha.onk.group1.interfaces.ITssFacadeFactory;
import dk.iha.onk.group1.interfaces.ITssFacade;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class TssFacadeFactory extends UnicastRemoteObject implements ITssFacadeFactory, Serializable
{
	public TssFacadeFactory() throws RemoteException
	{
		super();
	}
	
	public ITssFacade createFacade(String facadeName,String username, String password) throws RemoteException
	{
		try
		{
			Constructor contructor = Class.forName("dk.iha.onk.group1.server.facades.rmi."+facadeName).getConstructors()[0];
			ITssFacade facade = (ITssFacade)contructor.newInstance(new Object[]{});
			if(facade.login(username, password) == false)
				return null;
			return facade;
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	

}
