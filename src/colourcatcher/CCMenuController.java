/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourcatcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rhianne
 */
public class CCMenuController implements Initializable {
    
  
    
    
    @FXML
    private void teButtonAction(ActionEvent event) {
          try {
            Parent game_page=FXMLLoader.load(getClass().getResource("CCTimedE.fxml"));
           Scene scene = new Scene(game_page);
            Stage stage;
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
           System.out.println("Error");
        }
     
        
    }
     @FXML
    private void tmButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
     @FXML
    private void thButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
     @FXML
    private void seButtonAction(ActionEvent event) {
    
           try {
            Parent game_page=FXMLLoader.load(getClass().getResource("CCSurvivalE.fxml"));
           Scene scene = new Scene(game_page);
            Stage stage;
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
           System.out.println("Error");
        }
    }
     @FXML
    private void smButtonAction(ActionEvent event) {
         try {
            Parent game_page=FXMLLoader.load(getClass().getResource("CCSurvivalM.fxml"));
           Scene scene = new Scene(game_page);
            Stage stage;
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
           System.out.println("Error");
        }
        
    }
     @FXML
    private void shButtonAction(ActionEvent event) {
         try {
            Parent game_page=FXMLLoader.load(getClass().getResource("CCSurvivalH.fxml"));
           Scene scene = new Scene(game_page);
            Stage stage;
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
           System.out.println("Error");
        }
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    
    
}
