/*
 * The CropData class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Drazen
 */
public class CropData implements Serializable {

    public CropData() {}
    
    private int year;
    private int population;
    private int acresOwned;
    private int eatenByRats;
    private int wheatInStore;
    private int cropYield;
    private int newPeople;
    private int numberWhoDied;
    private int harvest;
    private int peopleFed;
    private int acresPlanted;
    private int wheatForPeople;
    private int offering;
    private int offeringPercentage;

    /**
     * Get the offering percentage
     * @return offeringPercentage
     */
    public int getOfferingPercentage() {
        return offeringPercentage;
    }

    /**
     * Set the offering percentage
     * @param offeringPercentage
     */
    public void setOfferingPercentage(int offeringPercentage) {
        this.offeringPercentage = offeringPercentage;
    }

    /**
     * Get the value of year
     *
     * @return the value of year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the value of year
     *
     * @param year new value of year
     */
    public void setYear(int year) {
        this.year = year;
    }


    /**
     * Get the value of population
     *
     * @return the value of population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Set the value of population
     *
     * @param population new value of population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Get the value of acresOwned
     *
     * @return the value of acresOwned
     */
    public int getAcresOwned() {
        return acresOwned;
    }

    /**
     * Get the value of eatenByRats
     *
     * @return the value of eatenByRats
     */
    public int getEatenByRats() {
        return eatenByRats;
    }

    /**
     * Set the value of eatenByRats
     *
     * @param eatenByRats new value of eatenByRats
     */
    public void setEatenByRats(int eatenByRats) {
        this.eatenByRats = eatenByRats;
    }

    /**
     * Set the value of acresOwned
     *
     * @param acresOwned new value of acresOwned
     */
    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    /**
     * Get the value of cropYield
     *
     * @return the value of cropYield
     */
    public int getCropYield() {
        return cropYield;
    }

    /**
     * Set the value of cropYield
     *
     * @param cropYield new value of cropYield
     */
    public void setCropYield(int cropYield) {
        this.cropYield = cropYield;
    }

    /**
     * Get the value of wheatInStore
     *
     * @return the value of wheatInStore
     */
    public int getWheatInStore() {
        return wheatInStore;
    }

    /**
     * Set the value of wheatInStore
     *
     * @param wheatInStore new value of wheatInStore
     */
    public void setWheatInStore(int wheatInStore) {
        this.wheatInStore = wheatInStore;
    }

    /**
     * Get the value of numberWhoDied
     *
     * @return the value of numberWhoDied
     */
    public int getNumberWhoDied() {
        return numberWhoDied;
    }

    /**
     * Set the value of numberWhoDied
     *
     * @param numberWhoDied new value of numberWhoDied
     */
    public void setNumberWhoDied(int numberWhoDied) {
        this.numberWhoDied = numberWhoDied;
    }

    /**
     * Get the value of newPeople
     *
     * @return the value of newPeople
     */
    public int getNewPeople() {
        return newPeople;
    }

    /**
     * Set the value of newPeople
     *
     * @param newPeople new value of newPeople
     */
    public void setNewPeople(int newPeople) {
        this.newPeople = newPeople;
    }

    /**
     * Get the value of harvest
     *
     * @return the value of harvest
     */
    public int getHarvest() {
        return harvest;
    }

    /**
     * Set the value of harvest
     *
     * @param harvest new value of harvest
     */
    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    /**
     * Get the value of peopleFed
     *
     * @return the value of peopleFed
     */
    public int getPeopleFed() {
        return peopleFed;
    }

    /**
     * Set the value of peopleFed
     *
     * @param peopleFed new value of peopleFed
     */
    public void setPeopleFed(int peopleFed) {
        this.peopleFed = peopleFed;
    }

    /**
     * Get the value of acresPlanted
     *
     * @return the value of acresPlanted
     */
    public int getAcresPlanted() {
        return acresPlanted;
    }

    /**
     * Set the value of acresPlanted
     *
     * @param acresPlanted new value of acresPlanted
     */
    public void setAcresPlanted(int acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    /**
     * Get the value of wheatForPeople
     *
     * @return the value of wheatForPeople
     */
    public int getWheatForPeople() {
        return wheatForPeople;
    }

    /**
     * Set the value of wheatForPeople
     *
     * @param wheatForPeople new value of wheatForPeople
     */
    public void setWheatForPeople(int wheatForPeople) {
        this.wheatForPeople = wheatForPeople;
    }

    /**
     * Get the value of offering
     *
     * @return the value of offering
     */
    public int getOffering() {
        return offering;
    }

    /**
     * Set the value of offering
     *
     * @param offering new value of offering
     */
    public void setOffering(int offering) {
        this.offering = offering;
    }
 
}