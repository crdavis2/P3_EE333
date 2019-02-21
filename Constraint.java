/*
 * File: Constraint.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P3 - EE333 Spring 2019
 * Vers: 1.0.0 01/22/2019 crd - initial coding
 * Vers: 2.0.0 01/29/2019 crd - added superclass capabilities
 * Vers: 3.0.0 02/15/2019 crd - revised coding from P2 comments
 */

/**
 * Generic Constraint
 * @author Collin Davis crdavis2@uab.edu
 */
public class Constraint extends ProjectComponent {
    
    /**
    * Create a constraint with a UID and a name. If name is null,
    * then "Unnamed constraint" shall be used for the
    * name of the constraint.
    * 
    * @param title title of the constraint
    */
    public Constraint(String title) {
        super(title);
        if (title == null) {
            this.title = "Unnamed constraint";
        } else {
            this.title = title;
        }
    }
    
    /**
     * Return the constraint prefix "CO-" to allow construction of project component IDs
     * @return "CO-"
     */
    @Override
    public String getComponentPrefix() {
        return "CO-";
    }
    
}