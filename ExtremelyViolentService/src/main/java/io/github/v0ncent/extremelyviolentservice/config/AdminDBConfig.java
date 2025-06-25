package io.github.v0ncent.extremelyviolentservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.v0ncent.extremelyviolentservice.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "io.github.v0ncent.extremelyviolentservice.Repositories.AdminRepository",
        mongoTemplateRef = "admin"
)
public class AdminDBConfig {

    @Bean(name= "admin")
    public MongoTemplate adminDB() {
        System.out.println(Config.get("MONGO_URI"));
        System.out.println(Config.get("MONGODB_ADMIN_DATABASE"));

        final MongoClient mongoClient = MongoClients.create(Config.get("MONGO_URI"));

        return new MongoTemplate(mongoClient, Config.get("MONGODB_ADMIN_DATABASE"));
    }

}
