// The HelpMenuView class - part of the view layer
// Object of this class manages the Help menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 6, 2018
//-------------------------------------------------------
package view;

import java.util.Scanner;
/**
 *
 * @author tweet
 */
public class HelpMenuView {
    
    Scanner keyboard=new Scanner(System.in);
    private final String theMenu;
    private final int max;
   
    // The HelpMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================

    public HelpMenuView() {
        theMenu = "\n" +
                   "*****************************\n" +
                   "* CITY OF AARON: HELP MENU  *\n" +
                   "*****************************\n" +
                   " 1 - What are the goals of the game?\n" +
                   " 2 - Where is the city of Aaron?\n" +
                   " 3 - How do I view the map?\n" +
                   " 4 - How do I move to another location?\n" +
                   " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
                   " 6 - Return to the Main menu\n";
        max = 6;
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
                System.out.println("Error: you must select 1,2,3,4,5 or 6");
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
            case 1://Goals of the game
                viewGoals();
                break;
            case 2://Where is the city of Aaron
                viewCityLocation();
                break;
            case 3://View Map
                viewMapHelp();
                break;
            case 4://Move To Another Location
                viewMoveHelp();
                break;
            case 5://List Inventory
                viewListHelp();
                break;
            case 6://Back to Main Menu
                return;
        }
    }
    
    public void displayMenuView()
    {
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

    private void viewGoals() {
        System.out.println("viewGoals Option Selected");
    }

    private void viewCityLocation() {
        System.out.println("viewCityLocation Option Selected");
    }

    private void viewMapHelp() {
        System.out.println("viewMapHelp Option Selected");
    }

    private void viewMoveHelp() {
        System.out.println("viewMoveHelp Option Selected");
    }

    private void viewListHelp() {
        System.out.println("viewListHelp Option Selected");
    }

}
