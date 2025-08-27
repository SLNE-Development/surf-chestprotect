package dev.slne.surf.chestprotect.dto.group

import dev.slne.surf.chestprotect.dto.group.result.GroupMemberAddResult
import dev.slne.surf.chestprotect.dto.group.result.GroupMemberRemoveResult
import dev.slne.surf.chestprotect.dto.group.result.GroupRenameResult
import dev.slne.surf.chestprotect.dto.protection.Protection
import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.util.freeze
import dev.slne.surf.surfapi.core.api.util.mutableObjectSetOf
import it.unimi.dsi.fastutil.objects.ObjectSet
import net.kyori.adventure.text.ComponentLike

class ProtectionGroup(
    val protection: Protection,
    val owner: ProtectionUser,
    name: String,
    members: ObjectSet<ProtectionUser>
) : ComponentLike {
    private val _members = mutableObjectSetOf<ProtectionUser>(members)
    val members get() = _members.freeze()

    var name: String = name
        private set

    suspend fun addMember(member: ProtectionUser): GroupMemberAddResult {
        if (_members.contains(member)) {
            return GroupMemberAddResult.AlreadyMember(member)
        }

        // TODO: Db operations

        return GroupMemberAddResult.Success(member)
    }

    suspend fun removeUser(member: ProtectionUser): GroupMemberRemoveResult {
        if (!_members.contains(member)) {
            return GroupMemberRemoveResult.NotMember(member)
        }

        // TODO: Db operations

        return GroupMemberRemoveResult.Success(member)
    }

    suspend fun renameGroup(name: String): GroupRenameResult {
        if (protection.groups.any { it.name == name }) {
            return GroupRenameResult.GroupWithNameAlreadyExists(this, name)
        }

        this.name = name

        // DB Operations

        return GroupRenameResult.Success(this)
    }

    override fun asComponent() = buildText {
        variableValue(name)

        hoverEvent(buildText {

        })
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProtectionGroup

        if (owner != other.owner) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = owner.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}