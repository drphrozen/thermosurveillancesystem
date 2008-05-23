
package dk.iha.onk.group1.server.facades;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class TssBootstrappah 
{
	private static final int PORT = 1099;
	private static final String IP = "172.21.186.14";
	
	public TssBootstrappah()
	{
		try 
		{ 
			TssFacadeFactoryImpl obj = new TssFacadeFactoryImpl();
			
			LocateRegistry.createRegistry(PORT);
			System.out.println( "Registry created" );
			
		//	UnicastRemoteObject.exportObject(obj);

			 
			// Bind this object instance to the name "HelloServer" 
			Naming.rebind("rmi://"+IP+":"+PORT+"/TssServer", obj); 
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
		new TssBootstrappah();
	}
}
