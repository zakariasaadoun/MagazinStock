/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author intel
 */
public class ConnectionUtil {
      public static Connection getConnection()
    {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","magazinstock","123");
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
        
    }
}
