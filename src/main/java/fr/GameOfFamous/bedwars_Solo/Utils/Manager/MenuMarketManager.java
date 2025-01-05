package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.commons.TeamAccount;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MenuMarketManager {

    public static final ConcurrentHashMap<Teams, TeamAccount> teamAccounts = GameManager.getInstance().teamAccounts;

    public static GameManager manager = GameManager.getInstance();

    public static List<String> getWoolLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f4 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 4) {
            lore.add("§cVous ne possédez pas assez de Diamants !");
        }else {
            lore.add("§aAcheter");
        }

        return lore;
    }

    public static Material getWoolMaterial(Teams team){

        return team.getWool();
    }


    public static int countIronInventory(Player player){
        int count = 0;

        for(ItemStack item : player.getInventory()){
            if(item != null && item.getType() == Material.IRON_INGOT){
                count += item.getAmount();
            }
        }

        return  count;
    }

    public static int countGoldInventory(Player player){
        int count = 0;

        for(ItemStack item : player.getInventory()){
            if(item != null && item.getType() == Material.GOLD_INGOT){
                count += item.getAmount();
            }
        }

        return  count;
    }

}
