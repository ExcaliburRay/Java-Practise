/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import question1.Cruise;
import question1.InsertData;

/**
 * FXML Controller class
 * set the method in generating cruise and ship 
 * @author Ray
 */
public class FXMLCreateCruiseController implements Initializable {

    private int cruiseID;
    @FXML
    private Button btnCreate;
    @FXML
    private TextField tfCruise;
    @FXML
    private TextField tfSa;
    @FXML
    private TextField tfRa;
    @FXML
    private TextField tfDp;
    @FXML
    private TextField tfShip;

    //getter and setter methods
    /**
     *
     * @return
     */
    public int getCruiseID(){
        return cruiseID;
    }

    /**
     *
     * @param cruiseID
     */
    public void setCruiseID(int cruiseID) {
        this.cruiseID = cruiseID;
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void buttonActionCreate(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {        
        //new on support and InsertData object to use its methods
        Support support = new Support();
        InsertData insert = new InsertData();
        if(support.checkInt(tfCruise)&&support.checkDate(tfSa)&&support.checkDate(tfRa)&&support.checkInt(tfShip)){
            //insert cruise and ship information to DB
            Cruise cruise = new Cruise(Integer.parseInt(tfCruise.getText()),Date.valueOf(tfSa.getText()),Date.valueOf(tfRa.getText()),tfDp.getText());
            insert.insertToCruiseShip(Integer.parseInt(tfCruise.getText()),Integer.parseInt(tfShip.getText()));
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("FXMLMatchPort.fxml").openStream());
            FXMLMatchPortController portController = (FXMLMatchPortController)loader.getController();
            portController.getID(tfCruise.getText());
            //jump to another scene and transfer ID
            support.move(event, root);
        }
    }
    
}
