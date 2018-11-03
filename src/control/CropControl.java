/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import java.util.Random;

/**
 *
 * @author Drazen
 */
public class CropControl {
    // constants

    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 11;
    private static final int ACRES_PER_BUSHEL = 2;
    private static final int ACRES_PER_PERSON = 10;
    private static final int BUSHELS_PER_PERSON = 20;
    private static final int MAX_POPULATION_GROWTH_PERCENTAGE = 5;

    // random number generator
    private static Random random = new Random();

    /**
     * calcLandCost() method Purpose: Calculate a random number between 17 and
     * 27 bushels/acre
     *
     * @return the land cost
     */
    public static int calcLandCost() {
        int landCost = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landCost;
    }
    
    /**
     * calcLandCost() method Purpose: Calculate a random number between 17 and
     * 27 bushels/acre
     *
     * @return the land cost
     */
    public static int calcPopulationGrowthPercentage() {
        int growthPercentage = random.nextInt(MAX_POPULATION_GROWTH_PERCENTAGE + 1);
        return growthPercentage;
    }

    /**
     * The sellLand() method Purpose: to sell land
     *
     * @param landPrice
     * @param acresToSell
     * @param cropData
     * @return the number of acres owned after selling Preconditions:
     * acresToSell must be positive and <= acresOwned
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
     * The buyLand() method Purpose: To buy land
     *
     * @param landPrice
     * @param acresToBuy
     * @param cropData
     * @return the number of acres owned after buying Preconditions: acres to
     * buy must be positive and the number of bushels of wheat owned must be
     * enough to buy the acres at a given price.
     */
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData) {
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
     * The setOffering() method Purpose: To set a percentage of offering
     *
     * @param offeringPercentage, an integer between 0 and 100 inclusive
     * @param cropData, a reference to a CropData object
     * @return valid offering percentage Preconditions: percentage must be a
     * value between 0 and 100 inclusive.
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

    /**
     * The feedPeople() method Purpose: To allocate wheat for feeding the people
     *
     * @param the number of bushels of wheat allocated to feed the people
     * @param a reference to a CropData object
     * @return the number bushels of wheat set aside to feed the people
     * Pre-conditions: the number of bushels of wheat allocated to feed the
     * people must be a positive number (can be zero as well) and must not
     * exceed available wheat in the store
     */
    public static int feedPeople(int wheatToFeed, CropData cropData) {

        // If the number of bushels to feed the people is negative, this is an error. Return a -1.
        if (wheatToFeed < 0) {
            return -1;
        }
        // If the number of bushels to feed the people is greater than the wheat in store, this is an error. Return a -1.
        if (wheatToFeed > cropData.getWheatInStore()) {
            return -1;
        }
        // Subtract the number of bushels to feed the people from the wheat in store and save the result into CropData object.
        int newWheatInStore = cropData.getWheatInStore() - wheatToFeed;
        cropData.setWheatInStore(newWheatInStore);
        
        // Save the number of bushels to feed the people into CropData object
        cropData.setWheatForPeople(wheatToFeed);
        // Return the number of bushels to feed the people.
        return wheatToFeed;
    }

    /**
     * The plantCrop() method Purpose: To plant crop
     *
     * @param acresToPlant
     * @param cropData
     * @return acresPlanted the number of acres owned after planting
     * Pre-conditions: The number of acres to plant is a positive value (can be
     * 0 as well). Required bushels is a less than or equal to wheat in store
     * Acres to plant must be less than or equal to acres owned City population
     * must be greater than or equal to number of acres to plant / 10
     */
    public static int plantCrops(int acresToPlant, CropData cropData) {

        //if acresToPlant <0, return -1
        if (acresToPlant < 0) {
            return -1;
        }
        //requiredushels=acresToPlant/2
        int requiredBushels = acresToPlant / ACRES_PER_BUSHEL;
        if (acresToPlant % ACRES_PER_BUSHEL > 0) {
            requiredBushels++;
        }

        //requiredBushels > wheatInStore, return -1
        int wheatInStore = cropData.getWheatInStore();
        if (requiredBushels > wheatInStore) {
            return -1;
        }

        //acresToPlant > acresOwned, return -1 
        int acresOwned = cropData.getAcresOwned();
        if (acresToPlant > acresOwned) {
            return -1;
        }

        //If RequiredPopultation>population
        int requiredPopulation = acresToPlant / ACRES_PER_PERSON;
        if (acresToPlant % ACRES_PER_PERSON > 0) {
            requiredPopulation++;
        }
        int population = cropData.getPopulation();
        if (requiredPopulation > population) {
            return -1;
        }

        //requiedBushels - wheatInStore;
        wheatInStore -= requiredBushels;

        cropData.setWheatInStore(wheatInStore);
        cropData.setAcresPlanted(acresToPlant);
        //return acresPlanted 
        return acresToPlant;
    }
    
    public static int growPopulation(int growthPercentage, CropData cropData) {
        int population = cropData.getPopulation();
        int newPeople = population * growthPercentage / 100;
        cropData.setNewPeople(newPeople);
        population += newPeople;
        cropData.setPopulation(population);
        return newPeople;
    }
    
    public static int calcStarved(CropData cropData) {
        int population = cropData.getPopulation();
        int wheatForPeople = cropData.getWheatForPeople();
        int adequatlyFed = wheatForPeople / BUSHELS_PER_PERSON;
        int starved = 0;
        if (adequatlyFed < population) {
            starved = population - adequatlyFed;
            cropData.setNumberWhoDied(starved);
            population -= starved;
            cropData.setPopulation(population);
        }
        return starved;
    }
    
    public static int calcEatenByRats (int eatenByRats, CropData cropData){
        int wheatInStore = cropData.getWheatInStore();
        int eaten = eatenByRats * wheatInStore/100;
        wheatInStore -= eaten;
        cropData.setWheatInStore(wheatInStore);
        cropData.setEatenByRats(eaten);
        return eaten;
   }


    public static int storeWheat (int wheat, CropData cropData){
        if (wheat<0){
            return -1;
        }
        int wheatInStore=cropData.getWheatInStore();
        wheatInStore+=wheat;
        cropData.setWheatInStore(wheatInStore);
          
        return wheatInStore;
    }
}
        