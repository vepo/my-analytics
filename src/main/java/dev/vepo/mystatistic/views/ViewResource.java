package dev.vepo.mystatistic.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/view")
@ApplicationScoped
public class ViewResource {
    private static final Logger logger = LoggerFactory.getLogger(ViewResource.class);

    private Map<String, Long> statisticsPerPage;

    @PostConstruct
    void setup() {
        logger.info("statistcPerPage init");
        statisticsPerPage = new HashMap<>();
    }

    @PreDestroy
    void shutdown() {
        logger.info("statistcPerPage shutdown");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateView(ViewUpdateRequest request) {
        logger.info("Request: {}", request);
//        var views = View.findByDomainAndUserAndPath(request.domain(), request.idUser(), request.path());
//        logger.info("Views: {}", views);
        var totalTime = statisticsPerPage.compute(request.path(), (page, previousView) -> {
            if (Objects.nonNull(previousView)) {
                return previousView + request.viewDuration();
            } else {
                return (long) request.viewDuration();
            }            
        });
        return Response.accepted()
                .entity(new ViewUpdateResponse(totalTime))
                .build();
    }

}
