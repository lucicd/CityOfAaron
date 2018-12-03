/*
 * The CropControlFeedPeopleTest class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Gail Lee, Carolyn Murray, Drazen Lucic
 */
package control;

import exceptions.CropException;
import model.CropData;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author tweet
 */
public class CropControlFeedPeopleTest {
    @Test
    public void testFeedPeopleCase1() {
        System.out.println("feedPeople - Test Case 1");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = 500;
        int wheatToFeed = 500;
        try {
            CropControl.feedPeople(wheatToFeed, cropData);
            assertEquals(expResult, cropData.getWheatForPeople());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }
    
    @Test
    public void testFeedPeopleCase2() {
        System.out.println("feedPeople - Test Case 2");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = 2000;
        int wheatToFeed = -5;
        try {
            CropControl.feedPeople(wheatToFeed, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }
    
    @Test
    public void testFeedPeopleCase3() {
        System.out.println("feedPeople - Test Case 3");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = 2000;
        int wheatToFeed = 3000;
        try {
            CropControl.feedPeople(wheatToFeed, cropData);
            fail("Exception was expected");
        } catch (CropException e) {
            assertEquals(expResult, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }
    
    @Test
    public void testFeedPeopleCase4() {
        System.out.println("feedPeople - Test Case 4");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = 2000;
        int wheatToFeed = 0;
        try {
            CropControl.feedPeople(wheatToFeed, cropData);
            assertEquals(expResult, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }
    
    @Test
    public void testFeedPeopleCase5() {
        System.out.println("feedPeople - Test Case 5");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = 2000;
        int wheatToFeed = 2000;
        try {
            CropControl.feedPeople(wheatToFeed, cropData);
            assertEquals(expResult, cropData.getWheatForPeople());
            assertEquals(0, cropData.getWheatInStore());
        } catch (Exception e) {
            fail("Unexpected exception " + e.getMessage());
        }
    }
}
