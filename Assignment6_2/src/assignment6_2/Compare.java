/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6_2;

import assignment6_2.Point.CompareY;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * class compare is used to add each point to ArrayList and sort it
 * @author Ray
 */
public class Compare {

    /**
     * execute the program
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //generate random points and sort it in two types
        ArrayList list = generate();
        sortX(list);
        System.out.println("-------------------");
        sortY(list);
        
    }
    
    /**
     * add 100 random points to one ArrayList
     * @return arrayList
     */
    public static ArrayList<Point> generate(){
        ArrayList<Point> list = new ArrayList();
        Random random = new Random();
        int x = 0,y=0;
        for(int i = 0;i<100;i++){
            x = random.nextInt(100);
            y = random.nextInt(100);
            Point point = new Point(x,y);
            list.add(point);
        }
        return list;
    }

    /**
     * sort ArrayList by x Axis
     * @param list arrayList
     */
    public static void sortX(ArrayList<Point> list){
        Collections.sort(list);
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
    /**
     * sort ArrayList by y Axis
     * @param list arrayList
     */
    public static void sortY(ArrayList<Point> list){
        Collections.sort(list,new CompareY());
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}
