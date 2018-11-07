// The GameMenuView class - part of the view layer
// Object of this class manages the Game menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 6, 2018
//-------------------------------------------------------
package view;

import java.util.Scanner;

/**
 *
 * @author Drazen
 */
public class GameMenuView {
    Scanner keyboard=new Scanner(System.in);
    private final String theMenu;
    private final int max;
    
    // The GameMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================

    public GameMenuView() {
        theMenu = "\n" +
                   "*****************************\n" +
                   "* CITY OF AARON: GAME MENU  *\n" +
                   "*****************************\n" +
                   " 1 - View the map\n" +
                   " 2 - View/Print a list\n" +
                   " 3 - Move to a new location\n" +
                   " 4 - Manage the Crops\n" +
                   " 5 - Return to the Main menu\n";
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
            case 1://View the map
                viewMap();
                break;
            case 2://View/Print a list
                viewList();
                break;
            case 3://Move to a new location
                moveToNewLocation();
                break;
            case 4://Manage the Crops
                manageCrops();
                break;
            case 5://Return to the Main menu
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

    private void viewMap() {
        System.out.println("\nView the map option selected.");
    }

    private void viewList() {
        CropView.displayCropsReportView();
    }

    private void moveToNewLocation() {
        System.out.println("\nMove to a new location option selected.");
    }

    private void manageCrops() {
        CropView.runCropView();
    }
}
