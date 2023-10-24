package dev.vepo.mystatistic.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/view")
@ApplicationScoped
public class ViewResource {
    private static final Logger logger = LoggerFactory.getLogger(ViewResource.class);

    @Inject
    UserViews userViews;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateView(ViewUpdateRequest request) {
        logger.info("Request: {}", request);
        return userViews.register(request.idUser(), request.domain(), request.path(), request.viewDuration())
                .map(view -> Response.ok(view)).orElseGet(() -> Response.status(Status.NOT_FOUND))
                .build();
    }

}
