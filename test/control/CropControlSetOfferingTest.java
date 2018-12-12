/*
 * The CropControlSetOfferingTest class file for the cityOfAaron project
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
public class CropControlSetOfferingTest {
    @Test
    public void testSetOfferingCase1() {
        System.out.println("setOffering - Test Case 1");
        CropData cropData = new CropData();

        try {
            CropControl.setOffering(5, cropData);
            assertEquals(5, cropData.getOfferingPercentage());
        } catch (Exception e) {
            fail("No exception expected but got " + e.getMessage());
        }
    }
    
    @Test
    public void testSetOfferingCase2() {
        System.out.println("setOffering - Test Case 2");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = -5;
        
        cropData.setOffering(oldOffering);
        
        try {
            CropControl.setOffering(newOffering, cropData);
            fail("Exception expected");
        } catch (CropException e) {
            assertEquals(oldOffering, cropData.getOffering());
        } catch (Exception e) {
            fail("No exception expected but got " + e.getMessage());
        }
    }
    
    @Test
    public void testSetOfferingCase3() {
        System.out.println("setOffering - Test Case 3");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = 120;
        
        cropData.setOffering(oldOffering);
        try {
            CropControl.setOffering(newOffering, cropData);
            fail("Exception expected.");
        } catch (CropException e) {
            assertEquals(oldOffering, cropData.getOffering());
        } catch (Exception e) {
            fail("No exception expected but got " + e.getMessage());
        }
    }
    
    @Test
    public void testSetOfferingCase4() {
        System.out.println("setOffering - Test Case 4");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = 0;
        
        cropData.setOffering(oldOffering);
        
        try {
            CropControl.setOffering(newOffering, cropData);
            assertEquals(newOffering, cropData.getOfferingPercentage());
        } catch (Exception e) {
            fail("No exception expected but got " + e.getMessage());
        }
    }
    
    @Test
    public void testSetOfferingCase5() {
        System.out.println("setOffering - Test Case 5");
        CropData cropData = new CropData();
        int oldOffering = 20;
        int newOffering = 100;
        
        cropData.setOffering(oldOffering);
        
        try {
            CropControl.setOffering(newOffering, cropData);
            assertEquals(newOffering, cropData.getOfferingPercentage());
        } catch (Exception e) {
            fail("No exception expected but got " + e.getMessage());
        }
    }
}
