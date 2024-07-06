package io.p4r53c.beersheva.telran24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Global exception handler for unchecked exceptions.
 * 
 * @author p4r53c
 * @since 2.0
 * 
 */
public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

        /**
         * Handles an uncaught exceptions (e.g. ArithmeticException) in a thread. 
         * If the exception logs an error message with the thread name and exception message.
         *
         * @param  t   the thread in which the exception occurred
         * @param  e   the exception that occurred
         */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof ArithmeticException) {
            logger.error("ArithmeticException caught in thread {}: {}", t.getName(), e.getMessage());
        } else {
            logger.error("Unhandled exception in thread {}: {}", t.getName(), e.getMessage());
        }
    }
}
