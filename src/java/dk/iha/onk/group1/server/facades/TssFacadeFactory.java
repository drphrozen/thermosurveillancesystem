/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface TssFacadeFactory extends Remote
{
	TssFacade createFacade(String facadeName) throws RemoteException;
}
