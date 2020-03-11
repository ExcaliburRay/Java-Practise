/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * generate the report analysis of the data
 * @author MSI-PC
 */
public class Report {
    private DBHelper db;
    private Statement st;

    /**
     * constructor that connect to the database
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Report() throws ClassNotFoundException, SQLException {
        db = new DBHelper();
        st = db.getConn().createStatement();
    }
    
    /**
     * generate the revenue report
     * @throws SQLException SQL error
     */
    public void Revenue() throws SQLException {
        //obtain revenue report based by country
        String prepareNationSQL = "SELECT NATIONALITY,SUM(MONEYPAID) AS REVENUE FROM PASSENGER GROUP BY NATIONALITY";
        ResultSet rs1 = st.executeQuery(prepareNationSQL);
        while(rs1.next()){
            System.out.println(rs1.getString(1)+"   "+rs1.getInt(2));
        }
        System.out.println("-----------------------------------------------");
        //obtain revenue report based by age
        String prepareAgeSQL = "SELECT AGE,SUM(MONEYPAID) AS REVENUE FROM PASSENGER GROUP BY AGE";
        ResultSet rs2 = st.executeQuery(prepareAgeSQL);
        while(rs2.next()){
            System.out.println(rs2.getInt(1)+"   "+rs2.getInt(2));
        }
    }
    
    /**
     * generate the SailorsList report
     * @param CruiseNumber cruiseID
     * @throws SQLException SQL error
     */
    public void SailorsList(int CruiseNumber) throws SQLException{
        //generate the SailorsList report
        String prepareSQL = "SELECT SAILORNAME,SUPERVISOR FROM SAILOR WHERE SAILORID IN(SELECT SAILORID FROM SHIPSAILOR WHERE SHIPID IN(SELECT SHIPID FROM CRUISESHIP WHERE CRUISEID = ?))";
        PreparedStatement pres = db.getConn().prepareCall(prepareSQL);
        pres.setInt(1, CruiseNumber);
        ResultSet rs = pres.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1)+"   "+rs.getString(2));
        }
    }
    
    /**
     * generate the passenger sorted report
     * @throws SQLException
     */
    public void SortedPassenger() throws SQLException{
        //generate the passenger sorted report
        String prepareSQL = "SELECT PASSENGERNAME,MONEYPAID FROM PASSENGER ORDER BY MONEYPAID";
        ResultSet rs = st.executeQuery(prepareSQL);
        while(rs.next()){
            System.out.println(rs.getString(1)+"   "+rs.getInt(2));
        }
    }
    
    /**
     * generate the evaluation report
     * @param CruiseNumber cruiseID
     * @throws SQLException SQL error
     */
    public void evaluation(int CruiseNumber) throws SQLException{
        String prepareSQL = "SELECT PASSENGERNAME,RATE FROM PASSENGER, CRUISEPASSENGER WHERE PASSENGER.PASSENGERID=CRUISEPASSENGER.PASSENGERID AND CRUISEID=?";
        PreparedStatement pres = db.getConn().prepareCall(prepareSQL);
        pres.setInt(1, CruiseNumber);
        ResultSet rs = pres.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1)+"   "+rs.getDouble(2));
        }
    }
}
