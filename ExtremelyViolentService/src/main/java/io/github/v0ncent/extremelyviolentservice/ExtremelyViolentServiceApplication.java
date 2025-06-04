package io.github.v0ncent.extremelyviolentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExtremelyViolentServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExtremelyViolentServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExtremelyViolentServiceApplication.class, args);

        LOGGER.info("LETS GET VIOLENT !");
    }
}
