package dev.slne.surf.chestprotect.listener

import dev.slne.surf.chestprotect.listener.connection.ProtectionUserConnectionListener
import dev.slne.surf.surfapi.bukkit.api.event.register

object ChestProtectListenerManager {

    fun registerListener() {
        ProtectionUserConnectionListener.register()
    }
}