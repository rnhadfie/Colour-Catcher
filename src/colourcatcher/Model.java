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
public class Model {
    private final static Model instance = new  Model();

    public static  Model getInstance() {
        return instance;
    }

    private gameData gd = new gameData();

    public gameData currentCountry() {
        return gd;
    }
}

