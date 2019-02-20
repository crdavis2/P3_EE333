/*
 * File: Logger.java
 * Author: Collin Davis crdavis2@uab.edu
 * Assignment:  crdavis2-P3 - EE333 Spring 2019
 * Vers: 1.0.0 02/16/2019 CRD - initial coding
 *
 */

/**
 * Logger Interface
 * @author Collin Davis crdavis2@uab.edu
 */
public interface Logger {
    
    // Constants
    static final int DEBUG      = 0; 
    static final int INFO       = 10; 
    static final int TIMESTAMP  = 20; 
    static final int WARNING    = 50;
    static final int ERROR      = 100;
    static final int ALWAYS     = 100000; // used when logging to ensure logging occurs
    
    /**
     * Set a new log threshold for actual logging
     * @param newThreshold level that must be met or exceeded for actual logging
     * when the logger is asked to log something
     */
    public void setLogThreshold(int newThreshold);

    /**
     * Log a message if `level` is greater than or equal to logger's threshold.
     * The actual logging routine will add a newline to the logEntry if appropriate.
     * @param level message's level
     * @param logEntry text to log (a newline will be added if appropriate)
     */
    public void log(int level, String logEntry);
    
    /**
    * Closing the logging on this class. The use of this log channel is complete and
    * any closing actions that are necessary should be done.
    */
    public void close();

}
