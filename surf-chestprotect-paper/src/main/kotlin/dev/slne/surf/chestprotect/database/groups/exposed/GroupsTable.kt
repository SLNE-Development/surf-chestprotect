package dev.slne.surf.chestprotect.database.groups.exposed

import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUsersTable
import org.jetbrains.exposed.dao.id.LongIdTable

object GroupsTable : LongIdTable("groups") {
    val owner = reference("owner_id", ProtectionUsersTable)
    val name = char("group_name", 16)
}