package io.github.v0ncent.extremelyviolentservice.APIRoutes;

import io.github.v0ncent.extremelyviolentservice.POJOModels.NewsModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public final class NewsController extends APIRoute<NewsModel> {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public MongoRepository<NewsModel, Long> getRepository() {
        return newsRepository;
    }
}
