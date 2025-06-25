package io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.NewsContentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<NewsContentModel, Long> {
}
