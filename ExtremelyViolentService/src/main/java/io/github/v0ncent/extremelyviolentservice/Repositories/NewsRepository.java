package io.github.v0ncent.extremelyviolentservice.Repositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.NewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<NewsModel, Long> {
}
