package se.claudiastenberg.TestKotlin.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.claudiastenberg.TestKotlin.repository.data.Animal;
import se.claudiastenberg.TestKotlin.service.AnimalService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Path("animals")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XHTML_XML})
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {

    private final AnimalService service;
    @Context
    private UriInfo uriInfo;

    @Autowired
    public AnimalResource(AnimalService service) {
        this.service = service;
    }

    @POST
    public Response createUser(Animal user){
        service.createUser(user);
        return Response.ok().build();
    }
    @GET
    public Response getUsers(){
        service.getallUsers();
        return Response.ok(service.getallUsers()).build();
    }
}
