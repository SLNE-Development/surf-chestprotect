package dev.slne.surf.chestprotect.database

import dev.slne.surf.chestprotect.database.groups.exposed.GroupsTable
import dev.slne.surf.chestprotect.database.groups.exposed.members.GroupMembersTable
import dev.slne.surf.chestprotect.database.protections.exposed.ProtectionsTable
import dev.slne.surf.chestprotect.database.protections.exposed.groups.ProtectionGroupsTable
import dev.slne.surf.chestprotect.database.protections.exposed.members.ProtectionMembersTable
import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUsersTable
import dev.slne.surf.chestprotect.plugin
import dev.slne.surf.database.DatabaseManager
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import kotlin.io.path.div

object DatabaseService {

    private val databaseManager = DatabaseManager(plugin.dataPath, plugin.dataPath / "storage")

    suspend fun connect() {
        databaseManager.databaseProvider.connect()

        newSuspendedTransaction {
            SchemaUtils.create(
                GroupMembersTable,
                GroupsTable,
                ProtectionGroupsTable,
                ProtectionMembersTable,
                ProtectionsTable,
                ProtectionUsersTable
            )
        }
    }

    fun disconnect() {
        databaseManager.databaseProvider.disconnect()
    }
}