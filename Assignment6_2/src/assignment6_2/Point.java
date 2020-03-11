/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6_2;

import java.util.Comparator;

/**
 * Point class
 * @author Ray
 */
public class Point implements Comparable<Object>{

    private int x;
    private int y;

    /**
     * constructor with arguments
     * @param x 
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getter and setter methods
    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    //override the compareTo method by comparing X axis first and then y Axis
    @Override
    public int compareTo(Object o) {
        Point point = (Point)o;
        if(point.getX()==this.getX()){
            if(point.getY()==this.getY()){
                return 0;
            }else if(point.getY()<this.getY()){
                return -1;
            }else{
                return 1;
            }
        }else if(point.getX()<this.getX()){
            return -1;
        }else{
            return 1;
        }
    }
    
    //override the toString method to print one specific format
    public String toString(){
        int x = this.getX();
        int y = this.getY();
        String record = "Point:  "+"Xaxis: "+x+"  "+"Yaxis: "+y;
        return record;
    }
    
    //inner class CompareY implement Comparator method that used to compare two 
    //points by their Y Axis first and then X Axis
    static class CompareY implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            Point pointOne = (Point)o1;
            Point pointTwo = (Point)o2;
            if(pointOne.getY()==pointTwo.getY()){
                if(pointOne.getX()==pointTwo.getX()){
                    return 0;
                }else if(pointOne.getX()<pointTwo.getX()){
                    return -1;
                }else{
                    return 1;
            }
            }else if(pointOne.getY()<pointTwo.getY()){
                return -1;
            }else{
                return 1;
            }
        }
    }
     
}
