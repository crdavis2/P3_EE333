/*
 * File: RiskNGTest.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  P2 - EE333 Spring 2019
 * Vers: 1.0.0 01/29/2019 CRD - initial coding
 */


import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Collin Davis crdavis2@uab.edu
 */
public class RiskNGTest {
    
    private Risk r1;
    private Risk r2;

    public RiskNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        r1 = new Risk("Risk 1");
        r2 = new Risk("Risk 2");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getComponentPrefix method, of class Risk.
     */
    @Test
    public void testGetComponentPrefix() {
        assertEquals(r1.getComponentPrefix(), "RI-");
    }
    
    /**
     * Test the ability to set ID sequence number and prefix with "RI-"
     */
    @Test
    public void testGetComponentID() {
        r1.setComponentID(10);
        r2.setComponentID(9);
        assertEquals(r1.getComponentID(),"RI-10");
        assertEquals(r2.getComponentID(),"RI-9" );
    }
    
    /**
     * Test of getUID method, of class Risk.
     */
    @Test
    public void testGetUID() {
        assertTrue(  r1.getUID() > 0);
        assertTrue(  r2.getUID() > 0);
        assertEquals(r2.getUID() - r1.getUID(), 1);
    }

    /**
     * Test of toString method, of class Risk.
     */
    @Test
    public void testToString() {
        r1.setComponentID(10);
        String expectedResult = "RI-10: Risk 1 (" + r1.getUID() + ")";
        assertEquals(r1.toString(), expectedResult);
    }

    /**
     * Test of getImpact method, of class Risk.
     */
    @Test
    public void testGetImpact() {
        int[] i1 = {2, 4, 6};
        int i3 = 5;
        r1.setImpact(i1);
        assertEquals(r1.getImpact(), 4);
        r1.setImpact(i3);
        assertEquals(r1.getImpact(), 5);
        
    }

    /**
     * Test of getLikelihood method, of class Risk.
     */
    @Test
    public void testGetLikelihood() {
        int[] L1 = {2, 4, 6};
        int L3 = 5;
        r1.setLikelihood(L1);
        assertEquals(r1.getLikelihood(), 4);
        r1.setLikelihood(L3);
        assertEquals(r1.getLikelihood(), 5);
    }

    /**
     * Test of priority method, of class Risk.
     */
    @Test
    public void testPriority() {
        // figure this out
    }

}