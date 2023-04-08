package me.blueamethyst.packio.backend.database

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import me.blueamethyst.packio.backend.json
import java.io.File

class MongoConfiguration {

    lateinit var config: MongoConfig

    init {
        val file = File("mongo.json")

        if (!file.parentFile.exists()) file.parentFile.mkdirs()
        if (!file.exists()) {
            file.createNewFile()
            file.writeText(json.encodeToString(MongoConfig("127.0.0.1", 27017, "pio-backend", "", "")))

            config = json.decodeFromString<MongoConfig>(file.readText())
        }
    }

    @Serializable
    data class MongoConfig(
        val host: String,
        val port: Int,
        val database: String,
        val user: String,
        val password: String
    )
}