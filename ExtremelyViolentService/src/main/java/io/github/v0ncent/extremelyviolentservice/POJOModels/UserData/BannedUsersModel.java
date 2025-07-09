package io.github.v0ncent.extremelyviolentservice.POJOModels.UserData;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("banned_users")
public class BannedUsersModel extends Model {
    private String email;
    private String userId;
    private String ipAddress;

    public BannedUsersModel(ObjectId id) {
        super(id);
    }
}
