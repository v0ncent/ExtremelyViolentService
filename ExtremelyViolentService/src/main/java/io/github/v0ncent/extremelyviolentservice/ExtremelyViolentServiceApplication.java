package io.github.v0ncent.extremelyviolentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ExtremelyViolentServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExtremelyViolentServiceApplication.class);

    public static void main(String[] args) {
        final SpringApplication app = new SpringApplication(ExtremelyViolentServiceApplication.class);

        // register properties here so we can use .env
        final Map<String, Object> props = new HashMap<>();

        props.put(Constants.Properties.APPLICATION_NAME_PROP, Constants.Properties.APPLICATION_NAME);
        props.put(Constants.Properties.MONGO_URI_PROP, Constants.Properties.MONGO_URI);
        props.put(Constants.Properties.MONGO_DATABASE_PROP, Constants.Properties.MONGO_DATABASE);

        app.setDefaultProperties(props);
        app.run(args);

        LOGGER.info("LETS GET VIOLENT !");
    }
}
