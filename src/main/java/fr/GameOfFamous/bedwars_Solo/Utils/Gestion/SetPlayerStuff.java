package fr.GameOfFamous.bedwars_Solo.Utils.Gestion;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.commons.MarketAccount;
import fr.GameOfFamous.commons.TeamAccount;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetPlayerStuff {

    public static void setPlayerArmor(Player player){

        Teams team = GameManager.getInstance().returnPlayerTeam(player);
        Color color = team.getColour();
        TeamAccount account = GameManager.getInstance().teamAccounts.get(team);
        MarketAccount marketAccount = GameManager.getInstance().marketAccounts.get(player);
        int enchantLevel = account.getProtection();

        ItemStack helmet = CreateItem.createColoredArmor(Material.LEATHER_HELMET, color, enchantLevel);
        ItemStack chesplate = CreateItem.createColoredArmor(Material.LEATHER_CHESTPLATE, color, enchantLevel);
        ItemStack leggins = CreateItem.createColoredArmor(Material.LEATHER_LEGGINGS, color, enchantLevel);
        ItemStack boots = CreateItem.createColoredArmor(Material.LEATHER_BOOTS, color, enchantLevel);

        if (marketAccount.getArmor() == 1) {
            chesplate = CreateItem.createColoredArmor(Material.CHAINMAIL_CHESTPLATE, color, enchantLevel);
            leggins = CreateItem.createColoredArmor(Material.CHAINMAIL_LEGGINGS, color, enchantLevel);
            boots = CreateItem.createColoredArmor(Material.CHAINMAIL_BOOTS, color, enchantLevel);
        } else if (marketAccount.getArmor() == 2) {
            chesplate = CreateItem.createColoredArmor(Material.IRON_CHESTPLATE, color, enchantLevel);
            leggins = CreateItem.createColoredArmor(Material.IRON_LEGGINGS, color, enchantLevel);
            boots = CreateItem.createColoredArmor(Material.IRON_BOOTS, color, enchantLevel);
        } else if (marketAccount.getArmor() == 3) {
            chesplate = CreateItem.createColoredArmor(Material.DIAMOND_CHESTPLATE, color, enchantLevel);
            leggins = CreateItem.createColoredArmor(Material.DIAMOND_LEGGINGS, color, enchantLevel);
            boots = CreateItem.createColoredArmor(Material.DIAMOND_BOOTS, color, enchantLevel);
        }

        player.getInventory().setHelmet(helmet);
        player.getInventory().setChestplate(chesplate);
        player.getInventory().setLeggings(leggins);
        player.getInventory().setBoots(boots);
    }

    public static void setPlayerSword(Player player){
        Teams team = GameManager.getInstance().returnPlayerTeam(player);
        TeamAccount account = GameManager.getInstance().teamAccounts.get(team);
        MarketAccount marketAccount = GameManager.getInstance().marketAccounts.get(player);
        boolean sharpness = account.isSharpness();

        ItemStack sword = CreateItem.newItemBedwars(Material.WOODEN_SWORD, 1, sharpness);

        if(marketAccount.getSword() == 1){
            sword = CreateItem.newItemBedwars(Material.STONE_SWORD, 1, sharpness);
        } else if (marketAccount.getSword() == 2) {
            sword = CreateItem.newItemBedwars(Material.IRON_SWORD, 1, sharpness);
        }else if (marketAccount.getSword() == 3) {
            sword = CreateItem.newItemBedwars(Material.DIAMOND_SWORD, 1, sharpness);
        }

        player.getInventory().setItem(0, sword);
    }

}
