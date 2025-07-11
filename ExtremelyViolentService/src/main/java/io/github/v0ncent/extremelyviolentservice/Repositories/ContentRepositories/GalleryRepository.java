package io.github.v0ncent.extremelyviolentservice.Repositories.ContentRepositories;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Content.GalleryContentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GalleryRepository extends MongoRepository<GalleryContentModel, String> {
}
