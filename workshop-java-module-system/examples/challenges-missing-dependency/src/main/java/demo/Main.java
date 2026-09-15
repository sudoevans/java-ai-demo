package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public final class Main {

    public static void main(final String[] args) {
        if (args.length > 0) {
            System.out.println("Not using a logger");
            System.out.println("Challenges - Missing dependency");
            System.out.println("Using Java " + System.getProperty("java.version"));
            System.out.println("Command line arguments: " + Arrays.toString(args));
        } else {
            /* A logger is used conditionally to demonstrate that missing classes cause a failure only when they are
                accessed for the first time. */
            final Logger logger = LoggerFactory.getLogger(Main.class);
            logger.debug("Using a logger");
            logger.debug("Challenges - Missing dependency");
            logger.debug("Using Java {}", System.getProperty("java.version"));
        }
    }
}
