package se.claudiastenberg.TestKotlin.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
/*
@Component
@Path("test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class TestResource {


    // CREATE
    @POST
    fun createTest(text: String): Long {
        val id = ids.incrementAndGet()

        return id;
    }

    companion object {
        private val ids = AtomicLong(1000)
    }
}*/