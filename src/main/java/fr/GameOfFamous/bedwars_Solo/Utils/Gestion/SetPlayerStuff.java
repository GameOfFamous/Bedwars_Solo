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
        ItemStack chesplate = null;
        ItemStack leggins = null;
        ItemStack boots = null;

        if(marketAccount.getArmor() == 0) {
            chesplate = CreateItem.createColoredArmor(Material.LEATHER_CHESTPLATE, color, enchantLevel);
            leggins = CreateItem.createColoredArmor(Material.LEATHER_LEGGINGS, color, enchantLevel);
            boots = CreateItem.createColoredArmor(Material.LEATHER_BOOTS, color, enchantLevel);
        }else if (marketAccount.getArmor() == 1) {
            chesplate = CreateItem.createArmor(Material.CHAINMAIL_CHESTPLATE, enchantLevel);
            leggins = CreateItem.createArmor(Material.CHAINMAIL_LEGGINGS, enchantLevel);
            boots = CreateItem.createArmor(Material.CHAINMAIL_BOOTS, enchantLevel);
        } else if (marketAccount.getArmor() == 2) {
            chesplate = CreateItem.createArmor(Material.IRON_CHESTPLATE, enchantLevel);
            leggins = CreateItem.createArmor(Material.IRON_LEGGINGS, enchantLevel);
            boots = CreateItem.createArmor(Material.IRON_BOOTS, enchantLevel);
        } else if (marketAccount.getArmor() == 3) {
            chesplate = CreateItem.createArmor(Material.DIAMOND_CHESTPLATE, enchantLevel);
            leggins = CreateItem.createArmor(Material.DIAMOND_LEGGINGS, enchantLevel);
            boots = CreateItem.createArmor(Material.DIAMOND_BOOTS, enchantLevel);
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

        player.getInventory().addItem(sword);
    }

}
