/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import model.CropData;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Drazen
 */
public class CropControl {
     // constants
     private static final int LAND_BASE = 17;
     private static final int LAND_RANGE = 11;

    // random number generator
    private static Random random = new Random();

    /**
     * calcLandCost() method
     * Purpose: Calculate a random number between 17 and 27 bushels/acre
     * @return the land cost
     */
    public static int calcLandCost() {
        int landCost = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landCost;
    }
    /**
     * The sellLand() method
     * Purpose: to sell land
     * @param landPrice
     * @param acresToSell
     * @param cropData
     * @return the number of acres owned after selling
     * Preconditions: acresToSell must be positive
     * and <= acresOwned
     */
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) {
        // if acresToSell < 0, return -1
        if (acresToSell < 0) {
            return -1;
        }
        
        //if acresToSell > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        if (acresToSell > acresOwned) {
            return -1;
        }

        //acresOwned = acresOwned - acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += acresToSell * landPrice;
        cropData.setWheatInStore(wheatInStore);

        //return acresOwned
        return acresOwned;
    }
    
    /**
     * The buyLand() method
     * Purpose: To buy land
     * @param landPrice
     * @param acresToBuy
     * @param cropData
     * @return the number of acres owned after buying
     * Preconditions: acres to buy must be positive
     * and the number of bushels of wheat owned must be
     * enough to buy the acres at a given price.
     */
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData)
    {
        // if acresToBuy < 0, return -1
        if (acresToBuy < 0) {
            return -1;
        }
        
        // requiredWheat = acresToBuy * landPrice
        int requiredWheat = acresToBuy * landPrice;
        
        // if requiredWheat > wheatInStore, return -1
        int wheatInStore = cropData.getWheatInStore();
        if (requiredWheat > wheatInStore) {
            return -1;
        }
        
        // acresOwned = acresOwned + acresToBuy
        int acresOwned = cropData.getAcresOwned();
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);
        
        // wheatInStore = wheatInStore – requiredWheat
        wheatInStore -= requiredWheat;
        cropData.setWheatInStore(wheatInStore);
        
        // return acresOwned
        return acresOwned;
    }
    
    /**
     * The setOffering() method
     * Purpose: To set a percentage of offering
     * @param offeringPercentage, an integer between 0 and 100 inclusive
     * @param cropData, a reference to a CropData object
     * @return valid offering percentage
     * Preconditions: percentage must be a value between 0 and 100 inclusive.
     */
    public static int setOffering(int offeringPercentage, CropData cropData) {
        //If the offering percentage is negative this is an error. Return a -1.
        if (offeringPercentage < 0) {
            return -1;
        }
        
        //If the offering percentage is greater than 100, this is an error. Return a -1.
        if (offeringPercentage > 100) {
            return -1;
        }
        
        //Save the offering percentage into CropData object.
        cropData.setOffering(offeringPercentage);
        
        //Return the offering percentage.

        return offeringPercentage;
    }

}
