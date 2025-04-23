package dev.slne.surf.chestprotect

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import dev.slne.surf.database.DatabaseProvider
import org.bukkit.plugin.java.JavaPlugin

class SurfChestProtectPaper(): SuspendingJavaPlugin() {
    val plugin = JavaPlugin.getPlugin(SurfChestProtectPaper::class.java)

    override suspend fun onEnableAsync() {
        DatabaseProvider(plugin.dataFolder.toPath(), plugin.dataFolder.toPath())
    }
}
