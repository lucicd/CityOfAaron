/*
 * The GameControl class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;
import model.*;
import cityofaaron.CityOfAaron;
import java.util.ArrayList;
import java.util.Arrays;

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
        
        //Create the list of animals
        createAnimalsList();
        
        //Create the list of tools
        createToolsList();
        
        //Create the list of provisions
        createProvisionsList();
        
        //Create the list of team members
        createTeamMembersList();
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
        
        // set an undeveloped land location
        String undeveloped = "\nYou are on the undeveloped land." +
                             "\nPerhaps the land price is good." + 
                             "\nConsider buying some land and planting crops.";
        loc = new Location();
        loc.setDescription(undeveloped);
        loc.setSymbol("00");
        theMap.setLocation(0, 2, loc);
        theMap.setLocation(0, 3, loc);
        
        // set a farmland location with a hint
        String farmland = "\nYou are on the fertile banks of the River." +
                          "\nIn the springthis low farmland floods and is covered with rich" +
                          "\nnew soil. Wheat is planted as far as you can see."; 
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat." + 
                                      "\nOne farmer can take care of 10 acres of land.");
        loc.setSymbol("!!");
        theMap.setLocation(1, 2, loc);
        theMap.setLocation(1, 3, loc);
        theMap.setLocation(2, 2, loc);
        theMap.setLocation(2, 3, loc);
        
        //Ruler's Court location
        String rulersCourt = "\nYou are the Ruler's Court." +
                             "\nThe citizens have full confidence in your leadership skills." +
                             "\nBuy/sell land, plant/harvest crops. Keep us safe from pests.";
        loc = new Location();
        loc.setDescription(rulersCourt);
        loc.setSymbol("&&");
        theMap.setLocation(0, 0, loc);
        
        //The City’s Granary and Storehouse location
        String storeHouse = "\nYou are the City's Granary and Storehouse.";
        loc = new Location();
        loc.setDescription(storeHouse);
        loc.setSymbol("[]");
        theMap.setLocation(0, 1, loc);
        
        //The city location
        String city = "\nYou are the City of Aaron streets." + 
                      "\nPeople are cheering for you.";
        loc = new Location();
        loc.setDescription(city);
        loc.setSymbol("##");
        theMap.setLocation(1, 0, loc);
        theMap.setLocation(1, 1, loc);
        
        //The village location with a hint
        String village = "\nYou are the village on the outskirts of the City of Aaron." + 
                         "\nIt is the home of hard-working farmers.";
        loc = new Location();
        loc.setDescription(village + "\nOne farmer can take care of 10 acres of land.");
        loc.setSymbol("@@");
        theMap.setLocation(2, 0, loc);
        theMap.setLocation(2, 1, loc);
        
        // define the string for mountain location
        String pastures = "\nYou are on the pastures area, green grass as far as the eye can see." +
                          "\nHughe herds of bisons are grazing around." +
                          "\nYet, planty of grass remains for your sheep and cattle.";

        // set a pastures location
        loc = new Location();
        loc.setDescription(pastures);
        loc.setSymbol("--");
        theMap.setLocation(3, 0, loc);
        theMap.setLocation(3, 1, loc);
        
        // set a mountains location
        String mountains = "\nYou are on the snow-covered mountains." +
                           "\nThere is plenty of wood, but beware of grizzly bears." +
                           "\nSearch carefully and you might find some ore for your tools.";
        loc = new Location();
        loc.setDescription(mountains);
        loc.setSymbol("^*");
        theMap.setLocation(4, 0, loc);
        theMap.setLocation(4, 1, loc);
        
        // set a desert location
        String desert = "\nYou are the desert." +
                        "\nLots of sand and not much else." +
                        "\nHowever, it is a buffer zone between you an the Lamanites.";
        loc = new Location();
        loc.setDescription(desert);
        loc.setSymbol("..");
        theMap.setLocation(3, 2, loc);
        theMap.setLocation(3, 3, loc);
        
        // set the border of the Lamaintes land
        String lamanitesLand = "\nYou are at the border of the Lamaintes land." +
                               "\nBeware of Lamanites. They seem to be on the war path nowadays.";
        loc = new Location();
        loc.setDescription(lamanitesLand);
        loc.setSymbol("xx");
        theMap.setLocation(4, 2, loc);
        theMap.setLocation(4, 3, loc);
        
        game.setMap(theMap);
    }
    
    //createAnimalsList method
    //Purpose: creates list of animals in the storehouse
    //         and stores it into the game object
    //Params: none
    //Returns: none
    //Made by Drazen
    public static void createAnimalsList() {
        ArrayList<ListItem> animals = new ArrayList<>();
        
        animals.add(new ListItem("Sheep", 100));
        animals.add(new ListItem("Cow", 120));
        animals.add(new ListItem("Horse", 350));
        animals.add(new ListItem("Goat", 50));
        
        game.setAnimals(animals);
    }
    
    //createToolsList method
    //Purpose: creates list of tools in the storehouse
    //         and stores it into the game object
    //Params: none
    //Returns: none
    //Made by Carolyn
    public static void createToolsList() {
        ArrayList<ListItem> tools = new ArrayList<>();
        
        tools.add(new ListItem("Axe", 10));
        tools.add(new ListItem("Shovel", 50));
        tools.add(new ListItem("Sickel", 150));
        tools.add(new ListItem("Plow", 50));
        
        game.setTools(tools);
    }
    
    //createProvisionsList method
    //Purpose: creates list of provisions in the storehouse
    //         and stores it into the game object
    //Params: none
    //Returns: none
    //Made by Gail
    public static void createProvisionsList() {
        ArrayList<ListItem> provisions = new ArrayList<>();
        
        provisions.add(new ListItem("Sugar", 350));
        provisions.add(new ListItem("Salt", 50));
        provisions.add(new ListItem("Flour", 550));
        provisions.add(new ListItem("Rice", 100));
        
        game.setProvisions(provisions);
    }
    
    //createTeamMembersList method
    //Purpose: creates list of team members
    //         and stores it into the game object
    //Params: none
    //Returns: none
    //Made by Drazen
    public static void createTeamMembersList() {
        ArrayList<TeamMember> teamMembers = 
                new ArrayList<TeamMember>(Arrays.asList(TeamMember.values()));
        game.setTeamMembers(teamMembers);
    }
}



