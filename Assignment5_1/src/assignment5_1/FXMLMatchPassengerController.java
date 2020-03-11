/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import question1.InsertData;

/**
 * FXML Controller class
 * set the method in add passenger to each cruise
 * @author Ray
 */
public class FXMLMatchPassengerController implements Initializable {

    @FXML
    private Button btnNext3;
    @FXML
    private TextField tfPassenger;
    @FXML
    private TextField tfPrice;
    @FXML
    private Text textTwo;
    @FXML
    private Text cruiseID3;

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
    private void actionEventNextThree(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        //new on support,TableGenerator and InsertData object to use its methods
        Support support = new Support();      
        InsertData insert = new InsertData();
        int id = 0;
        double rate = 0;
        if(support.checkInt(tfPassenger)&&support.checkInt(tfPrice)){
            id = Integer.parseInt(tfPassenger.getText());
            if(id>0){
                //generate evaluation of each passenger
                for(int i =0;i<10;i++){
                    rate +=(Math.random()*10+1);
                }
                rate = rate/10;
                //insert info to DB
                insert.insertToCruisePassenger(Integer.parseInt(cruiseID3.getText()),Integer.parseInt(tfPassenger.getText()),Integer.parseInt(tfPrice.getText()),rate);
                insert.updatePrice(Integer.parseInt(tfPassenger.getText()));
                support.alertSuccess();
                textTwo.setText("Keep inserting until you enter 0");
            }else if(id<0){
                support.alertInfo();            
            }else{
                //transfer information and jump to another scene 
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("FXMLReport.fxml").openStream());
                FXMLReportController reportController = (FXMLReportController)loader.getController();
                reportController.getID(cruiseID3.getText());
                support.move(event, root);
            }
        }
        
    }
    
    /**
     * get Cruise
     * @param id
     */
    public void getID(String id){
        cruiseID3.setText(id);
    }
    
}
