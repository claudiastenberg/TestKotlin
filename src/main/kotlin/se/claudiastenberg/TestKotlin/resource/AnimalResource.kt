package se.claudiastenberg.TestKotlin.resource


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import se.claudiastenberg.TestKotlin.repository.data.Animal
import se.claudiastenberg.TestKotlin.service.AnimalService

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("animals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class AnimalResource @Autowired
constructor(private val service: AnimalService) {

    @GET
    fun get() = service.getallClient()

    @POST
    fun createClient(client: Animal): Response {
        service.createClient(client)
        return Response.ok().build()
    }

    @GET @Path("{id}")
    fun getClient(@PathParam("id") id: Long?): Response {
        return Response.ok(service.getClient(id)).build()
    }

    @PUT @Path("{id}")
    fun updateClient(@PathParam("id") id: Long?, client: Animal): Response {
        service.updateUser(id, client)
        return Response.noContent().build()
    }

    @DELETE @Path("{id}")
    fun deleteClient(@PathParam("id") id: Long?): Response {
        service.deleteUser(id)
        return Response.noContent().build()
    }
}
/*
* fun är deklaration för metod.
* : Response- detta är return type, det kan lika gärna vara ex en Int ifall vi ska returnera en int
* */
