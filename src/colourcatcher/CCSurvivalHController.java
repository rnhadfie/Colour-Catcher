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
public class CCSurvivalHController implements Initializable {

    @FXML
    private Label life;
    @FXML
    private Button b00,b01,b02,b03, b04;
    @FXML
    private Button b10,b11,b12, b13, b14;
    @FXML
    private Button b20,b21,b22, b23, b24;
    @FXML
    private Button b30,b31,b32, b33, b34;
    @FXML
    private Button b40,b41,b42, b43, b44;
    private int[] off=new int[2];
    private Button[][] buttons=new Button[5][5];  
    Random colour=new Random();
    String normS="norm1";
    String offS="off1";
    public int scoreVal=0;
    public int gameScreen;
    
    @FXML
    private void ButtonEvent(ActionEvent event) {
        Button b=(Button)event.getSource();    
        System.out.println(b.getId().equalsIgnoreCase("b"+String.valueOf(off[0])+String.valueOf(off[1])));
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
                try {
                    Parent game_page=FXMLLoader.load(getClass().getResource("CCMenu.fxml"));
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
            int i=r.nextInt(5);
            int j=r.nextInt(5);
            int base=colour.nextInt(40);
            
            System.out.println(i+" "+j);
            
            System.out.println("Correct");
             scoreVal++;
             
            for(int n=0; n<5; n++)
            {
                for(int m=0; m<5; m++)
                {
                    System.out.println(n+" "+m);
                    if(n==off[0] && m==off[1])
                        buttons[n][m].getStyleClass().remove(offS);
                    else
                        buttons[n][m].getStyleClass().remove(normS);
                }
            }
           
                
            normS="norm"+String.valueOf(base);
            offS="off"+String.valueOf(base);
            for(int n=0; n<5; n++)
            {
                for(int m=0; m<5; m++)
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
      
      buttons[0][0]=b00; buttons[0][1]=b01; buttons[0][2]=b02; buttons[0][3]=b03; buttons[0][4]=b04;
      buttons[1][0]=b10; buttons[1][1]=b11; buttons[1][2]=b12; buttons[1][3]=b13; buttons[1][4]=b14;
      buttons[2][0]=b20; buttons[2][1]=b21; buttons[2][2]=b22; buttons[2][3]=b23; buttons[2][4]=b24;
      buttons[3][0]=b30; buttons[3][1]=b31; buttons[3][2]=b32; buttons[3][3]=b33; buttons[3][4]=b34;
      buttons[4][0]=b40; buttons[4][1]=b41; buttons[4][2]=b42; buttons[4][3]=b43; buttons[4][4]=b44;
      
    }    
    
}
