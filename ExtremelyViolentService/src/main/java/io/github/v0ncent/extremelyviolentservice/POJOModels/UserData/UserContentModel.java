package io.github.v0ncent.extremelyviolentservice.POJOModels.UserData;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("user_content")
public class UserContentModel extends Model {
    public String userId;
    public String[] comments;

    public UserContentModel(ObjectId id) {
        super(id);
    }
}
