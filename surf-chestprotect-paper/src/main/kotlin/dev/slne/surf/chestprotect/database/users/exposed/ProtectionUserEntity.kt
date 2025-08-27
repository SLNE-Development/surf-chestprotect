package dev.slne.surf.chestprotect.database.users.exposed

import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ProtectionUserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ProtectionUserEntity>(ProtectionUsersTable)

    var uuid by ProtectionUsersTable.uuid
    var feedback by ProtectionUsersTable.feedback
    var autoProtect by ProtectionUsersTable.autoProtect

    fun toDto() = ProtectionUser(
        uuid = uuid,
        feedback = feedback,
        autoProtect = autoProtect
    )
}