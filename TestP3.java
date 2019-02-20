/*
 * File: TestP2.java
 * Author: Collin R. Davis crdavis2@uab.edu
 * Assignment:  2019-1SpringP1toP3 - EE333 Spring 2019
 * Vers: 1.1.0 01/28/2019 dgg - P2 Changes
 * Vers: 1.0.0 01/14/2019 dgg - initial coding
 * Vers: 2.0.0 02/16/2019 crd - P3 changes
 * 
 * Credits to Dr. Green for initial coding and P2 changes
 */

/**
 * Exercise models in P3
 * @author David G. Green DGreen@uab.edu
 */
public class TestP3 {
    
    /**
     * Starting point for testing P3
     * @param args  unused
     */
    public static void main(String[] args) {
       
        Goal g1       = new Goal("g1");
        Goal g2       = new Goal("g2");
        Goal g3       = new Goal("g3");
        
        Constraint c1 = new Constraint("c1");
        Constraint c2 = new Constraint("c2");
        Constraint c3 = new Constraint("c3");
        
        Risk       r1 = new Risk("r1");
        Risk       r2 = new Risk("r2");
        Risk       r3 = new Risk("r3");
        
        Project    p1 = new Project("p1");
        
        println("g1 then c1 then r1 then p1 without anything more than constructor");
        println(g1);
        println(c1);
        println(r1);
        println(p1);
        
        r1.setImpact(5);
        r1.setLikelihood(3);
        r1.setMitigation("Failure, not highest priority");
        
        printEval( r1.priority() == 15, "r1 priority" );
        println("r1 priority: " + r1.priority());
        
        r2.setImpact(5);
        r2.setLikelihood(10);
        r2.setMitigation("Success if on top");
        
        printEval( r2.priority() == 45, "r2 priority" );
        println("r2 priority: " + r2.priority());
        
        // TBD: Check that prefixing IDs are applied
        
        p1.addConstraint(c1);
        p1.addGoal(g1);
        p1.addRisk(r1);
        
        println(p1);
        
        p1.addRisk(r2);        
        println(p1);
        println(p1.getNextRisk());
        println(p1.getNextRisk());
        if (p1.getNextRisk() != null) {
            println("getNextRisk failure");
        }
        
        p1.reset();
        println(p1.getNextRisk().getMitigation());
        
        Project p2 = new Project("p2");
        Risk r;
        
        for (int i = 0; i < 11; i++) {
            p2.addConstraint(new Constraint("cc" + i));
            p2.addGoal(      new Goal(      "gg" + i));
            
            r =              new Risk(      "rr" + 1 );
            
            r.setImpact(       i);
            r.setLikelihood(10-i);
            r.setMitigation("Mitigation " + i);
            p2.addRisk(r);
            
            println(p2);
        }
        
        printProject(p1);
        printProject(p2);
    }
    
    // Convenience functions
    private static void println(Object o) {
        System.out.println(o.toString());
    }
    
    private static void printEval( boolean success, String s) {
        String prefix = "Failed: ";
        if (success) {
            prefix = "Success: ";
        }
        System.out.println(prefix + s);
    }

    // print project
    //   print ---- separator
    //   print project title and number of components
    //   Print each constraint
    //   print each goal
    //   print each risk with its priority, impact, likelihood and mitigation
    //   print ---- separator
    private static void printProject(Project p) {
        println("--------------------------------");
        println(p);
        printComponents(p, "Constraints");
        printComponents(p, "Goals");
        printComponents(p, "Risks");
        println("--------------------------------");            
    }

    // print an array of ProjectComponents
    private static void printComponents(Project p, String type) {
        ProjectComponent pc;
        println("**" + type + "**");
        while ((pc = nextProjectComponent(p, type)) != null) {
            println(pc);
            
            if (type.equals("Risks")) {
                Risk r = (Risk) pc;
                println( "Priority: "    + r.priority()        +
                         " Impact: "     + r.getImpact()       +
                         " Likelihood: " + r.getLikelihood()   +
                         " Mitigation: " + r.getMitigation() ) ;
            }
        }
    }

    // return next ProjectComponent
    private static ProjectComponent nextProjectComponent(Project p, String type) {
        switch (type) {
            case "Constraints":
                return p.getNextConstraint();
            case "Goals":
                return p.getNextGoal();
            case "Risks":
                return p.getNextRisk();
            default:
                return null;
        }
    }
}

