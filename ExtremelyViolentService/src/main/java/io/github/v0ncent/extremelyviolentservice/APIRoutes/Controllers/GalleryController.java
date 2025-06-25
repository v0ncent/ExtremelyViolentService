package io.github.v0ncent.extremelyviolentservice.APIRoutes.Controllers;

import io.github.v0ncent.extremelyviolentservice.APIRoutes.APIRoute;
import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.GalleryContentModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gallery")
public final class GalleryController extends APIRoute<GalleryContentModel> {
    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public MongoRepository<GalleryContentModel, Long> getRepository() {
        return galleryRepository;
    }
}
