// The GameMenuView class - part of the view layer
// Object of this class manages the Game menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 13, 2018
//-------------------------------------------------------
package view;

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
    
    private void viewMap() {
        System.out.println("\nView the map option selected.");
    }

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