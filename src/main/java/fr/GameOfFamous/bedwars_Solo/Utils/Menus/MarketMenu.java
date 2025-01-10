package fr.GameOfFamous.bedwars_Solo.Utils.Menus;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.MenuMarketManager;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.Arrays;
import java.util.List;

public class MarketMenu {

    private static void addCategories(Inventory inv){
        ItemStack[] categories = {
                createCategoryItem(Material.NETHER_STAR, "§bAchat Rapide"),
                createCategoryItem(Material.WHITE_WOOL, "§bBlocks"),
                createCategoryItem(Material.GOLDEN_SWORD, "§bMêlée"),
                createCategoryItem(Material.CHAINMAIL_CHESTPLATE, "§bArmure"),
                createCategoryItem(Material.IRON_PICKAXE, "§bOutils"),
                createCategoryItem(Material.BOW, "§bA Distance"),
                createCategoryItem(Material.BREWING_STAND, "§bPotions"),
                createCategoryItem(Material.TNT, "§bUtilitaire"),
                createCategoryItem(Material.ENDER_PEARL, "§bObjets")
        };
        for(int i = 0; i < categories.length; i++){
            inv.setItem(i, categories[i]);
        }
    }

    private static void addBorder(Inventory inv, int choose){
        ItemStack choosen = CreateItem.newItem(Material.GREEN_STAINED_GLASS_PANE, 1, " ",false, new String[]{});
        ItemStack border = CreateItem.newItem(Material.GRAY_STAINED_GLASS_PANE, 1, " ",false, new String[]{});

        for(int i = 9; i <= 17; i++){
            if(!(i == choose)){
                inv.setItem(i, border);
            }else {
                inv.setItem(choose, choosen);
            }
        }
    }

    private static void addClose(Inventory inv){
        ItemStack close = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});

        inv.setItem(45, close);
        inv.setItem(53, close);
    }

    private static ItemStack createCategoryItem(Material material, String name){
        return CreateItem.newItem(material, 1, name, false, new String[]{"Cliquez !"});
    }

    public static void openMarketMenuRapid(Player player, String name, Teams team){

        List<ItemStack> itemStacks = Arrays.asList(
                CreateItem.newItem(MenuMarketManager.getWoolMaterial(team), 16, "§cLaine", false, MenuMarketManager.getWoolLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.OAK_PLANKS, 16, "§cPlanches de Chêne", false, MenuMarketManager.getWoodLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.STONE_SWORD, 1, "§cEpée en Pierre", false, MenuMarketManager.getStoneSwordLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.IRON_SWORD, 1, "§cEpée en fer", false, MenuMarketManager.getIronSwordLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§cArmure en cotte de mailles", false, MenuMarketManager.getChainChesplateLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.IRON_CHESTPLATE, 1, "§cArmure en Fer", false, MenuMarketManager.getIronChesplateLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.STONE_PICKAXE,1, "§cPioche en pierre", true, MenuMarketManager.getPickaxeLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.SHEARS, 1, "§cCisailles", false, MenuMarketManager.getShearsLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.BOW, 1, "§cArc", false, MenuMarketManager.getBowLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.ARROW, 6, "§cFlèches", false, MenuMarketManager.getArrowLore(team).toArray(new String[0])),
                CreateItem.newPotion(PotionType.SPEED, false, true, PotionEffectType.SPEED, 900, 1, MenuMarketManager.getSpeedLore(team).toArray(new String[0])),
                CreateItem.newPotion(PotionType.INVISIBILITY, false, false, PotionEffectType.INVISIBILITY, 600, 1, MenuMarketManager.getInvisibilityLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.TNT, 1, "§cTNT", false, MenuMarketManager.getTntLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.ENDER_PEARL, 1, "§cPerle de l'ender", false, MenuMarketManager.getEnderPearlLore(team).toArray(new String[0]))
        );
        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 9);

        addClose(inv);

        int[] slots = {19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34}; // Indices des emplacements
        for (int i = 0; i < itemStacks.size(); i++) {
            inv.setItem(slots[i], itemStacks.get(i));
        }

        player.openInventory(inv);
    }

    public static void openMarketMenuBlock(Player player, String name, Teams team){

        List<ItemStack> itemStacks = Arrays.asList(
                CreateItem.newItem(MenuMarketManager.getWoolMaterial(team), 16, "§cLaine", false, MenuMarketManager.getWoolLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.TERRACOTTA, 16, "§cArgile durcie", false, MenuMarketManager.getArgilelLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.GLASS, 4, "§cVerre anti Explosions", false, MenuMarketManager.getGlasslLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.END_STONE, 12, "§cPierre de l'end", false, MenuMarketManager.getEndStoneLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.LADDER, 8, "§cEchelle", false, MenuMarketManager.getLadderLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.OAK_PLANKS, 16, "§cPlanches de Chêne", false, MenuMarketManager.getWoodLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.OBSIDIAN, 4, "§cObsidienne", false, MenuMarketManager.getObsiLore(team).toArray(new String[0]))
        );

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 10);

        addClose(inv);

        int[] slots = {19, 20, 21, 22, 23, 24, 25}; // Indices des emplacements
        for (int i = 0; i < itemStacks.size(); i++) {
            inv.setItem(slots[i], itemStacks.get(i));
        }

        player.openInventory(inv);
    }

    public static void openMarketMenuMele(Player player, String name, Teams team){

        List<ItemStack> itemStacks = Arrays.asList(
                CreateItem.newItem(Material.STONE_SWORD, 1, "§cEpée en Pierre", false, MenuMarketManager.getStoneSwordLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.IRON_SWORD, 1, "§cEpée en fer", false, MenuMarketManager.getIronSwordLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.DIAMOND_SWORD, 1, "§cEpée en Diamant", false, MenuMarketManager.getDiamondSwordLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.STICK, 1, "§cEjector", false, MenuMarketManager.getStickLore(team).toArray(new String[0]))
        );

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 11);

        addClose(inv);

        int[] slots = {19, 20, 21, 22}; // Indices des emplacements
        for (int i = 0; i < itemStacks.size(); i++) {
            inv.setItem(slots[i], itemStacks.get(i));
        }

        player.openInventory(inv);
    }
    public static void openMarketMenuArmure(Player player, String name, Teams team){

        List<ItemStack> itemStacks = Arrays.asList(
                CreateItem.newItem(Material.CHAINMAIL_CHESTPLATE, 1, "§cArmure en cotte de mailles", false, MenuMarketManager.getChainChesplateLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.IRON_CHESTPLATE, 1, "§cArmure en fer", false, MenuMarketManager.getIronChesplateLore(team).toArray(new String[0])),
                CreateItem.newItem(Material.DIAMOND_CHESTPLATE, 1, "§cArmure en diamant", false, MenuMarketManager.getDiamsChesplateLore(team).toArray(new String[0]))
        );

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 12);

        addClose(inv);

        int[] slots = {19, 20, 21}; // Indices des emplacements
        for (int i = 0; i < itemStacks.size(); i++) {
            inv.setItem(slots[i], itemStacks.get(i));
        }

        player.openInventory(inv);
    }
    public static void openMarketMenuOutils(Player player, String name, Teams team){

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 13);

        addClose(inv);

        player.openInventory(inv);
    }
    public static void openMarketMenuDistance(Player player, String name, Teams team){

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 14);

        addClose(inv);

        player.openInventory(inv);
    }
    public static void openMarketMenuPotions(Player player, String name, Teams team){

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 15);

        addClose(inv);

        player.openInventory(inv);
    }
    public static void openMarketMenuUtilitaire(Player player, String name, Teams team){

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 16);

        addClose(inv);

        player.openInventory(inv);
    }
    public static void openMarketMenuObjet(Player player, String name, Teams team){

        Inventory inv = Bukkit.createInventory(null, 54, name);

        addCategories(inv);

        addBorder(inv, 17);

        addClose(inv);

        player.openInventory(inv);
    }

}
