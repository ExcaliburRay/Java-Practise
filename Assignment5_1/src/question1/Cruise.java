/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * generate and manage cruise object
 * @author MSI-PC
 */
public class Cruise {
    private int cruiseID;
    private Date sailingDate;
    private Date returnDate;
    private String departure;
    private DBHelper db;
    
    /**
     * constructor that connect to the database 
     * @param cruiseID cruise unique number
     * @param sailingDate date of sailing
     * @param returnDate return date
     * @param departure departure position
     * @throws ClassNotFoundException cannot found this class
     * @throws SQLException illegal SQL
     */
    public Cruise(int cruiseID, Date sailingDate, Date returnDate, String departure) throws ClassNotFoundException, SQLException {
        db = new DBHelper();
        try {
        //insert data to cruise table with error handling
        String prepareSQL = "INSERT INTO CRUISE(CRUISEID,SAILINGDATE,RETURNDATE,DEPARTURE) VALUES (?,?,?,?)";
        PreparedStatement pres = db.getConn().prepareStatement(prepareSQL);
        pres.setInt(1, cruiseID);
        pres.setDate(2, sailingDate);
        pres.setDate(3, returnDate);
        pres.setString(4, departure);
        pres.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Record Already exists.");
        }
        this.cruiseID = cruiseID;
        this.sailingDate = sailingDate;
        this.returnDate = returnDate;
        this.departure = departure;
    }
    /**
     * getter and setter method of each attribute of Cruise
     */
    /**
     * obtain the id of cruise
     * @return cruiseID
     */
    public int getCruiseID() {
        return cruiseID;
    }

    /**
     * 
     * @return 
     */
    public Date getSailingDate() {
        return sailingDate;
    }

    /**
     * 
     * @return
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     *
     * @return
     */
    public String getDeparture() {
        return departure;
    }

    /**
     *
     * @param cruiseID
     */
    public void setCruiseID(int cruiseID) {
        this.cruiseID = cruiseID;
    }

    /**
     *
     * @param sailingDate
     */
    public void setSailingDate(Date sailingDate) {
        this.sailingDate = sailingDate;
    }

    /**
     *
     * @param returnDate
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     *
     * @param departure
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    
}
