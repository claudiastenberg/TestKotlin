package se.claudiastenberg.TestKotlin.resource


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import se.claudiastenberg.TestKotlin.repository.data.Animal
import se.claudiastenberg.TestKotlin.service.AnimalService

import javax.ws.rs.*
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo


@Component
@Path("animals")
@Consumes(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XHTML_XML)
@Produces(MediaType.APPLICATION_JSON)
class AnimalResource @Autowired
constructor(private val service: AnimalService) {
    val users: Response

        @GET
        get() {
            service.getallUsers()
            return Response.ok(service.getallUsers()).build()
        }

    @POST
    fun createUser(user: Animal): Response {
        service.createUser(user)
        return Response.ok().build()
    }

    @GET
    @Path("{id}")
    fun getUser(@PathParam("id") id: Long?): Response {
        return Response.ok(service.getUser(id)).build()
    }

    @PUT
    @Path("{id}")
    fun updateUser(@PathParam("id") id: Long?, animal: Animal): Response {
        service.updateUser(id, animal)
        return Response.noContent().build()
    }

    @DELETE
    @Path("{id}")
    fun deleteUser(@PathParam("id") id: Long?): Response {
        service.deleteUser(id)
        return Response.noContent().build()
    }
}
