package me.blueamethyst.packio.backend.extensions

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// @author https://github.com/mooziii
suspend inline fun <reified T> ApplicationCall.respondJson(
    jsonObject: T,
    status: HttpStatusCode? = null,
    configure: OutgoingContent.() -> Unit = {}
) {
    respond(TextContent(Json.encodeToString(jsonObject), defaultTextContentType(ContentType.Application.Json), status).apply(configure))
}