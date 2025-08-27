package dev.slne.surf.chestprotect.utils

import org.bukkit.Material

enum class ProtectableBlocks(val container: Material) {

    CHEST(Material.CHEST),
    TRAPPED_CHEST(Material.TRAPPED_CHEST),
    ENDER_CHEST(Material.ENDER_CHEST),

    ANVIL(Material.ANVIL),
    CHIPPED_ANVIL(Material.CHIPPED_ANVIL),
    DAMAGED_ANVIL(Material.DAMAGED_ANVIL),

    BARREL(Material.BARREL),
    ENCHANTMENT_TABLE(Material.ENCHANTING_TABLE),
    BEACON(Material.BEACON),
    SPAWNER(Material.SPAWNER),
    DRAGON_EGG(Material.DRAGON_EGG),
    JUKEBOX(Material.JUKEBOX),

    HOPPER(Material.HOPPER),
    DISPENSER(Material.DISPENSER),
    DROPPER(Material.DROPPER),

    FURNACE(Material.FURNACE),
    BLAST_FURNACE(Material.BLAST_FURNACE),
    SMOKER_FURNACE(Material.SMOKER),

    SHULKER_BOX(Material.SHULKER_BOX),
    WHITE_SHULKER_BOX(Material.WHITE_SHULKER_BOX),
    ORANGE_SHULKER_BOX(Material.ORANGE_SHULKER_BOX),
    MAGENTA_SHULKER_BOX(Material.MAGENTA_SHULKER_BOX),
    LIGHT_BLUE_SHULKER_BOX(Material.LIGHT_BLUE_SHULKER_BOX),
    YELLOW_SHULKER_BOX(Material.YELLOW_SHULKER_BOX),
    LIME_SHULKER_BOX(Material.LIME_SHULKER_BOX),
    PINK_SHULKER_BOX(Material.PINK_SHULKER_BOX),
    GRAY_SHULKER_BOX(Material.GRAY_SHULKER_BOX),
    LIGHT_GRAY_SHULKER_BOX(Material.LIGHT_GRAY_SHULKER_BOX),
    CYAN_SHULKER_BOX(Material.CYAN_SHULKER_BOX),
    PURPLE_SHULKER_BOX(Material.PURPLE_SHULKER_BOX),
    BLUE_SHULKER_BOX(Material.BLUE_SHULKER_BOX),
    BROWN_SHULKER_BOX(Material.BROWN_SHULKER_BOX),
    GREEN_SHULKER_BOX(Material.GREEN_SHULKER_BOX),
    RED_SHULKER_BOX(Material.RED_SHULKER_BOX),
    BLACK_SHULKER_BOX(Material.BLACK_SHULKER_BOX);

    companion object {
        fun isProtectable(material: Material): Boolean {
            return entries.any { it.container == material }
        }
    }
}