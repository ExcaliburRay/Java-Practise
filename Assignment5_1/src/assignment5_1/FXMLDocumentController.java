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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import question1.InsertData;
import question1.TableGenerator;

/**
 * set the method in insert the initial method in this DB
 * @author MSI-PC
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button btnstart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonStart(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
       //new on support,TableGenerator and InsertData object to use its methods
        Support support = new Support();      
        TableGenerator table = new TableGenerator();
        table.setTable();
        InsertData insert = new InsertData();
        insert.insertToPassenger();
        insert.insertToPort();
        insert.insertToSailor();
        insert.insertToShip();
        insert.insertToshipSailor();
        //jump to next scene
        support.move(event, "FXMLCreateCruise.fxml");
    }
}
