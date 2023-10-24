package dev.vepo.mystatistic.views;

import java.util.Optional;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.vepo.mystatistic.views.View.ViewId;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@Default
@ApplicationScoped
public class ViewMongoRepository implements ViewRepository, PanacheMongoRepositoryBase<View, ViewId> {
    private static final Logger logger = LoggerFactory.getLogger(View.class);

    @Override
    public void updateViewTime(ViewId id, long time) {
        logger.info("Incrementing: id={} time={}", id, time);
        var updatedDocs = update("{'$inc': {'time': ?1}}", time).where(new Document("_id", id));
        if (updatedDocs == 0) {
            persist(new View(id, time));
        }
        logger.info("Updated documents: {}", updatedDocs);
    }

    @Override
    public Optional<View> findViewById(ViewId id) {
        return Optional.ofNullable(findById(id));
    }
}
