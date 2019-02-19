/*
 * File: ProjectComponent.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  P2 - EE333 Spring 2019
 * Vers: 1.0.0 01/31/2019 crd - initial coding
 * Vers: 2.0.0 02/15/2019 crd - revised coding from P2 comments
 */


/**
 * Superclass for ProjectComponent
 * @author Collin Davis crdavis2@uab.edu
 */
public class ProjectComponent {

    protected String title; // title of the component
    protected String prefix           = "";
    protected String componentID      = "";
    protected int    componentIDCount = 1;
    protected int    UID;                   // unique ID for the component
   
    
    public ProjectComponent(String title) {
        this.title = title;
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
     * returns the string "{prefix}-{project assigned ID}: {component-title} ({UID})"
     * example: <code>RI-1: Sample Risk (4)</code>
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return prefix + componentIDCount + ": " + title + "(" + UID + ")";
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
    
    
    public String getComponentPrefix() {
        return prefix;
    }
    
    public String getComponentID() {
        return componentID;
    }

    
    public void setComponentID(int componentIDCount) {
        componentID = prefix + componentIDCount;
    }
}
