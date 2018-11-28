/*
 * The CropControlBuyLandTest class file for the cityOfAaron project
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
public class CropControlBuyLandTest {
    
    public CropControlBuyLandTest() {
    }
    
    /**
     * Test of buyLand method, a class of CropControl
     */
    
    @Test
    public void testBuyLandCase1() {
        System.out.println("buyLand - Test Case 1");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToBuy = 10;
        int landPrice = 20;
        int expResult = 2810;
        try {
            CropControl.buyLand(landPrice, acresToBuy, cropData);
            assertEquals(expResult, cropData.getAcresOwned());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testBuyLandCase2() {
        System.out.println("buyLand - Test Case 2");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToBuy = -5;
        int landPrice = 20;
        int expResult = 2800;
        try {
            CropControl.buyLand(landPrice, acresToBuy, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresOwned());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testBuyLandCase3() {
        System.out.println("buyLand - Test Case 3");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToBuy = 100;
        int landPrice = 20;
        int expResult = 2800;
        try {
            CropControl.buyLand(landPrice, acresToBuy, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getAcresOwned());            
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testBuyLandCase4() {
        System.out.println("buyLand - Test Case 4");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToBuy = 25;
        int landPrice = 20;
        int expResult = 2825;
        try {
            CropControl.buyLand(landPrice, acresToBuy, cropData);
            assertEquals(expResult, cropData.getAcresOwned());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testBuyLandCase5() {
        System.out.println("buyLand - Test Case 5");
        CropData cropData = new CropData();
        cropData.setWheatInStore(500);
        cropData.setAcresOwned(2800);
        int acresToBuy = 0;
        int landPrice = 20;
        int expResult = 2800;
        try {
            CropControl.buyLand(landPrice, acresToBuy, cropData);
            assertEquals(expResult, cropData.getAcresOwned());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
