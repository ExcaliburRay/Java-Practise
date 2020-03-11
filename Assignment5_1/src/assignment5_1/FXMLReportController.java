/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * set the method in query information from DB and generate report
 * @author Ray
 */
public class FXMLReportController implements Initializable {
    @FXML
    private Button btnChart;
    
    @FXML
    private TableColumn<RevenueTableByCountry, String> tvcountry;
    @FXML
    private TableColumn<RevenueTableByCountry, Integer> tvprice1;
    @FXML
    private TableColumn<RevenueTableByAge, Integer> tvage;
    @FXML
    private TableColumn<RevenueTableByAge, String> tvprice2;
    @FXML
    private TableColumn<SailorSupervisors, String> tvsailors;
    @FXML
    private TableColumn<SailorSupervisors, String> tvsupervisors;
    @FXML
    private TableColumn<Passengers, String> tvpassengername;
    @FXML
    private TableColumn<Passengers, Integer> tvpricepayed;
    @FXML
    private TableColumn<Evaluation, String> tvpassenger;
    @FXML
    private TableColumn<Evaluation, Double> tvrate;
    @FXML
    private TableView<RevenueTableByCountry> tableview1;
    @FXML
    private TableView<RevenueTableByAge> tableview2;
    @FXML
    private TableView<SailorSupervisors> tableview3;
    @FXML
    private TableView<Passengers> tableview4;
    @FXML
    private TableView<Evaluation> tableview5;
    
    //set ObservableList to store object information
    ObservableList<RevenueTableByCountry> oblist1 = FXCollections.observableArrayList();
    ObservableList<RevenueTableByAge> oblist2 = FXCollections.observableArrayList();
    ObservableList<SailorSupervisors> oblist3 = FXCollections.observableArrayList();
    ObservableList<Passengers> oblist4 = FXCollections.observableArrayList();
    ObservableList<Evaluation> oblist5 = FXCollections.observableArrayList();
    @FXML
    private Text cruiseID4;
    @FXML
    private Button btnReport;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    // jump to next scene
    @FXML
    private void drawChart(ActionEvent event) throws IOException {
        Support support = new Support();
        support.move(event, "FXMLChart.fxml");
    }

    /**
     * get Cruise
     * @param id
     */
    public void getID(String id){
        cruiseID4.setText(id);
    }

    @FXML
    private void displayReport(ActionEvent event) {
        try {
            // TODO
            //connect to db and get the information in the first table
            Connection con = DBconnector.getConnection();
            String prepareNationSQL = "SELECT NATIONALITY,SUM(MONEYPAID) AS REVENUE FROM PASSENGER GROUP BY NATIONALITY";
            ResultSet rs1 = con.createStatement().executeQuery(prepareNationSQL);
            while(rs1.next()){
                oblist1.add(new RevenueTableByCountry(rs1.getString("NATIONALITY"),rs1.getInt("REVENUE")));
            }
            //connect to db and get the information in the second table
            String prepareAgeSQL = "SELECT AGE,SUM(MONEYPAID) AS REVENUE FROM PASSENGER GROUP BY AGE";
            ResultSet rs2 = con.createStatement().executeQuery(prepareAgeSQL);
            while(rs2.next()){
                oblist2.add(new RevenueTableByAge(rs2.getInt(1), rs2.getInt(2)));
            }
            
            //connect to db and get the information in the third table
            String prepareSailorSQL = "SELECT SAILORNAME,SUPERVISOR FROM SAILOR WHERE SAILORID IN(SELECT SAILORID FROM SHIPSAILOR WHERE SHIPID IN(SELECT SHIPID FROM CRUISESHIP WHERE CRUISEID = ?))";
            PreparedStatement presSailor = con.prepareCall(prepareSailorSQL);
            presSailor.setInt(1, Integer.parseInt(cruiseID4.getText()));
            ResultSet rs3 = presSailor.executeQuery();                      
            while(rs3.next()){
                oblist3.add(new SailorSupervisors(rs3.getString(1), rs3.getString(2)));
            }
            
            //connect to db and get the information in the forth table
            String preparePassengerSQL = "SELECT PASSENGERNAME,MONEYPAID FROM PASSENGER ORDER BY MONEYPAID";
            ResultSet rs4 = con.createStatement().executeQuery(preparePassengerSQL);
            while(rs4.next()){
                oblist4.add(new Passengers(rs4.getString(1), rs4.getInt(2)));
            }
            //connect to db and get the information in the fifth table
            String prepareSQL = "SELECT PASSENGERNAME,RATE FROM PASSENGER, CRUISEPASSENGER WHERE PASSENGER.PASSENGERID=CRUISEPASSENGER.PASSENGERID AND CRUISEID=?";
            PreparedStatement presEva = con.prepareCall(prepareSQL);
            presEva.setInt(1,  Integer.parseInt(cruiseID4.getText()));
            ResultSet rs5 = presEva.executeQuery();
            while(rs5.next()){
                oblist5.add(new Evaluation(rs5.getString(1), rs5.getDouble(2)));            
            }
            
            }catch (Exception ex) {
                Logger.getLogger(FXMLReportController.class.getName()).log(Level.SEVERE, null, ex);
            }

        //bound each attribute in each class with id of each table column
        tvcountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        tvprice1.setCellValueFactory(new PropertyValueFactory<>("moneypayed"));
        tvage.setCellValueFactory(new PropertyValueFactory<>("age"));
        tvprice2.setCellValueFactory(new PropertyValueFactory<>("moneyPayed"));
        tvsailors.setCellValueFactory(new PropertyValueFactory<>("sailors"));
        tvsupervisors.setCellValueFactory(new PropertyValueFactory<>("supervisors"));
        tvpassengername.setCellValueFactory(new PropertyValueFactory<>("passengerName"));
        tvpricepayed.setCellValueFactory(new PropertyValueFactory<>("PricePayed"));
        tvpassenger.setCellValueFactory(new PropertyValueFactory<>("PassengerName"));
        tvrate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        
        //set ObservableList in each table
        tableview1.setItems(oblist1);
        tableview2.setItems(oblist2);
        tableview3.setItems(oblist3);
        tableview4.setItems(oblist4);
        tableview5.setItems(oblist5);
        
        //make button disable to use
        btnReport.setDisable(true);
    }
}
