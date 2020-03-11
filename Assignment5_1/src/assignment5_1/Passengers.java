/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

/**
 * class passenger to store payment information
 * @author Ray
 */
public class Passengers {
    private String passengerName; 
    private int PricePayed;

    /**
     * constructors with arguments
     * @param passengerName
     * @param PricePayed
     */
    public Passengers(String passengerName, int PricePayed) {
        this.passengerName = passengerName;
        this.PricePayed = PricePayed;
    }

    //getter and setter methods
    /**
     *
     * @return
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     *
     * @param passengerName
     */
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    /**
     *
     * @return
     */
    public int getPricePayed() {
        return PricePayed;
    }

    /**
     *
     * @param PricePayed
     */
    public void setPricePayed(int PricePayed) {
        this.PricePayed = PricePayed;
    }
    
}
