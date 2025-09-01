package dev.slne.surf.chestprotect.listener

import dev.slne.surf.chestprotect.utils.isProtecable
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent

class ProtectionHandler : Listener {

    @EventHandler(ignoreCancelled = true)
    fun onBlockPlace(event: BlockPlaceEvent) {
        val player = event.player
        val block = event.block

        if (!block.isProtecable()) return

        // add protection to db
        //check notification setting
        player.sendText {
            success("Du das platzierte Objekt gesichert!")
        }
    }

    @EventHandler(ignoreCancelled = true)
    fun onBlockBreak(event: BlockBreakEvent) {
        val block = event.block
        val player = event.player


        //if player breaks block, check permission, else cancel -> protected

    }


}