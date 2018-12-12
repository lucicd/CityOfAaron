/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Gail Lee
 */
public class CropControlEatenByRatsTest {

    /**
     *
     */
    @Test
    public void testCalcEatenByRatsCase1() {
        System.out.println("calcEaten - Test Case 1");
        CropData cropData = new CropData();
        
        cropData.setWheatInStore(500);
     
        CropControl.calcEatenByRats(0, cropData);
        assertEquals(0, cropData.getEatenByRats());
        assertEquals(500, cropData.getWheatInStore());
    }
    @Test
    public void testCalcEatenByRatsCase2() {
        System.out.println("calcEaten - Test Case 2");
        CropData cropData = new CropData();
        
        cropData.setWheatInStore(500);
     
        CropControl.calcEatenByRats(10, cropData);
        assertEquals(50, cropData.getEatenByRats());
        assertEquals(450, cropData.getWheatInStore());
    }
}
    
   
