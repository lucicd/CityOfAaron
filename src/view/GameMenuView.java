// The GameMenuView class - part of the view layer
// Object of this class manages the Game menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 13, 2018
//-------------------------------------------------------
package view;

import cityofaaron.CityOfAaron;
import model.Game;
import model.Location;
import model.Map;

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
              " 2 - View/Print a list\n" +
              " 3 - Move to a new location\n" +
              " 4 - Manage the Crops\n" +
              " 5 - Return to the Main menu\n",
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
        System.out.println("\nMove to a new location option selected.");
    }

    private void manageCrops() {
        CropView.runCropView();
    }
}