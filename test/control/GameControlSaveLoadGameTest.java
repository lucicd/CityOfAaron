/*
 * The GameControlSaveLoadGameTest class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import cityofaaron.CityOfAaron;
import exceptions.CropException;
import model.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author Drazen
 */
public class GameControlSaveLoadGameTest {
    String filePath = "test_saved_game";
    String player = "Player 1";
    
    @Before
    public void createNewGame() {
        GameControl.createNewGame(player);
    }
    
    @Test
    public void saveLoadCropDataTest() {
        System.out.println("Save/Load Game Test - Test Case Game");
        try {
            Game game = CityOfAaron.getGame();
            //Do some changes in the cropData object
            CropData cropData = game.getCropData();
            cropData.setYear(1);
            cropData.setPopulation(2);
            cropData.setNewPeople(3);
            cropData.setCropYield(4);
            cropData.setNumberWhoDied(5);
            cropData.setWheatInStore(6);
            cropData.setAcresOwned(7);
            cropData.setHarvest(8);
            cropData.setOffering(9);
            cropData.setAcresPlanted(10);
            cropData.setEatenByRats(11);
            cropData.setWheatForPeople(12);
            cropData.setPeopleFed(13);

            //Save game
            GameControl.saveGame(filePath);

            //Again, do some changes in the cropData object
            cropData.setYear(10);
            cropData.setPopulation(20);
            cropData.setNewPeople(30);
            cropData.setCropYield(40);
            cropData.setNumberWhoDied(50);
            cropData.setWheatInStore(60);
            cropData.setAcresOwned(70);
            cropData.setHarvest(80);
            cropData.setOffering(90);
            cropData.setAcresPlanted(100);
            cropData.setEatenByRats(110);
            cropData.setWheatForPeople(120);
            cropData.setPeopleFed(130);

            //Get saved game
            GameControl.getSavedGame(filePath);

            //New game object should have been created
            assertNotEquals(game, CityOfAaron.getGame());

            //Verify that values from the saved data are correct
            cropData = CityOfAaron.getGame().getCropData();
            assertEquals(1, cropData.getYear());
            assertEquals(2, cropData.getPopulation());
            assertEquals(3, cropData.getNewPeople());
            assertEquals(4, cropData.getCropYield());
            assertEquals(5, cropData.getNumberWhoDied());
            assertEquals(6, cropData.getWheatInStore());
            assertEquals(7, cropData.getAcresOwned());
            assertEquals(8, cropData.getHarvest());
            assertEquals(9, cropData.getOffering());
            assertEquals(10, cropData.getAcresPlanted());
            assertEquals(11, cropData.getEatenByRats());
            assertEquals(12, cropData.getWheatForPeople());
            assertEquals(13, cropData.getPeopleFed());
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void saveLoadMapTest() {
        System.out.println("Save/Load Game Test - Test Case Map");
        
//Get default description and symbol
        Map map = CityOfAaron.getGame().getMap();
        Location location = map.getLocation(3, 3);
        String defaultDescription = location.getDescription();
        String defaultSymbol = location.getSymbol();
        
        //Change description and symbol for location (3,3)
        //and save game to a file
        String newDescription = "New description";
        String newSymbol = "New symbol";  
        location.setDescription(newDescription);
        location.setSymbol(newSymbol);
        try {
            GameControl.saveGame(filePath);
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        
        //Create new game and verify that location (3, 3)
        //has default description and symbol
        createNewGame();
        map = CityOfAaron.getGame().getMap();
        location = map.getLocation(3, 3);
        assertEquals(defaultDescription, location.getDescription());
        assertEquals(defaultSymbol, location.getSymbol());
        
        //Finally, get the saved game from the file and
        //verify that location (3, 3) has new description and symbol
        try {
            GameControl.getSavedGame(filePath);
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        map = CityOfAaron.getGame().getMap();
        location = map.getLocation(3, 3);
        assertEquals(newDescription, location.getDescription());
        assertEquals(newSymbol, location.getSymbol());
    }
    
    @Test
    public void saveLoadPlayerTest() {
        System.out.println("Save/Load Game Test - Test Case Player");
        
        //Get player's name
        String name = CityOfAaron.getGame().getPlayer().getName();
        
        try {
            //Save the game
            GameControl.saveGame(filePath);
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        
        //Change the player name and verify it
        String newName = "New player";
        CityOfAaron.getGame().getPlayer().setName(newName);
        assertEquals(newName, CityOfAaron.getGame().getPlayer().getName());
        
        //Load the saved game and verify the old player's name
        try {
            GameControl.getSavedGame(filePath);
            
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        assertEquals(name, CityOfAaron.getGame().getPlayer().getName());
    }
    
    @Test
    public void saveLoadAnimalsListTest() {
        System.out.println("Save/Load Game Test - Test Case Animals List");
        
        try {
            GameControl.saveGame(filePath);
            int size = CityOfAaron.getGame().getAnimals().size();

            ListItem newItem = new ListItem();
            newItem.setName("Test");
            newItem.setNumber(1200);
            CityOfAaron.getGame().getAnimals().add(newItem);
            assertEquals(size + 1, CityOfAaron.getGame().getAnimals().size());

            GameControl.getSavedGame(filePath);
            assertEquals(size, CityOfAaron.getGame().getAnimals().size());
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void saveLoadToolsListTest() {
        System.out.println("Save/Load Game Test - Test Tools List");
        
        try {
            GameControl.saveGame(filePath);
            int size = CityOfAaron.getGame().getTools().size();

            ListItem newItem = new ListItem();
            newItem.setName("Test");
            newItem.setNumber(1200);
            CityOfAaron.getGame().getTools().add(newItem);
            assertEquals(size+1, CityOfAaron.getGame().getTools().size());

            GameControl.getSavedGame(filePath);
            assertEquals(size, CityOfAaron.getGame().getTools().size());
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void saveLoadProvisionsListTest() {
        System.out.println("Save/Load Game Test - Test Provisions List");
        
        try {
            GameControl.saveGame(filePath);
            int size = CityOfAaron.getGame().getProvisions().size();

            ListItem newItem = new ListItem();
            newItem.setName("Test");
            newItem.setNumber(1200);
            CityOfAaron.getGame().getProvisions().add(newItem);
            assertEquals(size+1, CityOfAaron.getGame().getProvisions().size());

            GameControl.getSavedGame(filePath);
            assertEquals(size, CityOfAaron.getGame().getProvisions().size());
        } catch (CropException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}