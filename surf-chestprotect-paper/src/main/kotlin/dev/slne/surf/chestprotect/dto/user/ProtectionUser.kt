package dev.slne.surf.chestprotect.dto.user

import dev.slne.surf.chestprotect.database.users.UsersService
import dev.slne.surf.surfapi.bukkit.api.extensions.server
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import net.kyori.adventure.text.ComponentLike
import org.bukkit.entity.Player
import java.util.*

open class ProtectionUser(
    val uuid: UUID,
    feedback: Boolean,
    autoProtect: Boolean
) : ComponentLike {

    private val lock = Mutex()

    var feedback = feedback
        private set

    var autoProtect = autoProtect
        private set

    val username: String?
        get() = server.getOfflinePlayer(uuid).name

    suspend fun updateSettings(
        feedback: Boolean = this.feedback,
        autoProtect: Boolean = this.autoProtect
    ) = lock.withLock {
        // DB Operations

        this.feedback = feedback
        this.autoProtect = autoProtect
    }

    override fun asComponent() = buildText {
        variableValue(username ?: uuid.toString())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProtectionUser

        return uuid == other.uuid
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }

    companion object {
        operator fun get(uuid: UUID) = UsersService.getUser(uuid)
        operator fun get(player: Player) =
            UsersService.getUser(player.uniqueId) ?: error("Protection user not found: $player")
    }
}