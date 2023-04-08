package me.bluamethyst.packio.api

import me.bluamethyst.packio.api.packrequest.PackRequestHandler
import me.blueamethyst.packio.database.PIODatabase

class PIOApi(
    val pioDatabase: PIODatabase
) {

    fun getPackRequestHandler(): PackRequestHandler = PackRequestHandler(pioDatabase)
}