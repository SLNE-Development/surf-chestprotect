package dev.slne.surf.chestprotect.command.utils

import dev.slne.surf.surfapi.bukkit.api.permission.PermissionRegistry

object PermissionRegistry : PermissionRegistry() {

    private const val PREFIX = "surf.chestprotect"
    private const val COMMAND_PREFIX = "$PREFIX.command"

    val BASE = create("$COMMAND_PREFIX.base")

}