package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.Constants;
import io.github.v0ncent.extremelyviolentservice.POJOModels.UserData.BannedUsersModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.UserDataRepositories.BannedUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bannedUsers")
public final class BannedUsersController extends APIRoute<BannedUsersModel> {
    @Autowired
    private BannedUsersRepository bannedUsersRepository;

    public BannedUsersController(@Qualifier(Constants.MongoTemplateReferences.USERDATA_MONGO_TEMPLATE_REFERENCE)
                                 MongoOperations mongoOperations) {
        super(mongoOperations);
    }

    @Override
    public MongoRepository<BannedUsersModel, String> getRepository() {
        return bannedUsersRepository;
    }

    @Override
    public Class<BannedUsersModel> getEntityClass() {
        return BannedUsersModel.class;
    }
}
