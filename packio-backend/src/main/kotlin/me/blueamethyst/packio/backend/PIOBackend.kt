package me.blueamethyst.packio.backend

import me.blueamethyst.packio.backend.rest.RestApplication

object PIOBackend {

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info("starting piobackend...")

        RestApplication.init(host = config.restService.host, servicePort = config.restService.port)

        logger.info("Database: ${database.host}:${database.port}")
    }
}