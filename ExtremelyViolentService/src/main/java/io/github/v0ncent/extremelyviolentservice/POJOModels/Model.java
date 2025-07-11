package io.github.v0ncent.extremelyviolentservice.POJOModels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public abstract class Model {
    @Id
    protected String id;

    public Model(String id) {
        this.id = id;
    }
}
