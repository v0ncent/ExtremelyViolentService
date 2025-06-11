package io.github.v0ncent.extremelyviolentservice.POJOModels;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("comics")
public final class ComicsModel extends Model {
    private final boolean isSeries;

    public ComicsModel(long id, String title, String slug, String coverImage, String date, boolean isSeries) {
        super(id, title, slug, coverImage, date);
        this.isSeries = isSeries;
    }

    @Override
    public String getSequenceName() {
        return Constants.SequenceNames.COMICS_SEQ;
    }

    @Override
    protected String getExcerpt() {
        return Constants.Excerpts.COMICS_EXCERPT;
    }

    @Override
    protected String getTags() {
        return Constants.Tags.COMICS_TAG;
    }
}
