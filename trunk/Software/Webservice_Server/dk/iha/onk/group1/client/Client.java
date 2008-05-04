/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.iha.onk.group1.client;

import dk.iha.onk.group1.server.*;
import dk.iha.onk.group1.server.dataSourceLayer.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Client 
{
    public static void main(String[] args) throws InterruptedException
    {
     /*   AdminFacade a = new AdminFacade();

        Calendar c = Calendar.getInstance();

        MeasuresTable m = new MeasuresTable();
        m.addMeasure(1, new Date(), 42,23, 3, "Tester");
                c.roll(Calendar.HOUR, -1);
        System.out.println(c.getTime());
        System.out.println(Calendar.getInstance().getTime());
        System.out.println(c.getTime());
        double[] temps = m.getTemperatures(c, Calendar.getInstance());
        System.out.println(temps.length);
        
       */

        //Class.forName("org.apache.derby.jdbc.ClientDriver");
        //Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/tss", "onk", "kaffekande");
            


  //      m.setReadingStationName("Mikkels RS");
  //      m.setTimestamp(Calendar.getInstance());
  //      r.deliverReading(m);
        
    }
}
