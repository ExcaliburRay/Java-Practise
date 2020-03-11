/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * connect to the Derby
 * @author Ray
 */
public class DBconnector {

    /**
     * connect to the derby
     * @return connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/cruise","ray","123456");
        return connection;
    }
}
