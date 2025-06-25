package io.github.v0ncent.extremelyviolentservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.v0ncent.extremelyviolentservice.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories",
        mongoTemplateRef = "content"
)
public class ContentDBConfig {

    @Bean(name= "content")
    @Primary
    public MongoTemplate contentDB() {
        System.out.println(Config.get("MONGO_URI"));
        System.out.println(Config.get("MONGODB_CONTENT_DATABASE"));

        final MongoClient mongoClient = MongoClients.create(Config.get("MONGO_URI"));

        return new MongoTemplate(mongoClient, Config.get("MONGODB_CONTENT_DATABASE"));
    }

}
