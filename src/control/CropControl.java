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
     * @param none
     * @return the land cost
     */
    
    public static int calcLandCost() {
        int landCost = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landCost;
    }
    /**
     * 
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
}
