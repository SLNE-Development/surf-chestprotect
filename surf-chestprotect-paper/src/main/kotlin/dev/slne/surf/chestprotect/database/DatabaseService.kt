package dev.slne.surf.chestprotect.database

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

object DatabaseService {

    object ProtectionUsers : Table() {
        val id = varchar("id", 36).transform({ UUID.fromString(it) }, { it.toString() })
        val protections = text("protections")
        val notifications = bool("notifications").default(true)
        val autoProtections = bool("autoProtections").default(true)
        val autoMembers = bool("autoMembers").default(false)

        override val primaryKey = PrimaryKey(id)
    }

    object ProtectionGroups : Table() {
        val id = varchar("id", 36).transform({ UUID.fromString(it) }, { it.toString() })
        val owner = varchar("owner", 36).transform({ UUID.fromString(it) }, { it.toString() })
        val members = text("members")
        override val primaryKey = PrimaryKey(id)
    }

    fun createConnection() {
        transaction {
            SchemaUtils.create(ProtectionGroups, ProtectionUsers)
        }
    }
}