package dev.slne.surf.chestprotect.database.protections.exposed.groups

import dev.slne.surf.chestprotect.database.groups.exposed.GroupEntity
import dev.slne.surf.chestprotect.database.protections.exposed.ProtectionEntity
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ProtectionGroupEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ProtectionGroupEntity>(ProtectionGroupsTable)

    val protection by ProtectionEntity referencedOn ProtectionGroupsTable.protection
    val group by GroupEntity referencedOn ProtectionGroupsTable.group
}
