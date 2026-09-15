package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoRunner.class);

    @Override
    public void run(final String... args) {
        LOGGER.info("Running...");
    }
}
