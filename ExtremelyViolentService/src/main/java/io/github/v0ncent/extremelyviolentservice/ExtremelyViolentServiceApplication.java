package io.github.v0ncent.extremelyviolentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ExtremelyViolentServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExtremelyViolentServiceApplication.class);

    public static void main(String[] args) {
        final SpringApplication app = new SpringApplication(ExtremelyViolentServiceApplication.class);

        // register properties here so we can use .env
        final Map<String, Object> props = new HashMap<>();

        props.put(Constants.PropertyNames.SPRING_APPLICATION_NAME, Constants.PropertyValues.SPRING_APPLICATION_NAME);

        props.put(Constants.PropertyNames.SPRING_DATA_MONGODB_URI, Constants.PropertyValues.SPRING_DATA_MONGODB_URI);
        props.put(Constants.PropertyNames.SPRING_DATA_MONGODB_DATABASE, Constants.PropertyValues.SPRING_DATA_MONGODB_DATABASE);

        props.put(Constants.PropertyNames.LOGGING_LEVEL_ORG_SPRINGFRAMEWORK_DATA_MONGODB,
                Constants.PropertyValues.LOGGING_LEVEL_ORG_SPRINGFRAMEWORK_DATA_MONGODB);
        props.put(Constants.PropertyNames.LOGGING_LEVEL_COM_MONGODB, Constants.PropertyValues.LOGGING_LEVEL_COM_MONGODB);

        app.setDefaultProperties(props);
        app.run(args);

        LOGGER.info("LETS GET VIOLENT !");
    }
}
