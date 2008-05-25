
package dk.iha.onk.group1.server;

import dk.iha.onk.group1.server.facades.rmi.TssFacadeFactory;
import dk.iha.onk.group1.server.facades.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class TssServer 
{
	private static final int PORT = 1099;
	private static final String IP = "172.21.186.14";
	
	public TssServer()
	{
		try 
		{ 
			TssFacadeFactory factory = new TssFacadeFactory();
			
			LocateRegistry.createRegistry(PORT);
			System.out.println( "Registry created" );
			 
			// Bind this object instance to the name "HelloServer" 
			Naming.rebind("rmi://"+IP+":"+PORT+"/TssServer", factory); 
			System.out.println("HelloServer bound in registry"); 
        }
		catch (Exception e)
		{ 
			System.out.println("HelloServer err: " + e.getMessage()); 
			e.printStackTrace(); 
        } 
	}
	
	public static void main(String[] args)
	{
		new TssServer();
	}
}
