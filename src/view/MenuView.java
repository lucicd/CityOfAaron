// The MenuView class – base abstract class for all menu views
// Author: Drazen Lucic, Carolyn Murray, Gail Lee team
// Date last modified: November 13, 2018
//-------------------------------------------------------
package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Drazen
 */
public abstract class MenuView implements ViewInterface {
    protected final static Scanner keyboard=new Scanner(System.in);
    protected final String theMenu;
    protected final int max;
    
    public MenuView(String _menu, int _max) {
        theMenu = _menu;
        max = _max;
    }

    @Override
    public int getMenuOption()
    {
        int userInput=0;
        do
        {
            while (true) {
                try {
                    // get user input from the keyboard
                    userInput = keyboard.nextInt();
                    //Break the endless loopo
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer.");
                    keyboard.next();
                }
            }
            // if user input is not a valid value, output an error message
            if(userInput < 1 || userInput > max){
                System.out.format("\nError: input value must be between 1 and %d.", max);
            }
            // loop back to the top of the loop if input was not valid
            // end loop
        } while (userInput < 1 || userInput > max);
        
        return userInput;
    }

    @Override
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

