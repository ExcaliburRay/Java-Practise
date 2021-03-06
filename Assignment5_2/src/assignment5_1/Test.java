/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MSI-PC
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        List<InventoryItem> it = new ArrayList<InventoryItem>();
        it = insert();
        System.out.println("Please Input url");
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        objectSteamWrite(it,url);
        objectStreamRead(url);
    }
    public static void objectSteamWrite(List<InventoryItem> it,String url) throws FileNotFoundException, IOException{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(url));
        os.writeObject(it);
        os.close();
        System.out.println("Write Object Stream successfully");
    }
    
     public static List<InventoryItem> objectStreamRead(String url) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url));
        List<InventoryItem> it = (List<InventoryItem>)ois.readObject();
        System.out.println("Read Object Stream successfully");
        return it;
     }
     
     public static List<InventoryItem> insert(){
        List<InventoryItem> it = new ArrayList<InventoryItem>();
        Scanner sc = new Scanner(System.in);
        String state = "";
        System.out.println("Press any word to insert, with finish by word end");
        while(!(state.equals("end"))){
            System.out.println("Please input the name of your item");
            String ItemName = "";
            boolean CheckOne = false;
            while(!CheckOne){
                try{
                    ItemName = sc.nextLine();
                    CheckOne = true;
                }catch(Exception e){
                    System.out.println("input invalid,Please input valid");
                }
            }
            System.out.println("Please input the name of your itemID");
            boolean CheckTwo = false;
            int ItemId = 0;
            while(!CheckTwo){
                try{
                    ItemId = Integer.parseInt(sc.nextLine());
                    CheckTwo = true;
                }catch(Exception e){
                    System.out.println("input invalid,Please input valid");
                }
            }
            it.add(new InventoryItem(ItemName,ItemId));
            System.out.println("Insert Success!Do you want to move on? Finish with end");         
            state = sc.nextLine();           
            }
        sort(it);
        for(int i=0;i<it.size();i++){
            System.out.println(it.get(i).getName()+" "+it.get(i).getUniqueItemID());
        }
        return it;
     }

}
