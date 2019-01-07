package se.claudiastenberg.TestKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestKotlinApplication

fun main(args: Array<String>) {
    runApplication<TestKotlinApplication>(*args)
}

/** Static finns ej i Kotlin
 * Istället kan man använda companion object-
 * Alltså om man vill ha sin main metod i någon annan fil så kan man sätta companion object med annotation
 * @JVMStstic i så kan den köras där ifrå
 *
 * */