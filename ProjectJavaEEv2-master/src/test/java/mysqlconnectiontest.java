/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jee.model.Credentials;
import jee.model.DataAccess;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Julien
 */
public class mysqlconnectiontest {
    
    public mysqlconnectiontest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
       try {
           System.out.println("mysqlconnectiontest.hello()");
            Class.forName("com.mysql.jdbc.Driver");
            
           String dbUrl = "jdbc:mysql://localhost:3306/projectjeev2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
           String user= "root";
            String pwd = "";
            Connection dbConn = DriverManager.getConnection(dbUrl, user, pwd);
            System.out.println("mysqlconnectiontest.hello()");
            System.out.println(dbConn);
             Statement stmt = dbConn.createStatement();
              ArrayList<Credentials> usersList = new ArrayList<>();
               ResultSet rs=null;
              rs = stmt.executeQuery("Select * from CREDENTIALS");
        try {
            while (rs.next()) {
                Credentials u = new Credentials();
                u.setLogin(rs.getString("LOGIN"));
                u.setPwd(rs.getString("PWD"));
                System.out.println(u);
                usersList.add(u);
            }
           
        } catch (SQLException ex) {
            
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        } catch (Exception e) {
            System.out.println(e);
        }
       
       //fail();
     }
}
