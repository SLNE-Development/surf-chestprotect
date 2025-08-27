package dev.slne.surf.chestprotect.database.protections.exposed.members

import dev.slne.surf.chestprotect.database.protections.exposed.ProtectionEntity
import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUserEntity
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ProtectionMemberEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ProtectionMemberEntity>(ProtectionMembersTable)

    val protection by ProtectionEntity referencedOn ProtectionMembersTable.protection
    val member by ProtectionUserEntity referencedOn ProtectionMembersTable.member
}