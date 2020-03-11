/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_2;

import java.io.Serializable;

/**
 * InventoryItem class used to compare two different objects
 * @author MSI-PC
 */
public class InventoryItem implements Comparable<Object>,Serializable {
    private String name;
    private int uniqueItemID;

    /**
     * constructors with arguments
     * @param name
     * @param uniqueItemID
     */
    public InventoryItem(String name, int uniqueItemID) {
        this.name = name;
        this.uniqueItemID = uniqueItemID;
    }

    //getter and setter methods
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getUniqueItemID() {
        return uniqueItemID;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param uniqueItemID
     */
    public void setUniqueItemID(int uniqueItemID) {
        this.uniqueItemID = uniqueItemID;
    }
    //override methods and rewrite compareTo method to compare value
    @Override
    public int compareTo(Object obj) {
        InventoryItem it = (InventoryItem)obj;
        if(it.getUniqueItemID()>this.getUniqueItemID()){
            return 1;
        }else if(it.getUniqueItemID()<this.getUniqueItemID()){
            return -1;
        }else{
            return 0;
        }
    }
}
