/*
 * File: ConstraintNGTest.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  P2 - EE333 Spring 2019
 * Vers: 1.0.0 01/29/2019 CRD - initial coding
 * 
 * Credits - Dr. Green "ConstraintNGTest.java" was used as reference.
 */

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Constraint class testing
 * @author Collin Davis crdavis2@uab.edu
 */
public class ConstraintNGTest {
    
    private Constraint c1;
    private Constraint c2;
    private Constraint c3;

    public ConstraintNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        c1 = new Constraint("Constraint 1");
        c2 = new Constraint("Constraint 2");
        c3 = new Constraint(null);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    /**
     * Test of getComponentPrefix method, of class Constraint.
     */
    @Test
    public void testGetComponentPrefix() {
        assertEquals(c1.getComponentPrefix(), "CO-");
    }
    
    /**
     * Test the ability to set ID sequence number and prefix with "CO-"
     */
    @Test
    public void testGetComponentID() {
        c1.setComponentID(10);
        c2.setComponentID(9);
        assertEquals(c1.getComponentID(),"CO-10");
        assertEquals(c2.getComponentID(),"CO-9" );
    }
    
    /**
     * Test of getUID method, of class Constraint.
     */
    @Test
    public void testGetUID() {
        assertTrue(  c1.getUID() > 0);
        assertTrue(  c2.getUID() > 0);
        assertEquals(c2.getUID() - c1.getUID(), 1);
        
    }
    
    /**
     * Test of getTitle method, of class Constraint.
     */
    @Test
    public void testGetTitle() {
        assertEquals(c1.getTitle(), "Constraint 1");
        assertEquals(c2.getTitle(), "Constraint 2");
        assertEquals(c3.getTitle(), "Unnamed constraint");
    }

    /**
     * Test of toString method, of class Constraint.
     */
    @Test
    public void testToString() {
        c1.setComponentID(10);
        String expectedResult = "CO-10: Constraint 1 (" + c1.getUID() + ")";
        assertEquals(c1.toString(), expectedResult);
    }


}