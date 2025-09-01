package dev.slne.surf.chestprotect.database.users

import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUserEntity
import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUsersTable
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.util.*

object UsersRepository {
    suspend fun fetchUsers() = newSuspendedTransaction(Dispatchers.IO) { ProtectionUserEntity.all().map { it.toDto() } }

    suspend fun createUser(uuid: UUID) = newSuspendedTransaction(Dispatchers.IO) {
        ProtectionUserEntity.new {
            this.uuid = uuid
        }.toDto()
    }

    suspend fun findByUuid(uuid: UUID) = newSuspendedTransaction(Dispatchers.IO) {
        ProtectionUserEntity.find { ProtectionUsersTable.uuid eq uuid }.singleOrNull()?.toDto()
    }
    
    suspend fun getOrCreate(uuid: UUID) = newSuspendedTransaction(Dispatchers.IO) {
        findByUuid(uuid) ?: createUser(uuid)
    }
}