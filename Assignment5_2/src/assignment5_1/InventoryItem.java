/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.io.Serializable;

/**
 * 
 * @author MSI-PC
 */
public class InventoryItem implements Comparable<Object>,Serializable {
    private String name;
    private int uniqueItemID;

    public InventoryItem(String name, int uniqueItemID) {
        this.name = name;
        this.uniqueItemID = uniqueItemID;
    }

    public String getName() {
        return name;
    }

    public int getUniqueItemID() {
        return uniqueItemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueItemID(int uniqueItemID) {
        this.uniqueItemID = uniqueItemID;
    }

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
