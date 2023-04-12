package me.blueamethyst.packio.backend.rest

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import me.blueamethyst.packio.backend.rest.routes.MainRoute.configureRouting
import kotlin.concurrent.thread

object RestApplication {
    fun init(servicePort: Int = 8080, host: String = "0.0.0.0") {
        thread {
            embeddedServer(Netty, port = servicePort, host = host, module = Application::module)
                .start(wait = true)
        }
    }
}
fun Application.module() {
    configureRouting()
}