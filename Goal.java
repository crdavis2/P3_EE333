/*
 * File: Goal.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P3 - EE333 Spring 2019
 * Vers: 1.0.0 01/22/2019 crd - initial coding
 * Vers: 2.0.0 01/29/2019 crd - added superclass capabilities
 * Vers: 3.0.0 02/15/2019 crd - revised coding from P2 comments
 */

/**
 * Generic Goal
 * @author Collin Davis crdavis2@uab.edu
 */
public class Goal extends ProjectComponent {
     
    /**
     * Create a goal with a UID and a title. If the title is null, then "Unnamed
     * goal" shall be used for the title of the goal.
     * 
     * @param title text for goal
     */
    public Goal(String title) {
        super(title);
    }
    
    /**
     * Return the constraint prefix "GO-" to allow construction of project component IDs
     * @return "GO-"
     */
    @Override
    public String getComponentPrefix() {
        return "GO-";
    }
}