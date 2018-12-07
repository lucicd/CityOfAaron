// The ListMenuView class - part of the view layer
// Object of this class manages the List menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 25, 2018
//-------------------------------------------------------
package view;

import cityofaaron.CityOfAaron;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Game;
import model.ListItem;
import model.TeamMember;

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
           " 5 - Save the list of animals in the storehouse\n" +
           " 6 - Save the list of tools in the storehouse\n" +
           " 7 - Save the list of provisions in the storehouse\n" +
           " 8 - Return to the Game menu\n",
        8);
     
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
            case 5://Save the list of animals in the storehouse
                listAnimalsToFile();
                break;
            case 6://Save the list of tools in the storehouse
                listToolsToFile();
                break;
            case 7://Save the list of provisions in the storehouse
                listProvisionsToFile();
                break;
            case 8://Return to the Game menu
                return;
        }
    }
    
    //Drazen
    //The prepareAnimalsReport method
    //Purpose: prepares the lists the animals in the storehouse report
    //Parameters: none
    //Returns: String report
    //================================================
    private String prepareAnimalsReport() {
        //get the game object
        Game game = CityOfAaron.getGame();
        
        //use the game object to get the list of animals in the storehouse
        ArrayList<ListItem> animals = game.getAnimals();
        
        //build report header
        String report = "*****************************\n" +
                        "* Animals in the Storehouse *\n" +
                        "*****************************\n";
        for (ListItem animal: animals) {
            String name = animal.getName();
            int number = animal.getNumber();
            report += String.format("%-20s %d\n", name, number);
        }
        return report;
    }
    
    //Drazen
    //The listAnimals method
    //Purpose: lists the animals in the storehouse
    //Parameters: none
    //Returns: none
    //================================================
    private void listAnimals() {
        System.out.println(prepareAnimalsReport());
    }
    
    //Drazen
    //The listAnimalsToFile method
    //Purpose: lists the animals in the storehouse into a file
    //Parameters: none
    //Returns: none
    //================================================
    private void listAnimalsToFile() {
        //Define file name
        String fileName = "animals.txt";
        
        try (PrintWriter out = new PrintWriter(fileName)) {
            //Prepare the report and print it to a file
            out.print(prepareAnimalsReport());
            System.out.println("\nList of animals saved to a file " + fileName);
        } catch (IOException e) {
            System.out.println("File Error. " + e.getMessage());
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
               
        //Loop through the list and show the items
        for (ListItem tool: tools) {
            String name = tool.getName();
            int number = tool.getNumber();
            System.out.format("%s\t\t%d\n", name, number);
        }
    }
    
    private void listToolsToFile() {
        System.out.println("To be completed by Carolyn.");
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
               
        //Loop through the list and show the items
        for (ListItem provision: provisions) {
            String name = provision.getName();
            int number = provision.getNumber();
            System.out.format("%s\t\t%d\n", name, number);
        }
    }
    
    private void listProvisionsToFile() {
        System.out.println("To be completed by Gail.");
    }

    private void listTeam() {
        //get the game object
        Game game = CityOfAaron.getGame();
        
        //use the game object to get the list of team members
        ArrayList<TeamMember> teamMembers = game.getTeamMembers();
        
        //show report title
        System.out.println("\nDevelopment team:");
        
        //Loop through the list and show the team members
        for (TeamMember member: teamMembers) {
            String name = member.getName();
            String title = member.getTitle();
            System.out.format("%s, %s\n", name, title);
        }
    }
}
