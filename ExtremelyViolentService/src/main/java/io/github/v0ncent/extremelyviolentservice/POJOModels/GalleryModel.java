package io.github.v0ncent.extremelyviolentservice.POJOModels;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("gallery")
public final class GalleryModel extends Model {
    private long width;
    private long height;

    public GalleryModel(long id, String title, String slug, String coverImage, String date, long width, long height) {
        super(id, title, slug, coverImage, date);
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

    @Override
    public String getSequenceName() {
        return Constants.SequenceNames.GALLERY_SEQ;
    }
}
