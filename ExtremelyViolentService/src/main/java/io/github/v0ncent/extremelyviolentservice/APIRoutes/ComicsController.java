package io.github.v0ncent.extremelyviolentservice.APIRoutes;

import io.github.v0ncent.extremelyviolentservice.POJOModels.ComicsModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comics")
public class ComicsController extends APIRoute<ComicsModel> {
    @Autowired
    private ComicsRepository comicsRepository;

    @Override
    public MongoRepository<ComicsModel, Long> getRepository() {
        return comicsRepository;
    }
}
