package dev.slne.surf.chestprotect.command

import dev.jorel.commandapi.CommandAPICommand

class ChestProtectCommand(commandName: String): CommandAPICommand(commandName) {
    init {
        withPermission("surf.chestprotect.command.chestprotect")
        withAliases("chestprotect", "cp")
    }
}