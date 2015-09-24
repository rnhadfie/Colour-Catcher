package colourcatcher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rhianne
 */
import java.io.*;
import javax.swing.*;
import javax.sound.sampled.*;
public class SoundPlayer {

     private static File soundFile=new File("C:\\Users\\rhianne\\Documents\\Apps\\ColourCatcher\\src\\colourcatcher\\Countdown.wav");
    /**
     * @param args the command line arguments
     */
  
    public static void music()
    {
          try { 
          Clip clip = AudioSystem.getClip(); 
          clip.open(AudioSystem.getAudioInputStream(soundFile)); 
          clip.start(); 
          Thread.sleep(clip.getMicrosecondLength()); } 
          catch (Exception e) 
          { System.err.println(e.getMessage()); } 
    }
}
    

    
    
    
    

