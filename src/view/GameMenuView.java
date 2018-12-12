// The GameMenuView class - part of the view layer
// Object of this class manages the Game menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 13, 2018
//-------------------------------------------------------
package view;

import cityofaaron.CityOfAaron;
import control.CropControl;
import exceptions.CropException;
import java.util.InputMismatchException;
import model.Game;
import model.Location;
import model.Map;
import model.Player;

/**
 *
 * @author Drazen
 */
public class GameMenuView extends MenuView {
    // The GameMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================

    public GameMenuView() {
        super("\n" +
              "*****************************\n" +
              "* CITY OF AARON: GAME MENU  *\n" +
              "*****************************\n" +
              " 1 - View the map\n" +
              " 2 - View/print a list\n" +
              " 3 - Move to a new location\n" +
              " 4 - Manage the crops\n" +
              " 5 - Return to the main menu\n",
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
    
    // The printRowSeparator method
    // Purpose: Prints the separator between map rows
    // Parameters: none
    // Returns: none
    // ===================================
    private static void printRowSeparator(int maxCols) {
        for (int col = 0; col < maxCols; col++) {
            System.out.print("+-----");
        }
        System.out.println("+");
    }

    // The viewMap method
    // Purpose: Prints the map as 2D matrix
    // Parameters: none
    // Returns: none
    // ===================================
    private static void viewMap() {
        System.out.println("*******************************");
        System.out.println("*   CITY OF AARON: GAME MAP   *");
        System.out.println("*******************************");
        System.out.println(Map.getLegend());
        System.out.println();
        
        Game game = CityOfAaron.getGame();
        Map map = game.getMap();
        int maxRows = map.getRowCount();
        int maxCols = map.getColCount();
        for (int row = 0; row < maxRows; row++) {
            printRowSeparator(maxCols);
            for (int col = 0; col < maxCols; col++) {
                Location loc = map.getLocation(row, col);
                System.out.print("+ ");
                System.out.print(loc.getSymbol());
                System.out.print("  ");
            }
            System.out.println("+");
        }
        printRowSeparator(maxCols);
    }
    
    // The viewList() method
    // Purpose: Creates a ListMenuView object and calls its
    //    displayMenu( ) method       
    // Parameters: none
    // Returns: none

    private void viewList() {
        ListMenuView lmv = new ListMenuView();
        lmv.displayMenuView();
    }

    private void moveToNewLocation() {
        System.out.println("\nEnter the coordinates of the location you want to move to.");
        //Get references to the game and player objects
        Game game = CityOfAaron.getGame();
        
        int x;
        int y;
        boolean paramsNotOkay;
        do {
            paramsNotOkay = false;

            try {
                // Prompt the user to enter the x coordinates
                System.out.print("Enter the x-coordinate:");
                // Get the user’s input and save it.
                x = keyboard.nextInt();
                // Prompt the user to enter the y coordinates
                System.out.print("Enter the y-coordinate:");
                // Get the user’s input and save it.
                y = keyboard.nextInt();
                
                CropControl.setLocationCoordinates(x, y);
                
                //Show location descriptions.
                Map map = game.getMap();
                Location location = map.getLocation(y, x);
                System.out.println(location.getDescription());
                
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer");
                keyboard.next();
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);
        
    }

    private void manageCrops() {
        CropView.runCropView();
    }
}