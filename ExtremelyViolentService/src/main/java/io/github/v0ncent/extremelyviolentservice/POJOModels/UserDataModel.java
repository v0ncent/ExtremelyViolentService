package io.github.v0ncent.extremelyviolentservice.POJOModels;

import lombok.Getter;
import lombok.Setter;
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

    public UserDataModel(long id) {
        super(id);
    }

    @Override
    public String getSequenceName() {
        return "userpreferences_seq";
    }
}
