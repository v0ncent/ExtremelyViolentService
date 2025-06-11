package io.github.v0ncent.extremelyviolentservice.Repositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.ComicsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComicsRepository extends MongoRepository<ComicsModel, Long> {
}
