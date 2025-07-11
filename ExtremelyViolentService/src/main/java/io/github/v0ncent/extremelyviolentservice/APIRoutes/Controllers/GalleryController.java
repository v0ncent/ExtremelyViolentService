package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.Constants;
import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.GalleryContentModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gallery")
public final class GalleryController extends APIRoute<GalleryContentModel> {
    @Autowired
    private GalleryRepository galleryRepository;

    public GalleryController(@Qualifier(Constants.MongoTemplateReferences.CONTENT_MONGO_TEMPLATE_REFERENCE)
                             MongoOperations mongoOperations) {
        super(mongoOperations);
    }

    @Override
    public MongoRepository<GalleryContentModel, String> getRepository() {
        return galleryRepository;
    }

    @Override
    public Class<GalleryContentModel> getEntityClass() {
        return GalleryContentModel.class;
    }
}
