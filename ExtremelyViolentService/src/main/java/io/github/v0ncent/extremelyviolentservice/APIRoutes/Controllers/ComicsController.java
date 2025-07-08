package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.Constants;
import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.ComicsContentModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories.ComicsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comics")
public final class ComicsController extends APIRoute<ComicsContentModel> {
    @Autowired
    private ComicsRepository comicsRepository;

    public ComicsController(@Qualifier(Constants.MongoTemplateReferences.CONTENT_MONGO_TEMPLATE_REFERENCE)
            MongoOperations mongoOperations) {
        super(mongoOperations);
    }

    @Override
    public MongoRepository<ComicsContentModel, ObjectId> getRepository() {
        return comicsRepository;
    }

    @Override
    public Class<ComicsContentModel> getEntityClass() {
        return ComicsContentModel.class;
    }
}
