/*
 * File: Project.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P3 - EE333 Spring 2019
 * Vers: 1.0.0 01/22/2019 crd - initial coding
 * Vers: 1.0.1 01/23/2019 crd - added working sort algorithm for risk;
 * Vers: 2.0.0 01/31/2019 crd - revised coding for P2 
 * Vers: 3.0.0 02/15/2019 crd - revised coding from P2 comments for P3
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * Generic Project
 * @author Collin Davis crdavis2@uab.edu
 */
public class Project {

    // Instance Variables //
    
    // Constants
    private static final int SIZE = 10;
    
    // String and Class Variables
    private  String       title;                              // title of Project
    private  Constraint[] constraints  = new Constraint[SIZE];    
    private  Goal[]       goals        = new Goal[SIZE];             
    private  Risk[]       risks        = new Risk[SIZE];
    private  Milestone[]  milestones   = new Milestone[SIZE];
    private  Logger       logger;                             // creates a logger
    
    // Index Variables
    ArrayList<String> milestoneDateString = new ArrayList<>();
    private int numberGoals               = 0;
    private int numberConstraints         = 0;
    private int numberRisks               = 0;
    private int numberMilestones          = 0;
    
    private int nextGoalIndex             = 0;
    private int nextConstraintIndex       = 0;
    private int nextRiskIndex             = 0;
    
    /**
     * Models an effort to do something (build a product, write a paper,
     * marketing campaign, etc.)
     *
     * @param title text titling the project. If null, the project name will be
     * set to "Unnamed project"
     */
    public Project(String title) {
        if (title == null) {
            this.title = "Unnamed project";
        } else {
            this.title = title;
        }
    }

    // Queries
    /**
     * Get the title of the project
     *
     * @return the title of the project name
     */
    public String getTitle() {
        return title;
    }

    /**
     * Represent a text description of the project like
     *   {title} with {#constraints} constraints, {#goals} goals, and {#risks} risks.
     * @return  string as described
     */
    @Override
    public String toString() {
        return title + " with " + numberConstraints + " constraints, " +
                                  numberGoals       + " goals, "       + "and " +
                                  numberRisks       + " risks.";
    }

    // Commands
    /**
     * Add goal to the project
     *
     * @param goal the goal to add to the project
     */
    public void addGoal(Goal goal) {
        if (numberGoals < SIZE) {
            goals[numberGoals++] = goal;
        }
        updateNumbering(goals, numberGoals);
    }

    /**
     * Add constraint to the project
     *
     * @param constraint the constraint to add to project
     */
    public void addConstraint(Constraint constraint) {
        if (numberConstraints < SIZE) {
            constraints[numberConstraints++] = constraint;
        }
        updateNumbering(constraints, numberConstraints);
    }

    /**
     * Add risk to the project
     *
     * @param risk the risk to add to the project
     */
    public void addRisk(Risk risk) {
        if (numberRisks < SIZE) {
            risks[numberRisks++] = risk;
        }
        
        // let Arrays sort risks array in descending using 
        // r.priority() as the sort index
        
        if ( numberRisks > 1) {
            Arrays.sort(risks, 0, numberRisks, 
                        Comparator.comparingInt( r -> -r.priority() ) );
            
        }
        updateNumbering(risks, numberRisks);
    }
    
    // set component numbering to be sequential in array starting at 1 (index+1)
    private void updateNumbering(ProjectComponent[] components, int numberComponents) {
        for (int i = 0; i < numberComponents; i++) {
            components[i].setComponentID(i+1);
        }
    }

    /**
     * Reset the getNextGoal, getNextConstraint, getNextRisk behaviors to start
     * again at the "first" item again to allow sequencing through the list
     * again.
     */
    public void reset() {
        nextGoalIndex           = 0;
        nextConstraintIndex     = 0;
        nextRiskIndex           = 0;
    }

    // Other behavior
    /**
     * Get the next goal if it exists. The first time called, it will return the
     * first goal. The method <code>reset()</code> will reset the object such
     * that it will return the first goal on the next invocation of
     * <code>getNextGoal()</code> after the <code>reset()</code>.
     *
     * The order of the goals will be the ordered they were added to the object.
     *
     * @return goal object if one exists or null otherwise
     */
    public Goal getNextGoal() {
        if (nextGoalIndex < numberGoals) {
            return goals[nextGoalIndex++];
        } else {
           return null;
        }
    }

    /**
     * Get the next constraint if it exists. The first time called, it will
     * return the first constraint. The method <code>reset()</code> will reset
     * the object such that it will return the first constraint on the next
     * invocation of <code>getNextConstraint()</code> after the
     * <code>reset()</code>.
     *
     * @return constraint object if one exists or null otherwise
     */
    public Constraint getNextConstraint() {
        if (nextConstraintIndex < numberConstraints) {
            return constraints[nextConstraintIndex++];
        } else {
            return null;
        }
    }

    /**
     * Get the next risk if it exists in priority order. The first time called,
     * it will return the highest priority risk. The method <code>reset()</code>
     * will reset the object such that it will return the first risk on the next
     * invocation of <code>getNextRisk()</code> after the <code>reset()</code>.
     *
     * @return risk object if one exists or null otherwise
     */
    public Risk getNextRisk() {
        if (nextRiskIndex < numberRisks) {
            return risks[nextRiskIndex++];
        } else {
            return null;
        }
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