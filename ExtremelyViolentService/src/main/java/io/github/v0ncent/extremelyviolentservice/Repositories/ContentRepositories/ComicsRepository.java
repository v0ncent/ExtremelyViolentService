package io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.ComicsContentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComicsRepository extends MongoRepository<ComicsContentModel, String> {
}
