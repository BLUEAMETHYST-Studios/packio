package me.bluamethyst.packio.api.event

import me.bluamethyst.packio.api.data.TexturePackRequest
import me.obsilabor.alert.Event

class TexturePackRequestEvent(val request: TexturePackRequest): Event()