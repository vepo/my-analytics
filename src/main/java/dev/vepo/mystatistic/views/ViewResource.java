package dev.vepo.mystatistic.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/view")
@ApplicationScoped
public class ViewResource {
    private static final Logger logger = LoggerFactory.getLogger(ViewResource.class);

    @Inject
    UserViews userViews;

    @PersistenceContext
    EntityManager em;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateView(CreateViewRequest request) {
        logger.info("Request: {}", request);
        var navegacao = new Navegacao();
        navegacao.setUserId(request.idUser());
        navegacao.setPath(request.path());
        navegacao.setDomain(request.domain());
        navegacao.setDuration(0l);
        em.persist(navegacao);
        logger.info("Navegação criada: {}", navegacao);
        return Response.ok(new CreateViewResponse(navegacao.getId()))
                .build();
    }

    @POST
    @Path("{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateView(@PathParam("id") Long id, ViewUpdateRequest request) {
        logger.info("Request: {}", request);

        Navegacao navegacao;
        if (Objects.nonNull(id)) {
            navegacao = em.find(Navegacao.class, id);
            if (Objects.isNull(navegacao)) {
                throw new NotFoundException(String.format("Navegação não existe! id=%s", id));
            }
            navegacao.setDuration(request.time() + navegacao.getDuration());
            em.flush();
        } else {
            throw new BadRequestException("Id cannot be null!");
        }
        logger.info("Navegação atualizada: {}", navegacao);
        return Response.ok(new ViewUpdateResponse(navegacao.getId(), navegacao.getDuration()))
                .build();
    }

}
