/*
 * File: MilestoneNGTest.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  crdavis2-P3 - EE333 Spring 2019
 * Vers: 1.0.0 02/20/2019 CRD - initial coding
 */

import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit Testing for the Milestone class
 * @author Collin Davis crdavis2@uab.edu
 */
public class MilestoneNGTest {

    private Milestone m1;
    private Milestone m2;
    private Milestone m3;

    public MilestoneNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        m1 = new Milestone("Example milestone 1", "2019-02-28", "", false);
        m2 = new Milestone("Finish this project", "2019-02-21", "2019-02-21", true);
        m3 = new Milestone("Project completed early", "2019-02-26", "2019-02-20", true);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getDescription method, of class Milestone.
     */
    @Test
    public void testGetDescription() {
        assertEquals(m1.getDescription(), "Example milestone 1");
        assertEquals(m2.getDescription(), "Finish this project");
    }

    /**
     * Test of getPlannedCompletionDate method, of class Milestone.
     */
    @Test
    public void testGetPlannedCompletionDate() {
        assertEquals(m1.getPlannedCompletionDate(), "2019-02-28");
        assertEquals(m2.getPlannedCompletionDate(), "2019-02-21");
        assertEquals(m3.getPlannedCompletionDate(), "2019-02-26");
    }

    /**
     * Test of getActualCompletionDate method, of class Milestone.
     */
    @Test
    public void testGetActualCompletionDate() {
        assertEquals(m1.getActualCompletionDate(), "");
        assertEquals(m2.getActualCompletionDate(), "2019-02-21");
        assertEquals(m3.getActualCompletionDate(), "2019-02-20");
    }

    /**
     * Test of milestoneStatus method, of class Milestone.
     */
    @Test
    public void testMilestoneStatus() {
        assertEquals(m1.milestoneStatus(), "Milestone is still due.");
        assertEquals(m2.milestoneStatus(), "Milestone was completed on time.");
        assertEquals(m3.milestoneStatus(), "Milestone was completed early.");
    }

}