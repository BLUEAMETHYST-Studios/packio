package me.blueamethyst.packio.backend.rest.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

object MainRoute {

    fun Application.configureRouting() {
        routing {
            get("/") {
                call.respondText("online")
            }
        }
    }
}