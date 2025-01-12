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
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getWoodLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §64 Or");
        lore.add(" ");

        if(countGoldInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getStoneSwordLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f10 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 10) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getIronSwordLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §67 Or");
        lore.add(" ");

        if(countGoldInventory(player) >= 7) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }
    public static List<String> getChainChesplateLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f24 Fer");
        lore.add(" ");
        lore.add("§bAchat Permanant !");
        lore.add(" ");

        if(countIronInventory(player) >= 24) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getIronChesplateLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §612 Or");
        lore.add(" ");
        lore.add("§bAchat Permanant !");
        lore.add(" ");

        if(countGoldInventory(player) >= 12) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getPickaxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §67 Or");
        lore.add(" ");
        lore.add("§bEfficacité I");
        lore.add(" ");

        if(countGoldInventory(player) >= 7) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getShearsLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f20 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 20) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getBowLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §612 Or");
        lore.add(" ");

        if(countGoldInventory(player) >= 12) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getArrowLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §62 Or");
        lore.add(" ");

        if(countGoldInventory(player) >= 2) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getSpeedLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §22 Emeraudes");
        lore.add(" ");
        lore.add("§bRapidité II (0:45)");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 2) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getInvisibilityLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §23 Emeraudes");
        lore.add(" ");
        lore.add("§bInvisibilité (0:30)");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 3) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getTntLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §64 Or");
        lore.add(" ");
        lore.add("§7Déclenchement automatique");
        lore.add(" ");

        if(countGoldInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getEnderPearlLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §24 Emeraudes");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getArgilelLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f12 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 12) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getGlasslLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f12 Fer");
        lore.add(" ");
        lore.add("§bImmunisé contre les explosions");
        lore.add(" ");

        if(countIronInventory(player) >= 12) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getEndStoneLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f24 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 24) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getLadderLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f4 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getObsiLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §24 Emeraudes");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getDiamondSwordLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §24 Emeraudes");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getStickLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §65 Or");
        lore.add(" ");
        lore.add("§6Recul I");
        lore.add(" ");

        if(countGoldInventory(player) >= 5) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getDiamsChesplateLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §26 Emeraudes");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 6) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getWoodPickaxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f10 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 10) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getIronPickaxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §67 Or");
        lore.add(" ");

        if(countGoldInventory(player) >= 7) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getDiamondPickaxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §24 Emeraudes");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getWoodAxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f10 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 10) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getStoneAxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §f24 Fer");
        lore.add(" ");

        if(countIronInventory(player) >= 24) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez de §fFer§c !");
        }

        return lore;
    }

    public static List<String> getIronAxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §67 Or");
        lore.add(" ");

        if(countGoldInventory(player) >= 7) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getDiamondAxeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §24 Emeraudes");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 4) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
        }

        return lore;
    }

    public static List<String> getBow2Lore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §620 Or");
        lore.add(" ");

        if(countGoldInventory(player) >= 20) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§6Or§c !");
        }

        return lore;
    }

    public static List<String> getBow3Lore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Prix : §26 Emeraudes");
        lore.add(" ");

        if(countEmeraldInventory(player) >= 6) {
            lore.add("§aAcheter");
        }else {
            lore.add("§cVous ne possédez pas assez d'§2Emeraudes§c !");
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

    public static int countEmeraldInventory(Player player){
        int count = 0;

        for(ItemStack item : player.getInventory()){
            if(item != null && item.getType() == Material.EMERALD){
                count += item.getAmount();
            }
        }

        return  count;
    }

}
