package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("gallery")
public final class GalleryContentModel extends ContentModel {
    private long width;
    private long height;

    public GalleryContentModel(ObjectId id,
                               String title,
                               String slug,
                               String coverImage,
                               String date,
                               String postId,
                               PostComment[] comments,
                               long width,
                               long height) {
        super(id, title, slug, coverImage, date, postId, comments);
        this.width = width;
        this.height = height;
    }

    @Override
    public String getExcerpt() {
        return Constants.Excerpts.GALLERY_EXCERPT;
    }

    @Override
    public String getTags() {
        return Constants.Tags.GALLERY_TAG;
    }

}
