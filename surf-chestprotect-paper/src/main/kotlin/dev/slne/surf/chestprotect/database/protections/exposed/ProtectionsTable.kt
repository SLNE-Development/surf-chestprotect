package dev.slne.surf.chestprotect.database.protections.exposed

import dev.slne.surf.chestprotect.database.users.exposed.ProtectionUsersTable
import org.jetbrains.exposed.dao.id.LongIdTable
import java.util.*

object ProtectionsTable : LongIdTable("protections") {

    val world = char("world", 36).transform({ UUID.fromString(it) }, { it.toString() })
    val x = double("x")
    val y = double("y")
    val z = double("z")

    val owner = reference("protection_owner_id", ProtectionUsersTable)
}