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
        mongoTemplateRef = "contentMongoTemplate"
)
public class MongoConfig {

    @Bean(name= "contentMongoTemplate")
    @Primary
    public MongoTemplate contentMongoTemplate() {
        final String uri = Config.get("MONGO_URI");
        final String dbName = Config.get("MONGODB_CONTENT_DATABASE");

        validateConfig("MONGO_URI", uri);
        validateConfig("MONGODB_CONTENT_DATABASE", dbName);

        final MongoClient mongoClient = MongoClients.create(uri);
        return new MongoTemplate(mongoClient, dbName);
    }

    @Bean(name = "adminMongoTemplate")
    public MongoTemplate adminMongoTemplate() {
        final String uri = Config.get("MONGO_URI");
        final String dbName = Config.get("MONGODB_ADMIN_DATABASE");

        validateConfig("MONGO_URI", uri);
        validateConfig("MONGODB_ADMIN_DATABASE", dbName);

        final MongoClient mongoClient = MongoClients.create(uri);
        return new MongoTemplate(mongoClient, dbName);
    }

    private void validateConfig(String key, String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(key + " cannot be empty or null!");
        }
    }

}
