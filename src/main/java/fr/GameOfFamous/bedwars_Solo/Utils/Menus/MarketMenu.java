package fr.GameOfFamous.bedwars_Solo.Utils.Menus;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.CreateItem;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.MenuMarketManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class MarketMenu {

    public static void openMarketMenuRapid(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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

        ItemStack wool = CreateItem.newItem(MenuMarketManager.getWoolMaterial(team), 16, "§cLaine", false, MenuMarketManager.getWoolLore(team).toArray(new String[0]));
        ItemStack wood = CreateItem.newItem(Material.OAK_PLANKS, 16, "§cPlanches de Chêne", false, MenuMarketManager.getWoodLore(team).toArray(new String[0]));

        ItemStack stoneSword = CreateItem.newItem(Material.STONE_SWORD, 1, "§cEpée en Pierre", false, MenuMarketManager.getStoneSwordLore(team).toArray(new String[0]));
        ItemStack ironSword = CreateItem.newItem(Material.IRON_SWORD, 1, "§cEpée en fer", false, MenuMarketManager.getIronSwordLore(team).toArray(new String[0]));

        ItemStack chainchesplate = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§cArmure en cotte de mailles", false, MenuMarketManager.getChainChesplateLore(team).toArray(new String[0]));
        ItemStack ironChesplate = CreateItem.newItem(Material.IRON_CHESTPLATE, 1, "§cArmure en Fer", false, MenuMarketManager.getIronChesplateLore(team).toArray(new String[0]));

        ItemStack pickaxe = CreateItem.newItem(Material.STONE_PICKAXE,1, "§cPioche en pierre", true, MenuMarketManager.getPickaxeLore(team).toArray(new String[0]));
        ItemStack cheers = CreateItem.newItem(Material.SHEARS, 1, "§cCisailles", false, MenuMarketManager.getShearsLore(team).toArray(new String[0]));

        ItemStack bow = CreateItem.newItem(Material.BOW, 1, "§cArc", false, MenuMarketManager.getBowLore(team).toArray(new String[0]));
        ItemStack arrow = CreateItem.newItem(Material.ARROW, 6, "§cFlèches", false, MenuMarketManager.getArrowLore(team).toArray(new String[0]));

        ItemStack speed = CreateItem.newPotion(PotionType.SPEED, false, true, PotionEffectType.SPEED, 900, 1, MenuMarketManager.getSpeedLore(team).toArray(new String[0]));
        ItemStack invisible = CreateItem.newPotion(PotionType.INVISIBILITY, false, false, PotionEffectType.INVISIBILITY, 600, 1, MenuMarketManager.getInvisibilityLore(team).toArray(new String[0]));

        ItemStack tnt = CreateItem.newItem(Material.TNT, 1, "§cTNT", false, MenuMarketManager.getTntLore(team).toArray(new String[0]));
        ItemStack enderpearl = CreateItem.newItem(Material.ENDER_PEARL, 1, "§cPerle de l'ender", false, MenuMarketManager.getEnderPearlLore(team).toArray(new String[0]));

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

        inv.setItem(19, wool);
        inv.setItem(20, stoneSword);
        inv.setItem(21, chainchesplate);
        inv.setItem(22, pickaxe);
        inv.setItem(23, bow);
        inv.setItem(24, speed);
        inv.setItem(25, tnt);

        inv.setItem(28, wood);
        inv.setItem(29, ironSword);
        inv.setItem(30, ironChesplate);
        inv.setItem(31, cheers);
        inv.setItem(32, arrow);
        inv.setItem(33, invisible);
        inv.setItem(34, enderpearl);

        player.openInventory(inv);
    }

    public static void openMarketMenuBlock(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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

        ItemStack wool = CreateItem.newItem(MenuMarketManager.getWoolMaterial(team), 16, "§cLaine", false, MenuMarketManager.getWoolLore(team).toArray(new String[0]));
        ItemStack argile = CreateItem.newItem(Material.TERRACOTTA, 16, "§cArgile durcie", false, MenuMarketManager.getArgilelLore(team).toArray(new String[0]));
        ItemStack glass = CreateItem.newItem(Material.GLASS, 4, "§cVerre anti Explosions", false, MenuMarketManager.getGlasslLore(team).toArray(new String[0]));
        ItemStack endStone = CreateItem.newItem(Material.END_STONE, 12, "§cPierre de l'end", false, MenuMarketManager.getEndStoneLore(team).toArray(new String[0]));
        ItemStack ladder = CreateItem.newItem(Material.LADDER, 8, "§cEchelle", false, MenuMarketManager.getLadderLore(team).toArray(new String[0]));
        ItemStack wood = CreateItem.newItem(Material.OAK_PLANKS, 16, "§cPlanches de Chêne", false, MenuMarketManager.getWoodLore(team).toArray(new String[0]));
        ItemStack obsidian = CreateItem.newItem(Material.OBSIDIAN, 4, "§cObsidienne", false, MenuMarketManager.getObsiLore(team).toArray(new String[0]));

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

        inv.setItem(9, border);
        inv.setItem(10, choosen);
        inv.setItem(11, border);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        inv.setItem(19, wool);
        inv.setItem(20, argile);
        inv.setItem(21, glass);
        inv.setItem(22, endStone);
        inv.setItem(23, ladder);
        inv.setItem(24, wood);
        inv.setItem(25, obsidian);

        player.openInventory(inv);
    }

    public static void openMarketMenuMele(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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

        ItemStack stoneSword = CreateItem.newItem(Material.STONE_SWORD, 1, "§cEpée en Pierre", false, MenuMarketManager.getStoneSwordLore(team).toArray(new String[0]));
        ItemStack ironSword = CreateItem.newItem(Material.IRON_SWORD, 1, "§cEpée en fer", false, MenuMarketManager.getIronSwordLore(team).toArray(new String[0]));
        ItemStack DiamondSword = CreateItem.newItem(Material.DIAMOND_SWORD, 1, "§cEpée en Diamant", false, MenuMarketManager.getDiamondSwordLore(team).toArray(new String[0]));
        ItemStack stick = CreateItem.newItem(Material.STICK, 1, "§cEjector", false, MenuMarketManager.getStickLore(team).toArray(new String[0]));

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

        inv.setItem(9, border);
        inv.setItem(10, border);
        inv.setItem(11, choosen);
        inv.setItem(12, border);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        inv.setItem(19, stoneSword);
        inv.setItem(20, ironSword);
        inv.setItem(21, DiamondSword);
        inv.setItem(22, stick);

        player.openInventory(inv);
    }
    public static void openMarketMenuArmure(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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

        ItemStack chainArmor = CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§cArmure en cotte de mailles", false, MenuMarketManager.getChainChesplateLore(team).toArray(new String[0]));
        ItemStack IronArmor = CreateItem.newItem(Material.IRON_CHESTPLATE, 1, "§cArmure en fer", false, MenuMarketManager.getIronChesplateLore(team).toArray(new String[0]));
        ItemStack DiamsArmor = CreateItem.newItem(Material.DIAMOND_CHESTPLATE, 1, "§cArmure en diamant", false, MenuMarketManager.getDiamsChesplateLore(team).toArray(new String[0]));

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

        inv.setItem(9, border);
        inv.setItem(10, border);
        inv.setItem(11, border);
        inv.setItem(12, choosen);
        inv.setItem(13, border);
        inv.setItem(14, border);
        inv.setItem(15, border);
        inv.setItem(16, border);
        inv.setItem(17, border);

        inv.setItem(53, close);
        inv.setItem(45, close);

        inv.setItem(19, chainArmor);
        inv.setItem(20, IronArmor);
        inv.setItem(21, DiamsArmor);

        player.openInventory(inv);
    }
    public static void openMarketMenuOutils(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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
    public static void openMarketMenuDistance(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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
    public static void openMarketMenuPotions(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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
    public static void openMarketMenuUtilitaire(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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
    public static void openMarketMenuObjet(Player player, String name, Teams team){

        ItemStack catAchatRapid = CreateItem.newItem(Material.NETHER_STAR, 1, "§bAchat Rapide", false, new String[]{"Cliquez !"});
        ItemStack catblocks = CreateItem.newItem(Material.WHITE_WOOL, 1, "§bBlocks", false, new String[]{"Cliquez !"});
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
