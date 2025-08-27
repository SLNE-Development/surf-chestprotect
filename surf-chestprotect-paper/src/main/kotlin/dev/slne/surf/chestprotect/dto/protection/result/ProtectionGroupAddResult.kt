package dev.slne.surf.chestprotect.dto.protection.result

import dev.slne.surf.chestprotect.dto.group.ProtectionGroup
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.builder.SurfComponentBuilder
import net.kyori.adventure.text.ComponentLike

sealed class ProtectionGroupAddResult(val message: SurfComponentBuilder.() -> Unit) : ComponentLike {
    override fun asComponent() = buildText(message)

    data class Success(val group: ProtectionGroup) : ProtectionGroupAddResult({
        success("Die Gruppe")
        append(group)
        success(" wurde erfolgreich zur Sicherung hinzugefügt.")
    })

    data class GroupAlreadyExists(val group: ProtectionGroup) : ProtectionGroupAddResult({
        error("Die Gruppe ")
        append(group)
        error(" wurde bereits zur Sicherung hinzugefügt.")
    })
}