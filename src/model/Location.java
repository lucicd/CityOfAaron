/*
 * The Location class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package model;

/**
 *
 * @author Carolyn Murray
 */
public class Location {

    private String description;

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    private String symbol;

    /**
     * Get the value of symbol
     *
     * @return the value of symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set the value of symbol
     *
     * @param symbol new value of symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
   
}
