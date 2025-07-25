package io.github.v0ncent.extremelyviolentservice.POJOModels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("extremeviolence_admins")
public final class AdminEmailModel extends Model {
    private String email;

    public AdminEmailModel(String id, String email) {
        super(id);
        this.email = email;
    }

}
