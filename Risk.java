/*
 * File: Risk.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P3 - EE333 Spring 2019
 * Vers: 1.0.0 01/22/2019 crd - initial coding
 * Vers: 2.0.0 01/29/2019 crd - added superclass capabilities
 * Vers: 3.0.0 02/15/2019 crd - revised coding from P2 comments
 */

/**
 * Generic Risk
 * @author Collin Davis crdavis2@uab.edu
 */
public class Risk extends ProjectComponent {
    
    // Instance Variables
    private String     mitigation;          // action to reduce Risk
    protected String   riskPrefix  = "RI-";
    private static int riskCount   = 1;     // used to generate UID
    private int[]      impactArray;         // measure of severity of Risk
    private int        impact;              // for get purposes
    private int[]      likelihoodArray;     // measure of certainty that a Risk will happen
    private int        likelihood;          // for get purposes
    private int        priority;            // product of impact and likelihood
    private  Logger    logger;            // creates a logger
    
    /**
    * Create a risk with a UID and a title. If title is null, then "Unnamed 
    * risk" shall be used for the title of the risk. The other properties are   
    * set to legal values like 0, "" such that the Risk object
    * valid values at all time.
    * 
    * @param title text for risk
    */
    public Risk(String title) {
        super(title);
        if (title == null) {
            this.title = "Unnamed risk";
            UID = riskCount;
            riskCount++;
        } else {
            this.title = title;
            UID = riskCount;
            addLogger(logger);
            riskCount++;
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
        priority =  impact * likelihood;
        return priority;
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
        if (value <= 0) {
            impact = 0;
        } else if (value >= 9) {
            impact = 9;
        } else {
            impact = value;
        }
    }
    
    
    /**
    * Set (change) the impact of the risk if it happens. Bounding between 0 
    * and 9 enforced so that, as examples, -1 would be saved as 0 and 220 
    * would be saved as 9.
    * 
    * @param value new impact value array 0-9 with 9 most severe
    */
    public void setImpact(int[] value) {
        int n   = value.length;
        impactArray = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            if (value[i] <= 0) {
                impactArray[i] = 0;
            } else if (value[i] >= 9) {
                impactArray[i] = 9;
            } else {    
                impactArray[i] = value[i];
            }
        }
        
        for ( int i : impactArray ) sum += i;
        impact = sum / impactArray.length;
    }
    
    /**
    * Set (change) the likelihood of the risk happening. Bounding between 0 
    * and 9 enforced so that, as examples, -1 would be saved as 0 and 220 
    * would be saved as 9.
    * 
    * @param value new likelihood value array 0-9 with 9 most severe
    */
    public void setLikelihood(int value) {
        if (value <= 0) {
            likelihood = 0;
        } else if (value >= 9) {
            likelihood = 9;
        } else {
            likelihood = value;
        }
    }
    
    /**
    * Set (change) the likelihood of the risk happening. Bounding between 0 
    * and 9 enforced so that, as examples, -1 would be saved as 0 and 220 
    * would be saved as 9.
    * 
    * @param value new likelihood value array 0-9 with 9 most severe
    */
    public void setLikelihood(int[] value) {
        int n = value.length;
        likelihoodArray = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            if (value[i] <= 0) {
                likelihoodArray[i] = 0;
            } else if (value[i] >= 9) {
                likelihoodArray[i] = 9;
            } else {
                likelihoodArray[i] = value[i];
            }
        }
        
        for ( int i : likelihoodArray ) sum += i;
        likelihood = sum / likelihoodArray.length;
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
    
    @Override
    public String getComponentPrefix() {
        prefix = riskPrefix;
        return prefix;
    }
    
    @Override
    public void setComponentID(int componentIDCount) {
        componentID = riskPrefix + componentIDCount;
    }
    
    /**
     * returns the string "RI-{project assigned ID}: {risk-title} ({UID})"
     * example: <code>RI-1: Sample Risk (4)</code>
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return componentID + ": " + title + " (" + UID + ")";
    }
    
    /**
     * Logs changes to the state of a Project
     * 
     * @param logger default logger type 
     */
    private void addLogger(Logger logger) {
        this.logger = logger;
    }
                
}