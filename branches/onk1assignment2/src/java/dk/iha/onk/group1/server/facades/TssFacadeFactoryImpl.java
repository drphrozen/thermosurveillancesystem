/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.server.facades;

import java.lang.reflect.Constructor;

/**
 *
 * @author dk021998
 */
public class TssFacadeFactoryImpl implements TssFacadeFactory
{
	public TssFacade createFacade(String facadeName)
	{
		try
		{
			Constructor contructor = Class.forName("dk.iha.onk.group1.server.facades." + facadeName).getConstructors()[0];
			return (TssFacade)contructor.newInstance(new Object[]{});
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	

}
