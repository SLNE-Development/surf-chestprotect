package dev.slne.surf.chestprotect

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import dev.slne.surf.chestprotect.command.chestProtectCommand
import dev.slne.surf.chestprotect.database.DatabaseService
import dev.slne.surf.chestprotect.listener.ChestprotectListenerManager
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(SurfChestProtectPaper::class.java)

class SurfChestProtectPaper : SuspendingJavaPlugin() {

    override suspend fun onLoadAsync() {
        DatabaseService.connect()
    }

    override suspend fun onEnableAsync() {
        ChestprotectListenerManager.registerListener()

        chestProtectCommand()
    }

    override suspend fun onDisableAsync() {
        DatabaseService.disconnect()
    }
}
