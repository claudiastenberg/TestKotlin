package se.claudiastenberg.TestKotlin.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.claudiastenberg.TestKotlin.repository.data.Appointment;
import se.claudiastenberg.TestKotlin.service.AppoinmentService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Component
@Path("appoinemts")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XHTML_XML})
@Produces(MediaType.APPLICATION_JSON)
public class AppoinmentResource {

    private final AppoinmentService service;
    @Context
    private UriInfo uriInfo;

    @Autowired
    public AppoinmentResource(AppoinmentService service) {
        this.service = service;
    }

    @POST
    public Response createAppoinment(Appointment appointment){
        service.bookAppoinment(appointment);
        return Response.ok().build();
    }
    @GET
    public Response getAppoiments(){
        service.getallBookings();
        return Response.ok(service.getallBookings()).build();
    }
}
