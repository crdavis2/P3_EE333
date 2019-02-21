/*
 * File: Milestone.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  crdavis2-P3 - EE333 Spring 2019
 * Vers: 1.0.0 02/17/2019 CRD - initial coding
 * Vers: 1.1.0 02/19/2019 CRD - implementation of Date class
 */

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Milestone Class for Completion Date Creation
 * @author Collin Davis crdavis2@uab.edu
 */
public class Milestone extends ProjectComponent {
    
    // Instance Variables
    private Date    plannedCompletionDate;   // Date class, allows for easy comparison of dates
    private Date    actualCompletionDate;    // Date class, allows for easy comparison of dates
    
    private String  plannedDateString;       // used for retrieving planned completion date
    private String  actualDateString;        // used for retrieving actual completion date
    private String  description;             // description of the milestone
    
    private int     milestoneCount = 0;      // tracks # of Milestones
    private int     milestoneID    = 1;
    
    private boolean completed;               // true if Milestone is completed, false otherwise
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
    // above sets a more user-friendly format for the dates
    
    /**
     * Creates a Milestone with a description, planned completion date and
     * actual completion date.If no actual completion date is given, then 
     * it will simply not be set. Dates must be in yyyy-MM-dd format in 
     * order to work.
     * 
     * @param description general description of the milestone
     * @param plannedCompletionDate expected date of milestone completion
     * @param actualCompletionDate actual date of milestone completion
     * @param completed indicates if the new Milestone has already been completed
     */
    public Milestone(String description, String plannedCompletionDate, 
            String actualCompletionDate, boolean completed) {
        this.description = description;
        this.completed = completed;
        this.plannedDateString = plannedCompletionDate;
        this.actualDateString = actualCompletionDate;
        
        try {
            this.plannedCompletionDate = sdf.parse(plannedCompletionDate);
        } catch (ParseException e) {
            // won't happen if parameters are formatted correctly
        }
        
        
        if (actualCompletionDate == null) {
            // do nothing
        } else {
            // set actualCompletionDate to input
            try {
                this.actualCompletionDate = sdf.parse(actualCompletionDate);
            } catch (ParseException e) {
                // won't happen if parameters are formatted correctly
            }
        }       
    } 
    
    /**
     * Return the constraint prefix "MI-" to allow construction of project component IDs
     * @return "MI-"
     */
    @Override
    public String getComponentPrefix() {
        return "MI-";
    }
    
    /**
     * Get the description of the milestone
     * 
     * @return description description string
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Get the planned completion date of the milestone
     * 
     * @return plannedCompletionDate planned completion date in String form
     */
    public String getPlannedCompletionDate() {
        return plannedDateString;
    }
    
    /**
     * Get the actual completion date of the milestone (if applicable)
     * @return actualCompletionDate actual completion date in String form
     */
    public String getActualCompletionDate() {
        return actualDateString;
    }
    
    /**
     * Set a new planned completion date
     * 
     * @param newPlannedCompletionDate new date for planned completion
     */
    public void setPlannedCompletionDate(String newPlannedCompletionDate) {
        try {
            this.plannedCompletionDate = sdf.parse(newPlannedCompletionDate);
        } catch (ParseException e) {
            System.out.println("Unable to parse " + newPlannedCompletionDate);
        }
    }
    
    /**
     * Update the status of completion for the Milestone
     * 
     * @param completed conditional describing if the milestone has been achieved
     */
    public void setCompletion(boolean completed) {
        if (completed == true) {
            this.completed = true;
        } else {
            // completion has not occurred
            this.completed = false;
        }
    }
    
    /**
     * Gives the status of the milestone relative to its completion status and
     * a comparison of actualCompletionDate vs plannedCompletionDate or 
     * today's date vs plannedCompletionDate
     * 
     * @return returnString string that tells the status of the milestone
     */
    public String milestoneStatus() {
        Date today = new Date();
        String returnString = "";
        
        if (completed == true) {
            if (actualCompletionDate.after(plannedCompletionDate)) {
                returnString = "Milestone was completed late.";
            } else if (actualCompletionDate.before(plannedCompletionDate)) {
                returnString = "Milestone was completed early.";
            } else {
                // actual and planned completion dates are the same
                returnString = "Milestone was completed on time.";
            }
        } else if (completed == false) {
              if (today.before(plannedCompletionDate)) {
                  returnString = "Milestone is still due.";
              } else if (today.after(plannedCompletionDate)) {
                  returnString = "Milestone is past due: planned completion date missed";
              } else {
                  //should not reach here
                  System.out.println("Milestone not completed, ERROR ocurred.");
              }
        } else {
            // should not reach here
            System.out.println("Issue with completion variable.");
        }
        return returnString;
    }
    
    

}
