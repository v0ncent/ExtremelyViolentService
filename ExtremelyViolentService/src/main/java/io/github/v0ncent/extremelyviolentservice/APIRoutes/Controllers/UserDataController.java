package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.POJOModels.UserDataModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.UserDataRepository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userData")
public class UserDataController extends APIRoute<UserDataModel> {
    @Autowired
    private UserDataRepository userDataRepository;


    @Override
    public MongoRepository<UserDataModel, Long> getRepository() {
        return userDataRepository;
    }
}
