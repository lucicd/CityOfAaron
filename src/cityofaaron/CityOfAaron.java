/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package cityofaaron;

import view.*;

/**
 *
 * @author Drazen
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainMenuView mmv=new MainMenuView();
        mmv.displayMenuView();
    }
}
