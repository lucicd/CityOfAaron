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
import exceptions.CropException;
import exceptions.EndOfGameException;
import exceptions.PeopleStarvedException;
import java.util.InputMismatchException;

/**
 *
 * @author Drazen
 */
public class CropView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
     
    // Get references to the Game object and the CropData object
    //static private Game game = CityOfAaron.getGame();
    //static private CropData cropData = game.getCropData();
    
    // The buyLandView method
    // Purpose: interface with the user input for buying land
    // Parameters: none
    // Returns: none
    public static void buyLandView()
    {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();

        System.out.format("\nLand is selling for %d bushels per acre.\n", price);
        
        int toBuy;
        boolean paramsNotOkay;
        do {
            paramsNotOkay = false;

            try {
                // Prompt the user to enter the number of acres to buy
                System.out.print("How many acres of land do you wish to buy? ");
                // Get the user’s input and save it.
                toBuy = keyboard.nextInt();
                // Call the buyLand() method in the control layer to buy the land
                CropControl.buyLand(price, toBuy, cropData);
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer");
                keyboard.next();
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);
        
        //output how much land we own now
        System.out.format("You now own %d acres of land.\n", cropData.getAcresOwned());
    }
    // The sellLandView method
    // Purpose: interface with the user input for selling land
    // Parameters: none
    // Returns: none
    
    public static void sellLandView()
    {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        System.out.format("\nLand is selling for %d bushels per acre.\n", price);
        
        int toSell;
        boolean paramsNotOkay;
        do {
            paramsNotOkay = false;
            try {
                // Prompt the user to enter the number of acres to sell
                System.out.print("How many acres of land do you wish to sell? ");
                // Get the user’s input and save it.
                toSell = keyboard.nextInt();
                // Call the sellLand() method in the control layer to sell the land
                CropControl.sellLand(price, toSell, cropData);
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer");
                keyboard.next();
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);
        
        //output how much land we own now
        System.out.format("You now own %d acres of land.\n", cropData.getAcresOwned());
    }
    
    // The feedPeopleView method
    // Purpose: interface with the user input for feeding people
    // Parameters: none
    // Returns: none
    public static void feedPeopleView()
    {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();        
       
        int wheatToFeed;
        boolean paramsNotOkay;
        do {
            paramsNotOkay=false;
            
            try{
               System.out.print("How many bushels do you want to set aside to feed the people?");
        // Get the user’s input and save it.
               wheatToFeed = keyboard.nextInt();
               
        // Call the feedPeople() method in the control layer to feed the people
        CropControl.feedPeople(wheatToFeed, cropData);
        }catch (CropException e){
         System.out.println("I am sorry master, I cannot do this.");
         System.out.println(e.getMessage());
         paramsNotOkay=true;
        }catch (InputMismatchException e){
          System.out.println("Please enter an integer");
          keyboard.next();
          paramsNotOkay=true;
          
         }
        } while (paramsNotOkay);
        
        //output The number of bushels that are left in store
        System.out.format("You now have %d bushels in store.\n", cropData.getWheatInStore());
        
    }
    
    // The plantCropsView method
    // Purpose: interface with the user input for planting the crops
    // Parameters: none
    // Returns: none
    public static void plantCropsView()
    {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        int acresToPlant;
        boolean paramsNotOkay;
        do 
        {
            paramsNotOkay=false;
            try {
            System.out.print("How many acres of land do you want to plant?");
            // Get the user’s input and save it.
            acresToPlant = keyboard.nextInt();
            
          // Call the plantCrops() method in the control layer to plant the crops
        CropControl.plantCrops(acresToPlant,cropData);
            } catch(CropException e){
            System.out.println("I am sorry master, I cannot do this.");
            System.out.println(e.getMessage());
            paramsNotOkay=true;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer");
                keyboard.next();
                paramsNotOkay=true;
            }
        }while(paramsNotOkay);
        
    //output how much land we own now
        System.out.format("You now own %d acres of land.\n", cropData.getAcresOwned());
    } 
    
    // The displayCropsReportView method
    // Purpose: Display the data from the cropData object
    // Parameters: none
    // Returns: none
    public static void displayCropsReportView()
    {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        System.out.format("\n%s, here is your report!", CityOfAaron.getGame().getPlayer().getName());
        System.out.print("\n********************************");
        System.out.print("\n* CITY OF AARON: ANNUAL REPORT *");
        System.out.print("\n********************************");
        System.out.format("\nWheat in store:\t\t%d", cropData.getWheatInStore());
        System.out.format("\nWheat for people:\t%d", cropData.getWheatForPeople());
        System.out.format("\nCrop yield:\t\t%d", cropData.getCropYield());
        System.out.format("\nHarvest:\t\t%d", cropData.getHarvest());
        System.out.format("\nEaten by rats:\t\t%d", cropData.getEatenByRats());
        System.out.format("\nOffering:\t\t%d", cropData.getOffering());
        System.out.format("\nAcres owned:\t\t%d", cropData.getAcresOwned());
        System.out.format("\nAcres planted:\t\t%d", cropData.getAcresPlanted());
        System.out.format("\nPopulation:\t\t%d", cropData.getPopulation());
        System.out.format("\nPeople fed:\t\t%d", cropData.getPeopleFed());
        System.out.format("\nNew people:\t\t%d", cropData.getNewPeople());
        System.out.format("\nNumber who died:\t%d", cropData.getNumberWhoDied());
        System.out.format("\nYear\t\t\t%d\n", cropData.getYear());
    }
    
    public static void advanceOneYearView() {
        try {
            CropControl.advanceOneYear();
        }
        catch (EndOfGameException e) {
            System.out.println("\n\nGame over you have reached 10 years. ");
            System.out.println("Great Job! Here are your achievement.");
            System.out.println("Start a new game to play again.");
            displayCropsReportView();
            System.exit(0);
        }
        catch (PeopleStarvedException e) {
            System.out.println("\n\nGame over you have starved too many people.");
            System.out.println("Shame on you. Try again to do better next time!");
            System.out.println("Start a new game to play again.");
            displayCropsReportView();
            System.exit(0);
        }
    }
            
    // The runCropView method()
    // Purpose: runs the methods to manage the crops game
    // Parameters: none
    // Returns: none
    public static void runCropView()
    {
        // Call the displayCropsReportView() method
        displayCropsReportView();
        
        // call the buyLandView() method
        buyLandView();
        
        // call the sellLandView() method
        sellLandView();
        
        // Call the feedPeopleView() method
        feedPeopleView();
        
        // Call the plantCrops() method
        plantCropsView();
        
        // Advance one year
        advanceOneYearView (); 
        
        // Call the displayCropsReportView() method
        displayCropsReportView();
        
        // add calls to the other crop view methods
        // as they are written
    }
}
