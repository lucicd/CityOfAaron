// The HelpMenuView class - part of the view layer
// Object of this class manages the Help menu
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 6, 2018
//-------------------------------------------------------
package view;

/**
 *
 * @author tweet
 */
public class HelpMenuView extends MenuView {
    
    // The HelpMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================

    public HelpMenuView() {
        super("\n" +
                   "*****************************\n" +
                   "* CITY OF AARON: HELP MENU  *\n" +
                   "*****************************\n" +
                   " 1 - What are the goals of the game?\n" +
                   " 2 - Where is the city of Aaron?\n" +
                   " 3 - How do I view the map?\n" +
                   " 4 - How do I move to another location?\n" +
                   " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
                   " 6 - Return to the Main menu\n",
                6);
    }
    //The doAction method
    //Purpose: performs the selected action
    //Parameters;none
    //Returns:none
    //==================================================================
    @Override
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
