package me.blueamethyst.packio.backend.rest.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.blueamethyst.packio.backend.extensions.respondJson
import me.blueamethyst.packio.backend.pioApi

object MainRoute {

    fun Application.configureRouting() {
        routing {
            get("/") {
                call.respondText("online")
            }

            get("/packrequests") {
                call.respondJson(pioApi.getPackRequestHandler().getRequests())
            }
        }
    }
}