/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITssFacade extends Remote
{
	boolean login(String username, String password) throws RemoteException;
}
