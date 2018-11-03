/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.*;
import cityofaaron.CityOfAaron;

/**
 *
 * @author tweet
 */
public class GameControl {
    public static void createNewGame(String _name){
        // Create a new Game object.
        Game game = new Game();
        
        // Create a new Player object.
        Player player = new Player();
        
        // Store the name of the player in the Player object
        player.setName(_name);
    
        // Store a reference to the Player object in the Game object
        game.setPlayer(player);
        
        // Create a CropData object
        CropData cropData = new CropData();
        
        // Initialize the data values in the CropData object
        cropData.setYear(0);
        cropData.setPopulation(100);
        cropData.setNewPeople(5);
        cropData.setCropYield(3);
        cropData.setNumberWhoDied(0);
        cropData.setWheatInStore(2700);
        cropData.setAcresOwned(1000);
        cropData.setAcresPlanted(1000);
        cropData.setHarvest(3000);
        
        // Save a reference to the CropData object in the Game object
        game.setCropData(cropData);
        
        // Save a reference to the Game object in the static variable
        // declared in the CityOfAaron class.
        CityOfAaron.setGame(game);
    }
}
