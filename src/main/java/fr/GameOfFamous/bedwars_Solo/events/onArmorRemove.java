package fr.GameOfFamous.bedwars_Solo.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class onArmorRemove implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (e.getWhoClicked().getType() != org.bukkit.entity.EntityType.PLAYER) return;

        // Vérifie si l'action concerne l'armure
        if (e.getSlotType() == InventoryType.SlotType.ARMOR) {
            ItemStack currentItem = e.getCurrentItem();

            // Si l'emplacement contient une pièce d'armure
            if (currentItem != null && isArmor(currentItem)) {
                // Annule l'événement pour empêcher le retrait
                e.setCancelled(true);
            }
        }
    }
        private boolean isArmor(ItemStack item) {
            Material type = item.getType();
            return type.name().endsWith("_HELMET") ||
                    type.name().endsWith("_CHESTPLATE") ||
                    type.name().endsWith("_LEGGINGS") ||
                    type.name().endsWith("_BOOTS");
        }

}
