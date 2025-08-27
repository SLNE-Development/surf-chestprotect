package dev.slne.surf.chestprotect.database.groups.exposed.members

import dev.slne.surf.chestprotect.database.groups.exposed.GroupsTable
import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUsersTable
import org.jetbrains.exposed.dao.id.LongIdTable

object GroupMembersTable : LongIdTable("group_members") {
    val group = reference("group_id", GroupsTable)
    val member = reference("member_id", ProtectionUsersTable)
}