package dev.slne.surf.chestprotect.database.groups.exposed

import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUserEntity
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class GroupEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<GroupEntity>(GroupsTable)

    var name by GroupsTable.name

    val owner by ProtectionUserEntity referencedOn GroupsTable.owner
}