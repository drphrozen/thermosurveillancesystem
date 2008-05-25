/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author dk021998
 */
public interface ITssFacadeFactory extends Remote
{
	ITssFacade createFacade(String facadeName,String username, String password) throws RemoteException;
}
