package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("news")
public class NewsContentModel extends ContentModel {
    private String html;

    public NewsContentModel(ObjectId id,
                            String title,
                            String slug,
                            String coverImage,
                            String date,
                            String postId,
                            PostComment[] comments,
                            String html) {
        super(id, title, slug, coverImage, date, postId, comments);
        this.html = html;
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
