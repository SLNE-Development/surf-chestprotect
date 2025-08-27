package dev.slne.surf.chestprotect.dto.group.result

import dev.slne.surf.chestprotect.dto.group.ProtectionGroup
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.builder.SurfComponentBuilder
import net.kyori.adventure.text.ComponentLike

sealed class GroupRenameResult(val message: SurfComponentBuilder.() -> Unit) : ComponentLike {
    override fun asComponent() = buildText(message)

    data class Success(val group: ProtectionGroup) : GroupRenameResult({
        success("Die Gruppe ")
        append(group)
        success(" wurde erfolgreich umbenannt.")
    })

    data class GroupWithNameAlreadyExists(val group: ProtectionGroup, val name: String) : GroupRenameResult({
        error("Die Gruppe ")
        append(group)
        error(" kann nicht umbenannt werden, da bereits eine andere Gruppe mit dem Namen ")
        variableValue(name)
        error(" existiert.")
    })
}