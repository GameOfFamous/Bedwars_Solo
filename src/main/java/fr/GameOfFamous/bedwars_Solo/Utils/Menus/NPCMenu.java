package fr.GameOfFamous.bedwars_Solo.Utils.Menus;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.CreateItem;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.MenuManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NPCMenu {

    public static void openMarketMenu(Player player, String name){
        Inventory inv = Bukkit.createInventory(null, 36, name);

        player.openInventory(inv);
    }

    public static void openUpgradeMenu(Player player, String name, Teams team){

        ItemStack sharpness = CreateItem.newItem(Material.DIAMOND_SWORD, 1, MenuManager.getSharpnessName(team), MenuManager.getSharpnessEnchant(team), MenuManager.getSharpnessLore(team).toArray(new String[0]));
        ItemStack protection = CreateItem.newItem(Material.DIAMOND_CHESTPLATE, 1, MenuManager.getProtectionName(team), MenuManager.getProtectionEnchant(team), MenuManager.getProtectionList(team).toArray(new String[0]));
        ItemStack hast =CreateItem.newItem(Material.GOLDEN_PICKAXE, 1, MenuManager.getHastName(team), MenuManager.getHastEnchant(team), MenuManager.getHastLore(team).toArray(new String[0]));
        ItemStack forge = CreateItem.newItem(Material.IRON_INGOT, 1, MenuManager.getForgeName(team), MenuManager.getForgeEnchant(team), MenuManager.getForgeLore(team).toArray(new String[0]));
        ItemStack healPool = CreateItem.newItem(Material.CAULDRON, 1, MenuManager.getHealPoolName(team), MenuManager.getHealPoolEnchant(team), MenuManager.getHealPoolLore(team).toArray(new String[0]));
        ItemStack speedPool = CreateItem.newItem(Material.BREWING_STAND, 1, MenuManager.getSpeedPoolName(team), MenuManager.getSpeedPoolEnchant(team), MenuManager.getSpeedPoolLore(team).toArray(new String[0]));
        ItemStack trapSlowness = CreateItem.newItem(Material.CHAIN, 1, MenuManager.getSlownessName(team), MenuManager.getSlownessEnchant(team), MenuManager.getSlownessLore(team).toArray(new String[0]));
        ItemStack trapBlindness = CreateItem.newItem(Material.FIREWORK_STAR, 1, MenuManager.getBlindnessName(team), MenuManager.getBlindnessEnchant(team), MenuManager.getBlindnessLore(team).toArray(new String[0]));
        ItemStack trapMining = CreateItem.newItem(Material.WOODEN_SWORD, 1, MenuManager.getMiningName(team), MenuManager.getMiningEnchant(team), MenuManager.getMiningLore(team).toArray(new String[0]));
        ItemStack trapAlarm = CreateItem.newItem(Material.REDSTONE_TORCH, 1, MenuManager.getAlarmName(team), MenuManager.getAlarmEnchant(team), MenuManager.getAlarmLore(team).toArray(new String[0]));

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
