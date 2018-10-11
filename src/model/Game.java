/*
 * The Player class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package model;

/**
 *
 * @author tweet
 */
public class Game {

    public Game() {
    }

    private Player thePlayer;

    /**
     * Get the value of thePlayer
     *
     * @return the value of thePlayer
     */
    public Player getPlayer() {
        return thePlayer;
    }

    /**
     * Set the value of thePlayer
     *
     * @param thePlayer new value of thePlayer
     */
    public void setPlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
    
}
