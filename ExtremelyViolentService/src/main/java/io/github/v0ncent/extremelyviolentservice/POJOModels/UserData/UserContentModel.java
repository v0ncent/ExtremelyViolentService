package io.github.v0ncent.extremelyviolentservice.POJOModels.UserData;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("user_content")
public class UserContentModel extends Model {
    public String userId;
    public Comment[] comments;
    public AdminComment[] adminComments;

    public UserContentModel(String id, String userId, Comment[] comments, AdminComment[] adminComments) {
        super(id);
        this.userId = userId;
        this.comments = comments;
        this.adminComments = adminComments;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Comment {
        private String commentId;
        private String postId;
        private String postTitle;
        private String section;
        private String text;
        private String date;
        private Comment[] adminComments;
        private boolean deletedByAdmin;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdminComment {
        private String commentId;
        private String onComment;
        private String postId;
        private String postTitle;
        private String section;
        private String text;
        private String date;
    }
}
