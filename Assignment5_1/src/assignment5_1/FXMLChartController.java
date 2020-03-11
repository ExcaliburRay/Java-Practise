/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_1;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 * set the display line chart method
 * @author Ray
 */
public class FXMLChartController implements Initializable {

    @FXML
    private LineChart<?, ?> linechart1;
    @FXML
    private NumberAxis y1;
    @FXML
    private CategoryAxis x1;
    @FXML
    private LineChart<?, ?> linechart2;
    @FXML
    private NumberAxis y2;
    @FXML
    private CategoryAxis x2;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //query the database and set the result in ResultSet
            Connection con = DBconnector.getConnection();
            String prepareNationSQL = "SELECT NATIONALITY,SUM(MONEYPAID) AS REVENUE FROM PASSENGER GROUP BY NATIONALITY";
            ResultSet rs1 = con.createStatement().executeQuery(prepareNationSQL);
            //initial one line chart
            XYChart.Series series1 = new XYChart.Series();
            while(rs1.next()){                
                series1.getData().add(new XYChart.Data(rs1.getString("NATIONALITY"),rs1.getInt("REVENUE")));
            }
            //query the database and set the result in ResultSet
            String prepareAgeSQL = "SELECT AGE,SUM(MONEYPAID) AS REVENUE FROM PASSENGER GROUP BY AGE";
            ResultSet rs2 = con.createStatement().executeQuery(prepareAgeSQL);
            //initial one line chart
            XYChart.Series series2 = new XYChart.Series();
            while(rs2.next()){                
                series2.getData().add(new XYChart.Data(String.valueOf(rs2.getInt(1)), rs2.getInt(2)));
            }
            //bound line chart with the id of line graph and set label of X and Y
            linechart1.getData().addAll(series1);
            x1.setLabel("age");
            y1.setLabel("payment in total");
            linechart2.getData().addAll(series2);
            x2.setLabel("country");
            y2.setLabel("payment in total");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
}
