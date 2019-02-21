/*
 * File: Risk.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P3 - EE333 Spring 2019
 * Vers: 1.0.0 01/22/2019 crd - initial coding
 * Vers: 2.0.0 01/29/2019 crd - added superclass capabilities
 * Vers: 3.0.0 02/15/2019 crd - revised coding from P2 comments
 *      with respect to furnished P2 comments and solution from Dr. David Green
 */

/**
 * Generic Risk
 * @author Collin Davis crdavis2@uab.edu
 */
public class Risk extends ProjectComponent {
    
    // Instance Variables
    private String     mitigation = "";     // action to reduce Risk
    private int        impact;              // for get purposes
    private int        likelihood;          // for get purposes
    private Logger     logger;              // creates a logger
    
    /**
    * Create a risk with a UID and a title. If title is null, then "Unnamed 
    * risk" shall be used for the title of the risk. The other properties are   
    * set to legal values like 0, "" such that the Risk object holds
    * valid values at all time.
    * 
    * @param title text for risk
    */
    public Risk(String title) {
        super(title);
        if (title == null) {
            this.title = "Unnamed risk";
        } else {
            this.title = title;
        }
    }
    
    /**
    * Get impact of risk if it happens 0-9 with 9 most severe
    * 
    * @return impact impact value
    */
    public int getImpact() {
        return impact;
    }
    
    /**
    * Get likelihood of risk occurring 0-9 with 9 being most likely
    * 
    * @return likelihood likelihood value
    */
    public int getLikelihood() {
        return likelihood;
    }
    
    /**
    * Get priority of risk (product of impact and likelihood) where larger is 
    * higher priority
    * 
    * @return int priority value
    */
    public int priority() {
        return impact * likelihood;
    }
    
    /**
    * Get mitigation (description of what will be done to mitigate the risk)
    * 
    * @return String text of mitigation description
    */
    public String getMitigation() {
        return mitigation;
    }
    
    /**
    * Set (change) the impact of the risk if it happens. Bounding between 0 
    * and 9 enforced so that, as examples, -1 would be saved as 0 and 220 
    * would be saved as 9.
    * 
    * @param value new impact value array 0-9 with 9 most severe
    */
    public void setImpact(int value) {
        impact = bound(value);
    }
    
    
    /**
    * Set (change) the impact of the risk if it happens. Bounding between 0 
    * and 9 enforced so that, as examples, -1 would be saved as 0 and 220 
    * would be saved as 9.
    * 
    * @param values new impact value array 0-9 with 9 most severe
    */
    public void setImpact(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += bound(values[i]);
        }
        impact = (sum + values.length/2) / values.length;
    }
    
    /**
    * Set (change) the likelihood of the risk happening. Bounding between 0 
    * and 9 enforced so that, as examples, -1 would be saved as 0 and 220 
    * would be saved as 9.
    * 
    * @param value new likelihood value array 0-9 with 9 most severe
    */
    public void setLikelihood(int value) {
        likelihood = bound(value);
    }
    
    /**
    * Set (change) the likelihood of the risk happening. Bounding between 0 
    * and 9 enforced so that, as examples, -1 would be saved as 0 and 220 
    * would be saved as 9.
    * 
    * @param values new likelihood value array 0-9 with 9 most severe
    */
    public void setLikelihood(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += bound(values[i]);
        }
        likelihood = (sum + values.length/2) / values.length;
    }
    
    /**
    * Set (or change) risk mitigation text (description of what will be done 
    * to mitigate the risk)
    * If new text is null, the text will NOT change.
    * 
    * @param text new risk mitigation text
    */
    public void setMitigation(String text) {
        if (text != null) {
            mitigation = text;
        } else {
            // title does not change
        }
    }
    
    /**
     * Return the constraint prefix "RI-" to allow construction of project component IDs
     * @return "RI-"
     */
    @Override
    public String getComponentPrefix() {
        return "RI-";
    }
    
    // bound value between 0 and 9
    private int bound(int value) {
        int newValue;
        
        newValue = Math.max(0, value);
        newValue = Math.min(newValue, 9);
        return newValue;
    }
    
    
    /**
     * Logs changes to the state of a Project
     * If addLogger is called more than once, it will simply print that it has
     * been called to.
     * 
     * @param logger default logger type 
     */
    private void addLogger(Logger logger) {
        if (this.logger == logger) {
            // Logger has already been created
            System.out.println("Logger has already been added.");
        } else{
            // Logger has not been created yet
            this.logger = logger;
        }
    }
                
}