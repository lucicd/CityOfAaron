/*
 * The CropControlSellLandTest class file for the cityOfAaron project
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
 * @author Drazen
 */
public class CropControlSellLandTest {
    
    public CropControlSellLandTest() {
    }
    
    /**
     * Test of sellLand method, a class of CropControl
     */
    
    @Test
    public void testSellLandCase1() {
        System.out.println("sellLand - Test Case 1");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToSell = 10;
        int landPrice = 20;
        int expResult = 2790;
        try {
            CropControl.sellLand(landPrice, acresToSell, cropData);
            assertEquals(expResult, cropData.getAcresOwned());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testSellLandCase2() {
        System.out.println("sellLand - Test Case 2");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToSell = -5;
        int landPrice = 20;
        int expResult = 2800;
        try {
            CropControl.sellLand(landPrice, acresToSell, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresOwned());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testSellLandCase3() {
        System.out.println("sellLand - Test Case 3");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToSell = 5000;
        int landPrice = 20;
        int expResult = 2800;
        try {
            CropControl.sellLand(landPrice, acresToSell, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresOwned());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testSellLandCase4() {
        System.out.println("sellLand - Test Case 4");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2000);
        int acresToSell = 2000;
        int landPrice = 20;
        int expResult = 0;
        try {
            CropControl.sellLand(landPrice, acresToSell, cropData);
            assertEquals(expResult, cropData.getAcresOwned());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testSellLandCase5() {
        System.out.println("sellLand - Test Case 5");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToSell = 0;
        int landPrice = 20;
        int expResult = 2800;
        try {
            CropControl.sellLand(landPrice, acresToSell, cropData);
            assertEquals(expResult, cropData.getAcresOwned());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
