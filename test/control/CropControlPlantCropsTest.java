/*
 * The CropControlPlantCropsTest class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import exceptions.CropException;
import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 *
 * @author GailRVC
 */
public class CropControlPlantCropsTest {
    
    @Test
    public void testPlantCropsCase1() {
        System.out.println("PlantCrops - Test Case 1");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(1000);
        cropData.setPopulation(100);
        int acresToPlant = 500;
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            assertEquals(acresToPlant, cropData.getAcresPlanted());
            assertEquals(250, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }
 @Test
    public void testPlantCropsCase2() {
        System.out.println("PlantCrops - Test Case 2");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(1000);
        cropData.setPopulation(100);
        int acresToPlant = -5;
        int expResult = 1000;
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresOwned());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }  
    
    @Test
    public void testPlantCropsCase3() {
        System.out.println("PlantCrops - Test Case 3");
        CropData cropData = new CropData();
        cropData.setWheatInStore(1);
        cropData.setAcresOwned(1000);
        cropData.setPopulation(100);
        int acresToPlant = 10;
        int expResult = 0;

        try {
            CropControl.plantCrops(acresToPlant, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresPlanted());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testPlantCropsCase4() {
        System.out.println("PlantCrops - Test Case 4");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(10);
        cropData.setPopulation(100);
        int acresToPlant = 25;
        int expResult = 0;
        
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresPlanted());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    } 
    
    @Test
    public void testPlantCropsCase5() {
        System.out.println("PlantCrops - Test Case 5");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(1000);
        cropData.setPopulation(2);
        int acresToPlant = 50;
        int expResult = 0;
        
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresPlanted());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    } 
    
    @Test
    public void testPlantCropsCase6() {
        System.out.println("PlantCrops - Test Case 6");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(1000);
        cropData.setPopulation(100);
        int acresToPlant = 0;
        
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            assertEquals(acresToPlant, cropData.getAcresPlanted());
            assertEquals(500, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }  
    
    @Test
    public void testPlantCropsCase7() {
        System.out.println("PlantCrops - Test Case 7");
        CropData cropData = new CropData();
        cropData.setWheatInStore(1);
        cropData.setAcresOwned(1000);
        cropData.setPopulation(100);
        int acresToPlant = 2;
        
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            assertEquals(acresToPlant, cropData.getAcresPlanted());
            assertEquals(0, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }  
    
    @Test
    public void testPlantCropsCase8() {
        System.out.println("PlantCrops - Test Case 8");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(10);
        cropData.setPopulation(100);
        int acresToPlant = 10;
        
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            assertEquals(acresToPlant, cropData.getAcresPlanted());
            assertEquals(495, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }  
    
    @Test
    public void testPlantCropsCase9() {
        System.out.println("PlantCrops - Test Case 9");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(1000);
        cropData.setPopulation(2);
        int acresToPlant = 20;
        
        try {
            CropControl.plantCrops(acresToPlant, cropData);
            assertEquals(acresToPlant, cropData.getAcresPlanted());
            assertEquals(490, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }  
}
