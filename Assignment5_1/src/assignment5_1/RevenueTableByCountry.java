/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

/**
 * class RevenueTableByCountry used to store information in payment by country
 * @author Ray
 */
public class RevenueTableByCountry {
    private String country;
    private int moneypayed;

    /**
     * constructors with arguments
     * @param country
     * @param moneypayed
     */
    public RevenueTableByCountry(String country, int moneypayed) {
        this.country = country;
        this.moneypayed = moneypayed;
    }

    //getter and setter methods
    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public int getMoneypayed() {
        return moneypayed;
    }

    /**
     *
     * @param moneypayed
     */
    public void setMoneypayed(int moneypayed) {
        this.moneypayed = moneypayed;
    }

    
    
}
