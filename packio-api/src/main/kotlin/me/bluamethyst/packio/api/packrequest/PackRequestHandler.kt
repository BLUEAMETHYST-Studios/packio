package me.bluamethyst.packio.api.packrequest

import me.bluamethyst.packio.api.data.TexturePackRequest
import me.bluamethyst.packio.api.event.TexturePackRequestEvent
import me.blueamethyst.packio.database.PIODatabase
import me.obsilabor.alert.EventManager
import org.litote.kmongo.getCollection

class PackRequestHandler(database: PIODatabase) {
    private val collection = database.mongoDatabase.getCollection<TexturePackRequest>("packio-pack-requests")

    fun requestTexturePack(texturePackRequest: TexturePackRequest) {
        collection.insertOne(texturePackRequest)

        EventManager.callEvent(TexturePackRequestEvent(texturePackRequest))
    }

    fun getRequests(): List<TexturePackRequest> {
        return collection.find().toList<TexturePackRequest>()
    }
}