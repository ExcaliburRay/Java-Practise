/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

/**
 * Evaluation class 
 * @author Ray
 */
public class Evaluation {
    private String PassengerName;
    private Double rate;

    /**
     * constructor with arguments
     * @param PassengerName
     * @param rate
     */
    public Evaluation(String PassengerName, Double rate) {
        this.PassengerName = PassengerName;
        this.rate = rate;
    }

    //getter and setter methods
    /**
     *
     * @return
     */
    public String getPassengerName() {
        return PassengerName;
    }

    /**
     *
     * @param PassengerName
     */
    public void setPassengerName(String PassengerName) {
        this.PassengerName = PassengerName;
    }

    /**
     *
     * @return
     */
    public Double getRate() {
        return rate;
    }

    /**
     *
     * @param rate
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }
    
    
}
