package dev.slne.surf.chestprotect.database.protections.exposed.members

import dev.slne.surf.chestprotect.database.protections.exposed.ProtectionsTable
import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUsersTable
import org.jetbrains.exposed.dao.id.LongIdTable

object ProtectionMembersTable : LongIdTable("protection_members") {

    val protection = reference("protection_id", ProtectionsTable)
    val member = reference("member_id", ProtectionUsersTable)

}