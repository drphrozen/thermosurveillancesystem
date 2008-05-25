/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

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
			Constructor contructor = Class.forName("dk.iha.onk.group1.server.facades."+facadeName).getConstructors()[0];
			ITssFacade facade = (ITssFacade)contructor.newInstance(new Object[]{});
			facade.login(username, password);
			return facade;
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	

}
