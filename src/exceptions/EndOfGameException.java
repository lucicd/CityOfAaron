// The EndOfGameException class
// Object of this class implement exception handling
// Author: Gail Lee
// Date last modified: December 11, 2018
//-------------------------------------------------------
package exceptions;

/**
 *
 * @author Gail Lee
 */
public class EndOfGameException extends Exception {
    // Default constructor
    // Purpose: Initializes data members to default values
    // Parameters: none
    // Returns: none
    public EndOfGameException() { }


    // Parameterized  constructor
    // Purpose: Initializes data members to value passed as a parameter
    // Parameters: A string containing the error message
    // Returns: none
    public EndOfGameException(String string)
    {
        super(string);
    } 

}
