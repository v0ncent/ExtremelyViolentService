package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.Constants;
import io.github.v0ncent.extremelyviolentservice.POJOModels.UserData.UserContentModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.UserDataRepositories.UserContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userContent")
public final class UserContentController extends APIRoute<UserContentModel> {
    @Autowired
    private UserContentRepository userContentRepository;

    public UserContentController(@Qualifier(Constants.MongoTemplateReferences.USERDATA_MONGO_TEMPLATE_REFERENCE)
                                 MongoOperations mongoOperations) {
        super(mongoOperations);
    }

    @Override
    public MongoRepository<UserContentModel, String> getRepository() {
        return userContentRepository;
    }

    @Override
    public Class<UserContentModel> getEntityClass() {
        return UserContentModel.class;
    }
}
