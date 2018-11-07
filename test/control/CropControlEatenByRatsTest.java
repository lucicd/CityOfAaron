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
        
        int wheatInStore = 500;
        int eatenByRats = 500;
        int expResult = 2500;
        
        cropData.setWheatInStore(wheatInStore);
        cropData.setEatenByRats(0);
     
        int result = CropControl.calcEatenByRats(eatenByRats, cropData);
        assertEquals(expResult, result);
    }
    @Test
    public void testCalcEatenByRatsCase2() {
        System.out.println("calcEaten - Test Case 2");
        CropData cropData = new CropData();
        
        int wheatInStore = 500;
        int eatenByRats = 500;
        int expResult = 2500;
        
        cropData.setWheatInStore(wheatInStore);
        cropData.setEatenByRats(0);
     
        int result = CropControl.calcEatenByRats(eatenByRats, cropData);
        assertEquals(expResult, result);
    }
        }
    
   
