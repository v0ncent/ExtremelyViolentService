package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class ContentModel extends Model {
    public abstract String getSequenceName();

    protected abstract String getExcerpt();
    protected abstract String getTags();

    // keep so it posts these fields to db
    private final String excerpt = getExcerpt();
    private final String tags = getTags();

    private String title, slug, date, coverImage;

    public ContentModel(long id, String title, String slug, String coverImage, String date) {
        super(id);
        this.title = title;
        this.slug = slug;
        this.coverImage = coverImage;
        this.date = date;
    }
}
