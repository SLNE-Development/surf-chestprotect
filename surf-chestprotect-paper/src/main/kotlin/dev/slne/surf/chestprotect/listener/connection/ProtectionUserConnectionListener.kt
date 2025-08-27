package dev.slne.surf.chestprotect.listener.connection

import dev.slne.surf.chestprotect.database.users.UsersService
import io.papermc.paper.event.connection.configuration.AsyncPlayerConnectionConfigureEvent
import kotlinx.coroutines.runBlocking
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

@Suppress("UnstableApiUsage")
object ProtectionUserConnectionListener : Listener {

    @EventHandler
    fun onAsyncPlayerConnectionConfigure(event: AsyncPlayerConnectionConfigureEvent) {
        val uuid = event.connection.profile.id ?: error("UUID not set")
        if (UsersService.existsUser(uuid)) return

        runBlocking { UsersService.createUser(uuid) }
    }
}