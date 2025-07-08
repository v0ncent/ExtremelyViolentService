package io.github.v0ncent.extremelyviolentservice.POJOModels;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public abstract class Model {
    @Id
    private ObjectId id;

    public Model(ObjectId id) {
        this.id = id;
    }
}
