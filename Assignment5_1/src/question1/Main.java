/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * execute the program
 * @author MSI-PC
 */
public class Main {

    /**
     * calling method to generate table,insert data,create cruise.with its passenger and give report
     * @param args the commend line arguments
     * @throws ClassNotFoundException cannot find class error
     * @throws SQLException SQL error
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        //call method to generate the table 
        TableGenerator table = new TableGenerator();
        InsertData insert = new InsertData();
        table.setTable();
        //call method to insert data
        insert.insertToPassenger();
        insert.insertToPort();
        insert.insertToSailor();
        insert.insertToShip();
        insert.insertToshipSailor();
        //input data by user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the cruise number");
        int cruiseNumber = 0;
        boolean checkFirst = false;
        while(!checkFirst){
            try{
                cruiseNumber = Integer.valueOf(sc.nextLine());
                checkFirst = true;
            }catch(Exception e){
                System.out.println("input invalid,Please input valid");
            }
        }        
        System.out.println("Please input the cruise sailing date,format yyyy-mm-dd");
        Date sailingDate = null;
        boolean checkSecond = false;
        while(!checkSecond){
            try{
                sailingDate = Date.valueOf(sc.nextLine());
                checkSecond = true;
            }catch(Exception e){
                System.out.println("input invalid,Please input valid");
            }
        } 
        System.out.println("Please input the cruise return date,format yyyy-mm-dd");
        Date returnDate = null;
        boolean checkThird = false;
        while(!checkThird){
            try{
                returnDate = Date.valueOf(sc.nextLine());
                checkThird = true;
            }catch(Exception e){
                System.out.println("input invalid,Please input valid");
            }
        } 
        System.out.println("Please input the cruise departure position");
        String departure = "";
        boolean checkFouth = false;
        while(!checkFouth){
            try{
                departure = sc.nextLine();
                checkFouth = true;
            }catch(Exception e){
                System.out.println("input invalid,Please input valid");
            }
        } 
        //build one new cruise object
        Cruise cruise = new Cruise(cruiseNumber,sailingDate,returnDate,departure);
        System.out.println("Please input the ship number in this cruise");
        int shipNumber = 0;
        //create ship that connect to cruise
        boolean checkFifth = false;
        while(!checkFifth){
            try{
                shipNumber = Integer.valueOf(sc.nextLine());
                insert.insertToCruiseShip(cruise.getCruiseID(), shipNumber);
                checkFifth = true;
            }catch(Exception e){
                System.out.println("input invalid,Please input valid");
            }
        }      
        System.out.println("Please input the port number in this cruise,end with 0");
        //create ports that connect to the ship
        int portNumber = 0;
        boolean checkSixth = false;
        while(!checkSixth){
             try{
                 portNumber = Integer.valueOf(sc.nextLine());
                 checkSixth = true;
             }catch(Exception e){
                 System.out.println("input invalid,Please input valid");
             }
         }
         while(portNumber != 0){
             insert.insertToCruisePort(cruise.getCruiseID(), portNumber);
             System.out.println("Insert success");
             System.out.println("Please input the port number in this cruise,end with 0");
             checkSixth = false;
             while(!checkSixth){
                 try{
                    portNumber = Integer.valueOf(sc.nextLine());
                    checkSixth = true;
                 }catch(Exception e){
                     System.out.println("input invalid,Please input valid");
                 }
             }
         }
        //create passenger that connect with this cruise
        System.out.println("Please input the passengerID in this cruise,end with 0");
        int passengerID = 0;
        int price = 0;
        double rate = 0;
        //generate evaluation of each passenger
            for(int i =0;i<10;i++){
                rate +=(Math.random()*10+1);
            }
            rate = rate/10;
            boolean checkSeventh = false;
            while(!checkSeventh){
                try{
                    passengerID = Integer.valueOf(sc.nextLine());
                    checkSeventh = true;
                }catch(Exception e){
                    System.out.println("input invalid,Please input valid"); 
                }
            }
            System.out.println("Please input the price you paid in this cruise");
            boolean checkEighth = false;
            while(!checkEighth){
                try{
                    price = Integer.valueOf(sc.nextLine());
                    checkEighth = true;
                }catch(Exception e){
                    System.out.println("input invalid,Please input valid");            
                }
            }
        while(passengerID != 0){
            insert.insertToCruisePassenger(cruise.getCruiseID(), passengerID,price,rate);
            insert.updatePrice(passengerID);
            System.out.println("Insert success");
            System.out.println("Please input the passengerID in this cruise,end with 0");
            checkSeventh = false;
            while(!checkSeventh){
                try{
                    passengerID = Integer.valueOf(sc.nextLine());
                    checkSeventh = true;
                }catch(Exception e){
                    System.out.println("input invalid,Please input valid"); 
                }
            }           
            if(passengerID ==0){
                break;
            }
            System.out.println("Please input the price you paid in this cruise");
            checkEighth = false;
            while(!checkEighth){
                try{
                    price = Integer.valueOf(sc.nextLine());
                    checkEighth = true;
                }catch(Exception e){
                    System.out.println("input invalid,Please input valid");            
                }
            }
            rate = 0;
            for(int i =0;i<10;i++){
                rate +=(Math.random()*10+1);
            }
            rate = rate/10;
        }
        //call methods to generate reports
        Report report = new Report();
        System.out.println("1.Revenue Report");
        report.Revenue();
        System.out.println("-----------------------------------------------");
        System.out.println("2.Sailors and Supervisors Report");
        report.SailorsList(cruise.getCruiseID());
        System.out.println("-----------------------------------------------");
        System.out.println("3.List of Passengers sorted by money");
        report.SortedPassenger();
        System.out.println("-----------------------------------------------");
        System.out.println("4.Cruise Evaluation Report");        
        report.evaluation(cruiseNumber);
    }
}
