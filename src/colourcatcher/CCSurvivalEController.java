/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourcatcher;


import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author rhianne
 */
public class CCSurvivalEController implements Initializable {
     @FXML
    private Label life;
     @FXML
    private Button b00,b01,b10,b11;
    private int[] off=new int[2];
    private Button[][] buttons=new Button[2][2];  
    Random colour=new Random();
    String normS="norm1";
    String offS="off1";
    public static int scoreVal=0;
    public static String gameScreen="CCSurvivalE.fxml";
    /**
     * Initializes the controller class.
     */

   Model m=new Model();
    
    @FXML
    private void ButtonEvent(ActionEvent event) {
        Button b=(Button)event.getSource();    
        //b.getId().equalsIgnoreCase("b"+String.valueOf(off[0])+String.valueOf(off[1]));
        if(!b.getId().equalsIgnoreCase("b"+String.valueOf(off[0])+String.valueOf(off[1])))   
        {   
            String s=life.getText();
            int i=Integer.valueOf(s);
            //int i=Integer.getInteger(life.getText());
            i=i-1;
            if(i>0)
            life.setText(String.valueOf(i));
            else
            {
                m.getInstance().currentCountry().setScore(scoreVal);
                try {
                    Parent game_page=FXMLLoader.load(getClass().getResource("gameOver.fxml"));
                    Scene scene = new Scene(game_page);
                    Stage stage;
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                   System.out.println("Error");
                }
            }
        }
        else
        {
            Random r=new Random();
            int i=r.nextInt(2);
            int j=r.nextInt(2);
            int base=colour.nextInt(20)+1;
            
           
            scoreVal++;
            for(int n=0; n<2; n++)
            {
                for(int m=0; m<2; m++)
                {
                    if(n==off[0] && m==off[1])
                        buttons[n][m].getStyleClass().remove(offS);
                    else
                        buttons[n][m].getStyleClass().remove(normS);
                }
            }
           
                
            normS="norm"+String.valueOf(base);
            offS="off"+String.valueOf(base);
            for(int n=0; n<2; n++)
            {
                for(int m=0; m<2; m++)
                {
                    if(n==i && m==j)
                        buttons[n][m].getStyleClass().add(offS);
                    else
                        buttons[n][m].getStyleClass().add(normS);
                }
            }
            off[0]=i;
            off[1]=j;
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      off[0]=1; off[1]=1;
      
      buttons[0][0]=b00;
      buttons[0][1]=b01;
      buttons[1][0]=b10;
      buttons[1][1]=b11;
 
     m.getInstance().currentCountry().setSceneName("CCSurvivalE.fxml");
     System.out.println( m.getInstance().currentCountry().getSceneName());
    
    }    
    
}
