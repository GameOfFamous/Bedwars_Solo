package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SetPlayerStuff;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Menus.UpgradeMenu;
import fr.GameOfFamous.commons.TeamAccount;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class onUpgradeMenu implements Listener {

    @EventHandler
    public void onInventory(InventoryClickEvent e){

        if(GameManager.getInstance().gameState != GameState.IN_GAME){
            return;
        }

        Player p = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
        Teams team = GameManager.getInstance().returnPlayerTeam(p);
        TeamAccount account = GameManager.getInstance().teamAccounts.get(team);

        if(current == null)return;

        if(e.getView().getTitle().equalsIgnoreCase("Upgrade")){
            e.setCancelled(true);

            switch (current.getType()){
                case DIAMOND_SWORD:
                    if(!account.isSharpness()){
                        if(countInventory(p) >= 4){
                            processPurchase(p, 4);
                            account.setSharpness(true);
                            SetPlayerStuff.setPlayerSword(p);
                            p.closeInventory();
                            UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                        }
                    }
                    break;
                case DIAMOND_CHESTPLATE:
                    upgradeProtection(p, team, account);
                    break;
                case GOLDEN_PICKAXE:
                    upgradeHast(p, team, account);
                    break;
                case IRON_INGOT:
                    upgradeForge(p, team, account);
                    break;
                case CAULDRON:
                    if(!account.isHealPool()){
                        if(countInventory(p) >= 2){
                            processPurchase(p, 2);
                            account.setHealPool(true);
                            p.closeInventory();
                            UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                        }
                    }
                    break;
                case BREWING_STAND:
                    if(!account.isSpeedPool()){
                        if(countInventory(p) >= 2){
                            processPurchase(p, 2);
                            account.setSpeedPool(true);
                            p.closeInventory();
                            UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                        }
                    }
                    break;
                case CHAIN:
                    if(!account.isTrapSlowness()){
                        if(countInventory(p) >= 2){
                            processPurchase(p, 2);
                            account.setTrapSlowness(true);
                            p.closeInventory();
                            UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                        }
                    }
                    break;
                case FIREWORK_STAR:
                    if(!account.isTrapBlindness()){
                        if(countInventory(p) >= 2){
                            processPurchase(p, 2);
                            account.setTrapBlindness(true);
                            p.closeInventory();
                            UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                        }
                    }
                    break;
                case WOODEN_SWORD:
                    if(!account.isTrapMiningFatigue()){
                        if(countInventory(p) >= 2){
                            processPurchase(p, 2);
                            account.setTrapMiningFatigue(true);
                            p.closeInventory();
                            UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                        }
                    }
                    break;
                case REDSTONE_TORCH:
                    if(!account.isAlarmTrap()){
                        if(countInventory(p) >= 2){
                            processPurchase(p, 2);
                            account.setAlarmTrap(true);
                            p.closeInventory();
                            UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                        }
                    }
                    break;
                case BARRIER:
                    p.closeInventory();
                    break;
            }
        }

    }

    private void processPurchase(Player player, int cost) {
        if (countInventory(player) >= cost) {
            removeItems(player, cost);
        } else {
            player.sendMessage("§cVous n'avez pas assez pour acheter cet item !");
        }
    }

    private void removeItems(Player player, int amount){
        int remaining = amount;

        for(ItemStack item : player.getInventory().getContents()){
            if(item != null && item.getType() == Material.DIAMOND){
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

    private int countInventory(Player player){
        int count = 0;

        for(ItemStack item : player.getInventory()){
            if(item != null && item.getType() == Material.DIAMOND){
                count += item.getAmount();
            }
        }

        return  count;
    }

    private void upgradeProtection(Player p, Teams team, TeamAccount account){
        switch(account.getProtection()){
            case 0:
                if(countInventory(p) >= 2) {
                    processPurchase(p, 2);
                    account.setProtection(account.getProtection() + 1);
                    SetPlayerStuff.setPlayerArmor(p);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 1:
                if(countInventory(p) >= 4) {
                    processPurchase(p, 4);
                    account.setProtection(account.getProtection() + 1);
                    SetPlayerStuff.setPlayerArmor(p);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 2:
                if(countInventory(p) >= 8) {
                    processPurchase(p, 8);
                    account.setProtection(account.getProtection() + 1);
                    SetPlayerStuff.setPlayerArmor(p);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 3:
                if(countInventory(p) >= 16) {
                    processPurchase(p, 16);
                    account.setProtection(account.getProtection() + 1);
                    SetPlayerStuff.setPlayerArmor(p);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 4:
                p.sendMessage(ChatColor.RED + "Vous avez déja l'amélioration maximum !");
                break;
        }
    }

    private void upgradeHast(Player p, Teams team, TeamAccount account){
        switch (account.getHast()){
            case 0:
                if(countInventory(p) >= 2){
                    processPurchase(p, 2);
                    account.setHast(account.getHast() + 1);
                    p.removePotionEffect(PotionEffectType.FAST_DIGGING);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 1:
                if(countInventory(p) >= 4){
                    processPurchase(p, 4);
                    account.setHast(account.getHast() + 1);
                    p.removePotionEffect(PotionEffectType.FAST_DIGGING);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1));
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 2:
                p.sendMessage(ChatColor.RED + "Vous avez déja l'amélioration maximum !");
                break;
        }
    }

    private void upgradeForge(Player p, Teams team, TeamAccount account){
        switch (account.getForge()){
            case 0:
                if(countInventory(p) >= 2){
                    processPurchase(p, 2);
                    account.setForge(account.getForge() + 1);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 1:
                if(countInventory(p) >= 4){
                    processPurchase(p, 4);
                    account.setForge(account.getForge() + 1);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 2:
                if(countInventory(p) >= 6){
                    processPurchase(p, 6);
                    account.setForge(account.getForge() + 1);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 3:
                if(countInventory(p) >= 8){
                    processPurchase(p, 8);
                    account.setForge(account.getForge() + 1);
                    p.closeInventory();
                    UpgradeMenu.openUpgradeMenu(p, "Upgrade", team);
                }
                break;
            case 4:
                p.sendMessage(ChatColor.RED + "Vous avez déja l'amélioration maximum !");
                break;
        }
    }

}
