package dev.slne.surf.chestprotect.dto.group.result

import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.builder.SurfComponentBuilder
import net.kyori.adventure.text.ComponentLike

sealed class GroupMemberRemoveResult(val message: SurfComponentBuilder.() -> Unit) : ComponentLike {
    override fun asComponent() = buildText(message)

    data class Success(val member: ProtectionUser) : GroupMemberRemoveResult({
        success("Der Spieler ")
        append(member)
        success(" wurde erfolgreich aus der Gruppe entfernt.")
    })

    data class NotMember(val member: ProtectionUser) : GroupMemberRemoveResult({
        error("Der Spieler ")
        append(member)
        error(" ist kein Mitglied dieser Gruppe.")
    })
}