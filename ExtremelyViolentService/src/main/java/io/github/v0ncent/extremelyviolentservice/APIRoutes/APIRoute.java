package io.github.v0ncent.extremelyviolentservice.APIRoutes;

import io.github.v0ncent.extremelyviolentservice.MongoTools.SequenceGenerator;
import io.github.v0ncent.extremelyviolentservice.POJOModels.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@RestController
public abstract class APIRoute<T extends Model> {
    public abstract MongoRepository<T, Long> getRepository();

    private static final Logger LOGGER = LoggerFactory.getLogger(APIRoute.class);

    @Autowired
    private SequenceGenerator sequenceGenerator;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(HttpServletRequest request, @PathVariable long id) {
        logRequest(id, RequestType.GET, request);

        try {
            Optional<T> entry = getRepository().findById(id);

            if (entry.isPresent()) {
                logResponse(null, RequestType.GET, request, ResponseType.SUCCESS);
            } else {
                LOGGER.info("No entry found for id: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());
            }

            return entry.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createEntry")
    public ResponseEntity<T> createEntry(HttpServletRequest request, @RequestBody T model) {
        model.setId(sequenceGenerator.getSequence(model.getSequenceName(), request));

        logRequest(model.getId(), RequestType.POST, request);

        try {
            T entry = getRepository().save(model);

            logResponse(model.getId(), RequestType.POST, request, ResponseType.SUCCESS);

            return ResponseEntity.status(HttpStatus.CREATED).body(entry);
        } catch (Exception e) {
            logResponse(model.getId(), RequestType.POST, request, ResponseType.ERROR);
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<T> updateEntry(HttpServletRequest request, @PathVariable long id, @RequestBody T model) {
        logRequest(model.getId(), RequestType.PUT, request);

        try {
            model.setId(id);

            getRepository().save(model);

            logResponse(model.getId(), RequestType.PUT, request, ResponseType.SUCCESS);
        } catch (Exception e) {
            logResponse(model.getId(), RequestType.PUT, request, ResponseType.ERROR);
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok().body(model);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(HttpServletRequest request, @PathVariable long id) {
        logRequest(id, RequestType.DELETE, request);

        try {
            getRepository().deleteById(id);

            logResponse(id, RequestType.DELETE, request, ResponseType.SUCCESS);

            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            logResponse(id, RequestType.DELETE, request, ResponseType.ERROR);
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public void logRequest(@Nullable Long id, RequestType requestType, HttpServletRequest request) {
        if (id == null) {
            LOGGER.info("Request to {} on: {} from: {}", requestType, LocalDate.now(), request.getRemoteAddr());
            return;
        }

        LOGGER.info("Request to {} entry: {} on: {} from: {}", id, requestType, LocalDate.now(), request.getRemoteAddr());
    }

    public void logResponse(@Nullable Long id, RequestType requestType, HttpServletRequest request, ResponseType responseType) {
        if (Objects.requireNonNull(responseType) == ResponseType.ERROR) {
            LOGGER.info("Failed to complete {} request of entry id: {} on: {} from: {}",
                    request,
                    id != null ? id : "ALL",
                    LocalDate.now(),
                    request.getRemoteAddr()
            );

            return;
        }

        LOGGER.info("Successful {} of entry {} on: {} from: {}",
                requestType, id != null ? id : "ALL",
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
