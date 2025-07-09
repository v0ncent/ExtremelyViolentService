package io.github.v0ncent.extremelyviolentservice.POJOModels.UserData;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("user_data")
public class UserDataModel extends Model {
    private String userId;
    private String email;
    private String authProvider;
    private boolean isAdmin;
    private String imagePath;
    private String userName;

    public UserDataModel(ObjectId id) {
        super(id);
    }

}
