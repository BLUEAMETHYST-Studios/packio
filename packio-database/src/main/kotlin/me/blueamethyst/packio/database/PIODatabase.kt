package me.blueamethyst.packio.database

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.serialization.SerializationClassMappingTypeService

// DatabaseConnector by <a href="#{@JulixnDev}">{@https://github.com/JulixnDev}</a>

class PIODatabase(
    val host: String,
    val port: Int,
    val database: String,
    val user: String,
    val password: String
) {
    private lateinit var client: MongoClient
    lateinit var mongoDatabase: MongoDatabase

    fun connect() {
        System.setProperty(
            "org.litote.mongo.mapping.service",
            SerializationClassMappingTypeService::class.qualifiedName!!
        )
        val authString: String = if (user != "") {
            if (password != "")
                "$user:$password@"
            else
                "$user@"
        } else
            ""

        val authMethod = if (authString != "")
            "?authMechanism=DEFAULT"
        else ""
        client = KMongo.createClient("mongodb://$authString${host}:${port}/$authMethod")
        mongoDatabase = client.getDatabase(database)
    }

    fun disconnect() {
        client.close()
    }
}