package dev.slne.surf.chestprotect.database.protections.exposed.groups

import dev.slne.surf.chestprotect.database.groups.exposed.GroupsTable
import dev.slne.surf.chestprotect.database.protections.exposed.ProtectionsTable
import org.jetbrains.exposed.dao.id.LongIdTable

object ProtectionGroupsTable : LongIdTable("protection_groups") {

    val protection = reference("protection_id", ProtectionsTable)
    val group = reference("group_id", GroupsTable)
}