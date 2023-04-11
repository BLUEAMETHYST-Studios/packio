package me.blueamethyst.packio.dcbot.config

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import me.blueamethyst.packio.dcbot.json
import java.io.File

@Serializable
data class ConfigData(
    val token: String,
    val mongoConfig: MongoConfig
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
    private val file = File("config.json")

    init {
        if (!file.exists()) {
            file.createNewFile()
            file.writeText(json.encodeToString(ConfigData("token", MongoConfig("127.0.0.1", 27017, "packio", "", ""))))
        }

        config = json.decodeFromString(file.readText())
    }
}