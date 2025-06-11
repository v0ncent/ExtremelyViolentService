package io.github.v0ncent.extremelyviolentservice.APIRoutes;

import io.github.v0ncent.extremelyviolentservice.POJOModels.GalleryModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gallery")
public final class GalleryController extends APIRoute<GalleryModel> {
    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public MongoRepository<GalleryModel, Long> getRepository() {
        return galleryRepository;
    }
}
