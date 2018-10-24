/*
 * The CropControlSetOfferingTest class file for the cityOfAaron project
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
public class CropControlSetOfferingTest {
    @Test
    public void testSetOfferingCase1() {
        System.out.println("setOffering - Test Case 1");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = 10;
        int expResult = newOffering;
        
        cropData.setOffering(oldOffering);
        
        int result = CropControl.setOffering(newOffering, cropData);
        assertEquals(expResult, result);
        assertEquals(newOffering, cropData.getOffering());
    }
    
    @Test
    public void testSetOfferingCase2() {
        System.out.println("setOffering - Test Case 2");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = -5;
        int expResult = -1;
        
        cropData.setOffering(oldOffering);
        
        int result = CropControl.setOffering(newOffering, cropData);
        assertEquals(expResult, result);
        assertEquals(oldOffering, cropData.getOffering());
    }
    
    @Test
    public void testSetOfferingCase3() {
        System.out.println("setOffering - Test Case 3");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = 120;
        int expResult = -1;
        
        cropData.setOffering(oldOffering);
        
        int result = CropControl.setOffering(newOffering, cropData);
        assertEquals(expResult, result);
        assertEquals(oldOffering, cropData.getOffering());
    }
    
    @Test
    public void testSetOfferingCase4() {
        System.out.println("setOffering - Test Case 4");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = 0;
        int expResult = 0;
        
        cropData.setOffering(oldOffering);
        
        int result = CropControl.setOffering(newOffering, cropData);
        assertEquals(expResult, result);
        assertEquals(newOffering, cropData.getOffering());
    }
    
    @Test
    public void testSetOfferingCase5() {
        System.out.println("setOffering - Test Case 5");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = 100;
        int expResult = 100;
        
        cropData.setOffering(oldOffering);
        
        int result = CropControl.setOffering(newOffering, cropData);
        assertEquals(expResult, result);
        assertEquals(newOffering, cropData.getOffering());
    }
}
