package dev.slne.surf.chestprotect.database.protections.exposed

import dev.slne.surf.chestprotect.database.protections.exposed.members.ProtectionMemberEntity
import dev.slne.surf.chestprotect.database.protections.exposed.members.ProtectionMembersTable
import dev.slne.surf.chestprotect.database.users.UsersService
import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUserEntity
import dev.slne.surf.chestprotect.dto.protection.Protection
import dev.slne.surf.surfapi.bukkit.api.extensions.server
import org.bukkit.Location
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ProtectionEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ProtectionEntity>(ProtectionsTable)

    var world by ProtectionsTable.world
    var x by ProtectionsTable.x
    var y by ProtectionsTable.y
    var z by ProtectionsTable.z

    var location: Location
        get() {
            val bukkitWorld =
                server.getWorld(world) ?: error("World '$world' not found for entry $this.")

            return Location(bukkitWorld, x, y, z)
        }
        set(value) {
            world = value.world.uid
            x = value.x
            y = value.y
            z = value.z
        }

    val owner by ProtectionUserEntity referencedOn ProtectionsTable.owner
    val members by ProtectionMemberEntity referrersOn ProtectionMembersTable.protection

    suspend fun toDto() = Protection(
        location = location,
        members = members.map { UsersService.getOrCreate(it.member.uuid) },
        groups = 
    )
}