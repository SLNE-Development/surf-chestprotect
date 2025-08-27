package dev.slne.surf.chestprotect.command

import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.slne.surf.chestprotect.command.utils.PermissionRegistry
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText

fun chestProtectCommand() = commandAPICommand("chestprotect") {
    withPermission(PermissionRegistry.BASE)
    withAliases("cp")

    anyExecutor { sender, args ->
        sender.sendText {
            appendPrefix()

            info("No.")
        }
    }
}