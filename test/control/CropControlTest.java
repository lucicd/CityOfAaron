/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Drazen
 */
public class CropControlTest {
    
    public CropControlTest() {
    }
    
    /**
     * Test of buyLand method, a class of CropControl
     */
    
    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        CropData cropData = null;
        int acresToBuy = 0;
        int landPrice = 0;
        int expResult = 0;
        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
    }
}
