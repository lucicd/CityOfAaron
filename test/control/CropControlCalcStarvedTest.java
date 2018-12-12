/*
 * The CropControlCalcStarvedTest class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Drazen
 */
public class CropControlCalcStarvedTest {
    
    @Test
    public void testCalcStarvedCase1() {
        System.out.println("calcStarved - Test Case 1");
        CropData cropData = new CropData();
        
        int population = 1000;
        int wheatForPeople = 30000;
        int expResult = 0;
        
        cropData.setPopulation(population);
        cropData.setWheatForPeople(wheatForPeople);
        CropControl.calcStarved(cropData);
        assertEquals(expResult, cropData.getNumberWhoDied());
        assertEquals(population - expResult, cropData.getPopulation());
    }
    
    @Test
    public void testCalcStarvedCase2() {
        System.out.println("calcStarved - Test Case 2");
        CropData cropData = new CropData();
        
        int population = 1000;
        int wheatForPeople = 20000;
        int expResult = 0;
        
        cropData.setPopulation(population);
        cropData.setWheatForPeople(wheatForPeople);
        CropControl.calcStarved(cropData);
        assertEquals(expResult, cropData.getNumberWhoDied());
        assertEquals(population - expResult, cropData.getPopulation());
    }
    
    @Test
    public void testCalcStarvedCase3() {
        System.out.println("calcStarved - Test Case 3");
        CropData cropData = new CropData();
        
        int population = 1000;
        int wheatForPeople = 10000;
        int expResult = 500;
        
        cropData.setPopulation(population);
        cropData.setWheatForPeople(wheatForPeople);
        CropControl.calcStarved(cropData);
        assertEquals(expResult, cropData.getNumberWhoDied());
        assertEquals(population - expResult, cropData.getPopulation());
    }
    
    @Test
    public void testCalcStarvedCase4() {
        System.out.println("calcStarved - Test Case 4");
        CropData cropData = new CropData();
        
        int population = 1000;
        int wheatForPeople = 0;
        int expResult = 1000;
        
        cropData.setPopulation(population);
        cropData.setWheatForPeople(wheatForPeople);
        CropControl.calcStarved(cropData);
        assertEquals(expResult, cropData.getNumberWhoDied());
        assertEquals(population - expResult, cropData.getPopulation());
    }
    
    @Test
    public void testCalcStarvedCase5() {
        System.out.println("calcStarved - Test Case 5");
        CropData cropData = new CropData();
        
        int population = 0;
        int wheatForPeople = 0;
        int expResult = 0;
        
        cropData.setPopulation(population);
        cropData.setWheatForPeople(wheatForPeople);
        CropControl.calcStarved(cropData);
        assertEquals(expResult, cropData.getNumberWhoDied());
        assertEquals(population - expResult, cropData.getPopulation());
    }
    
    @Test
    public void testCalcStarvedCase6() {
        System.out.println("calcStarved - Test Case 6");
        CropData cropData = new CropData();
        
        int population = 0;
        int wheatForPeople = 100;
        int expResult = 0;
        
        cropData.setPopulation(population);
        cropData.setWheatForPeople(wheatForPeople);
        CropControl.calcStarved(cropData);
        assertEquals(expResult, cropData.getNumberWhoDied());
        assertEquals(population - expResult, cropData.getPopulation());
    }
}
