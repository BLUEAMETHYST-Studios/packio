package me.blueamethyst.packio.backend

import me.blueamethyst.packio.backend.database.MongoAdapter

object PIOBackend {

    val mongoAdapter = MongoAdapter()

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("starting piobackend...")

        mongoAdapter.startup()
    }
}