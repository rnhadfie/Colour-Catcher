/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourcatcher;

/**
 *
 * @author rhianne
 */
public class gameData {
    private int score=0;
    private String sceneName="CCMenu.fxml";
    
    public int getScore()
    {
        return score;
    }
    public void setScore(int s)
    {
        score=s;
    }
    
    public String getSceneName()
    {
        return sceneName;
    }
    public void setSceneName(String s)
    {
        sceneName=s;
    }
    
    
}
