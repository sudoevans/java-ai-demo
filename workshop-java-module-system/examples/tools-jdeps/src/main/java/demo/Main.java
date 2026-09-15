package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        LOGGER.debug("Tools - jdeps");
        LOGGER.debug("Using Java {}", System.getProperty("java.version"));
    }
}
