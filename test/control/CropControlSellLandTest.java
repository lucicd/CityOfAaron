/*
 * The CropControlSellLandTest class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 * This is an alternative implementation.
 * It includes a TestParams nested classe
 * and a parametrized test method testCases(),
 * which is called by specific test nethods
 * testSellLandCase1, testSellLandCase2, etc.
 */
package control;

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
    
    private static class TestParams {
        static int caseId = 0;
        int acresOwned = 2800;
        int wheatInStore = 0;
        int landCost = 20;
        int toSell;
        int expWheatInStore;
        int expAcresOwned;
        int expResult;

        public TestParams() {
            TestParams.caseId++;
        }
    }
    
    /**
     * Test of sellLand method, a class of CropControl
     */
    
    private void testCase(TestParams testParams) {
        System.out.format("sellLand - Test Case %d\n", testParams.caseId);
        CropData cropData = new CropData();
        cropData.setAcresOwned(testParams.acresOwned);
        cropData.setWheatInStore(testParams.wheatInStore);
        
        int result = CropControl.sellLand(
                testParams.landCost, testParams.toSell, cropData);
        assertEquals(testParams.expResult, result);
        
        int newWheatInStore = cropData.getWheatInStore();
        assertEquals(newWheatInStore, testParams.expWheatInStore);
        
        int newAcresOwned = cropData.getAcresOwned();
        assertEquals(newAcresOwned, testParams.expAcresOwned);
    }
    
    @Test
    public void testSellLandCase1() {
        TestParams p = new TestParams();
        p.toSell = 10;
        p.expAcresOwned = 2790;
        p.expResult = 2790;
        p.expWheatInStore = 200;
        testCase(p); 
    }
    
    @Test
    public void testSellLandCase2() {
        TestParams p = new TestParams();
        p.toSell = -5;
        p.expAcresOwned = 2800;
        p.expResult = -1;
        p.expWheatInStore = 0;
        testCase(p); 
    }
    
    @Test
    public void testSellLandCase3() {
        TestParams p = new TestParams();
        p.toSell = 3000;
        p.expAcresOwned = 2800;
        p.expResult = -1;
        p.expWheatInStore = 0;
        testCase(p); 
    }
    
    @Test
    public void testSellLandCase4() {
        TestParams p = new TestParams();
        p.toSell = 2800;
        p.expAcresOwned = 0;
        p.expResult = 0;
        p.expWheatInStore = 56000;
        testCase(p); 
    }
    
    @Test
    public void testSellLandCase5() {
        TestParams p = new TestParams();
        p.toSell = 0;
        p.expAcresOwned = 2800;
        p.expResult = 2800;
        p.expWheatInStore = 0;
        testCase(p); 
    }
}