/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAL.database.*;
/**
 *
 * @author Martin
 */
public class Test 
{
    public Test()
    {
        
    }

    public void RunTest()
    {
        try{
            MySQLConnector connection = MySQLConnector.getInstance();
            UnitsTable units = new UnitsTable();
            UserTable users = new UserTable();
            ProbeTable probes = new ProbeTable();
            MeasuresTable measures = new MeasuresTable();
            ResultSet tempresult;

            // <editor-fold defaultstate="collapsed" desc="Connection">
            System.out.print("Connecting...");
            if (connection.connect("localhost", "onk", "onk", "kaffekande") == false)
//              if (connection.connect("misc.lir.dk", "onk", "onk", "kaffekande") == false)
            {
                System.out.println("ERROR!");
                return;
            }
            System.out.println("done.");
            // </editor-fold>
            
            System.out.println("Catalog: " + connection.getCatalog());

            // <editor-fold defaultstate="collapsed" desc="UnitsTable">
            System.out.println("UnitsTable manipulation");
            tempresult = units.getAllUnits();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Unit: " + tempresult.getString("Unit") + " - " + tempresult.getString("UnitText"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Adding 2 new units -----");
            units.addUnit("Kilo");
            units.addUnit("Gram");
            tempresult = units.getAllUnits();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Unit: " + tempresult.getString("Unit") + " - " + tempresult.getString("UnitText"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("   ----- Removing 2 units -----");
            units.removeUnit("Kilo");
            units.removeUnit("Gram");
            tempresult = units.getAllUnits();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Unit: " + tempresult.getString("Unit") + " - " + tempresult.getString("UnitText"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("UnitsTable manipulation done");
            // </editor-fold>
            
            // <editor-fold defaultstate="collapsed" desc="UserTable">
            System.out.println("Usertable manipulation");
            tempresult = users.getAllUsers();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  User: " + tempresult.getString("UserID") + " - " + tempresult.getString("Pwd") + " - " + tempresult.getString("Type"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Adding 2 new users -----");
            users.addUser("Mikkel", "Rosendahl", 1);
            users.addUser("Claus", "Andersen", 2);
            tempresult = users.getAllUsers();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  User: " + tempresult.getString("UserID") + " - " + tempresult.getString("Pwd") + " - " + tempresult.getString("Type"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Change usernames -----");
            users.changeUsername("Mikkel", "Rosendahl", "DOUGH");
            users.changeUsername("Claus", "Andersen", "DOUGH2");
            tempresult = users.getAllUsers();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  User: " + tempresult.getString("UserID") + " - " + tempresult.getString("Pwd") + " - " + tempresult.getString("Type"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Change passwords -----");
            users.changePassword("DOUGH", "Rosendahl", "Rick");
            users.changePassword("DOUGH2", "Andersen", "wing");
            tempresult = users.getAllUsers();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  User: " + tempresult.getString("UserID") + " - " + tempresult.getString("Pwd") + " - " + tempresult.getString("Type"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Change types -----");
            users.changeType("DOUGH", "Rick", 3);
            users.changeType("DOUGH2", "wing", 3);
            tempresult = users.getAllUsers();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  User: " + tempresult.getString("UserID") + " - " + tempresult.getString("Pwd") + " - " + tempresult.getString("Type"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Remove users -----");
            users.removeUser("DOUGH", "Rick");
            users.removeUser("DOUGH2", "wing");
            tempresult = users.getAllUsers();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  User: " + tempresult.getString("UserID") + " - " + tempresult.getString("Pwd") + " - " + tempresult.getString("Type"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("UserTable manipulation done");
            // </editor-fold>
            
            // <editor-fold defaultstate="collapsed" desc="ProbeTable">
            System.out.println("ProbeTable manipulation");
            int tempint = 0;
            String tempstring = "";
            tempresult = probes.getAllProbes();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Probe: " + tempresult.getString("Probe") + ", RS: " + tempresult.getString("RSName") + ", ProbeID: " + tempresult.getString("ProbeID") + ", Unit: " + tempresult.getString("Unit"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Adding 2 new probes -----");
            probes.addProbe(1, "RS 1", 7);
            probes.addProbe(2, "RS 2", 8);
            tempresult = probes.getAllProbes();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Probe: " + tempresult.getString("Probe") + ", RS: " + tempresult.getString("RSName") + ", ProbeID: " + tempresult.getString("ProbeID") + ", Unit: " + tempresult.getString("Unit"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Change RS names -----");
            tempresult = probes.getProbe(1, "RS 1");
            try {
                connection.next(tempresult);
                tempint = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }
            probes.changeRSName(tempint, "RS 7");
            tempresult = probes.getProbe(2, "RS 2");
            try {
                connection.next(tempresult);
                tempint = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }
            probes.changeRSName(tempint, "RS 8");
            tempresult = probes.getAllProbes();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Probe: " + tempresult.getString("Probe") + ", RS: " + tempresult.getString("RSName") + ", ProbeID: " + tempresult.getString("ProbeID") + ", Unit: " + tempresult.getString("Unit"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Change units -----");
            tempresult = probes.getProbe(1, "RS 7");
            try {
                connection.next(tempresult);
                tempint = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }
            probes.changeUnit(tempint, 4);
            tempresult = probes.getProbe(2, "RS 8");
            try {
                connection.next(tempresult);
                tempint = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }
            probes.changeUnit(tempint, 15);
            tempresult = probes.getAllProbes();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Probe: " + tempresult.getString("Probe") + ", RS: " + tempresult.getString("RSName") + ", ProbeID: " + tempresult.getString("ProbeID") + ", Unit: " + tempresult.getString("Unit"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("   ----- Delete probes -----");
            tempresult = probes.getProbe(1, "RS 7");
            try {
                connection.next(tempresult);
                tempint = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }
            probes.removeProbe(tempint);
            tempresult = probes.getProbe(2, "RS 8");
            try {
                connection.next(tempresult);
                tempint = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }
            probes.removeProbe(tempint);
            tempresult = probes.getAllProbes();
            while (connection.next(tempresult)) {
                try {
                    System.out.println("  Probe: " + tempresult.getString("Probe") + ", RS: " + tempresult.getString("RSName") + ", ProbeID: " + tempresult.getString("ProbeID") + ", Unit: " + tempresult.getString("Unit"));
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("ProbeTable manipulation done");
            // </editor-fold>
            
            // <editor-fold defaultstate="collapsed" desc="MeasuresTable">
            System.out.println("MeasuresTable manipulation");
            double tempdouble = 0.0;
            int probe1 = 0;
            int probe2 = 0;
            probes.addProbe(1, "RS 1", 7);
            probes.addProbe(2, "RS 2", 8);

            java.sql.Timestamp ts1 = Timestamp.valueOf("2008-04-15 20:18:43");
            java.sql.Timestamp ts2 = Timestamp.valueOf("2008-01-23 07:41:17");

            tempresult = probes.getProbe(1, "RS 1");
            try {
                connection.next(tempresult);
                probe1 = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }

            tempresult = probes.getProbe(2, "RS 2");
            try {
                connection.next(tempresult);
                probe2 = tempresult.getInt("ProbeID");
            } catch (Exception ex) {
            }

            System.out.println("  ----- Current measures -----");
            tempresult = measures.getMeasure(probe1, ts1);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts1 + ", Probe: " + probe1);
            tempresult = measures.getMeasure(probe1, ts2);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts2 + ", Probe: " + probe1);


            tempresult = measures.getMeasure(probe2, ts1);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts1 + ", Probe: " + probe2);
            tempresult = measures.getMeasure(probe2, ts2);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts2 + ", Probe: " + probe2);

            System.out.println("  ----- Adding measures -----");
//            measures.addMeasure(probe1, ts1, 17.7);
//            measures.addMeasure(probe1, ts2, -3.8);
//
//            measures.addMeasure(probe2, ts1, 9.3);
//            measures.addMeasure(probe2, ts2, -739.5);

            System.out.println("  ----- Current measures -----");
            tempresult = measures.getMeasure(probe1, ts1);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts1 + ", Probe: " + probe1);
            tempresult = measures.getMeasure(probe1, ts2);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts2 + ", Probe: " + probe1);


            tempresult = measures.getMeasure(probe2, ts1);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts1 + ", Probe: " + probe2);
            tempresult = measures.getMeasure(probe2, ts2);
            try {
                connection.next(tempresult);
                tempdouble = tempresult.getDouble("Data");
            } catch (Exception ex) {
            }
            System.out.println("  Measure: " + tempdouble + ", Date: " + ts2 + ", Probe: " + probe2);

            System.out.println("MeasuresTable manipulation done");
            // </editor-fold>
            
            // <editor-fold defaultstate="collapsed" desc="Closing connection">
            System.out.print("Closing connection...");
            if (connection.close() == false) {
                System.out.println("ERROR!");
                return;
            }
            System.out.println("done.");
            // </editor-fold>
            }
            catch(Exception ex) {}
    }
}
