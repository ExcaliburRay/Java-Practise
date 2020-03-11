/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.io.IOException;
import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * the support class used to setting supporting method such as show Alert and error handling
 * @author Ray
 */
public class Support {

    /**
     * show alert when check the invalid input
     */
    public void alertInfo(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Input Invalid");
        alert.setContentText("Please input valid information");
        alert.show();
    }
    
    /**
     * error handling in check whether data is in type of Integer
     * @param tf
     * @return
     */
    public boolean checkInt(TextField tf){
        boolean state = false;
        try{
            int num = Integer.parseInt(tf.getText());
            state = true;
        }catch(Exception e){
            alertInfo();
        }
        return state;
    }
     
    /**
     * error handling in check whether data is in type of Date
     * @param tf
     * @return
     */
    public boolean checkDate(TextField tf){
        boolean state = false;
        try{
            Date date = Date.valueOf(tf.getText());
            state = true;
        }catch(Exception e){
            alertInfo();
        }
        return state;
    }
    
    /**
     * jump from one scene to another scene with information transfer
     * @param event
     * @param str
     * @throws IOException
     */
    public void move(ActionEvent event,String str) throws IOException{
        Parent viewParent = FXMLLoader.load(getClass().getResource(str));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
    
    /**
     * jump from one scene to another scene without information transfer
     * @param event
     * @param root
     * @throws IOException
     */
    public void move(ActionEvent event,Pane root) throws IOException{
        Scene viewScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
    
    /**
     * show alert when insert information successfully
     */
    public void alertSuccess(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulation");
        alert.setHeaderText("");
        alert.setContentText("Insert Success");
        alert.show();
    }
}
