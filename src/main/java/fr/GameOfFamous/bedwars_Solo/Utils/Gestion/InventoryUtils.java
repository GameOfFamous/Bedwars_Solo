package fr.GameOfFamous.bedwars_Solo.Utils.Gestion;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventoryUtils {

    public static void transferItems(Player from, Player to, ItemFilter filter) {
        Inventory fromInventory = from.getInventory();
        Inventory toInventory = to.getInventory();

        // Parcours de l'inventaire du joueur source
        for (ItemStack item : fromInventory.getContents()) {
            if (item != null && filter.shouldTransfer(item)) {
                // Vérifie si l'objet peut être entièrement ajouté à l'inventaire cible
                HashMap<Integer, ItemStack> leftover = toInventory.addItem(item.clone());

                if (leftover.isEmpty()) {
                    // Si tout l'objet a été transféré, on le retire de l'inventaire source
                    fromInventory.remove(item);
                } else {
                    // Si une partie de l'objet ne peut pas être transférée
                    int remainingAmount = leftover.values().iterator().next().getAmount();
                    item.setAmount(remainingAmount);
                }
            }
        }
    }

    /**
     * Interface pour définir quels objets doivent être transférés.
     */
    @FunctionalInterface
    public interface ItemFilter {
        boolean shouldTransfer(ItemStack item);
    }

}
