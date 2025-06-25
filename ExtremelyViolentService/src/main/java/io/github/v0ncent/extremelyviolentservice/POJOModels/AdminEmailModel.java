package io.github.v0ncent.extremelyviolentservice.POJOModels;

import io.github.v0ncent.extremelyviolentservice.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("extremeviolence_admins")
public final class AdminEmailModel extends Model {
    private String email;

    public AdminEmailModel(long id, String email) {
        super(id);
        this.email = email;
    }

    @Override
    public String getSequenceName() {
        return Constants.SequenceNames.ADMIN_SEQ;
    }
}
