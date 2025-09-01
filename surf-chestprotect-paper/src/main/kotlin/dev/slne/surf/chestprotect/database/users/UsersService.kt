package dev.slne.surf.chestprotect.database.users

import com.github.benmanes.caffeine.cache.Caffeine
import com.sksamuel.aedile.core.asLoadingCache
import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import java.util.*

object UsersService {
    private val userCache = Caffeine.newBuilder()
        .asLoadingCache<UUID, ProtectionUser>() { UsersRepository.getOrCreate(it) }

    suspend fun fetchUsers() {
        userCache.invalidateAll()
        val fetched = UsersRepository.fetchUsers().associateBy { it.uuid }
        for ((uuid, user) in fetched) {
            userCache[uuid] = user
        }
    }


    suspend fun createUser(uuid: UUID) = UsersRepository.createUser(uuid).also { userCache.put(uuid, it) }
    fun existsUser(uuid: UUID) = getUser(uuid) != null
    fun getUser(uuid: UUID): ProtectionUser? = userCache.underlying().getIfPresent(uuid)?.getNow(null)
    suspend fun getOrCreate(uuid: UUID) = userCache.get(uuid)

    suspend fun getAll(uuids: List<UUID>) = userCache.getAll(uuids).values


}