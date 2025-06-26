package io.github.v0ncent.extremelyviolentservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "io.github.v0ncent.extremelyviolentservice.Repositories.AdminRepository",
        mongoTemplateRef = "adminMongoTemplate"
)
public class AdminDBConfig {

}
