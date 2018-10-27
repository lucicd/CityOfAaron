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
        int result = CropControl.feedPeople(wheatToFeed, cropData);
        assertEquals(expResult, result);
    }
   @Test
    public void testFeedPeopleCase2() {
        System.out.println("feedPeople - Test Case 2");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = -1;
        int wheatToFeed = -5;
        int result = CropControl.feedPeople(wheatToFeed, cropData);
        assertEquals(expResult, result);
    }
 @Test
    public void testFeedPeopleCase3() {
        System.out.println("feedPeople - Test Case 3");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = -1;
        int wheatToFeed = 3000;
        int result = CropControl.feedPeople(wheatToFeed, cropData);
        assertEquals(expResult, result);
    }
 @Test
    public void testFeedPeopleCase4() {
        System.out.println("feedPeople - Test Case 4");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = 0;
        int wheatToFeed = 0;
        int result = CropControl.feedPeople(wheatToFeed, cropData);
        assertEquals(expResult, result);
    }
 @Test
    public void testFeedPeopleCase5() {
        System.out.println("feedPeople - Test Case 5");
        CropData cropData = new CropData();
        cropData.setWheatInStore(2000);
        int expResult = 2000;
        int wheatToFeed = 2000;
        int result = CropControl.feedPeople(wheatToFeed, cropData);
        assertEquals(expResult, result);
    }
 
}
