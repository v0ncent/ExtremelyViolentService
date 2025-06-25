package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.NewsContentModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public final class NewsController extends APIRoute<NewsContentModel> {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public MongoRepository<NewsContentModel, Long> getRepository() {
        return newsRepository;
    }
}
