package io.p4r53c.beersheva.telran24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    // For sake of a good practice to NOT use System.out.println().
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Hello world!");

        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
        // testDivideByZero(); There is an unchecked exception in the divide method.
        // Iam catch it and log the error message.
        try {
            int result = Calculator.divide(10, 0);
            logger.error("No exception in divide method, result: {}", result);
        } catch (ArithmeticException e) {
            logger.error("Caught ArithmeticException: divided {}", e.getMessage());
        }
    }
}