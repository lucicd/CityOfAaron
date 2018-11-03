/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package cityofaaron;

import model.Game;
import view.*;

/**
 *
 * @author Drazen
 */
public class CityOfAaron {
    // variable for keeping a reference to the Game object
    private static Game theGame = null;

    // getter for theGame reference
    public static Game getGame() {
        return theGame;
    }

    // setter for theGame reference
    public static void setGame(Game theGame) {
        CityOfAaron.theGame = theGame;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainMenuView mmv=new MainMenuView();
        mmv.displayMenuView();
    }
}
