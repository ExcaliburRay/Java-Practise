/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * connect to the database
 * @author MSI-PC
 */
public class DBHelper {
    private Connection conn;

    /**
     * constructor that connect the database
     * @throws ClassNotFoundException cannot found the class
     * @throws SQLException illegal SQL
     */
    public DBHelper() throws ClassNotFoundException, SQLException{
        //config the environment,connect the database with route,username and password
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/cruise","ray","123456");
    }

    /**
     * get the connection object
     * @return connection object
     */
    public Connection getConn() {
        return conn;
    }
    
}
