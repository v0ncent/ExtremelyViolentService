package io.github.v0ncent.extremelyviolentservice.POJOModels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public abstract class Model {
    public abstract String getSequenceName();

    protected abstract String getExcerpt();
    protected abstract String getTags();

    @Id
    private long id;

    private String title, slug, date, coverImage;

    public Model(long id, String title, String slug, String coverImage, String date) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.coverImage = coverImage;
        this.date = date;
    }
}
