package me.blueamethyst.packio.backend

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("piobackend")!!

val json = Json {
    prettyPrint = true
}

val mainScope = CoroutineScope(Dispatchers.IO)