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

    public NewsContentModel(String id,
                            String title,
                            String slug,
                            String coverImage,
                            String date,
                            PostComment[] comments,
                            String html) {
        super(id, title, slug, coverImage, date, comments);
        this.html = html;
    }

    @Override
    public String getExcerpt() {
        return Constants.Excerpts.NEWS_EXCERPT;
    }

    @Override
    public String getTags() {
        return Constants.Tags.NEWS_TAG;
    }
}
