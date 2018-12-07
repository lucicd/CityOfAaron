/*
 * The GameControlCreateNewGameTest class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import cityofaaron.CityOfAaron;
import java.util.ArrayList;
import model.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Drazen
 */

public class GameControlCreateNewGameTest {
    private Game game = null;
    
    @Before
    public void createNewGame() {
        String player = "Player 1";
        GameControl.createNewGame(player);
        game = CityOfAaron.getGame();
    }
    
    @Test
    public void testDefaultCropData() {
        System.out.println("createNewGame - Test Case Defaults");
        CropData cropData = game.getCropData();
        assertEquals(0, cropData.getYear());
        assertEquals(100, cropData.getPopulation());
        assertEquals(5, cropData.getNewPeople());
        assertEquals(3, cropData.getCropYield());
        assertEquals(0, cropData.getNumberWhoDied());
        assertEquals(2700, cropData.getWheatInStore());
        assertEquals(1000, cropData.getAcresOwned());
        assertEquals(3000, cropData.getHarvest());
        assertEquals(300, cropData.getOffering());
        assertEquals(1000, cropData.getAcresPlanted());
        assertEquals(0, cropData.getEatenByRats());
        assertEquals(0, cropData.getWheatForPeople());
        assertEquals(0, cropData.getPeopleFed());
    }
    
    @Test
    public void testPlayer() {
        System.out.println("createNewGame - Test Case Player");
        Player player = game.getPlayer();
        assertEquals("Player 1", player.getName());
    }
    
    @Test
    public void testMap() {
        System.out.println("createNewGame - Test Case Map");
        Map map = game.getMap();
        assertEquals(5, map.getRowCount());
        assertEquals(5, map.getColCount());
    }
    
    @Test
    public void testAnimalsList() {
        System.out.println("createNewGame - Test Case Animals List");
        ArrayList<ListItem> animals = game.getAnimals();
        assertEquals(4, animals.size());
        assertEquals("Sheep", animals.get(0).getName());
        assertEquals(100, animals.get(0).getNumber());
    }
    
    @Test
    public void testToolsList() {
        System.out.println("createNewGame - Test Case Tools List");
        ArrayList<ListItem> tools = game.getTools();
        assertEquals(4, tools.size());
        assertEquals("Axe", tools.get(0).getName());
        assertEquals(10, tools.get(0).getNumber());
    }
    
    @Test
    public void testProvisionsList() {
        System.out.println("createNewGame - Test Case Provisions List");
        ArrayList<ListItem> provisions = game.getProvisions();
        assertEquals(4, provisions.size());
        assertEquals("Sugar", provisions.get(0).getName());
        assertEquals(350, provisions.get(0).getNumber());
    }
    
    @Test
    public void testTeamMembersList() {
        System.out.println("createNewGame - Test Case Team Members List");
        ArrayList<TeamMember> teamMembers = game.getTeamMembers();
        assertEquals(3, teamMembers.size());
        assertEquals("Gail Lee", teamMembers.get(0).getName());
        assertEquals("Empress", teamMembers.get(0).getTitle());
    }
}