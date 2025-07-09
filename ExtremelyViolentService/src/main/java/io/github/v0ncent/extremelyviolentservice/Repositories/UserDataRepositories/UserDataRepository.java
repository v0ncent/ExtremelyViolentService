package io.github.v0ncent.extremelyviolentservice.Repositories.UserDataRepositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.UserData.UserDataModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepository extends MongoRepository<UserDataModel, ObjectId> {
}
