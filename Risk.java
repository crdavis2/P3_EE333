/*
 * File: Risk.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P1
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
    private int[]      impact;              // measure of severity of Risk
    private int[]      likelihood;          // measure of certainty that a Risk will happen
    private int        priority;            // product of impact and likelihood
    private int        averageImpact;       // average impact from an array of impacts
    private int        averageLikelihood;   // average likelihood form an array of likelihoods
    
    
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
            riskCount++;
        }
    }
    
    /**
    * Get impact of risk if it happens 0-9 with 9 most severe
    * 
    * @param impact array of impacts accepted
    * @return averageImpact  average impact value
    */
    public int getImpact(int[] impact) {
        int sum = 0;
        
        for ( int i : impact ) sum += i;
        averageImpact = sum / impact.length;
        
        return averageImpact;
    }
    
    /**
    * Get likelihood of risk occurring 0-9 with 9 being most likely
    * 
    * @param likelihood array of likelihoods accepted
    * @return averageLikelihood average likelihood value
    */
    public int getLikelihood(int[] likelihood) {
        int sum = 0;
        
        for ( int i : likelihood ) sum += i;
        averageLikelihood = sum / likelihood.length;
        
        return averageLikelihood;
    }
    
    /**
    * Get priority of risk (product of impact and likelihood) where larger is 
    * higher priority
    * 
    * @return int priority value
    */
    public int priority() {
        priority =  averageImpact * averageLikelihood;
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
    public void setImpact(int[] value) {
        int n = value.length;
        
        for (int i = 0; i <= n; i++) {
            if (value[i] <= 0) {
                impact[i] = 0;
            } else if (value[i] >= 9) {
                impact[i] = 9;
            } else {
                impact[i] = value[i];
            }
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
        
        for (int i = 0; i <= n; i++) {
            if (value[i] <= 0) {
                likelihood[i] = 0;
            } else if (value[i] >= 9) {
                likelihood[i] = 9;
            } else {
                likelihood[i] = value[i];
            }
        }
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
                
}