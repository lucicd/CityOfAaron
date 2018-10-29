/*
 * The CropControlGrowPopulationTest class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import model.CropData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Drazen
 */
public class CropControlGrowPopulationTest {
    
    @Test
    public void testGrowPopulationCase1() {
        System.out.println("growPopulation - Test Case 1");
        CropData cropData = new CropData();
        int population = 1000;
        int growthPercentage = 2;
        int expResult = 20;
        cropData.setPopulation(population);
        int result = CropControl.growPopulation(growthPercentage, cropData);
        assertEquals(expResult, result);
        assertEquals(expResult + population, cropData.getPopulation());
        assertEquals(expResult, cropData.getNewPeople());
    }
    
    @Test
    public void testGrowPopulationCase2() {
        System.out.println("growPopulation - Test Case 2");
        CropData cropData = new CropData();
        int population = 1000;
        int growthPercentage = 0;
        int expResult = 0;
        cropData.setPopulation(population);
        int result = CropControl.growPopulation(growthPercentage, cropData);
        assertEquals(expResult, result);
        assertEquals(expResult + population, cropData.getPopulation());
        assertEquals(expResult, cropData.getNewPeople());
    }
    
    @Test
    public void testGrowPopulationCase3() {
        System.out.println("growPopulation - Test Case 3");
        CropData cropData = new CropData();
        int population = 1000;
        int growthPercentage = 5;
        int expResult = 50;
        cropData.setPopulation(population);
        int result = CropControl.growPopulation(growthPercentage, cropData);
        assertEquals(expResult, result);
        assertEquals(expResult + population, cropData.getPopulation());
        assertEquals(expResult, cropData.getNewPeople());
    }
    
    @Test
    public void testGrowPopulationCase4() {
        System.out.println("growPopulation - Test Case 4");
        CropData cropData = new CropData();
        int population = 782;
        int growthPercentage = 3;
        int expResult = 23;
        cropData.setPopulation(population);
        int result = CropControl.growPopulation(growthPercentage, cropData);
        assertEquals(expResult, result);
        assertEquals(expResult + population, cropData.getPopulation());
        assertEquals(expResult, cropData.getNewPeople());
    }
    
    @Test
    public void testGrowPopulationCase5() {
        System.out.println("growPopulation - Test Case 5");
        CropData cropData = new CropData();
        int population = 822;
        int growthPercentage = 3;
        int expResult = 24;
        cropData.setPopulation(population);
        int result = CropControl.growPopulation(growthPercentage, cropData);
        assertEquals(expResult, result);
        assertEquals(expResult + population, cropData.getPopulation());
        assertEquals(expResult, cropData.getNewPeople());
    }
    
    @Test
    public void testGrowPopulationCase6() {
        System.out.println("growPopulation - Test Case 6");
        CropData cropData = new CropData();
        int population = 822;
        int growthPercentage = CropControl.calcPopulationGrowthPercentage();
        assertTrue(growthPercentage >= 0);
        assertTrue(growthPercentage <= 5);
        int expResult = population * growthPercentage / 100;
        cropData.setPopulation(population);
        int result = CropControl.growPopulation(growthPercentage, cropData);
        assertEquals(expResult, result);
        assertEquals(expResult + population, cropData.getPopulation());
        assertEquals(expResult, cropData.getNewPeople());
    }
}