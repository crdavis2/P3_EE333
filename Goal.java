/*
 * File: Goal.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P1
 * Vers: 1.0.0 01/22/2019 crd - initial coding
 * Vers: 2.0.0 01/29/2019 crd - added superclass capabilities
 * Vers: 3.0.0 02/15/2019 crd - revised coding from P2 comments
 */

/**
 * Generic Goal
 * @author Collin Davis crdavis2@uab.edu
 */
public class Goal extends ProjectComponent {
    
    // Instance Variables
    private static int    goalCount  = 1;     // used to generate UID
    private final  String goalPrefix = "GO-"; // string prefix for goals
    
      
    /**
     * Create a goal with a UID and a title. If the title is null, then "Unnamed
     * goal" shall be used for the title of the goal.
     * 
     * @param title text for goal
     */
    public Goal(String title) {
        super(title);
        if (title == null) {
            this.title = "Unnamed goal";
            UID = goalCount;
            goalCount++;
        } else {
            this.title = title;
            UID = goalCount;
            goalCount++;
        }
    }
    
    @Override
    public String getComponentPrefix() {
        prefix = goalPrefix;
        return prefix;
    }
    
    @Override
    public void setComponentID(int componentIDCount) {
        componentID = goalPrefix + componentIDCount;
    }
    
    /**
     * returns the string "GO-{project assigned ID}: {goal-title} ({UID})"
     * example: <code>GO-1: Sample Goal (4)</code>
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return componentID + ": " + title + " (" + UID + ")";
    }

}