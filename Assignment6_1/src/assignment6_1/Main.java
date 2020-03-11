/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6_1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * used to analyze the frequency of letters in this document
 * @author Ray
 */
public class Main {
    
    /**
     * URL route
     */
    public static String filename = "108-0.txt";

    /**
     * count the total sum of letters
     */
    public static int total = 0;

    /**
     * execute the program
     * @param args the command line argument
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        count(readFile());
    }
    
    /**
     * used to read letter one by one in this file with judge whether or not letter
     * @return Map
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Map<String,Integer> readFile() throws FileNotFoundException, IOException{
        //read doc with stream
        File file = new File(filename);
        Reader reader;
        reader = null;
        int tempChar = 0;
        Map<String,Integer> map = new HashMap<>();
        reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
        if(file.exists()){
            while((tempChar = reader.read())!= -1){
                if(Character.isLetter((char)tempChar)){
                    total++;
                    String key = String.valueOf((char)tempChar).toLowerCase();
                    //add statistic data of letter to map
                    if (key.length() > 0) {
                        if (!map.containsKey(key)) {
                        map.put(key, 1);
                        }else{
                        int value = map.get(key);
                        value++;
                        map.put(key, value);
                        }
                    }
                }
            }           
        }
        
        return map;
        
    }
    
    /**
     * sort the result by quantity
     * @param map
     */
    public static void count(Map<String,Integer> map){
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> word1, Map.Entry<String, Integer> word2) {

                if (word1.getValue() < word2.getValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        //print words frequency
        System.out.printf("%-10s%-10s%5s%n", "WORD", "  ", "FRENQUENCY");
        System.out.println("-----------------------------");
        //set the result divide by the total num to get frequency
        for (Map.Entry<String, Integer> entry : entryList) {
            double percent = (entry.getValue() / (double) total);
            System.out.println(entry.getKey()+ "     "+ percent);

        }
    }
    
}
