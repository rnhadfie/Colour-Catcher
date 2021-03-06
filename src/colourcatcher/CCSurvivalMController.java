/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourcatcher;


import colourcatcher.Model;
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
public class CCSurvivalMController implements Initializable {
    Model m=new Model();
    @FXML
    private Label life;
    @FXML
    private Button b00, b01, b02, b10, b11, b12, b20, b21, b22;
    private int[] off = new int[2];
    private Button[][] buttons = new Button[3][3];
    Random colour = new Random();
    String normS = "norm1";
    String offS = "off1";
    public int scoreVal = 0;
    public int gameScreen;

    @FXML
    private void ButtonEvent(ActionEvent event) {
        Button b = (Button) event.getSource();
        System.out.println(b.getId().equalsIgnoreCase("b" + String.valueOf(off[0]) + String.valueOf(off[1])));
        if (!b.getId().equalsIgnoreCase("b" + String.valueOf(off[0]) + String.valueOf(off[1]))) {
            String s = life.getText();
            int i = Integer.valueOf(s);
            m.getInstance().currentCountry().setScore(scoreVal);
            i = i - 1;
            if (i > 0) {
                life.setText(String.valueOf(i));
            } else {
                try {
                    Parent game_page = FXMLLoader.load(getClass().getResource("gameOver.fxml"));
                    Scene scene = new Scene(game_page);
                    Stage stage;
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    System.out.println("Error");
                }
            }
        } else {

            Random r = new Random();
            int i = r.nextInt(3);
            int j = r.nextInt(3);
            int base = colour.nextInt(40);

            System.out.println(i + " " + j);

            System.out.println("Correct");
            scoreVal++;

            for (int n = 0; n < 3; n++) {
                for (int m = 0; m < 3; m++) {
                    if (n == off[0] && m == off[1]) {
                        buttons[n][m].getStyleClass().remove(offS);
                    } else {
                        buttons[n][m].getStyleClass().remove(normS);
                    }
                }
            }

            normS = "norm" + String.valueOf(base);
            offS = "off" + String.valueOf(base);
            for (int n = 0; n < 3; n++) {
                for (int m = 0; m < 3; m++) {
                    if (n == i && m == j) {
                        buttons[n][m].getStyleClass().add(offS);
                    } else {
                        buttons[n][m].getStyleClass().add(normS);
                    }
                }
            }
            off[0] = i;
            off[1] = j;

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        off[0] = 1;
        off[1] = 1;

        buttons[0][0] = b00;
        buttons[0][1] = b01;
        buttons[0][2] = b02;
        buttons[1][0] = b10;
        buttons[1][1] = b11;
        buttons[1][2] = b12;
        buttons[2][0] = b20;
        buttons[2][1] = b21;
        buttons[2][2] = b22;

        m.getInstance().currentCountry().setSceneName("CCSurvivalM.fxml");
        System.out.println( m.getInstance().currentCountry().getSceneName());
    }

}
