package io.github.v0ncent.extremelyviolentservice.POJOModels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public abstract class Model {
    public abstract String getSequenceName();

    @Id
    private long Id;

    public Model(long id) {
        this.Id = id;
    }
}
