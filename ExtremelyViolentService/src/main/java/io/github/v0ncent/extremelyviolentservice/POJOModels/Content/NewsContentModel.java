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
                            String postId,
                            String slug,
                            String coverImage,
                            String date,
                            PostComment[] comments,
                            String html) {
        super(id, postId, title, slug, coverImage, date, comments);
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

    @Override
    public String toString() {
        StringBuilder commentsStr = new StringBuilder("[");
        if (getComments() != null) {
            for (int i = 0; i < getComments().length; i++) {
                PostComment c = getComments()[i];
                commentsStr.append(String.format(
                        "{userId='%s', commentId='%s', text='%s', date='%s'}",
                        c.getUserId(), c.getCommentId(), c.getText(), c.getDate()
                ));
                if (i < getComments().length - 1) commentsStr.append(", ");
            }
        }
        commentsStr.append("]");

        return "NewsContentModel{" +
                "id='" + getId() + '\'' +
                ", title='" + this.getTitle() + '\'' +
                ", slug='" + this.getSlug() + '\'' +
                ", date='" + this.getDate() + '\'' +
                ", coverImage='" + this.getCoverImage() + '\'' +
                ", postId='" + this.getPostId() + '\'' +
                ", excerpt='" + this.getExcerpt() + '\'' +
                ", tags='" + this.getTags() + '\'' +
                ", comments=" + commentsStr +
                ", html='" + html + '\'' +
                '}';
    }
}
