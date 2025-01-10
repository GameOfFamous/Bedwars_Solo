package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SetPlayerStuff;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Menus.MarketMenu;
import fr.GameOfFamous.commons.MarketAccount;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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
        MarketAccount marketAccount = GameManager.getInstance().marketAccounts.get(p);

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
                    processPurchase(p, Material.IRON_INGOT, 4, CreateItem.newItemBedwars(team.getWool(), 16, false), 16);
                    break;
                case "§cArgile durcie":
                    processPurchase(p, Material.IRON_INGOT, 12, CreateItem.newItemBedwars(Material.TERRACOTTA, 16, false), 16);
                    break;
                case "§cVerre anti Explosions":
                    processPurchase(p, Material.IRON_INGOT, 12, CreateItem.newItemBedwars(Material.GLASS, 4, false), 4);
                    break;
                case "§cPierre de l'end":
                    processPurchase(p, Material.IRON_INGOT, 24, CreateItem.newItemBedwars(Material.END_STONE, 12, false), 12);
                    break;
                case "§cEchelle":
                    processPurchase(p, Material.IRON_INGOT, 4, CreateItem.newItemBedwars(Material.LADDER, 8, false), 8);
                    break;
                case "§cPlanches de Chêne":
                    processPurchase(p, Material.GOLD_INGOT, 4, CreateItem.newItemBedwars(Material.OAK_PLANKS, 16, false), 16);
                    break;
                case "§cObsidienne":
                    processPurchase(p, Material.EMERALD, 4, CreateItem.newItemBedwars(Material.OBSIDIAN, 4, false), 4);
                    break;
                case "§cEpée en Pierre":
                    if(!(marketAccount.getSword() == 1)){
                        if(countInventory(p, Material.IRON_INGOT) >= 10){
                            marketAccount.setSword(1);
                            removeItems(p, 10, Material.IRON_INGOT);
                            SetPlayerStuff.setPlayerSword(p);
                        }
                    }
                    break;
                case "§cEpée en fer":
                    if (!(marketAccount.getSword() == 2)){
                        if(countInventory(p, Material.GOLD_INGOT) >= 7){
                            marketAccount.setSword(2);
                            removeItems(p, 7, Material.GOLD_INGOT);
                            SetPlayerStuff.setPlayerSword(p);
                        }
                    }
                    break;
                case "§cEpée en Diamant":
                    if(!(marketAccount.getSword() == 3)){
                        if(countInventory(p, Material.EMERALD) >= 4){
                            marketAccount.setSword(3);
                            removeItems(p, 4, Material.EMERALD);
                            SetPlayerStuff.setPlayerSword(p);
                        }
                    }
                    break;
                case "§cEjector":
                    processPurchase(p, Material.GOLD_INGOT, 5, CreateItem.newItemCustomBedwars(Material.STICK, "§cEjector", Enchantment.KNOCKBACK, 1), 1);
                    break;
                case "§cArmure en cotte de mailles":
                    if(!(marketAccount.getArmor() == 1)){
                        if(countInventory(p, Material.IRON_INGOT) >= 24){
                            marketAccount.setArmor(1);
                            removeItems(p, 24, Material.IRON_INGOT);
                            SetPlayerStuff.setPlayerArmor(p);
                        }
                    }
                    break;
                case "§cArmure en fer":
                    if(!(marketAccount.getArmor() == 2)){
                        if(countInventory(p, Material.GOLD_INGOT) >= 12){
                            marketAccount.setArmor(2);
                            removeItems(p, 12, Material.GOLD_INGOT);
                            SetPlayerStuff.setPlayerArmor(p);
                        }
                    }
                    break;
                case "§cArmure en diamant":
                    if(!(marketAccount.getArmor() == 3)){
                        if(countInventory(p, Material.EMERALD) >= 6){
                            marketAccount.setArmor(3);
                            removeItems(p, 6, Material.EMERALD);
                            SetPlayerStuff.setPlayerArmor(p);
                        }
                    }
                    break;
            }
        }
    }

    public static void processPurchase(Player player, Material currency, int cost, ItemStack item, int quantity) {
        if (countInventory(player, currency) >= cost) {
            if(hasEnoughSpace(player, item, quantity)){
                removeItems(player, cost, currency);
                player.getInventory().addItem(item);
            }else {
                player.sendMessage("§cVous n'avez pas assez de place dans votre inventaire !");
            }
        } else {
            player.sendMessage("§cVous n'avez pas assez pour acheter cet item !");
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

    public static boolean hasEnoughSpace(Player player, ItemStack item, int quantity) {
        int remainingQuantity = quantity;

        for (ItemStack inventoryItem : player.getInventory().getStorageContents()) {
            if (inventoryItem == null) {
                // Slot vide, peut contenir une pile entière
                remainingQuantity -= item.getMaxStackSize();
            } else if (inventoryItem.isSimilar(item)) {
                // Slot contenant le même type d'item
                remainingQuantity -= (item.getMaxStackSize() - inventoryItem.getAmount());
            }

            if (remainingQuantity <= 0) {
                return true; // Assez d'espace trouvé
            }
        }

        return false; // Pas assez d'espace
    }

}
