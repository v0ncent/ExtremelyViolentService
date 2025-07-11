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

    public UserContentModel(String id, String userId, Comment[] comments) {
        super(id);
        this.userId = userId;
        this.comments = comments;
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
    }
}
