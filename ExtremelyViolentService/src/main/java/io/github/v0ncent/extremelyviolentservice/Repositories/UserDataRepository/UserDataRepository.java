package io.github.v0ncent.extremelyviolentservice.Repositories.UserDataRepository;

import io.github.v0ncent.extremelyviolentservice.POJOModels.UserDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepository extends MongoRepository<UserDataModel, Long> {
}
