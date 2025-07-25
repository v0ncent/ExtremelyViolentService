package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("comics")
public final class ComicsContentModel extends ContentModel {
    private final boolean series;

    private final String description;

    public ComicsContentModel(String id,
                              String title,
                              String slug,
                              String coverImage,
                              String postId,
                              String date,
                              PostComment[] comments,
                              boolean series,
                              String description) {
        super(id, postId, title, slug, coverImage, date, comments);
        this.series = series;
        this.description = description;
    }

    @Override
    public String getExcerpt() {
        return Constants.Excerpts.COMICS_EXCERPT;
    }

    @Override
    public String getTags() {
        return Constants.Tags.COMICS_TAG;
    }
}
