package io.github.v0ncent.extremelyviolentservice.APIRoutes;

import io.github.v0ncent.extremelyviolentservice.MongoTools.SequenceGenerator;
import io.github.v0ncent.extremelyviolentservice.POJOModels.GalleryModel;
import io.github.v0ncent.extremelyviolentservice.Repositories.GalleryRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/gallery")
public final class GalleryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GalleryController.class);

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @GetMapping("/getall")
    public Collection<GalleryModel> getAll(HttpServletRequest request) {
        LOGGER.info("Request to get all entries on: {} from: {}", LocalDate.now(), request.getRemoteAddr());

        try {
            Collection<GalleryModel> galleryModels = galleryRepository.findAll();

            LOGGER.info("Retrieved all entries on: {} from: {}", LocalDate.now(), request.getRemoteAddr());

            return galleryModels;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);

            return null;
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(HttpServletRequest request, @PathVariable long id) {
        LOGGER.info("Request to get entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());

        try {
            Optional<GalleryModel> entry = galleryRepository.findById(id);

            if (entry.isPresent()) {
                LOGGER.info("Successful Retrieval of entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());
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
    public ResponseEntity<GalleryModel> createEntry(HttpServletRequest request, @RequestBody GalleryModel model) {
        model.setId(sequenceGenerator.getSequence(GalleryModel.sequence_name, request));

        LOGGER.info("Request to create entry: {} on: {} from: {}", model.getId(), LocalDate.now(), request.getRemoteAddr());

        try {
            GalleryModel entry = galleryRepository.save(model);

            LOGGER.info("Successfully created entry: {} on: {} from: {}", entry.getId(), LocalDate.now(), request.getRemoteAddr());

            return ResponseEntity.status(HttpStatus.CREATED).body(entry);
        } catch (Exception e) {
            LOGGER.info("Failed to create entry: {} on: {} from: {}", model.getId(), LocalDate.now(), request.getRemoteAddr());
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GalleryModel> updateEntry(HttpServletRequest request, @PathVariable long id, @RequestBody GalleryModel model) {
        LOGGER.info("Request to update entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());

        try {
            galleryRepository.save(model);

            LOGGER.info("Updated entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());
        } catch (Exception e) {
            LOGGER.info("Failed to update entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok().body(model);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(HttpServletRequest request, @PathVariable long id) {
        LOGGER.info("Request to delete entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());

        try {
            galleryRepository.deleteById(id);

            LOGGER.info("Deleted entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());

            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            LOGGER.info("Failed to delete entry: {} on: {} from: {}", id, LocalDate.now(), request.getRemoteAddr());
            LOGGER.error(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
