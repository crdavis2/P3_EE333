/*
 * File: PrintLogger.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  crdavis2-P3 - EE333 Spring 2019
 * Vers: 1.0.0 02/16/2019 CRD - initial coding
 */

import java.util.ArrayList;

/**
 * PrintLogger Class
 * @author Collin Davis crdavis2@uab.edu
 */
public class PrintLogger implements Logger {
    
    // Instance Variables
    private int logThreshold;       // threshold value for the logger
    private ArrayList<String> log;  // standard log ArrayList of Strings
    
    /**
    * Create a PrintLogger with specific threshold
    * @param threshold level that has to be met or exceeded for logging to occur
    */
    public PrintLogger(int threshold) {
        logThreshold = threshold;
        log = new ArrayList<>();
    }
    
    /**
     * Set a new log threshold for actual logging
     * @param newThreshold level that must be met or exceeded for actual logging
     * when the logger is asked to log something
     */
    @Override
    public void setLogThreshold(int newThreshold) {
        if (newThreshold >= 0 && newThreshold < 10) {
            logThreshold = DEBUG;
        } else if (newThreshold >= 10 && newThreshold < 20) {
            logThreshold = INFO;
        } else if (newThreshold >= 20 && newThreshold < 50) {
            logThreshold = TIMESTAMP;
        } else if (newThreshold >= 50 && newThreshold < 100) {
            logThreshold = WARNING;
        } else if (newThreshold >= 100 && newThreshold < 100) {
            logThreshold = ERROR;
        } else if (newThreshold >= 100000) {
            logThreshold = ALWAYS;
        } else {
            // happens if number is less than 0
            System.out.println("Please enter a valid threshold value.");
        }
    }
    
    /**
    * Prints a string to stdout if level is >= threshold.
    * The printing routine will add a newline to the logEntry.
    * The Logger class defines common values for level.
    * @param level value noting the type of the information
    * @param logEntry text to be part of the printed log
    */
    @Override
    public void log(int level, String logEntry) {
        if (level >= logThreshold) {
            log.add(logEntry);
            System.out.println(logEntry);
        }
    }
    
    /**
    * Closing the logging on this class. The use of this log channel is complete and
    * any closing actions that are necessary should be done.
    */
    @Override
    public void close() {
        log.clear();
    }

}
