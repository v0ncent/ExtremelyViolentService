package io.github.v0ncent.extremelyviolentservice.Repositories.UserDataRepositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.UserData.BannedUsersModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BannedUsersRepository extends MongoRepository<BannedUsersModel, ObjectId> {
}
