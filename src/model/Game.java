/*
 * The Game class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tweet
 */
public class Game {

    private ArrayList<ListItem> tools;

    public Game() {
    }

    private CropData cropData;
    private Map map;
    private ArrayList<ListItem> animals;
       
    /**
     * Get the value of animals
     *
     * @return the value of animals
     */
    public ArrayList<ListItem> getAnimals() {
        return animals;
    }

    /**
     * Set the value of animals
     *
     * @param animals new value of animals
     */
    public void setAnimals(ArrayList<ListItem> animals) {
        this.animals = animals;
    }

    /**
     * Get the value of tools
     *
     * @return the value of tools
     */
    public ArrayList<ListItem> getTools() {
        return tools;
    }

    /**
     * Set the value of tools
     *
     * @param tools new value of tools
     */
    public void setTools(ArrayList<ListItem> tools) {
        this.tools = tools;
    }


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
