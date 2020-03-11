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
 * set the method in adding port information to cruise 
 * @author Ray
 */
public class FXMLMatchPortController implements Initializable {

    @FXML
    private Button btnNext2;
    @FXML
    private TextField ftPort;
    @FXML
    private Text cruiseID2;
    @FXML
    private Text textOne;

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
    private void actionEventNextTwo(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        //new on support object to use its methods
        Support support = new Support();
        InsertData insert = new InsertData();
        int num=-10;
        if(support.checkInt(ftPort)){
            num = Integer.parseInt(ftPort.getText());
            if(num>0){
                //insert info to DB
                insert.insertToCruisePort(Integer.parseInt(cruiseID2.getText()), Integer.parseInt(ftPort.getText()));
                support.alertSuccess();  
                textOne.setText("Keep inserting until you enter 0");
            }else if(num<0){
                support.alertInfo();            
            }else{
                //transfer information and jump to another scene 
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("FXMLMatchPassenger.fxml").openStream());
                FXMLMatchPassengerController passengerController = (FXMLMatchPassengerController)loader.getController();
                passengerController.getID(cruiseID2.getText());
                support.move(event, root);
            }
        }
        
    }
    
    /**
     * get Cruise
     * @param id
     */
    public void getID(String id){
        cruiseID2.setText(id);
    }
}
