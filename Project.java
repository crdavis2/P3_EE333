/*
 * File: Project.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment: P3 - EE333 Spring 2019
 * Vers: 1.0.0 01/22/2019 crd - initial coding
 * Vers: 1.0.1 01/23/2019 crd - added working sort algorithm for risk;
 * Vers: 2.0.0 01/31/2019 crd - revised coding for P2 
 * Vers: 3.0.0 02/15/2019 crd - revised coding from P2 comments for P3
 */

/**
 * Generic Project
 * @author Collin Davis crdavis2@uab.edu
 */
public class Project {

    
    
    // Instance Variables //
    
    // Constants
    private static final int MAX_CONSTRAINTS   = 10; // Max constraints accepted
    private static final int MAX_GOALS         = 10; // Max goals accepted
    private static final int MAX_RISKS         = 10; // Max risks accepted
    
    // String and Class Variables
    private  String               title;             // title of Project
    private  Constraint[]         constraints;       // creates constraints of type Constraint
    private  Goal[]               goals;             // creates goals of type Goals
    private  Risk[]               risks;             // creates risks of type Risks
    private  Logger               logger;            // creates a logger
    
    // Index Variables
    private int           ConstraintCounter     = 0; // tracks constraints for getNextConstraint
    private int           GoalCounter           = 0; // tracks goals for getNextGoal
    private int           RiskCounter           = 0; // tracks risks for getNextRisk
    private int           numConstraints        = 0; // tracks constraints for addConstraint
    private int           numGoals              = 0; // tracks goals for addGoal
    private int           numRisks              = 0; // tracks risks for addRisk
    public  static int    projectCount          = 1; // used to generate project assigned ID

    /**
     * Constructor for objects of class Project with title

     * @param title text for title. If null, the project title will
     * be set to "Unnamed project"
     */
    public Project(String title) {
        if (title == null) {
            this.title = "Unnamed project";
        } else {
            this.title = title;
        }
        constraints = new Constraint[MAX_CONSTRAINTS];
        goals = new Goal[MAX_GOALS];
        risks = new Risk[MAX_RISKS];
        addLogger(logger);
        projectCount++;
    }

    /**
     * Get the title of the project
     *
     * @return the text of the project title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Represent a text description of the project like: {title} with {#constraints}
     * constraints, {#goals}, and {#risks} risks.
     * 
     * @return string as described
     */
    @Override
    public String toString() {
        return title + " with " + numConstraints + " constraints, " + numGoals +
                " goals, and " + numRisks + " risks.";
    }

    /**
     * Get the next goal if it exists. The first time called, it will return the
     * first goal. The method <code>reset()</code> will reset the object such that
     * it will return the first goal on the next invocation of
     * <code>getNextGoal()</code> after the <code>reset()</code>.
     * The order of the goals will be the ordered they were added to the object.
     * 
     * @return goal object if one exists or null otherwise
     */
    public Goal getNextGoal() {
        if (GoalCounter < MAX_GOALS) {
            GoalCounter++;
            return goals[GoalCounter];
        } else {
            return null;
        }
    }

    /**
    * Get the next constraint if it exists. The first time called, it will return
    * the first constraint. The method <code>reset()</code> will reset the object
    * such that it will return the first constraint on the next invocation of
    * <code>getNextConstraint()</code> after the <code>reset()</code>.
    * 
    * @return constraint object if one exists or null otherwise
    */
    public Constraint getNextConstraint() {
        if (ConstraintCounter < MAX_CONSTRAINTS) {
            ConstraintCounter++;
            return constraints[ConstraintCounter];
        } else {
            return null;
        }
    }

    /**
     * Get the next risk if it exists in priority order. The first time called, it
     * will return the highest priority risk. The method <code>reset()</code> will
     * reset the object such that it will return the first risk on the next
     * invocation of <code>getNextRisk()</code> after the <code>reset()</code>.
     * 
     * @return risk object if one exists or null otherwise
     */
    public Risk getNextRisk() {
        if (RiskCounter == 0) {
            sort(risks, 0, numRisks - 1);
        }
        if (RiskCounter <= MAX_RISKS) {
            RiskCounter++;
            return risks[RiskCounter - 1];
        } else {
            return null;
        }
    }

    /**
     * Add constraint to the project
     *
     * @param constraint the constraint to add to the project
     */
    public void addConstraint(Constraint constraint) {
        if (numConstraints < MAX_CONSTRAINTS) {
            constraints[numConstraints] = constraint;
            numConstraints++;
        } else {
            // some error handling goes here
        }
    }

    /**
     * Add goal to the project
     *
     * @param goal the goal to add to the project
     */
    public void addGoal(Goal goal) {
        if (numGoals < MAX_GOALS) {
            goals[numGoals] = goal;
            numGoals++;
        } else {
            // some error handling goes here
        }
    }

    /**
     * Add risk to the project
     *
     * @param risk the risk to add to the project
     */
    public void addRisk(Risk risk) {
        if (numRisks < MAX_RISKS) {
            risks[numRisks] = risk;
            numRisks++;
        } else {
            // some error handling goes here
        }
    }

    /**
     * Reset the getNextGoal, getNextConstraint, getNextRisk behaviors to start
     * again at the "first" item to allow sequencing through the list again
     */
    public void reset() {
        GoalCounter       = 0;
        RiskCounter       = 0;
        ConstraintCounter = 0;
    }

    // Functions to sort risks from max to min for getNextRisk
    // Yes, it was tedious/time-consuming to implement merge-sort sorting algorithm
    /**
     * Apply merge-sort procedure to array of risks once each side of the
     * array has been sorted from max to min
     * 
     * @param arr array of type Risk to be sorted/merged
     * @param l left-hand starting point of array (beginning of array)
     * @param m middle of the array
     * @param r right hand starting point of array (end of array)
     */
     private void merge(Risk[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        Risk[] L = new Risk[n1];
        Risk[] R = new Risk[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].priority() > R[j].priority()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

     /**
      * Takes array of risks, splits into a left and right side,
      * sorts left side from max to min, sorts right side from max to min,
      * calls merge function to reform the array
      * 
      * @param arr array of type Risk to be sorted/merged
      * @param l left-hand starting point of array (beginning of array)
      * @param r right hand starting point of array (end of array)
      */
    private void sort(Risk[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
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