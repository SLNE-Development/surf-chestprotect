package dev.slne.surf.chestprotect.database.groups.exposed.members

import dev.slne.surf.chestprotect.database.groups.exposed.GroupEntity
import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUserEntity
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class GroupMemberEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<GroupMemberEntity>(GroupMembersTable)

    val group by GroupEntity referencedOn GroupMembersTable.group
    val member by ProtectionUserEntity referencedOn GroupMembersTable.member
}