package dev.slne.surf.chestprotect.utils

import com.destroystokyo.paper.MaterialSetTag
import dev.slne.surf.surfapi.bukkit.api.util.key
import org.bukkit.Material
import org.bukkit.block.Block


val protectableBlocks = MaterialSetTag(key("protectable"))
    .add(Material.CHEST, Material.TRAPPED_CHEST, Material.ENDER_CHEST)
    .add { MaterialSetTag.ANVIL.isTagged(it) }
    .add { MaterialSetTag.SHULKER_BOXES.isTagged(it) }
    .add(Material.BARREL)
    .add(Material.ENCHANTING_TABLE)
    .add(Material.BEACON)
    .add(Material.SPAWNER)
    .add(Material.DRAGON_EGG)
    .add(Material.JUKEBOX)
    .add(Material.HOPPER)
    .add(Material.DISPENSER)
    .add(Material.DROPPER)
    .add(Material.FURNACE, Material.BLAST_FURNACE, Material.SMOKER)
    .lock()

fun Material.isProtectable() = protectableBlocks.isTagged(this)
fun Block.isProtecable() = protectableBlocks.isTagged(this)