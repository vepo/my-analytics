package dev.vepo.mystatistic.views;

import java.util.Objects;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "View")
public class View extends PanacheMongoEntityBase {
    public record ViewId(String idUser, String domain, String path) {
    }

    public ViewId id;
    public long time;

    public View(ViewId id, long time) {
        this.id = id;
        this.time = time;
    }

    public View() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            View other = (View) obj;
            return Objects.equals(id, other.id);
        }
    }

    @Override
    public String toString() {
        return String.format("View [id=%s, time=%d]", id, time);
    }
}
