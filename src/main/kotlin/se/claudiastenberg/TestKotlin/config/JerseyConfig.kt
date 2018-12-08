package se.claudiastenberg.TestKotlin.config

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration


@Configuration
class JerseyConfig : ResourceConfig() {
    init {
        register(se.claudiastenberg.TestKotlin.resource.AppoinmentResource::class.java)
        register(se.claudiastenberg.TestKotlin.resource.AnimalResource::class.java)
    }
}