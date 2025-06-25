package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("news")
public class NewsContentModel extends ContentModel {
    private String html;

    public NewsContentModel(long id, String title, String slug, String coverImage, String date, String html) {
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
