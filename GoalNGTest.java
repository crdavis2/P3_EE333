/*
 * File: GoalNGTest.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  P2 - EE333 Spring 2019
 * Vers: 1.0.0 01/29/2019 crd - initial coding
 * Vers: 2.0.0 02/16/2019 crd - changes for P3
 */

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Collin Davis crdavis2@uab.edu
 */
public class GoalNGTest {
    
    private Goal g1;
    private Goal g2;

    public GoalNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        g1 = new Goal("Goal 1");
        g2 = new Goal("Goal 2");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    /**
     * Test of getComponentPrefix method, of class Constraint.
     */
    @Test
    public void testGetComponentPrefix() {
        assertEquals(g1.getComponentPrefix(), "GO-");
    }

    /**
     * Test the ability to set ID sequence number and prefix with "CO-"
     */
    @Test
    public void testGetComponentID() {
        g1.setComponentID(10);
        g2.setComponentID(9);
        assertEquals(g1.getComponentID(),"GO-10");
        assertEquals(g2.getComponentID(),"GO-9" );
    }
    
    /**
     * Test of toString method, of class Goal.
     */
    @Test
    public void testToString() {
        g1.setComponentID(10);
        String expectedResult = "GO-10: Goal 1 (" + g1.getUID() + ")";
        assertEquals(g1.toString(), expectedResult);
    }
    
    /**
     * Test UID generation.  Note that we don't know when this test runs, so the exact
     * values are not known.
     */
    @Test
    public void testUID() {
        assertTrue(  g1.getUID() > 0);
        assertTrue(  g2.getUID() > 0);
        assertEquals(g2.getUID() - g1.getUID(), 1);
    }
}