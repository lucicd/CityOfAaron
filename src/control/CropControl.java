/*
 * The CropControl class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import cityofaaron.CityOfAaron;
import exceptions.CropException;
import exceptions.EndOfGameException;
import exceptions.PeopleStarvedException;
import model.CropData;
import java.util.Random;
import model.Game;
import model.Map;
import model.Player;

/**
 *
 * @author Drazen
 */
public class CropControl {
    // constants
    public static final int LAND_BASE = 17;
    public static final int LAND_RANGE = 11;
    public static final int CROP_YIELD_BASE = 2;
    public static final int CROP_YIELD_RANGE = 4;
    public static final int MAX_EATEN_BY_RATS_PERCENTAGE = 10;
    public static final int ACRES_PER_BUSHEL = 2;
    public static final int ACRES_PER_PERSON = 10;
    public static final int BUSHELS_PER_PERSON = 20;
    public static final int MAX_POPULATION_GROWTH_PERCENTAGE = 5;

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
     * calcCropYield() method 
     * Purpose: Calculate a random crop yield between 2 and 5 bushels per acre
     *
     * @return the cropYield
     */
    public static int calcCropYield() {
        int cropYield = random.nextInt(CROP_YIELD_RANGE) + CROP_YIELD_BASE;
        return cropYield;
    }
   
    /**
     * Calculates random population growth percentage
     * @return growthPercentage
     */
    public static int calcPopulationGrowthPercentage() {
        int growthPercentage = random.nextInt(MAX_POPULATION_GROWTH_PERCENTAGE + 1);
        return growthPercentage;
    }
    
    /**
     * Calculates random percentage of crops eaten by rats
     * @return percentage
     */
    public static int calcEatenByRatsPercentage() {
        int percentage = random.nextInt(MAX_EATEN_BY_RATS_PERCENTAGE + 1);
        return percentage;
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
            throw new CropException("A negative value was input.");
        }

        //if acresToSell > acresOwned, throw exception
        int acresOwned = cropData.getAcresOwned();
        if (acresToSell > acresOwned) {
            throw new CropException("There is insufficient land to sell.");
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
            throw new CropException("A negative value was input.");
        }

        // requiredWheat = acresToBuy * landPrice
        int requiredWheat = acresToBuy * landPrice;

        // if requiredWheat > wheatInStore, throw exception
        int wheatInStore = cropData.getWheatInStore();
        if (requiredWheat > wheatInStore) {
            throw new CropException("There is insufficient wheat to buy this much land.");
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
     * @throws exceptions.CropException
     */
    public static void setOffering(int offeringPercentage, CropData cropData) 
        throws CropException 
    {
        //If the offering percentage is negative this is an error.
        if (offeringPercentage < 0) {
            throw new CropException("A negative value was input.");
        }

        //If the offering percentage is greater than 100, this is an error.
        if (offeringPercentage > 100) {
            throw new CropException("The percentage can't be greater than 100.");
        }

        //Save the offering percentage into CropData object.
        cropData.setOfferingPercentage(offeringPercentage);
    }
    
    /**
     * The payOffering() method Purpose: 
     * To calculate offering amount
     * @param cropData, a reference to a CropData object
     */
    public static void payOffering(CropData cropData) 
    {
        //Get offering percentage
        int offeringPercentage = cropData.getOfferingPercentage();
        
        //Calculate the offering
        int offering = cropData.getWheatInStore() * offeringPercentage / 100;

        //Save the offering into CropData object.
        cropData.setOffering(offering);
        
        //Update wheat in store
        int wheatInStore = cropData.getWheatInStore();
        cropData.setWheatInStore(wheatInStore - offering);
    }

    /**
     * The feedPeople() method Purpose: To allocate wheat for feeding the people
     *
     * @param wheatToFeed 
     * @param cropData
     * @throws exceptions.CropException
     */
    public static void feedPeople(int wheatToFeed,CropData cropData) 
            throws CropException{

        // If the number of bushels to feed the people is negative, this is an error. 
        if (wheatToFeed < 0) {
            throw new CropException("A negative value was input.");
        }
        
        // If the number of bushels to feed the people is greater than the wheat in store, this is an error. 
        if (wheatToFeed > cropData.getWheatInStore()) {
                throw new CropException("There is insufficient wheat to feed the people.");
        }
        
        // Subtract the number of bushels to feed the people from the wheat in store and save the result into CropData object.
        int newWheatInStore = cropData.getWheatInStore() - wheatToFeed;
        cropData.setWheatInStore(newWheatInStore);
        
        // Save the number of bushels to feed the people into CropData object
        cropData.setWheatForPeople(wheatToFeed); 
    }

     
    /**
     * The plantCrop() method Purpose: To plant crop
     * @param acresToPlant
     * @param cropData
     * @throws exceptions.CropException
     */
    public static void plantCrops(int acresToPlant, CropData cropData) 
         throws CropException
    {

        //if acresToPlant <0
        if (acresToPlant < 0) {
            throw new CropException("A negative value was input.");
        }
    
        //requiredushels=acresToPlant/2
        int requiredBushels = acresToPlant / ACRES_PER_BUSHEL;
        if (acresToPlant % ACRES_PER_BUSHEL > 0) {
            requiredBushels++;
        }

        //requiredBushels > wheatInStore
        int wheatInStore = cropData.getWheatInStore();
        if (requiredBushels > wheatInStore) {
           throw new CropException("There was insuficient wheat in store to plant crops.");
        }

        //acresToPlant > acresOwned
        int acresOwned = cropData.getAcresOwned();
        if (acresToPlant > acresOwned) {
             throw new CropException("There was not enough acres to plant the crop.");
        }

        //If RequiredPopultation>population
        int requiredPopulation = acresToPlant / ACRES_PER_PERSON;
        if (acresToPlant % ACRES_PER_PERSON > 0) {
            requiredPopulation++;
        }
        int population = cropData.getPopulation();
        if (requiredPopulation > population) {
             throw new CropException("There was not enough people to plant the crops.");
        }

        //requiedBushels - wheatInStore;
        wheatInStore -= requiredBushels;

        cropData.setWheatInStore(wheatInStore);
        cropData.setAcresPlanted(acresToPlant);
      
    }
    
    /**
     * Calculates population growth of the City of Aaron based on a given random percentage
     * @param growthPercentage
     * @param cropData
     */
    public static void growPopulation(int growthPercentage, CropData cropData) {
        int population = cropData.getPopulation();
        int newPeople = population * growthPercentage / 100;
        cropData.setNewPeople(newPeople);
        population += newPeople;
        cropData.setPopulation(population);
    }
    
    /**
     * Calculates the number of people fed and starved
     * @param cropData
     */
    public static void calcStarved(CropData cropData) {
        int population = cropData.getPopulation();
        int wheatForPeople = cropData.getWheatForPeople();
        int adequatlyFed = wheatForPeople / BUSHELS_PER_PERSON;
        if (adequatlyFed >= population) {
            adequatlyFed = population;
            cropData.setNumberWhoDied(0);
        } else {
            int starved = population - adequatlyFed;
            cropData.setNumberWhoDied(starved);
            population -= starved;
            cropData.setPopulation(population);
        }
        
        cropData.setPeopleFed(adequatlyFed);
        
        //Check if there is any leftover and return it to the store
        int leftoverWheat = wheatForPeople - adequatlyFed * BUSHELS_PER_PERSON;
        if (leftoverWheat > 0) {
            int wheatInStore = cropData.getWheatInStore();
            cropData.setWheatInStore(wheatInStore + leftoverWheat);
        }
    }
    
    /**
     * calcEatenByRats method calculates the amount of wheat eaten by rats
     * @param eatenByRats
     * @param cropData
     */
    public static void calcEatenByRats (int eatenByRats, CropData cropData){
        int wheatInStore = cropData.getWheatInStore();
        int eaten = eatenByRats * wheatInStore / 100;
        wheatInStore -= eaten;
        cropData.setWheatInStore(wheatInStore);
        cropData.setEatenByRats(eaten);
   }


    public static void storeWheat (int wheat, CropData cropData) 
        throws CropException {
        if (wheat < 0){
            throw new CropException("A negative value was input.");
        }
        int wheatInStore=cropData.getWheatInStore();
        wheatInStore+=wheat;
        cropData.setWheatInStore(wheatInStore);
    }
    
    public static void setLocationCoordinates (int x, int y) throws CropException  {
        if (x<0){
            throw new CropException("A negative x coordinate was input.");
        }
        if (y<0){
            throw new CropException("A negative y coordinate was input.");
        } 
        Game game = CityOfAaron.getGame();
        Map map = game.getMap();
        if (x>=map.getColCount()){
            throw new CropException("An x coordinate is too large.");
        }
        if (y>=map.getRowCount()){
            throw new CropException("An y coordinate is too large.");
        }
        Player player = game.getPlayer();
        // Set player's row and column
        player.setColumn(x);
        player.setRow(y);
    } 
    
    public static void advanceOneYear() throws EndOfGameException, PeopleStarvedException {
        Game game = CityOfAaron.getGame();
        CropData cropData = game.getCropData();
        int currentYear = cropData.getYear();
        currentYear++;
        cropData.setYear(currentYear);
        if (currentYear>10){
            throw new EndOfGameException("Game over!");
        }
        int population = cropData.getPopulation();
        int starved = cropData.getNumberWhoDied();
        if (starved>population/2){
            throw new PeopleStarvedException("You are fired!");
        }
    }  
    
    /**
     * The harvestCrops() method 
     * Purpose: To harvest crops based on acres planted and crop yield
     * @param cropData
     */
    public static void harvestCrops(CropData cropData) {
        //calculate crop yield per acre
        int cropYield = calcCropYield();
        
        //calculate harvest
        int acresPlanted = cropData.getAcresPlanted();
        int harvest = cropYield * acresPlanted;
        
        //Update the harvest and crop yield into cropData object
        cropData.setCropYield(cropYield);
        cropData.setHarvest(harvest);
        
        //Increase wheat in store
        int wheatInStore = cropData.getWheatInStore();
        cropData.setWheatInStore(wheatInStore + harvest);
    }
}