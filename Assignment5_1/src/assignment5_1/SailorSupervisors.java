/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

/**
 * class SailorSupervisors used to store information in relationship between people
 * @author Ray
 */
public class SailorSupervisors {
    
    private String sailors,supervisors;

    /**
     * constructors with arguments
     * @param sailors
     * @param supervisors
     */
    public SailorSupervisors(String sailors, String supervisors) {
        this.sailors = sailors;
        this.supervisors = supervisors;
    }

    //getter and setter methods
    /**
     *
     * @return
     */
    public String getSailors() {
        return sailors;
    }

    /**
     *
     * @param sailors
     */
    public void setSailors(String sailors) {
        this.sailors = sailors;
    }

    /**
     *
     * @return
     */
    public String getSupervisors() {
        return supervisors;
    }

    /**
     *
     * @param supervisors
     */
    public void setSupervisors(String supervisors) {
        this.supervisors = supervisors;
    }
       
}
