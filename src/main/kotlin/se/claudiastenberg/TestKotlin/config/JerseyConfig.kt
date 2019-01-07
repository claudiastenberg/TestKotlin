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

//Om du vill att en kod i en klass/objekt ska innehålla samma som den som ärver från den så kan du använda metoder- init(){}.
//Detta villkor kommer då gälla för alla klasser och metoder som ärver från denna basklass.