/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

/**
 * insert data to several tables in database
 * @author MSI-PC
 */
public class InsertData {

    private DBHelper db;
    private Statement st;

    /**
     * constructor in using connect database method
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public InsertData() throws ClassNotFoundException, SQLException{
        db = new DBHelper();
        st = db.getConn().createStatement();
    }

    /**
     * insert data to Passenger Table
     * @throws SQLException illegal SQL
     */
    public void insertToPassenger() throws SQLException {
        //insert data to Passenger Table
        try {
            st.execute("INSERT INTO PASSENGER(PASSENGERID,PASSENGERNAME,HOMEADDRESS,NATIONALITY,DOB,AGE) VALUES (1,'A','WAYMOUTH','CHINA','1997-01-02',21)");
            st.execute("INSERT INTO PASSENGER(PASSENGERID,PASSENGERNAME,HOMEADDRESS,NATIONALITY,DOB,AGE) VALUES (2,'B','WAYMOUTH','CHINA','1991-01-03',27)");
            st.execute("INSERT INTO PASSENGER(PASSENGERID,PASSENGERNAME,HOMEADDRESS,NATIONALITY,DOB,AGE) VALUES (3,'C','WAYMOUTH','AUSTRALIA','1978-01-04',40)");
            st.execute("INSERT INTO PASSENGER(PASSENGERID,PASSENGERNAME,HOMEADDRESS,NATIONALITY,DOB,AGE) VALUES (4,'D','WAYMOUTH','AUSTRALIA','2001-01-05',17)");
            st.execute("INSERT INTO PASSENGER(PASSENGERID,PASSENGERNAME,HOMEADDRESS,NATIONALITY,DOB,AGE) VALUES (5,'E','WAYMOUTH','U.S.','1997-01-06',21)");
            st.execute("INSERT INTO PASSENGER(PASSENGERID,PASSENGERNAME,HOMEADDRESS,NATIONALITY,DOB,AGE) VALUES (6,'F','WAYMOUTH','U.S.','2001-01-07',17)");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        }
    }
    
    /**
     * insert data to Port Table
     * @throws SQLException illegal SQL
     */
    public void insertToPort() throws SQLException{
        //insert data to Port Table
        try{
            st.execute("INSERT INTO PORT(PORTID,PORTNAME,COUNTRYBELONG,POPULATION,PASSPORT,DOCKINGFEE)VALUES(1,'AA','CHINA',40000,TRUE,5)");
            st.execute("INSERT INTO PORT(PORTID,PORTNAME,COUNTRYBELONG,POPULATION,PASSPORT,DOCKINGFEE)VALUES(2,'BB','CHINA',20000,TRUE,3)");
            st.execute("INSERT INTO PORT(PORTID,PORTNAME,COUNTRYBELONG,POPULATION,PASSPORT,DOCKINGFEE)VALUES(3,'CC','CHINA',42400,TRUE,7)");
            st.execute("INSERT INTO PORT(PORTID,PORTNAME,COUNTRYBELONG,POPULATION,PASSPORT,DOCKINGFEE)VALUES(4,'DD','CHINA',23400,TRUE,5)");
            st.execute("INSERT INTO PORT(PORTID,PORTNAME,COUNTRYBELONG,POPULATION,PASSPORT,DOCKINGFEE)VALUES(5,'EE','CHINA',52400,TRUE,8)");
            st.execute("INSERT INTO PORT(PORTID,PORTNAME,COUNTRYBELONG,POPULATION,PASSPORT,DOCKINGFEE)VALUES(6,'FF','CHINA',63200,TRUE,9)");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        }
    }   
    
    /**
     * insert data to Sailor Table
     * @throws SQLException illegal SQL
     */
    public void insertToSailor() throws SQLException{
        //insert data to Sailor Table
        try{
            st.execute("INSERT INTO SAILOR(SAILORID,SAILORNAME,DOB,NATIONALITY,SUPERVISOR)VALUES(1,'LILY','2018-03-01','CHINA','RAY')");
            st.execute("INSERT INTO SAILOR(SAILORID,SAILORNAME,DOB,NATIONALITY,SUPERVISOR)VALUES(2,'JACK','2013-02-23','CHINA','BEN')");
            st.execute("INSERT INTO SAILOR(SAILORID,SAILORNAME,DOB,NATIONALITY,SUPERVISOR)VALUES(3,'BEN','2014-08-21','CHINA','BEN')");
            st.execute("INSERT INTO SAILOR(SAILORID,SAILORNAME,DOB,NATIONALITY,SUPERVISOR)VALUES(4,'DAVID','1998-03-01','CHINA','BEN')");
            st.execute("INSERT INTO SAILOR(SAILORID,SAILORNAME,DOB,NATIONALITY,SUPERVISOR)VALUES(5,'NICK','2008-09-01','CHINA','RAY')");
            st.execute("INSERT INTO SAILOR(SAILORID,SAILORNAME,DOB,NATIONALITY,SUPERVISOR)VALUES(6,'RAY','2008-03-20','CHINA','RAY')");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        }       
    }
    
    /**
     * insert data to Ship Table
     * @throws SQLException illegal SQL
     */
    public void insertToShip() throws SQLException{
        //insert data to Ship Table
        try{
            st.execute("INSERT INTO SHIP(SHIPID,SHIPNAME,WEIGHT,BUILTYEAR,CAPACITY)VALUES(1,'GOONE',40,1999,3000)");
            st.execute("INSERT INTO SHIP(SHIPID,SHIPNAME,WEIGHT,BUILTYEAR,CAPACITY)VALUES(2,'GOTWO',50,1989,5000)");
            st.execute("INSERT INTO SHIP(SHIPID,SHIPNAME,WEIGHT,BUILTYEAR,CAPACITY)VALUES(3,'GOTHREE',55,2004,6300)");
            st.execute("INSERT INTO SHIP(SHIPID,SHIPNAME,WEIGHT,BUILTYEAR,CAPACITY)VALUES(4,'GOFOUR',35,2017,8000)");
            st.execute("INSERT INTO SHIP(SHIPID,SHIPNAME,WEIGHT,BUILTYEAR,CAPACITY)VALUES(5,'GOFIVE',29,2018,3500)");
            st.execute("INSERT INTO SHIP(SHIPID,SHIPNAME,WEIGHT,BUILTYEAR,CAPACITY)VALUES(6,'GOSIX',60,2015,6000)");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        } 
    }
    
    /**
     * insert data to Sailor Table
     * @throws SQLException illegal SQL
     */
    public void insertToshipSailor() throws SQLException{
        //insert data to Sailor Table
        try{
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(1,2)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(1,4)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(1,5)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(2,1)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(2,2)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(3,5)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(4,4)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(5,2)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(5,6)");
            st.execute("INSERT INTO SHIPSAILOR(SHIPID,SAILORID)VALUES(3,3)");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        } 
    }
    
    /**
     * insert data to CruiseShip Table
     * @param CruiseNumber the cruiseID 
     * @param ShipNumber the shipID
     * @throws SQLException
     */
    public void insertToCruiseShip(int CruiseNumber,int ShipNumber)throws SQLException{
        //insert data to CruiseShip Table
        try{
            String prepareSQL = "INSERT INTO CRUISESHIP(CRUISEID,SHIPID) VALUES (?,?)";
            PreparedStatement pres = db.getConn().prepareStatement(prepareSQL);
            pres.setInt(1, CruiseNumber);
            pres.setInt(2, ShipNumber);
            pres.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        } 
    }
    
    /**
     * insert data to CruisePort Table
     * @param CruiseNumber the cruiseID
     * @param PortNumber the porrtID
     * @throws SQLException
     */
    public void insertToCruisePort(int CruiseNumber,int PortNumber)throws SQLException{
        //insert data to CruisePort Table
        try{
            String prepareSQL = "INSERT INTO CRUISEPORT(CRUISEID,PORTID) VALUES (?,?)";
            PreparedStatement pres = db.getConn().prepareStatement(prepareSQL);
            pres.setInt(1, CruiseNumber);
            pres.setInt(2, PortNumber);
            pres.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        } 
    }
    
    /**
     * insert data to CruisePassenger Table
     * @param CruiseNumber the cruiseID
     * @param PassengerNumber the passengerID
     * @param price the price of passenger paid
     * @param rate the evaluation
     * @throws SQLException
     */
    public void insertToCruisePassenger(int CruiseNumber,int PassengerNumber,int price,double rate)throws SQLException{
        //insert data to CruisePassenger Table
        try{
            String prepareSQL = "INSERT INTO CRUISEPASSENGER(CRUISEID,PASSENGERID,PRICE,RATE) VALUES (?,?,?,?)";
            PreparedStatement pres = db.getConn().prepareStatement(prepareSQL);
            pres.setInt(1, CruiseNumber);
            pres.setInt(2, PassengerNumber);
            pres.setInt(3, price);
            pres.setDouble(4, Double.valueOf(String.format("%.1f", rate)));
            pres.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        } 
    }
    
    /**
     * update the moneyPaid in table Passenger
     * @param PassengerNumber
     * @throws SQLException
     */
    public void updatePrice(int PassengerNumber) throws SQLException{
        //count the total money from CRUISEPASSENGER Table
        String prepareSQL = "SELECT PASSENGERID,SUM(PRICE) AS TOTALPRICE FROM CRUISEPASSENGER WHERE PASSENGERID = ? GROUP BY PASSENGERID";
        PreparedStatement pres = db.getConn().prepareStatement(prepareSQL);
        pres.setInt(1, PassengerNumber);
        ResultSet rs = pres.executeQuery();
        while(rs.next()){
            int price = rs.getInt("TOTALPRICE");
            if(price>0){
                //update the moneyPaid in table Passenger
                String updatePriceSQL = "UPDATE PASSENGER SET MONEYPAID=? WHERE PASSENGERID=?";
                pres = db.getConn().prepareStatement(updatePriceSQL);
                pres.setInt(1, price);
                pres.setInt(2, PassengerNumber);
                pres.executeUpdate();
            }
        }
    }
}
