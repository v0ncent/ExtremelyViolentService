package io.github.v0ncent.extremelyviolentservice.POJOModels.Content;

import com.mongodb.lang.Nullable;
import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public abstract class ContentModel extends Model {
    public abstract String getExcerpt();
    public abstract String getTags();

    // keep so it posts these fields to db
    private final String excerpt = getExcerpt();
    private final String tags = getTags();

    private String title, slug, date, coverImage, postId;

    private PostComment[] comments;

    public ContentModel(String id,
                        String postId,
                        String title,
                        String slug,
                        String coverImage,
                        String date,
                        PostComment[] comments) {
        super(id);

        this.title = title;
        this.postId = postId;
        this.slug = slug;
        this.coverImage = coverImage;
        this.date = date;
        this.comments = comments != null ? comments : new PostComment[0];
    }

    @Setter
    @Getter
    public static class PostComment {
        private String replyingTo;
        private String userId;
        private String commentId;
        private String text;
        private String date;
        private AdminComment[] adminComments;

        public PostComment(@Nullable String replyingTo,
                           String userId,
                           String text,
                           String date,
                           AdminComment[] adminComments) {
            this.replyingTo = replyingTo;
            this.userId = userId;
            this.commentId = UUID.randomUUID().toString();
            this.text = text;
            this.date = date;
            this.adminComments = adminComments != null ? adminComments : new AdminComment[0];
        }
    }

    @Setter
    @Getter
    public static class AdminComment {
        private String userId;
        private String commentId;
        private String onComment;
        private String text;
        private String date;

        public AdminComment(String userId, String onComment, String text, String date) {
            this.userId = userId;
            this.onComment = onComment;
            this.commentId = UUID.randomUUID().toString();
            this.text = text;
            this.date = date;
        }
    }
}
