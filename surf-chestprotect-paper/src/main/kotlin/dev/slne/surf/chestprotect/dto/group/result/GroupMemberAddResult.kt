package dev.slne.surf.chestprotect.dto.group.result

import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.builder.SurfComponentBuilder
import net.kyori.adventure.text.ComponentLike

sealed class GroupMemberAddResult(val message: SurfComponentBuilder.() -> Unit) : ComponentLike {
    override fun asComponent() = buildText(message)

    data class Success(val member: ProtectionUser) : GroupMemberAddResult({
        success("Der Spieler ")
        append(member)
        success(" wurde erfolgreich zur Gruppe hinzugefügt.")
    })

    data class AlreadyMember(val member: ProtectionUser) : GroupMemberAddResult({
        error("Der Spieler ")
        append(member)
        error(" ist bereits Mitglied dieser Gruppe.")
    })
}