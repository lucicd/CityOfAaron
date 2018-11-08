// The ListMenuView class - part of the view layer
// Object of this class manages the List menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 6, 2018
//-------------------------------------------------------
package view;

import java.util.Scanner;

/**
 *
 * @author Gail Lee
 */
public class ListMenuView {
    Scanner keyboard=new Scanner(System.in);
    private final String theMenu;
    private final int max;
    
    // The ListMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================  

    public ListMenuView() {
     theMenu = "\n" +
                   "*****************************\n" +
                   "* CITY OF AARON: LIST MENU  *\n" +
                   "*****************************\n" +
                   " 1 - List or view the animals in the storehouse\n" +
                   " 2 - List or view the tools in the storehouse\n" +
                   " 3 - List or view the provisions in the storehouse\n" +
                   " 4 - List or view the provisions in the storehouse\n" +
                   " 5 - Return to the Game menu\n";
        max = 5;
     
    }
    // The getMenuOption method
    // Purpose: gets the user's input
    // Parameters: none
    // Returns: integer - the option selected
    // ===================================       
    public int getMenuOption()
    {
        int userInput=0;
        do
        {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > max){
                System.out.println("Error: you must select 1,2,3,4,or 5");
            }
            // loop back to the top of the loop if input was not valid
            // end loop
        } while (userInput <1 || userInput > max);
        return userInput;
    }
    //The doAction method
    //Purpose: performs the selected action
    //Parameters;none
    //Returns:none
    //==================================================================
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
            case 4://Manage the CropsList or view the developers of this game
                listTeam();
                break;
            case 5://Return to the Game menu
                return;
        }
    }
    
    public void displayMenuView() {
        int menuOption;
        do
        {
            // Display the menu
            System.out.println(theMenu);
            
            // Prompt the user and get the user’s input
            menuOption=getMenuOption();
            
            // Perform the desired action
             doAction(menuOption);
        } while (menuOption != max);

    }
    
    private void listAnimals() {
        System.out.println("listAnimals options selected");
    }

    private void listTools() {
        System.out.println("listTools options selected");
    }

    private void listProvisions() {
        System.out.println("listProvisions options selected");
    }

    private void listTeam() {
        System.out.println("listTeam options selected");
    }
}
