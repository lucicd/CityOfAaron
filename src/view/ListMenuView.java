// The ListMenuView class - part of the view layer
// Object of this class manages the List menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 13, 2018
//-------------------------------------------------------
package view;

import cityofaaron.CityOfAaron;
import java.util.ArrayList;
import model.Game;
import model.ListItem;

/**
 *
 * @author Gail Lee
 */
public class ListMenuView extends MenuView{
    
    // The ListMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================  

    public ListMenuView() {
     super("\n" +
           "*****************************\n" +
           "* CITY OF AARON: LIST MENU  *\n" +
           "*****************************\n" +
           " 1 - List or view the animals in the storehouse\n" +
           " 2 - List or view the tools in the storehouse\n" +
           " 3 - List or view the provisions in the storehouse\n" +
           " 4 - List or view the people in the development team\n" +
           " 5 - Return to the Game menu\n",
        5);
     
    }
    //The doAction method
    //Purpose: performs the selected action
    //Parameters;none
    //Returns:none
    //==================================================================
    @Override
    public void doAction(int option){
        switch(option){
            case 1://List or view the animals in the storehouse
                listAnimals();
                break;
            case 2://List or view the tools in the storehouse
                listTools();
                break;
            case 3://List or view the provisions in the storehouse
                listProvisions();
                break;
            case 4://List or view the developers of this game
                listTeam();
                break;
            case 5://Return to the Game menu
                return;
        }
    }
    
    //The listAnimals method
    //Purpose: lists the animals in the sorehouse
    //Parameters: none
    //Returns: none
    //================================================
    private void listAnimals() {
        //get the game object
        Game game = CityOfAaron.getGame();
        
        //use the game object to get the list of animals in the storehouse
        ArrayList<ListItem> animals = game.getAnimals();
        
        //show report title
        System.out.println("\nAnimals in the City of Aaron");
               
        for (ListItem animal: animals) {
            String name = animal.getName();
            int number = animal.getNumber();
            System.out.format("%s\t\t%d\n", name, number);
        }
    }
   
    //Carolyn
    //The listTools method
    //Purpose: lists the tools in the storehouse
    //Parameters: none
    //Returns: none
    //================================================
    private void listTools() {
        //get the game object
        Game game = CityOfAaron.getGame();
        
        //use the game object to get the list of tools in the storehouse
        ArrayList<ListItem> tools = game.getTools();
        
        //show report title
        System.out.println("\nTools in the City of Aaron");
               
        for (ListItem tool: tools) {
            String name = tool.getName();
            int number = tool.getNumber();
            System.out.format("%s\t\t%d\n", name, number);
        }
    }

    //Gail Lee
    //The listProvisions method
    //Purpose: lists the provisions in the storehouse
    //Parameters: none
    //Returns: none
    //================================================
    private void listProvisions() {
        //get the game object
        Game game = CityOfAaron.getGame();
        
        //use the game object to get the list of provisions in the storehouse
        ArrayList<ListItem> provisions = game.getProvisions();
        
        //show report title
        System.out.println("\nProvisions in the City of Aaron");
               
        for (ListItem provision: provisions) {
            String name = provision.getName();
            int number = provision.getNumber();
            System.out.format("%s\t\t%d\n", name, number);
        }
    }

    private void listTeam() {
        System.out.println("listTeam options selected");
    }
}
