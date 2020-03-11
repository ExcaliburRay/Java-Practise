/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

/**
 * class RevenueTableByAge used to store information in payment by age
 * @author Ray
 */
public class RevenueTableByAge {
    private int age;
    private int moneyPayed;

    /**
     * constructors with arguments
     * @param age
     * @param moneyPayed
     */
    public RevenueTableByAge(int age, int moneyPayed) {
        this.age = age;
        this.moneyPayed = moneyPayed;
    }

    //getter and setter methods
    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public int getMoneyPayed() {
        return moneyPayed;
    }

    /**
     *
     * @param moneyPayed
     */
    public void setMoneyPayed(int moneyPayed) {
        this.moneyPayed = moneyPayed;
    }

    
}
