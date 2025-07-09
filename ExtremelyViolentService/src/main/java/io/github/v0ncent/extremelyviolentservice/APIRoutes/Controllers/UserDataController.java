package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.Constants;
import io.github.v0ncent.extremelyviolentservice.POJOModels.UserData.UserDataModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.UserDataRepositories.UserDataRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userData")
public class UserDataController extends APIRoute<UserDataModel> {
    @Autowired
    private UserDataRepository userDataRepository;

    public UserDataController(@Qualifier(Constants.MongoTemplateReferences.USERDATA_MONGO_TEMPLATE_REFERENCE)
            MongoOperations mongoOperations) {
        super(mongoOperations);
    }


    @Override
    public MongoRepository<UserDataModel, ObjectId> getRepository() {
        return userDataRepository;
    }

    @Override
    public Class<UserDataModel> getEntityClass() {
        return UserDataModel.class;
    }
}
