package dev.vepo.mystatistic.views;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserViews {
    @Inject
    ViewRepository viewRepository;

    public Optional<View> register(String idUser, String domain, String path, int viewDuration) {
        viewRepository.updateViewTime(new View.ViewId(idUser, domain, path), viewDuration);
        return viewRepository.findViewById(new View.ViewId(idUser, domain, path));
    }
}
