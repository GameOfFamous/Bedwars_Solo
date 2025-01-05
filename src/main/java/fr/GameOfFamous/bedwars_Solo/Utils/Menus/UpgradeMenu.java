package fr.GameOfFamous.bedwars_Solo.Utils.Menus;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.CreateItem;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.MenuUpgradeManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class UpgradeMenu {

    public static void openUpgradeMenu(Player player, String name, Teams team){

        ItemStack sharpness = CreateItem.newItem(Material.DIAMOND_SWORD, 1, MenuUpgradeManager.getSharpnessName(team), MenuUpgradeManager.getSharpnessEnchant(team), MenuUpgradeManager.getSharpnessLore(team).toArray(new String[0]));
        ItemStack protection = CreateItem.newItem(Material.DIAMOND_CHESTPLATE, 1, MenuUpgradeManager.getProtectionName(team), MenuUpgradeManager.getProtectionEnchant(team), MenuUpgradeManager.getProtectionList(team).toArray(new String[0]));
        ItemStack hast =CreateItem.newItem(Material.GOLDEN_PICKAXE, 1, MenuUpgradeManager.getHastName(team), MenuUpgradeManager.getHastEnchant(team), MenuUpgradeManager.getHastLore(team).toArray(new String[0]));
        ItemStack forge = CreateItem.newItem(Material.IRON_INGOT, 1, MenuUpgradeManager.getForgeName(team), MenuUpgradeManager.getForgeEnchant(team), MenuUpgradeManager.getForgeLore(team).toArray(new String[0]));
        ItemStack healPool = CreateItem.newItem(Material.CAULDRON, 1, MenuUpgradeManager.getHealPoolName(team), MenuUpgradeManager.getHealPoolEnchant(team), MenuUpgradeManager.getHealPoolLore(team).toArray(new String[0]));
        ItemStack speedPool = CreateItem.newItem(Material.BREWING_STAND, 1, MenuUpgradeManager.getSpeedPoolName(team), MenuUpgradeManager.getSpeedPoolEnchant(team), MenuUpgradeManager.getSpeedPoolLore(team).toArray(new String[0]));
        ItemStack trapSlowness = CreateItem.newItem(Material.CHAIN, 1, MenuUpgradeManager.getSlownessName(team), MenuUpgradeManager.getSlownessEnchant(team), MenuUpgradeManager.getSlownessLore(team).toArray(new String[0]));
        ItemStack trapBlindness = CreateItem.newItem(Material.FIREWORK_STAR, 1, MenuUpgradeManager.getBlindnessName(team), MenuUpgradeManager.getBlindnessEnchant(team), MenuUpgradeManager.getBlindnessLore(team).toArray(new String[0]));
        ItemStack trapMining = CreateItem.newItem(Material.WOODEN_SWORD, 1, MenuUpgradeManager.getMiningName(team), MenuUpgradeManager.getMiningEnchant(team), MenuUpgradeManager.getMiningLore(team).toArray(new String[0]));
        ItemStack trapAlarm = CreateItem.newItem(Material.REDSTONE_TORCH, 1, MenuUpgradeManager.getAlarmName(team), MenuUpgradeManager.getAlarmEnchant(team), MenuUpgradeManager.getAlarmLore(team).toArray(new String[0]));

        ItemStack border = CreateItem.newItem(team.getBorder(), 1, "§c ", false, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});


        Inventory inv = Bukkit.createInventory(null, 36, name);

        inv.setItem(0, border);
        inv.setItem(1, border);
        inv.setItem(2, border);
        inv.setItem(3, border);
        inv.setItem(4, border);
        inv.setItem(5, border);
        inv.setItem(6, border);
        inv.setItem(7, border);
        inv.setItem(8, border);

        inv.setItem(9, border);
        inv.setItem(18, border);

        inv.setItem(17, border);
        inv.setItem(26, border);

        inv.setItem(28, border);
        inv.setItem(29, border);
        inv.setItem(30, border);
        inv.setItem(31, border);
        inv.setItem(32, border);
        inv.setItem(33, border);
        inv.setItem(34, border);

        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(22, border);
        inv.setItem(23, border);

        inv.setItem(27, close);
        inv.setItem(35, close);

        inv.setItem(10, sharpness);
        inv.setItem(11, protection);
        inv.setItem(12, hast);
        inv.setItem(19, forge);
        inv.setItem(20, healPool);
        inv.setItem(21, speedPool);

        inv.setItem(15, trapSlowness);
        inv.setItem(16, trapBlindness);
        inv.setItem(24, trapMining);
        inv.setItem(25, trapAlarm);

        player.openInventory(inv);

    }

}
