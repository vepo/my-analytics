package dev.vepo.mystatistic.views;

import java.util.Optional;

import dev.vepo.mystatistic.views.View.ViewId;

public interface ViewRepository {
    void updateViewTime(ViewId id, long time);

    Optional<View> findViewById(ViewId id);
}
