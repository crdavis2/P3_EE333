/*
 * File: ProjectComponent.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  P3 - EE333 Spring 2019
 * Vers: 1.0.0 01/31/2019 crd - initial coding
 * Vers: 2.0.0 02/15/2019 crd - revised coding for P3 from P2 comments
 *      with respect to furnished P2 comments and solution from Dr. David Green
 */


/**
 *
 * @author Collin Davis crdavis2@uab.edu
 */
public abstract class ProjectComponent {

    protected String title; // title of the component
    protected String componentID;
    protected int    componentCount   = 0;
    protected int    UID;                   // unique ID for the component
   
    
    public ProjectComponent(String title) {
        if (title == null) {
            this.title = "Unnamed component";
        } else {
            this.title = title;
        }
        UID = componentCount++;
        componentID = "";
    }

    /**
     * Get the UID for the sensor CO-{number}, CO-{number}, CO-{number}
     *
     * @return component UID
     */
    public int getUID() {
        return UID;
    }

    /**
     * Get the title of the component
     *
     * @return title text of the title for component
     */
    public String getTitle() {
        return title;
    }
    

    /**
     * returns the string "{componenttype}-{project assigned ID}: {component-title} ({UID})"
     * example: <code>RI-1: Sample Risk (4)</code>
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return componentID + ": " + title + "(" + UID + ")";
    }

    /**
     * Set (change) the title of a component. If the new title is null,
     * the title will NOT change.
     *
     * @param title text for title
     */
    public void setTitle(String title) {
        if (this.title != null) {
            title = this.title;
        } else {
            // title does not change
        }
    }
    
    public String getComponentID() {
        return componentID;
    }
    
    public abstract String getComponentPrefix();

    
    public void setComponentID(int ID) {
        componentID = getComponentPrefix() + ID;
    }
}