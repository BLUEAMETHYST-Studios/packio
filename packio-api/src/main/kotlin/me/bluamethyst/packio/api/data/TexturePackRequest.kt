package me.bluamethyst.packio.api.data

import kotlinx.serialization.Serializable

@Serializable
data class TexturePackRequest(
    val discordUserId: Long,
    val packName: String,
    val packDescription: String,
    val packLink: String,
    val packTags: List<String>,
    val packCredits: List<String>
)
