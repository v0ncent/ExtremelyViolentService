package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("gallery")
public final class GalleryContentModel extends ContentModel {
    private long width;
    private long height;

    public GalleryContentModel(String id,
                               String title,
                               String slug,
                               String postId,
                               String coverImage,
                               String date,
                               PostComment[] comments,
                               long width,
                               long height) {
        super(id, postId, title, slug, coverImage, date, comments);
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
