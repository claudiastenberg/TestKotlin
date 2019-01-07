package se.claudiastenberg.TestKotlin.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import se.claudiastenberg.TestKotlin.repository.data.Appointment
import se.claudiastenberg.TestKotlin.service.AppoinmentService

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * Constructure keyword används om man vill sätta mer än en konstruktor utöver den primära.
 * I detta fall har vi ej en primär men vi vill testa att använda detta keyword
 * I Java måste vi bilda en konstruktor med samma namn som return value. Men här behöver vi bara säga constructor*/

@Component
@Path("appoinemts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class AppoinmentResource @Autowired
constructor(private val service: AppoinmentService) {

    @GET
    fun getallAppointments(): Response {
        return Response.ok(service.getallAppoinments()).build()
    }

    @POST
    fun createAppoinment(appointment: Appointment): Response {
        service.bookAppoinment(appointment)
        return Response.ok().build()
    }

    @GET @Path("{id}")
    fun getAppoinment(@PathParam("id") id: Long?): Response {
        return Response.ok(service.getAppoinment(id)).build()
    }

    @PUT @Path("{id}")
    fun updateAppoiment(@PathParam("id") id: Long?, appointment: Appointment): Response {
        service.updateAppoinment(id, appointment)
        return Response.noContent().build()
    }

    @DELETE @Path("{id}")
    fun deleteAppoiment(@PathParam("id") id: Long?): Response {
        service.deleteAppoiment(id)
        return Response.noContent().build()
    }
}
