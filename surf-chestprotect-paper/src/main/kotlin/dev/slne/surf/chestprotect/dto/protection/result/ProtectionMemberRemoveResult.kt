package dev.slne.surf.chestprotect.dto.protection.result

import dev.slne.surf.chestprotect.dto.user.ProtectionUser
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.builder.SurfComponentBuilder
import net.kyori.adventure.text.ComponentLike

sealed class ProtectionMemberRemoveResult(val message: SurfComponentBuilder.() -> Unit) : ComponentLike {
    override fun asComponent() = buildText(message)

    data class Success(val member: ProtectionUser) : ProtectionMemberRemoveResult({
        success("Der Spieler ")
        append(member)
        success(" wurde erfolgreich aus der Sicherung entfernt.")
    })

    data class NotMember(val member: ProtectionUser) : ProtectionMemberRemoveResult({
        error("Der Spieler ")
        append(member)
        error(" ist kein Mitglied dieser Sicherung.")
    })
}
