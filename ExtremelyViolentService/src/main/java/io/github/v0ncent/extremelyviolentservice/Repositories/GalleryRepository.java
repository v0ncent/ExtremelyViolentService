package io.github.v0ncent.extremelyviolentservice.Repositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.GalleryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GalleryRepository extends MongoRepository<GalleryModel, Long> {
    long count();
}
