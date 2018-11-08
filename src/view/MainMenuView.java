// The MainMenuView class - part of the view layer
// Object of this class manages the main menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee team
// Date last modified: October 30, 2018
//-------------------------------------------------------
package view;

import java.util.Scanner;
import control.GameControl;

/**
 *
 * @author Gail Lee
 */
public class MainMenuView {
    Scanner keyboard=new Scanner(System.in);
    private final String theMenu;
    private final int max;
// The MainMenuView constructor
// Purpose: Initialize the menu data
// Parameters: none
// Returns: none
// ===================================
public MainMenuView()
{
        theMenu = "\n" +
                   "**********************************\n" +
                   "* CITY OF AARON: MAIN GAME MENU  *\n" +
                   "**********************************\n" +
                   " 1 - Start new game\n" +
                   " 2 - Get and start a saved game\n" +
                   " 3 - Get help on playing the game\n" +
                   " 4 - Save game\n" +
                   " 5 - Quit\n";
        
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

        }while (userInput <1 || userInput > max);
        return userInput;
    }
//The doAction method
    //Purpose: performs the selected action
    //Parameters;none
    //Returns:none
    //==================================================================
    public void doAction(int option){
        switch(option){
            case 1://create and start a new game
                startNewGame();
                break;
            case 2://get and start a saved game
                startSavedGame();
                break;
            case 3://get help menu
                displayHelpMenuView();
                break;
            case 4://save game
                displaySaveGameView();
                break;
            case 5:
                System.out.println("Thanks for playing...goodbye.");
        }
    }
    //The startNewGame method
    //Purpose:creates game object and starts the game
    //Parmeters:none
    //Returns:none
    //===========================================
    public void startNewGame(){
    // Display the Banner Page.
    System.out.println(
            "Welcome to the city of Aaron! You have been elected by the people\n" +
            "to assume a role as the ruler of our budding city. We have full\n" + 
            "confidence in your abilities and wisdom to manage available resources.\n"+
            "Buy and sell land, determine how much wheat to plant each year and\n"+
            "how much to set aside to feed your people. If you fail to provide\n"+
            "enough wheat for the people, people will starve, some people will die,\n"+
            "and your workforce will be diminished. Beware of rats! Those pesky\n"+
            "creatures developed some taste for our wheat and last year devoured\n"+
            "10% of our crops. Unfortunately, if too many people die, you will be\n"+
            "removed from the office. However, if you are successful, more\n"+
            "inhabitants will join us, and the city of Aaron will flourish.\n"+
            "Good luck!"
    );
    
    // Prompt for and get the user's name.
    String name;
    System.out.println("\nPlease type in your first name:");
    name = keyboard.next();
    
    // Call the createNewGame() method in the GameControl class
    GameControl.createNewGame(name);
    
    // Display a welcome message
    System.out.println("Welcome " + name + " have fun!!!!");
    // Display the Game menu
    GameMenuView gmv=new GameMenuView( );
    gmv.displayMenuView();
    
    }
    //The startSavedGame()
    //Purposed:loads and starts the saved game
    //Parameters:none
    //Returns:none
    //===========================================
    public void startSavedGame(){
        System.out.println("\nStart saved game option selected.");
    }
    //The displayHelpMenuView()
    //Purposed: displays help menu
    //Parameters:none
    //Returns:none
    //===============================================
    public void displayHelpMenuView(){
        HelpMenuView mmv = new HelpMenuView();
        mmv.displayMenuView();
    }
    // The displaySaveGameView()
    //Purposed: display save game view
    //Parameters:none
    //Returns:none
    //==============================================
    public void displaySaveGameView(){
        System.out.println("\nDisplay save game view options selected.");
    }
// The displayMenuView method
    // Purpose: displays the menu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
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
    
}
