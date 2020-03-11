/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;
import java.sql.Statement;



/**
 * create table
 * @author MSI-PC
 */
public class TableGenerator {
    String sqlCRUISE = "CREATE TABLE CRUISE ("
            + "CRUISEID INTEGER not null primary key,"
            + "SAILINGDATE DATE,"
            + "RETURNDATE DATE,"
            + "DEPARTURE VARCHAR(50)"
            + ")";
    
    String sqlSHIP = "CREATE TABLE SHIP ("
            + "SHIPID INTEGER not null primary key,"
            + "SHIPNAME VARCHAR(50),"
            + "WEIGHT INTEGER,"
            + "BUILTYEAR INTEGER,"
            + "CAPACITY INTEGER"
            + ")";
    
    String sqlSAILOR = "CREATE TABLE SAILOR ("
            + "SAILORID INTEGER not null primary key,"
            + "SAILORNAME VARCHAR(50),"
            + "DOB DATE,"
            + "NATIONALITY VARCHAR(50),"
            + "SUPERVISOR VARCHAR(50)"
            + ")";
    
    String sqlPORT = "CREATE TABLE PORT (" 
            + "PORTID INTEGER not null primary key,"
            + "PORTNAME VARCHAR(50),"
            + "COUNTRYBELONG VARCHAR(50)," 
            + "POPULATION INTEGER," 
            + "PASSPORT BOOLEAN," 
            + "DOCKINGFEE INTEGER" 
            + ")";
    
    String sqlPASSENGER = "CREATE TABLE PASSENGER (" 
            + "PASSENGERID INTEGER not null primary key,"
            + "PASSENGERNAME VARCHAR(50)," 
            + "HOMEADDRESS VARCHAR(50)," 
            + "NATIONALITY VARCHAR(50)," 
            + "DOB DATE,"
            + "AGE INTEGER,"
            + "MONEYPAID INTEGER" 
            + ")";
    
    String sqlCRUISESHIP = "CREATE TABLE CRUISESHIP (" 
            + "CRUISEID INTEGER," 
            + "SHIPID INTEGER," 
            + "PRIMARY KEY (CRUISEID,SHIPID)," 
            + "FOREIGN KEY (CRUISEID) REFERENCES CRUISE(CRUISEID)," 
            + "FOREIGN KEY (SHIPID) REFERENCES SHIP(SHIPID)" 
            + ")";
      
    String sqlSHIPSAILOR = "CREATE TABLE SHIPSAILOR (" 
            + "SHIPID INTEGER," 
            + "SAILORID INTEGER," 
            + "PRIMARY KEY (SHIPID,SAILORID)," 
            + "FOREIGN KEY (SHIPID) REFERENCES SHIP(SHIPID)," 
            + "FOREIGN KEY (SAILORID) REFERENCES SAILOR(SAILORID)" 
            + ")";
    
    String sqlCRUISEPORT = "CREATE TABLE CRUISEPORT (" 
            + "CRUISEID INTEGER," 
            + "PORTID INTEGER," 
            + "PRIMARY KEY (CRUISEID,PORTID)," 
            + "FOREIGN KEY (CRUISEID) REFERENCES CRUISE(CRUISEID)," 
            + "FOREIGN KEY (PORTID) REFERENCES PORT(PORTID)" 
            + ")";
    
    String sqlCRUISEPASSENGER = "CREATE TABLE CRUISEPASSENGER ("
            + "CRUISEID INTEGER,"
            + "PASSENGERID INTEGER," 
            + "PRICE INTEGER," 
            + "RATE DOUBLE," 
            + "PRIMARY KEY (CRUISEID,PASSENGERID)," 
            + "FOREIGN KEY (CRUISEID) REFERENCES CRUISE(CRUISEID)," 
            + "FOREIGN KEY (PASSENGERID) REFERENCES PASSENGER(PASSENGERID)" 
            +")";
    
    /**
     * use SQL to build table in database
     * @throws ClassNotFoundException cannot found this database
     * @throws SQLException illegal SQL
     */
    public void setTable() throws ClassNotFoundException, SQLException{
        //connect to the databse
        DBHelper db = new DBHelper();
        try{
        Statement st = db.getConn().createStatement();
        //generate the mutiple tables
        try{
            st.execute(sqlCRUISE);
            st.execute(sqlSHIP);
            st.execute(sqlSAILOR);
            st.execute(sqlPORT);
            st.execute(sqlPASSENGER);
            st.execute(sqlCRUISESHIP);
            st.execute(sqlSHIPSAILOR);
            st.execute(sqlCRUISEPORT);
            st.execute(sqlCRUISEPASSENGER);
        }catch(SQLTransactionRollbackException e){
            System.out.println("Tables already exists");
        }
        System.out.println("success");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
