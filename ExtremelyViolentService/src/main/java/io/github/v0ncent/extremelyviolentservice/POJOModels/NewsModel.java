package io.github.v0ncent.extremelyviolentservice.POJOModels;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("news")
public class NewsModel extends Model {
    private String html;

    public NewsModel(long id, String title, String slug, String coverImage, String date, String html) {
        super(id, title, slug, coverImage, date);
        this.html = html;
    }

    @Override
    public String getSequenceName() {
        return Constants.SequenceNames.NEWS_SEQ;
    }

    @Override
    protected String getExcerpt() {
        return Constants.Excerpts.NEWS_EXCERPT;
    }

    @Override
    protected String getTags() {
        return Constants.Tags.NEWS_TAG;
    }
}
