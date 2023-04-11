package me.blueamethyst.packio.dcbot

import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import kotlinx.coroutines.launch
import me.blueamethyst.packio.database.PIODatabase
import me.blueamethyst.packio.dcbot.config.Config

lateinit var database: PIODatabase

suspend fun main() {
    with(Config.config) {
        database = PIODatabase(mongoConfig.host, mongoConfig.port, mongoConfig.database, mongoConfig.user, mongoConfig.password)
    }

    val kord = Kord(Config.config.token)
    mainScope.launch {
        kord.login {
            @OptIn(PrivilegedIntent::class)
            intents += Intent.MessageContent
        }
    }
    kord.editPresence { status = PresenceStatus.DoNotDisturb }
}