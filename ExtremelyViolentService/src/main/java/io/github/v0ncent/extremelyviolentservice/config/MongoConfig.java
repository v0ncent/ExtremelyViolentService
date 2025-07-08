package io.github.v0ncent.extremelyviolentservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.v0ncent.extremelyviolentservice.Config;
import io.github.v0ncent.extremelyviolentservice.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = Constants.RepositoryPackages.CONTENT_REPOSITORIES_PACKAGE,
        mongoTemplateRef = Constants.MongoTemplateReferences.CONTENT_MONGO_TEMPLATE_REFERENCE
)
public class MongoConfig {

    @Bean(name= Constants.MongoTemplateReferences.CONTENT_MONGO_TEMPLATE_REFERENCE)
    @Primary
    public MongoTemplate contentMongoTemplate() {
        return buildMongoTemplate(Constants.EnvironmentVariables.MONGODB_CONTENT_DATABASE);
    }

    @Bean(name = Constants.MongoTemplateReferences.ADMIN_MONGO_TEMPLATE_REFERENCE)
    public MongoTemplate adminMongoTemplate() {
        return buildMongoTemplate(Constants.EnvironmentVariables.MONGODB_ADMIN_DATABASE);
    }

    @Bean(name = Constants.MongoTemplateReferences.USERDATA_MONGO_TEMPLATE_REFERENCE)
    public MongoTemplate userDataMongoTemplate() {
        return buildMongoTemplate(Constants.EnvironmentVariables.MONGODB_USERDATA_DATABASE);
    }

    private MongoTemplate buildMongoTemplate(String dbName) {
        final String uri = Config.get(Constants.EnvironmentVariables.MONGO_URI);
        final String database = Config.get(dbName);

        validateConfig(Constants.EnvironmentVariables.MONGO_URI, uri);
        validateConfig(dbName, database);

        final MongoClient mongoClient = MongoClients.create(uri);
        return new MongoTemplate(mongoClient, database);
    }

    private void validateConfig(String key, String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException(key + " cannot be empty or null!");
        }
    }

}
