package me.blueamethyst.packio.backend.config


import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import me.blueamethyst.packio.backend.json
import java.io.File

@Serializable
data class ConfigData(
    val restService: RestConfig,
    val mongoConfig: MongoConfig
)

@Serializable
data class RestConfig(
    val host: String,
    val port: Int
)

@Serializable
data class MongoConfig(
    val host: String,
    val port: Int,
    val database: String,
    val user: String,
    val password: String
)

object Config {
    var config: ConfigData
    private val file = File("backend.json")

    init {
        if (!file.exists()) {
            file.createNewFile()
            file.writeText(json.encodeToString(ConfigData(RestConfig("127.0.0.1", 8080), MongoConfig("127.0.0.1", 27017, "packio", "", ""))))
        }

        config = json.decodeFromString(file.readText())
    }
}