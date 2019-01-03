package se.claudiastenberg.TestKotlin.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import se.claudiastenberg.TestKotlin.repository.data.Animal
import se.claudiastenberg.TestKotlin.repository.data.Appointment
import se.claudiastenberg.TestKotlin.service.AppoinmentService

import javax.ws.rs.*
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

import javax.ws.rs.core.Response.Status.NOT_FOUND


@Component
@Path("appoinemts")
@Consumes(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XHTML_XML)
@Produces(MediaType.APPLICATION_JSON)
class AppoinmentResource @Autowired
constructor(private val service: AppoinmentService) {
    val appoiments: Response
        @GET
        get() {
            service.getallAppoinments()
            return Response.ok(service.getallAppoinments()).build()
        }

    @POST
    fun createAppoinment(appointment: Appointment): Response {
        service.bookAppoinment(appointment)
        return Response.ok().build()
    }

    /*@GET
    @Path("{id}")
    fun getAppoinment(@PathParam("id") id: Long?): Response {
        return service.getAppoinment(id).map<ResponseBuilder>(Function<Appointment, ResponseBuilder> { Response.ok(it) }).orElse(Response.status(NOT_FOUND)).build()
    }*/

    @PUT
    @Path("{id}")
    fun updateAppoiment(@PathParam("id") id: Long?, appointment: Appointment): Response {
        service.updateAppoinment(id, appointment)
        return Response.noContent().build()
    }

    @DELETE
    @Path("{id}")
    fun deleteAppoiment(@PathParam("id") id: Long?): Response {
        service.deleteAppoiment(id)
        return Response.noContent().build()
    }
}
