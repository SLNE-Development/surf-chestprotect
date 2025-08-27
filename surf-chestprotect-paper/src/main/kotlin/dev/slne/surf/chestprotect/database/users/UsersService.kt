package dev.slne.surf.chestprotect.database.users

import com.github.benmanes.caffeine.cache.Caffeine
import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import java.util.*

object UsersService {
    private val userCache = Caffeine.newBuilder()
        .build<UUID, ProtectionUser>()

    suspend fun fetchUsers() {
        userCache.invalidateAll()
        userCache.putAll(UsersRepository.fetchUsers().associateBy { it.uuid })
    }

    suspend fun createUser(uuid: UUID) = UsersRepository.createUser(uuid).also { userCache.put(uuid, it) }
    fun existsUser(uuid: UUID) = userCache.getIfPresent(uuid) != null
    fun getUser(uuid: UUID): ProtectionUser? = userCache.getIfPresent(uuid)

}