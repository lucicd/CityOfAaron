/*
 * The Map class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package model;

/**
 *
 * @author Drazen
 */
public class Map {
    private int rowCount;               // stores the number of rows 
    private int colCount;               // stores the number of columns
    private Location[][] locations;     // a reference to a 2-dimensional array
                                        // of Location objects
    
    // default Map constructor
    // Purpose: Set data members to default values
    // Parameters: none
    // Returns: none
    public Map() {};
    
    // parameterized Map constructor
    // Purpose: Sets row and column values
    //    and creates an array of Location objects
    // Parameters: row count and column count
    // Returns: none
    public Map(int _rows, int _cols)
    {
        rowCount = _rows;
        colCount = _cols;

        // create the array of location objects
        locations = new Location[_rows][_cols];        
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    // The getLocation method
    // Purpose: returns the location object at the given row and column
    // Parameters: a row and column
    // Returns: a Location object
    public Location getLocation(int row, int col)
    {
        return locations[row][col];
    }
    
    // The setLocation method
    // Purpose: stores a location object at the  row and column
    // Parameters: a row and column, and a reference to a location object
    // Returns: void
    public void setLocation(int row, int col, Location _location)
    {
        locations[row][col] = _location;
    } 

    public static String getLegend() {
        return "\n&& - The Ruler’s Court" +
               "\n[] - The City’s granary and storehouse" + 
               "\n## - The City of Aaron streets" + 
               "\n&& - The village"+
               "\n-- - The pastures"+
               "\n^* - Snow-covered mountains"+
               "\n00 - Undeveloped land"+
               "\n!! - Farmland"+
               "\n.. - Desert"+
               "\nxx - The border of the Lamanites land"+
               "\n~~ - The river";
    }
}
