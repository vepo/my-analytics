package dev.vepo.mystatistic.views;

import java.util.Optional;

import dev.vepo.mystatistic.views.View.ViewId;
import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class MockViewRepository implements ViewRepository {

    @Override
    public void updateViewTime(ViewId id, long time) {

    }

    @Override
    public Optional<View> findViewById(ViewId id) {
        return Optional.of(new View(new ViewId("asdasdsa", "sadasd", "qwewqe"), 20));
    }
}
