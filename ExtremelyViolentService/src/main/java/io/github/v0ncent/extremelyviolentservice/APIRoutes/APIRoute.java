package io.github.v0ncent.extremelyviolentservice.APIRoutes;

import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@RestController
public abstract class APIRoute<T extends Model> {
    public abstract MongoRepository<T, ObjectId> getRepository();
    public abstract Class<T> getEntityClass();

    private static final Logger LOGGER = LoggerFactory.getLogger(APIRoute.class);

    private final MongoOperations mongoOperations;

    public APIRoute(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @GetMapping("/getall")
    public Collection<T> getAll(HttpServletRequest request) {
        logRequest(null, RequestType.GET_ALL, request);

        try {
            Collection<T> galleryModels = getRepository().findAll();

            logResponse(null, RequestType.GET_ALL, request, ResponseType.SUCCESS);

            return galleryModels;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);

            return null;
        }
    }

    @GetMapping("/get/{queryField}/{queryValue}")
    public ResponseEntity<?> getOne(HttpServletRequest request, @PathVariable String queryField, @PathVariable String queryValue) {
        logRequest(queryValue, RequestType.GET, request);

        try {
            final Query query = new Query(Criteria.where(queryField).is(queryValue));

            final T result = mongoOperations.findOne(query, getEntityClass());

            if (result != null) {
                logResponse(null, RequestType.GET, request, ResponseType.SUCCESS);
            } else {
                LOGGER.info("No entry found for value: {} on: {} from: {}", queryValue, LocalDate.now(), request.getRemoteAddr());
            }

            return result != null ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createEntry")
    public ResponseEntity<T> createEntry(HttpServletRequest request, @RequestBody T model) {
        model.setId(new ObjectId());

        logRequest(model.getId(), RequestType.POST, request);

        try {
            T entry = getRepository().save(model);

            logResponse(model.getId().toString(), RequestType.POST, request, ResponseType.SUCCESS);

            return ResponseEntity.status(HttpStatus.CREATED).body(entry);
        } catch (Exception e) {
            logResponse(model.getId().toString(), RequestType.POST, request, ResponseType.ERROR);
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{queryParam}/{queryValue}/{fieldToUpdate}/{updatedValue}")
    public ResponseEntity<?> updateEntry(HttpServletRequest request, @PathVariable String queryParam,
                                                  @PathVariable String queryValue, @PathVariable String fieldToUpdate,
                                                  @PathVariable String updatedValue) {
        logRequest(queryValue, RequestType.PUT, request);

        T result;

        try {
            final Query query = new Query(Criteria.where(queryParam).is(queryValue));
            final Update update = new Update().set(fieldToUpdate, updatedValue);

            result = mongoOperations.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), getEntityClass());

            logResponse(queryValue, RequestType.PUT, request, ResponseType.SUCCESS);
        } catch (Exception e) {
            logResponse(queryValue, RequestType.PUT, request, ResponseType.ERROR);
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{field}/{value}")
    public ResponseEntity<?> delete(HttpServletRequest request, @PathVariable String field, @PathVariable String value) {
        logRequest(value, RequestType.DELETE, request);

        try {
            final Query query = new Query(Criteria.where(field).is(value));

            mongoOperations.findAndRemove(query, getEntityClass());

            logResponse(value, RequestType.DELETE, request, ResponseType.SUCCESS);

            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            logResponse(value, RequestType.DELETE, request, ResponseType.ERROR);
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private void logRequest(@Nullable Object id, RequestType requestType, HttpServletRequest request) {
        if (id == null) {
            LOGGER.info("Request to {} on: {} from: {}", requestType, LocalDate.now(), request.getRemoteAddr());
            return;
        }

        LOGGER.info("Request to {} entry: {} on: {} from: {}", id, requestType, LocalDate.now(), request.getRemoteAddr());
    }

    private void logResponse(@Nullable String value, RequestType requestType, HttpServletRequest request, ResponseType responseType) {
        if (Objects.requireNonNull(responseType) == ResponseType.ERROR) {
            LOGGER.info("Failed to complete {} request of entry where value is: {} on: {} from: {}",
                    request,
                    value != null ? value : "ALL",
                    LocalDate.now(),
                    request.getRemoteAddr()
            );

            return;
        }

        LOGGER.info("Successful {} of entry with value {} on: {} from: {}",
                requestType, value != null ? value : "ALL",
                LocalDate.now(),
                request.getRemoteAddr()
        );
    }

    public enum RequestType {
        GET_ALL("Get All"),
        GET("Get"),
        POST("Post"),
        PUT("Put"),
        DELETE("Delete");

        private final String toString;

        RequestType(String s) {
            this.toString = s;
        }

        @Override
        public String toString() {
            return this.toString;
        }
    }

    public enum ResponseType {
        SUCCESS,
        ERROR,
        NOT_FOUND
    }
}
