package io.github.v0ncent.extremelyviolentservice.Repositories.AdminRepository;

import io.github.v0ncent.extremelyviolentservice.POJOModels.AdminEmailModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<AdminEmailModel, String> {
}
