/*
 * The GameControl class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;
import model.*;
import cityofaaron.CityOfAaron;

/**
 *
 * @author tweet
 */
public class GameControl {
    // size of the Locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    private static final Game game = new Game();

    public static void createNewGame(String _name){
        // Create a new Player object.
        Player player = new Player();
        
        // Store the name of the player in the Player object
        player.setName(_name);
    
        // Store a reference to the Player object in the Game object
        game.setPlayer(player);
        
        // Save a reference to the Game object in the static variable
        // declared in the CityOfAaron class.
        CityOfAaron.setGame(game);
        
        //Create CropData object
        createCropDataObject();
        
        //Create Map object
        createMap();
    }
    
    // createCropDataObject method
    // Purpose: creates CropData objects and populates starting values
    // Input parameters: none
    // Returns: none
    public static void createCropDataObject()
    {
        CropData theCrops = new CropData();
        
        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOffering(300);
        theCrops.setAcresPlanted(1000); 
        
        game.setCropData(theCrops);         
    }
    
    // The createMap method
    // Purpose: creates the location objects and the map
    // Parameters: none
    // Returns: none
    
    public static void createMap()   
    {
        // create the Map object, it is 5 x 5
        // refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        // create a string that will go in the Location objects
        // that contain the river
        String river = "\nYou are on the River. The river is the source" +
                       "\nof life for our city. The river marks the eastern " +
                       "\nboundary of the city - it is wilderness to the East.";
        // Create a new Location object
        Location loc = new Location();
        
        //use setters in the Location class to set the description and symbol
        loc.setDescription(river);
        loc.setSymbol("~~");
        
        for (int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 4, loc);
        }
        
        // define the string for a farm land location
        String farmland = "\nYou are on the fertile banks of the River." +
                          "\nIn the springthis low farmland floods and is covered with rich" +
                          "\nnew soil. Wheat is planted as far as you can see."; 

        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!");
        for (int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 2, loc);
            theMap.setLocation(i, 3, loc);
        }
        
        // define the string for mountain location
        String mountains = "\nYou are on the snow-covered mountains." +
                           "\nThere is plenty of wood, but beware of grizzly bears." +
                           "\nSearch carefully and you might find some ore for your tools.";

        // set a mountains location
        loc = new Location();
        loc.setDescription(mountains);
        loc.setSymbol("^*");
        theMap.setLocation(MAX_ROW - 1, 0, loc);
        theMap.setLocation(MAX_ROW - 1, 1, loc);

        // define the string for city location
        String city = "\nYou are the City of Aaron." +
                      "\nThe citizens have full confidence in your leadership skills." +
                      "\nBuy/sell land, plant/harvest crops. Keep us safe from pests.";

        // set a city location
        loc = new Location();
        loc.setDescription(city + "\nOne citizen can plant 10 acres of land.");
        loc.setSymbol("##");
        theMap.setLocation(0, 0, loc);
        theMap.setLocation(0, 1, loc);
        theMap.setLocation(1, 0, loc);
        theMap.setLocation(1, 1, loc);
        
        // define the string for mountain location
        String pastures = "\nYou are on the pastures area, green grass as far as the eye can see." +
                          "\nHughe herds of bisons are grazing around." +
                          "\nYet, planty of grass remains for your sheep and cattle.";

        // set a pastures location
        loc = new Location();
        loc.setDescription(pastures);
        loc.setSymbol("--");
        theMap.setLocation(2, 0, loc);
        theMap.setLocation(2, 1, loc);
        theMap.setLocation(3, 0, loc);
        theMap.setLocation(3, 1, loc);
        
        game.setMap(theMap);
    }

}
