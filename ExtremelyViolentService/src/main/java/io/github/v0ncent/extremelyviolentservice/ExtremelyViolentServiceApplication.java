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

        props.put("spring.application.name", "ExtremelyViolentService");
        props.put("spring.data.mongodb.uri", Config.get("MONGO_URI"));
        props.put("spring.data.mongodb.database", Config.get("MONGODB_CONTENT_DATABASE"));
        props.put("logging.level.org.springframework.data.mongodb", "DEBUG");
        props.put("logging.level.com.mongodb", "DEBUG");

        app.setDefaultProperties(props);
        app.run(args);

        LOGGER.info("LETS GET VIOLENT !");
    }
}
