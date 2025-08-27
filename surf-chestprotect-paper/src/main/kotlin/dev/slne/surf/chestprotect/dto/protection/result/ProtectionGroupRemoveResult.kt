package dev.slne.surf.chestprotect.dto.protection.result

import dev.slne.surf.chestprotect.dto.group.ProtectionGroup
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.builder.SurfComponentBuilder
import net.kyori.adventure.text.ComponentLike

sealed class ProtectionGroupRemoveResult(val message: SurfComponentBuilder.() -> Unit) : ComponentLike {
    override fun asComponent() = buildText(message)

    data class Success(val group: ProtectionGroup) : ProtectionGroupRemoveResult({
        success("Die Gruppe")
        append(group)
        success(" wurde erfolgreich aus der Sicherung entfernt.")
    })

    data class GroupDoesNotExist(val group: ProtectionGroup) : ProtectionGroupRemoveResult({
        error("Die Gruppe ")
        append(group)
        error(" ist nicht zur Sicherung hinzugefügt.")
    })
}