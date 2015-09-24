/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourcatcher;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rhianne
 */
public class GameOverController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML       
    private Label score;
    String sc="";
    @FXML
    private void ButtonEventMenu(ActionEvent event) {
        
        try {
            Parent game_page = FXMLLoader.load(getClass().getResource("CCMenu.fxml"));
            Scene scene = new Scene(game_page);
            Stage stage;
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GameOverController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
         
    }
     @FXML
    private void ButtonEventTry(ActionEvent event) {
        
        try {
            Parent game_page = FXMLLoader.load(getClass().getResource(sc));
            Scene scene = new Scene(game_page);
            Stage stage;
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GameOverController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
         
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Model m=new Model();
       //System.out.println(m.getInstance().currentCountry().getScore());
       int i=m.getInstance().currentCountry().getScore();
       String k=String.valueOf(i);
       score.setText(k);
       sc=m.getInstance().currentCountry().getSceneName();
     
    }     
    
}
