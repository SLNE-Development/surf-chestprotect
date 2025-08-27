package dev.slne.surf.chestprotect.dto.protection

import dev.slne.surf.chestprotect.dto.group.ProtectionGroup
import dev.slne.surf.chestprotect.dto.protection.result.ProtectionGroupAddResult
import dev.slne.surf.chestprotect.dto.protection.result.ProtectionGroupRemoveResult
import dev.slne.surf.chestprotect.dto.protection.result.ProtectionMemberAddResult
import dev.slne.surf.chestprotect.dto.protection.result.ProtectionMemberRemoveResult
import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import dev.slne.surf.surfapi.core.api.util.freeze
import dev.slne.surf.surfapi.core.api.util.mutableObjectSetOf
import it.unimi.dsi.fastutil.objects.ObjectSet
import org.bukkit.Location

class Protection(
    val location: Location,
    members: ObjectSet<ProtectionUser>,
    groups: ObjectSet<ProtectionGroup>
) {
    private val _members = mutableObjectSetOf<ProtectionUser>(members)
    val members get() = _members.freeze()

    private val _groups = mutableObjectSetOf<ProtectionGroup>(groups)
    val groups get() = _groups.freeze()

    suspend fun addGroup(group: ProtectionGroup): ProtectionGroupAddResult {
        if (_groups.contains(group)) {
            return ProtectionGroupAddResult.GroupAlreadyExists(group)
        }

        // DB Operations

        _groups.add(group)

        return ProtectionGroupAddResult.Success(group)
    }

    suspend fun removeGroup(group: ProtectionGroup): ProtectionGroupRemoveResult {
        if (!_groups.contains(group)) {
            return ProtectionGroupRemoveResult.GroupDoesNotExist(group)
        }

        // DB Operations

        _groups.remove(group)

        return ProtectionGroupRemoveResult.Success(group)
    }

    suspend fun addMember(member: ProtectionUser): ProtectionMemberAddResult {
        if (!_members.contains(member)) {
            return ProtectionMemberAddResult.AlreadyMember(member)
        }

        // DB Operations

        _members.add(member)

        return ProtectionMemberAddResult.Success(member)
    }

    suspend fun removeMember(member: ProtectionUser): ProtectionMemberRemoveResult {
        if (!_members.contains(member)) {
            return ProtectionMemberRemoveResult.NotMember(member)
        }

        // DB Operations

        _members.remove(member)

        return ProtectionMemberRemoveResult.Success(member)
    }
}