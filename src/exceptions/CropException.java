// The CropException class
// Object of this class implement exception handling
// Author: Drazen Lucic, Carolyn Murray, Gail Lee
// Date last modified: November 27, 2018
//-------------------------------------------------------
package exceptions;

/**
 *
 * @author CIT260 Team 1
 */
public class CropException extends Exception {
    // Default constructor
    // Purpose: Initializes data members to default values
    // Parameters: none
    // Returns: none
    public CropException() { }


    // Parameterized  constructor
    // Purpose: Initializes data members to value passed as a parameter
    // Parameters: A string containing the error message
    // Returns: none
    public CropException(String string)
    {
        super(string);
    } 

}
