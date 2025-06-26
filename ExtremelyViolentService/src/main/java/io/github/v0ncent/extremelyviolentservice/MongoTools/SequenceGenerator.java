package io.github.v0ncent.extremelyviolentservice.MongoTools;

import io.github.v0ncent.extremelyviolentservice.POJOModels.DBSequenceModel;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public final class SequenceGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(SequenceGenerator.class);

    @Autowired
    private MongoOperations mongoOperations;

    public long getSequence(String sequenceName, HttpServletRequest request) {
        LOGGER.info("Request to get sequence: {} from: {}", sequenceName, request.getRemoteAddr());

        Query query = new Query(Criteria.where("_id").is(sequenceName));

        Update update = new Update().inc("seq", 1);

        DBSequenceModel seq = mongoOperations
                .findAndModify(query, update,
                        options().returnNew(true).upsert(true),
                        DBSequenceModel.class);

        if (!Objects.isNull(seq)) {
            LOGGER.info("Sequence found: {}", seq);
            return seq.getSeq();
        } else {
            LOGGER.info("Sequence not found for: {} from: {}", sequenceName, request.getRemoteAddr());

            return 1;
        }
    }
}
