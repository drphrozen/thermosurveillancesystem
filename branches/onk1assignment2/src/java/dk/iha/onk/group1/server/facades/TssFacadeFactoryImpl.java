/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author dk021998
 */
public class TssFacadeFactoryImpl extends UnicastRemoteObject implements TssFacadeFactory, Serializable
{
	public TssFacadeFactoryImpl() throws RemoteException
	{
		super();
	}
	
	public TssFacade createFacade(String facadeName) throws RemoteException
	{
		try
		{
			//Constructor contructor = Class.forName("dk.iha.onk.group1.server.facades." + facadeName).getConstructors()[0];
			//TssFacade test = (TssFacade)contructor.newInstance(new Object[]{});
			return (TssFacade) new AdminFacade();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	

}
