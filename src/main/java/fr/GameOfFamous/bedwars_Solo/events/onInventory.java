package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SetPlayerStuff;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Menus.NPCMenu;
import fr.GameOfFamous.commons.TeamAccount;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class onInventory implements Listener {

    @EventHandler
    public void onInventory(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
        Teams team = GameManager.getInstance().returnPlayerTeam(p);
        TeamAccount account = GameManager.getInstance().teamAccounts.get(team);

        if(e.getView().getTitle().equalsIgnoreCase("Upgrade")){
            e.setCancelled(true);

            switch (current.getType()){
                case DIAMOND_SWORD:
                    if(!account.isSharpness()){
                        account.setSharpness(true);
                        SetPlayerStuff.setPlayerSword(p);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case DIAMOND_CHESTPLATE:
                    if(account.getProtection() != 4){
                        account.setProtection(account.getProtection() + 1);
                        SetPlayerStuff.setPlayerArmor(p);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case GOLDEN_PICKAXE:
                    if(account.getHast() != 2){
                        account.setHast(account.getHast() + 1);
                        p.removePotionEffect(PotionEffectType.FAST_DIGGING);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, account.getHast()));
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case IRON_INGOT:
                    if(account.getForge() != 4){
                        account.setForge(account.getForge() + 1);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case CAULDRON:
                    if(!account.isHealPool()){
                        account.setHealPool(true);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case BREWING_STAND:
                    if(!account.isSpeedPool()){
                        account.setSpeedPool(true);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case CHAIN:
                    if(!account.isTrapSlowness()){
                        account.setTrapSlowness(true);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case FIREWORK_STAR:
                    if(!account.isTrapBlindness()){
                        account.setTrapBlindness(true);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case WOODEN_SWORD:
                    if(!account.isTrapMiningFatigue()){
                        account.setTrapMiningFatigue(true);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case REDSTONE_TORCH:
                    if(!account.isAlarmTrap()){
                        account.setAlarmTrap(true);
                        p.closeInventory();
                        NPCMenu.openUpgradeMenu(p, "Upgrade", team);
                    }
                    break;
                case BARRIER:
                    p.closeInventory();
                    break;
            }
        }

    }

}
