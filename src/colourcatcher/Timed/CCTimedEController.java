/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourcatcher.Timed;


import colourcatcher.Model;
import java.io.IOException;
import java.net.*;
import javafx.scene.input.MouseEvent;
import java.util.*;
import java.util.logging.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author rhianne
 */
public class CCTimedEController implements Initializable {

    MyTimerTask myTimerTask;
    Timer myTimer;
    final int MAX = 120;
    @FXML
    private Button b00, b01, b10, b11;
    @FXML
    AnchorPane AnchorPane;
    Model m=new Model();
    private int[] off = new int[2];
    private Button[][] buttons = new Button[2][2];
    Random colour = new Random();
    String normS = "norm1";
    String offS = "off1";
    double count;
    public static int scoreVal = 0;
    public static String gameScreen="CCTimedE.fxml";
   
    /**
     * Initializes the controller class.
     */
    @FXML
    private ProgressBar pb;

    

    @FXML
    private void ButtonEvent(ActionEvent event) {
        if(count>=MAX)
        {
            System.out.println(2);
            //m.getInstance().currentCountry().setScore(scoreVal);
             /*   try {
                    Parent game_page=FXMLLoader.load(getClass().getResource("gameOver.fxml"));
                    Scene scene = new Scene(game_page);
                    Stage stage;
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                   System.out.println("Error");
                }*/
        }
        /*Button b = (Button) event.getSource();
        if (b.getId().equalsIgnoreCase("b" + String.valueOf(off[0]) + String.valueOf(off[1]))) {

            Random r = new Random();
            int i = r.nextInt(2);
            int j = r.nextInt(2);
            int base = colour.nextInt(40);

            scoreVal++;
            System.out.println(scoreVal);
            for (int n = 0; n < 2; n++) {
                for (int m = 0; m < 2; m++) {
                    if (n == off[0] && m == off[1]) {
                        buttons[n][m].getStyleClass().remove(offS);
                    } else {
                        buttons[n][m].getStyleClass().remove(normS);
                    }
                }
            }

            normS = "norm" + String.valueOf(base);
            offS = "off" + String.valueOf(base);
            for (int n = 0; n < 2; n++) {
                for (int m = 0; m < 2; m++) {
                    if (n == i && m == j) {
                        buttons[n][m].getStyleClass().add(offS);
                    } else {
                        buttons[n][m].getStyleClass().add(normS);
                    }
                }
            }
            off[0] = i;
            off[1] = j;

        } else {
            count += 10;
        }*/
    }
    @FXML
    private void MouseEvent(MouseEvent me) {
        if(count>=MAX){
        m.getInstance().currentCountry().setScore(scoreVal);
        try {
            
            Parent game_page = FXMLLoader.load(getClass().getResource("CCMenu.fxml"));
            
            Scene scene = new Scene(game_page);
            Stage s = (Stage) ((Node) me.getSource()).getScene().getWindow();
            System.out.println(s);
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(CCTimedEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        m.getInstance().currentCountry().setSceneName("CCTimedE.fxml");
        System.out.println( m.getInstance().currentCountry().getSceneName());
        off[0] = 1;
        off[1] = 1;

        buttons[0][0] = b00;
        buttons[0][1] = b01;

        buttons[1][0] = b10;
        buttons[1][1] = b11;

        pb.setProgress(0);
        myTimerTask = new MyTimerTask(pb);

        myTimer = new Timer();
        myTimer.scheduleAtFixedRate(myTimerTask, 0, 100);
        
        
    }

    class MyTimerTask extends TimerTask {

        ProgressBar bar;

        public MyTimerTask(ProgressBar b) {
            bar = b;
            count = 0;
        }

        @Override
        public void run() {
            
            if (count >= MAX) {
                myTimer.cancel();

            } else {
                bar.setProgress(count++ / MAX);
            }
        }

    }

}
