package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.Constants;
import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.NewsContentModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories.NewsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public final class NewsController extends APIRoute<NewsContentModel> {
    @Autowired
    private NewsRepository newsRepository;

    public NewsController(@Qualifier(Constants.MongoTemplateReferences.CONTENT_MONGO_TEMPLATE_REFERENCE)
            MongoOperations mongoOperations) {
        super(mongoOperations);
    }

    @Override
    public MongoRepository<NewsContentModel, ObjectId> getRepository() {
        return newsRepository;
    }

    @Override
    public Class<NewsContentModel> getEntityClass() {
        return NewsContentModel.class;
    }
}
