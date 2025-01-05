package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.commons.TeamAccount;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MenuManager {

    public static final ConcurrentHashMap<Teams, TeamAccount> teamAccounts = GameManager.getInstance().teamAccounts;

    public static GameManager manager = GameManager.getInstance();

    //Sharpness
    public static String getSharpnessName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isSharpness()){
            return "§aEpées tranchantes";
        }

        return "§cEpées tranchantes";
    }
    public static boolean getSharpnessEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isSharpness()){
            return true;
        }

        return false;
    }

    public static List<String> getSharpnessLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        Player player = teams.getPlayer();
        lore.add("§7Votre équipe obtient tranchant I");
        lore.add("§7de facon permanente sur toutes");
        lore.add("§7les épées et les haches !");

        if(teams.isSharpness()){
            lore.add(" ");
            lore.add("§7Possédé §f: §a✓");
        }else {
            lore.add(" ");
            lore.add("§7Coût : §b4 Diamants");
            lore.add(" ");
            if(countDiamondInventory(player) >= 4){
                lore.add("§7Possédé §f: §c✗");
            }else {
                lore.add("§cVous ne possédez pas assez de Diamants !");
            }
        }

        return lore;
    }


    //Protection
    public static String getProtectionName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        int protection = teams.getProtection();

        return switch (protection) {
            case 1 -> "§cProtection 2";
            case 2 -> "§cProtection 3";
            case 3 -> "§cProtection 4";
            case 4 -> "§aProtection";
            default -> "§cProtection 1";
        };
    }

    public static boolean getProtectionEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        int protection = teams.getProtection();

        if(protection == 4){
            return true;
        }

        return false;
    }

    public static List<String> getProtectionList(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        int protection = teams.getProtection();

        lore.add("§bAjoute protection à vos armures");

        // Générer la liste des protections en fonction du niveau
        for (int i = 1; i <= 4; i++) {
            if (i <= protection) {
                lore.add(String.format("§aProtection %d ✓", i)); // Protection acquise
            } else {
                lore.add(String.format("§cProtection %d ✗", i)); // Protection non acquise
            }
        }

        return lore;
    }

    public static String getHastName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        int hast = teams.getHast();

        return switch (hast) {
            case 1 -> "§cHast 2";
            case 2 -> "§aHast";
            default -> "§cHast 1";
        };
    }

    public static boolean getHastEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        int hast = teams.getHast();

        if(hast == 2){
            return true;
        }

        return false;
    }

    public static List<String> getHastLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        int hast = teams.getHast();

        lore.add("§bAjoute l'effet Hast");

        // Générer la liste des protections en fonction du niveau
        for (int i = 1; i <= 2; i++) {
            if (i <= hast) {
                lore.add(String.format("§aHast %d ✓", i)); // Protection acquise
            } else {
                lore.add(String.format("§cHast %d ✗", i)); // Protection non acquise
            }
        }

        return lore;
    }

    public static String getForgeName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        int forge = teams.getForge();

        return switch (forge) {
            case 1 -> "§cForge 2";
            case 2 -> "§cForge 3";
            case 3 -> "§cForge 4";
            case 4 -> "§aForge";
            default -> "§cForge 1";
        };
    }

    public static boolean getForgeEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        int forge = teams.getForge();

        if(forge == 4){
            return true;
        }

        return false;
    }

    public static List<String> getForgeLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        int forge = teams.getForge();

        String[] bonuses = {
                "+100% Iron",
                "+200% Iron",
                "+1 Diamond",
                "+1 Emerald"
        };
        lore.add("§bAméliorer son générateur à minerais");

        // Génération de la lore en fonction du niveau de forge
        for (int i = 0; i < bonuses.length; i++) {
            if (forge > i) {
                lore.add(String.format("§aForge %d ✓ : %s", i + 1, bonuses[i])); // Niveau acquis
            } else {
                lore.add(String.format("§cForge %d ✗ : %s", i + 1, bonuses[i])); // Niveau non acquis
            }
        }

        return lore;
    }

    public static String getHealPoolName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isHealPool()){
            return "§aHealPool";
        }

        return "§cHealPool";
    }

    public static boolean getHealPoolEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isHealPool()){
            return true;
        }

        return false;
    }

    public static List<String> getHealPoolLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        lore.add("§bAjoute un effet de Heal dans votre base");

        if(teams.isHealPool()){
            lore.add("§bPossédé §f: §a✓");
        }else {
            lore.add("§bPossédé §f: §c✗");
        }

        return lore;
    }

    public static String getSpeedPoolName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isSpeedPool()){
            return "§aSpeedPool";
        }

        return "§cSpeedPool";
    }

    public static boolean getSpeedPoolEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isSpeedPool()){
            return true;
        }

        return false;
    }

    public static List<String> getSpeedPoolLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        lore.add("§bAjoute un effet de speed dans votre base");

        if(teams.isSpeedPool()){
            lore.add("§bPossédé §f: §a✓");
        }else {
            lore.add("§bPossédé §f: §c✗");
        }

        return lore;
    }

    public static String getSlownessName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isTrapSlowness()){
            return "§aTrap Slowness";
        }

        return "§cTrap Slowness";
    }

    public static boolean getSlownessEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isTrapSlowness()){
            return true;
        }

        return false;
    }

    public static List<String> getSlownessLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        lore.add("§bAjoute un piège donnant Slowness pendant 10s à vos ennemies");

        if(teams.isTrapSlowness()){
            lore.add("§bPossédé §f: §a✓");
        }else {
            lore.add("§bPossédé §f: §c✗");
        }

        return lore;
    }

    public static String getBlindnessName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isTrapBlindness()){
            return "§aTrap Blindness";
        }

        return "§cTrap Blindness";
    }

    public static boolean getBlindnessEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isTrapBlindness()){
            return true;
        }

        return false;
    }

    public static List<String> getBlindnessLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        lore.add("§bAjoute un piège donnant Blindness pendant 10s à vos ennemies");

        if(teams.isTrapBlindness()){
            lore.add("§bPossédé §f: §a✓");
        }else {
            lore.add("§bPossédé §f: §c✗");
        }

        return lore;
    }

    public static String getMiningName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isTrapMiningFatigue()){
            return "§aTrap Mining Fatigue";
        }

        return "§cTrap Mining Fatigue";
    }

    public static boolean getMiningEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isTrapMiningFatigue()){
            return true;
        }

        return false;
    }

    public static List<String> getMiningLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        lore.add("§bAjoute un piège donnant Mining Fatigue pendant 10s à vos ennemies");

        if(teams.isTrapMiningFatigue()){
            lore.add("§bPossédé §f: §a✓");
        }else {
            lore.add("§bPossédé §f: §c✗");
        }

        return lore;
    }

    public static String getAlarmName(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isAlarmTrap()){
            return "§aTrap Alarm";
        }

        return "§cTrap Alarm";
    }

    public static boolean getAlarmEnchant(Teams team){
        TeamAccount teams = teamAccounts.get(team);
        if(teams.isAlarmTrap()){
            return true;
        }

        return false;
    }

    public static List<String> getAlarmLore(Teams team){
        List<String> lore = new ArrayList<>();
        TeamAccount teams = teamAccounts.get(team);
        lore.add("§bAjoute un piège vous avertissant si un ennemie est présent à vôtre base");

        if(teams.isAlarmTrap()){
            lore.add("§bPossédé §f: §a✓");
        }else {
            lore.add("§bPossédé §f: §c✗");
        }

        return lore;
    }

    public static int countDiamondInventory(Player player){
        int count = 0;

        for(ItemStack item : player.getInventory()){
            if(item != null && item.getType() == Material.DIAMOND){
                count += item.getAmount();
            }
        }

        return  count;
    }
}
