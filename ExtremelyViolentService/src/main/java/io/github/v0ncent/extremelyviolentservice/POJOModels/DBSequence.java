package io.github.v0ncent.extremelyviolentservice.POJOModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class DBSequence {
    @Id
    private String id;

    /**
     * -- GETTER --
     *  getter for Sequence integer of object instance
     */
    @Getter
    private long seq;
}
