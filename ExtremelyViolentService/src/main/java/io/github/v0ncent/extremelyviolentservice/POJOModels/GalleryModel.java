package io.github.v0ncent.extremelyviolentservice.POJOModels;

import io.github.v0ncent.extremelyviolentservice.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("gallery")
public final class GalleryModel implements Model {
    private final String excerpt = Constants.Excerpts.GALLERY_EXCERPT;
    private final String tags = Constants.Tags.GALLERY_TAG;

    @Id
    private long id;

    String title, slug, coverImage, date;
    long width;
    long height;

    public GalleryModel(long id, String title, String slug, String coverImage, String date, long width, long height) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.coverImage = coverImage;
        this.date = date;
        this.width = width;
        this.height = height;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public String getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getDate() {
        return date;
    }

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getSequenceName() {
        return Constants.SequenceNames.GALLERY_SEQ;
    }

    @Override
    public long getId() {
        return id;
    }

}
