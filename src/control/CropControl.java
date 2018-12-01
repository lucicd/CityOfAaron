/*
 * The CropControl class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import exceptions.CropException;
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
     * Preconditions: acresToSell must be positive and <= acresOwned
     * @param landPrice
     * @param acresToSell
     * @param cropData
     * @throws exceptions.CropException
     */
    public static void sellLand(int landPrice, 
            int acresToSell, CropData cropData)
            throws CropException
    {
        // if acresToSell < 0 throw exception
        if (acresToSell < 0) {
            throw new CropException("A negative value was input");
        }

        //if acresToSell > acresOwned, throw exception
        int acresOwned = cropData.getAcresOwned();
        if (acresToSell > acresOwned) {
            throw new CropException("There is insufficient land to sell");
        }

        //acresOwned = acresOwned - acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);

        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += acresToSell * landPrice;
        cropData.setWheatInStore(wheatInStore);
    }

    /**
     * The buyLand() method Purpose: To buy land
     *
     * @param landPrice
     * @param acresToBuy
     * @param cropData
     * @throws exceptions.CropException
     */
    public static void buyLand(int landPrice, 
            int acresToBuy, CropData cropData)
            throws CropException
    {
        // if acresToBuy < 0, throw exception
        if (acresToBuy < 0) {
            throw new CropException("A negative value was input");
        }

        // requiredWheat = acresToBuy * landPrice
        int requiredWheat = acresToBuy * landPrice;

        // if requiredWheat > wheatInStore, throw exception
        int wheatInStore = cropData.getWheatInStore();
        if (requiredWheat > wheatInStore) {
            throw new CropException("There is insufficient wheat to buy this much land");
        }

        // acresOwned = acresOwned + acresToBuy
        int acresOwned = cropData.getAcresOwned();
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);

        // wheatInStore = wheatInStore – requiredWheat
        wheatInStore -= requiredWheat;
        cropData.setWheatInStore(wheatInStore);
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
     * @throws exceptions.CropException
     */
    public static void plantCrops(int acresToPlant, CropData cropData) 
         throws CropException
    {

        //if acresToPlant <0
        if (acresToPlant < 0) {
            throw new CropException("A negative value was input");
    }
    
        //requiredushels=acresToPlant/2
        int requiredBushels = acresToPlant / ACRES_PER_BUSHEL;
        if (acresToPlant % ACRES_PER_BUSHEL > 0) {
            requiredBushels++;
        }

        //requiredBushels > wheatInStore
        int wheatInStore = cropData.getWheatInStore();
        if (requiredBushels > wheatInStore) {
           throw new CropException("There was insuficient wheat in store to plant crops");
        }

        //acresToPlant > acresOwned
        int acresOwned = cropData.getAcresOwned();
        if (acresToPlant > acresOwned) {
             throw new CropException("There was not enough acres to plant the crop");
        }

        //If RequiredPopultation>population
        int requiredPopulation = acresToPlant / ACRES_PER_PERSON;
        if (acresToPlant % ACRES_PER_PERSON > 0) {
            requiredPopulation++;
        }
        int population = cropData.getPopulation();
        if (requiredPopulation > population) {
             throw new CropException("There was not enough people to plant the crops");
        }

        //requiedBushels - wheatInStore;
        wheatInStore -= requiredBushels;

        cropData.setWheatInStore(wheatInStore);
        cropData.setAcresPlanted(acresToPlant);
      
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
        
