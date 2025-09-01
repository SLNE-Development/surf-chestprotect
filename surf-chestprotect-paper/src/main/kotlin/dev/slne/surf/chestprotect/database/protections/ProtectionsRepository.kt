package dev.slne.surf.chestprotect.database.protections

import dev.slne.surf.chestprotect.database.protections.exposed.ProtectionEntity
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object ProtectionsRepository {

    suspend fun fetchProtections() = newSuspendedTransaction(Dispatchers.IO) { ProtectionEntity }
}