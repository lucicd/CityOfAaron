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
        
        //output the number of bushels that are left in store
        System.out.format("You now have %d bushels in store.\n", cropData.getWheatInStore());
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
        
        //output the number of bushels that are left in store
        System.out.format("You now have %d bushels in store.\n", cropData.getWheatInStore());
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
        
        System.out.format("\nIt takes %d bushels to feed 1 person for 1 year.\n", 
                CropControl.BUSHELS_PER_PERSON);
       
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
            } catch (CropException e){
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay=true;
            } catch (InputMismatchException e){
                System.out.println("Please enter an integer");
                keyboard.next();
                paramsNotOkay=true;
            }
        } while (paramsNotOkay);
        
        //output the number of bushels that are left in store
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
        
        System.out.format("\nOne bushel is needed to plant %d acres. One person can farm %d acres.\n", 
                CropControl.ACRES_PER_BUSHEL, CropControl.ACRES_PER_PERSON);
        
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
                CropControl.plantCrops(acresToPlant, cropData);
            } catch(CropException e){
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay=true;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer");
                keyboard.next();
                paramsNotOkay=true;
            }
        } while(paramsNotOkay);
        
        //output the number of bushels that are left in store
        System.out.format("You now have %d bushels in store.\n", cropData.getWheatInStore());
    } 
    
    // The setOfferingView method
    // Purpose: interface with the user input for setting an offering
    // Parameters: none
    // Returns: none
    public static void setOfferingView()
    {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        System.out.format("\nThe offering can be between 0 an 100 (percent).\n");
        
        int offering;
        boolean paramsNotOkay;
        do 
        {
            paramsNotOkay=false;
            try {
                System.out.print("What percentage of wheat do you want to set for offering?");
                // Get the user’s input and save it.
                offering = keyboard.nextInt();
            
                // Call the plantCrops() method in the control layer to plant the crops
                CropControl.setOffering(offering, cropData);
                
            } catch(CropException e){
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay=true;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer");
                keyboard.next();
                paramsNotOkay=true;
            }
        } while(paramsNotOkay);
        
        //output offering percentage
        System.out.format("Your offering is set to %d percent.\n", cropData.getOfferingPercentage());
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
        System.out.print("\n**********************************");
        System.out.print("\n*  CITY OF AARON: ANNUAL REPORT  *");
        System.out.print("\n**********************************");
        System.out.format("\n%-25s %8d", "Wheat in store:", cropData.getWheatInStore());
        System.out.format("\n%-25s %8d", "Wheat for people:", cropData.getWheatForPeople());
        System.out.format("\n%-25s %8d", "Crop yield:", cropData.getCropYield());
        System.out.format("\n%-25s %8d", "Harvest:", cropData.getHarvest());
        System.out.format("\n%-25s %8d", "Eaten by rats:", cropData.getEatenByRats());
        System.out.format("\n%-25s %8d", "Offering (%):", cropData.getOfferingPercentage());
        System.out.format("\n%-25s %8d", "Offering paid:", cropData.getOffering());
        System.out.format("\n%-25s %8d", "Acres owned:", cropData.getAcresOwned());
        System.out.format("\n%-25s %8d", "Acres planted:", cropData.getAcresPlanted());
        System.out.format("\n%-25s %8d", "Population:", cropData.getPopulation());
        System.out.format("\n%-25s %8d", "People fed:", cropData.getPeopleFed());
        System.out.format("\n%-25s %8d", "New people:", cropData.getNewPeople());
        System.out.format("\n%-25s %8d", "Number who died:", cropData.getNumberWhoDied());
        System.out.format("\n%-25s %8d\n", "Year:", cropData.getYear());
    }
    
    /**
     * Advances the game calendar for one year.
     * Checks if preconditions to end the game are fulfilled
     * If so, ends the game.
     */
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
    
    /**
     * Calls harvestCrops() method and displays the harvest report
     */
    public static void harvestCropsView() {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        CropControl.harvestCrops(cropData);
        System.out.format("\nHARVEST REPORT:");
        System.out.format("\nThe crop yield is %d bushels per acre.", cropData.getCropYield());
        System.out.format("\nYou harvested %d bushels of wheat.", cropData.getHarvest());
        System.out.format("\nYou now have %d bushels in store.\n", cropData.getWheatInStore());
    }
    
    /**
     * Calls payOffering() method and displays the offering payment report
     */
    public static void payOfferingView() {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        CropControl.payOffering(cropData);
        System.out.format("\nOFFERING PAYMENT REPORT:");
        System.out.format("\nYou paid %d bushels of offering.", cropData.getOffering());
        System.out.format("\nYou now have %d bushels in store.\n", cropData.getWheatInStore());
    }
    
    /**
     * Calls calcEatenByRats() method and displays the rats report
     */
    public static void eatenByRatsView() {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        int percentage = CropControl.calcEatenByRatsPercentage();
        
        CropControl.calcEatenByRats(percentage, cropData);
        System.out.format("\nRATS REPORT:");
        System.out.format("\nRats devoured %d busheld of wheat.", cropData.getEatenByRats());
        System.out.format("\nYou now have %d bushels in store.\n", cropData.getWheatInStore());
    }
    
    /**
     * Gets random population growth percentage, calls growPopulation() method,
     * and shows the population report.
     */
    public static void growPopulationView() {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        int percentage = CropControl.calcPopulationGrowthPercentage();
        
        CropControl.growPopulation(percentage, cropData);
        System.out.format("\nPOPULATION REPORT:");
        System.out.format("\nPopulation grew by %d people this year.", cropData.getNewPeople());
        System.out.format("\nCity population stands at %d.\n", cropData.getPopulation());
    }
    
     public static void calcStarvedView() {
        //Get references to the game and cropData objects
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        
        CropControl.calcStarved(cropData);
        System.out.format("\nSUSTENANCE REPORT:");
        System.out.format("\nNumber of people adequatly fed: %d.", cropData.getPeopleFed());
        System.out.format("\nNumber of people starved: %d.", cropData.getNumberWhoDied());
        System.out.format("\nCity population stands at %d.\n", cropData.getPopulation());
    }
            
    // The runCropView method()
    // Purpose: runs the methods to manage the crops game
    // Parameters: none
    // Returns: none
    public static void runCropView()
    {
        // Call the displayCropsReportView() method
        displayCropsReportView();
        
        // Call the buyLandView() method
        buyLandView();
        
        // Call the sellLandView() method
        sellLandView();
        
        // Call the feedPeopleView() method
        feedPeopleView();
        
        // Call the plantCrops() method
        plantCropsView();
        
        // Call the setOffering() method
        setOfferingView();
        
        // Call harvestCropsView() method
        harvestCropsView();
        
        // Call payOfferingView() method
        payOfferingView();
        
        // Call eatenByRatsView() method
        eatenByRatsView();
        
        // Call growPopulationView() method
        growPopulationView();
        
        // Call calcStarvedView() method
        calcStarvedView();
        
        // Advance game clock by one year
        advanceOneYearView(); 
        
        // Call the displayCropsReportView() method
        displayCropsReportView();
        
        // add calls to the other crop view methods
        // as they are written
    }
}
