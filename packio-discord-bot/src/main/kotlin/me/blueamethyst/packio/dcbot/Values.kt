package me.blueamethyst.packio.dcbot

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory

val json = Json {
    prettyPrint = true
}

val mainScope = CoroutineScope(Dispatchers.IO)

val logger = LoggerFactory.getLogger("packio-dcbot")!!