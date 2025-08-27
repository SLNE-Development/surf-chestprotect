package dev.slne.surf.chestprotect.database.users.exposed

import org.jetbrains.exposed.dao.id.LongIdTable
import java.util.*

object ProtectionUsersTable : LongIdTable("protection_users") {
    val uuid = char("player_uuid", 36).transform({ UUID.fromString(it) }, { it.toString() })

    val feedback = bool("feedback").default(true)
    val autoProtect = bool("auto_protect").default(true)
}