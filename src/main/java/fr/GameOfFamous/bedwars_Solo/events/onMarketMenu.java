package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.InventoryUtils;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Menus.MarketMenu;
import fr.GameOfFamous.commons.MarketAccount;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class onMarketMenu implements Listener {

    @EventHandler
    public void onInventory(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
        ItemMeta item = current.getItemMeta();
        Teams team = GameManager.getInstance().returnPlayerTeam(p);
        MarketAccount account = GameManager.getInstance().marketAccounts.get(p);

        if(e.getView().getTitle().equalsIgnoreCase("Market")){
            e.setCancelled(true);

            if(item == null) return;

            switch (item.getDisplayName()){
                case "§bAchat Rapide":
                    MarketMenu.openMarketMenuRapid(p, "Market", team);
                    break;
                case "§bBlocks":
                    MarketMenu.openMarketMenuBlock(p, "Market", team);
                    break;
                case "§bMêlée":
                    MarketMenu.openMarketMenuMele(p, "Market", team);
                    break;
                case "§bArmure":
                    MarketMenu.openMarketMenuArmure(p, "Market", team);
                    break;
                case "§bOutils":
                    MarketMenu.openMarketMenuOutils(p, "Market", team);
                    break;
                case "§bA Distance":
                    MarketMenu.openMarketMenuDistance(p, "Market", team);
                    break;
                case "§bPotions":
                    MarketMenu.openMarketMenuPotions(p, "Market", team);
                    break;
                case "§bUtilitaire":
                    MarketMenu.openMarketMenuUtilitaire(p, "Market", team);
                    break;
                case "§bObjets":
                    MarketMenu.openMarketMenuObjet(p, "Market", team);
                    break;
                case "§cLaine":
                    if (countInventory(p, Material.IRON_INGOT) >= 4){
                        removeItems(p, 4, Material.IRON_INGOT);

                    }
                    break;
            }
        }
    }

    public static void removeItems(Player player, int amount, Material material){
        int remaining = amount;

        for(ItemStack item : player.getInventory().getContents()){
            if(item != null && item.getType() == material){
                int itemAmount = item.getAmount();
                if(itemAmount <= remaining){
                    remaining -= itemAmount;
                    player.getInventory().removeItem(item);
                }else {
                    item.setAmount(itemAmount - remaining);
                    remaining = 0;
                }

                if(remaining <= 0){
                    break;
                }
            }
        }
        player.updateInventory();
    }

    public static int countInventory(Player player, Material material){
        int count = 0;

        for(ItemStack item : player.getInventory()){
            if(item != null && item.getType() == material){
                count += item.getAmount();
            }
        }

        return  count;
    }

}
