// The ViewInterface class - part of the view layer
// The interface contains the method signatures
// that are common to all of the menu view classes.
// Author: Drazen Lucic, Carolyn Murray, Gail Lee team
// Date last modified: November 13, 2018
//-------------------------------------------------------
package view;

/**
 *
 * @author Drazen
 */
public interface ViewInterface {
    public void displayMenuView();
    public int getMenuOption();
    public void doAction(int option);
}
