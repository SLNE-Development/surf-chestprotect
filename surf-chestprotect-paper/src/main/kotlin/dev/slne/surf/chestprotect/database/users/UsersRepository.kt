package dev.slne.surf.chestprotect.database.users

import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUserEntity
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
}