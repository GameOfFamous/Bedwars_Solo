package fr.GameOfFamous.bedwars_Solo.Utils.Menus;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.CreateItem;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.MenuMarketManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MarketMenu {

    public static void openMarketMenuRapid(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        ItemStack wool = CreateItem.newItem(MenuMarketManager.getWoolMaterial(team), 16, "§cLaine", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }

    public static void openMarketMenuBlock(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }

    public static void openMarketMenuMele(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }
    public static void openMarketMenuArmure(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }
    public static void openMarketMenuOutils(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }
    public static void openMarketMenuDistance(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }
    public static void openMarketMenuPotions(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }
    public static void openMarketMenuUtilitaire(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }
    public static void openMarketMenuObjet(Player player, String name){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§aBlocks", false, new String[]{"Cliquez !"});
        ItemStack catMele = CreateItem.newItem(Material.GOLDEN_SWORD, 1, "§bMêlée", false, new String[]{"Cliquez !"});
        ItemStack catArmure = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§bArmure", false, new String[]{"Cliquez !"});
        ItemStack catOutils = CreateItem.newItem(Material.IRON_PICKAXE, 1, "§bOutils", false, new String[]{"Cliquez !"});
        ItemStack catDistance = CreateItem.newItem(Material.BOW, 1, "§bA Distance", false, new String[]{"Cliquez !"});
        ItemStack catPotions = CreateItem.newItem(Material.BREWING_STAND, 1, "§bPotions", false, new String[]{"Cliquez !"});
        ItemStack catUtilitaire = CreateItem.newItem(Material.TNT, 1, "§bUtilitaire", false, new String[]{"Cliquez !"});
        ItemStack catObjets = CreateItem.newItem(Material.ENDER_PEARL, 1, "§bObjets", false, new String[]{"Cliquez !"});

        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",true, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",true, new String[]{});

        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 54, name);

        inv.setItem(0, catAchatRapid);
        inv.setItem(1, catblocks);
        inv.setItem(2, catMele);
        inv.setItem(3, catArmure);
        inv.setItem(4, catOutils);
        inv.setItem(5, catDistance);
        inv.setItem(6, catPotions);
        inv.setItem(7, catUtilitaire);
        inv.setItem(8, catObjets);

        inv.setItem(9, choosen);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        player.openInventory(inv);
    }

}
