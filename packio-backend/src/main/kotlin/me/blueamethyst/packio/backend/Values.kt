package me.blueamethyst.packio.backend

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import me.blueamethyst.packio.backend.config.Config
import me.blueamethyst.packio.database.PIODatabase
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("piobackend")!!

val json = Json {
    prettyPrint = true
}

val mainScope = CoroutineScope(Dispatchers.IO)

val config = Config.config

val database = PIODatabase(config.mongoConfig.host, config.mongoConfig.port, config.mongoConfig.database, config.mongoConfig.user, config.mongoConfig.password)