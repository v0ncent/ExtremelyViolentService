package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Setter
@Getter
public abstract class ContentModel extends Model {
    protected abstract String getExcerpt();
    protected abstract String getTags();

    // keep so it posts these fields to db
    private final String excerpt = getExcerpt();
    private final String tags = getTags();

    private String title, slug, date, coverImage, postId;

    private PostComment[] comments;

    public ContentModel(ObjectId id,
                        String title,
                        String slug,
                        String coverImage,
                        String date,
                        String postId,
                        PostComment[] comments) {
        super(id);
        this.title = title;
        this.slug = slug;
        this.coverImage = coverImage;
        this.date = date;
        this.comments = comments;
        this.postId = postId;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostComment {
        private String postId;
        private String userId;
        private String text;
        private String date;
    }
}
