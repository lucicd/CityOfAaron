// The CropView class - part of the view layer
// Object of this class manages the Crop view
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 6, 2018
//-------------------------------------------------------
package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 *
 * @author Drazen
 */
public class CropView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
     
    // Get references to the Game object and the CropData object
    static private Game game = CityOfAaron.getGame();
    static private CropData cropData = game.getCropData();
    
    // The buyLandView method
    // Purpose: interface with the user input for buying land
    // Parameters: none
    // Returns: none
    public static void buyLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.\n", price);
        System.out.print("\nHow many acres of land do you wish to buy?");
        
        // Get the user’s input and save it.
        int toBuy;
        toBuy = keyboard.nextInt();
        
        // Call the buyLand( ) method in the control layer to buy the land
        CropControl.buyLand(price, toBuy, cropData);
        
        //output how much land we own now
        System.out.format("You now own %d acres of land.", cropData.getAcresOwned());
    }
    // The sellLandView method
    // Purpose: interface with the user input for selling land
    // Parameters: none
    // Returns: none
    public static void sellLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to sell
        System.out.format("Land is selling for %d bushels per acre.\n", price);
        System.out.print("\nHow many acres of land do you wish to sell?");
        
        // Get the user’s input and save it.
        int toSell;
        toSell = keyboard.nextInt();
        
        // Call the sellLand( ) method in the control layer to sell the land
        CropControl.sellLand(price, toSell, cropData);
        
        //output how much land we own now
        System.out.format("You now own %d acres of land.", cropData.getAcresOwned());
    }
    // The feedPeopleView method
    // Purpose: interface with the user input for feeding people
    // Parameters: none
    // Returns: none
    public static void feedPeopleView()
    {
        // Prompt the user to enter the number of bushels set aside to feed the people
        System.out.print("\nHow many bushels do you want to set aside to feed the people?");
        
        // Get the user’s input and save it.
        int wheatToFeed;
        wheatToFeed = keyboard.nextInt();
        
        // Call the feedPeople( ) method in the control layer to feed the people
        CropControl.feedPeople(wheatToFeed, cropData);
        
        //output The number of bushels that are left in store
        System.out.format("You now have %d bushels in store.", cropData.getWheatInStore());
        
    }
    
    // The runCropView method()
    // Purpose: runs the methods to manage the crops game
    // Parameters: none
    // Returns: none
    public static void runCropView()
    {
        // call the buyLandView( ) method
        buyLandView( );
        // call the sellLandView( ) method
        sellLandView( );
        // Call the feedPeopleView( ) method
        feedPeopleView( );
              

        // add calls to the other crop view methods
        // as they are written
    }

}
