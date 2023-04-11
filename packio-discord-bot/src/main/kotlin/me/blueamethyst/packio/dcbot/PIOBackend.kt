package me.blueamethyst.packio.dcbot

import dev.kord.core.Kord
import me.blueamethyst.packio.dcbot.config.Config

object PIOBackend {

    @JvmStatic
    suspend fun main(args: Array<String>) {
        val kord = Kord(Config.config.token)

        kord.login()
    }
}