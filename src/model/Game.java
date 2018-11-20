/*
 * The Game class file for the cityOfAaron project
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

    private CropData cropData;
    private Map map;

    /**
     * Get the value of map
     *
     * @return the value of map
     */
    public Map getMap() {
        return map;
    }

    /**
     * Set the value of map
     *
     * @param map new value of map
     */
    public void setMap(Map map) {
        this.map = map;
    }


    /**
     * Get the value of cropData
     *
     * @return the value of cropData
     */
    public CropData getCropData() {
        return cropData;
    }

    /**
     * Set the value of cropData
     *
     * @param cropData new value of cropData
     */
    public void setCropData(CropData cropData) {
        this.cropData = cropData;
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
