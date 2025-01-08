package fr.GameOfFamous.bedwars_Solo.Utils.Player;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class InGameBoard implements Runnable{

    private final static InGameBoard instance = new InGameBoard();

    public GameManager manager = GameManager.getInstance();

    private InGameBoard(){

    }

    @Override
    public void run(){

        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getScoreboard() != null && player.getScoreboard().getObjective("Hellstylia") != null){
                updateScoreboard(player);
            }else{
                createNewScoreboard(player);
            }
        }

    }

    private void createNewScoreboard(Player player){

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("Hellstylia", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Hellstylia");

        objective.getScore("§8 ").setScore(8); // Ligne vide pour espacer
        objective.getScore("§2 ").setScore(6); // Ligne vide pour espacer
        objective.getScore("§1 ").setScore(1); // Ligne vide pour espacer
        objective.getScore("§6§lhellstylia.com").setScore(0); // Site web ou footer

        // --- Rang ---
        Team rankTeam = scoreboard.registerNewTeam("rankTeam");
        String rankKey = ChatColor.AQUA.toString();
        rankTeam.addEntry(rankKey);
        rankTeam.setPrefix("§b " + "Vous ete : ");
        rankTeam.setSuffix(manager.returnPlayerTeam(player).getPrefix());
        objective.getScore(rankKey).setScore(7);

        // --- Argent ---
        Team REDTeam = scoreboard.registerNewTeam("REDTeam");
        String REDKey = ChatColor.RED.toString();
        REDTeam.addEntry(REDKey);
        REDTeam.setPrefix("§c " + manager.returnSymboleBed(Teams.RED));
        REDTeam.setSuffix("§cRed");
        objective.getScore(REDKey).setScore(5);

        // --- Clan ---
        Team BlueTeam = scoreboard.registerNewTeam("BLUETeam");
        String BlueKey = ChatColor.BLUE.toString();
        BlueTeam.addEntry(BlueKey);
        BlueTeam.setPrefix("§9 " + manager.returnSymboleBed(Teams.BLUE));
        BlueTeam.setSuffix("§9Blue");
        objective.getScore(BlueKey).setScore(4);

        // --- Grade ---
        Team YellowTeam = scoreboard.registerNewTeam("YELLOWTeam");
        String YellowKey = ChatColor.YELLOW.toString();
        YellowTeam.addEntry(YellowKey);
        YellowTeam.setPrefix("§e " + manager.returnSymboleBed(Teams.YELLOW));
        YellowTeam.setSuffix("§eYellow");
        objective.getScore(YellowKey).setScore(3);

        Team GreenTeam = scoreboard.registerNewTeam("GREENTeam");
        String GreedKey = ChatColor.GREEN.toString();
        GreenTeam.addEntry(GreedKey);
        GreenTeam.setPrefix("§a " + manager.returnSymboleBed(Teams.GREEN));
        GreenTeam.setSuffix("§aGreen");
        objective.getScore(GreedKey).setScore(2);

        // Appliquer le scoreboard au joueur
        player.setScoreboard(scoreboard);

    }

    private void updateScoreboard(Player player){

        Scoreboard scoreboard = player.getScoreboard();

        // Mise à jour du rang
        Team team1 = scoreboard.getTeam("rankTeam");
        if (team1 != null) {
            team1.setSuffix(manager.returnPlayerTeam(player).getPrefix());
        }

        // Mise à jour de l'argent
        Team team2 = scoreboard.getTeam("REDTeam");
        if (team2 != null) {
            team2.setPrefix("§c " + manager.returnSymboleBed(Teams.RED));
        }

        // Mise à jour du clan
        Team team3 = scoreboard.getTeam("BLUETeam");
        if (team3 != null) {
            team3.setPrefix("§9 " + manager.returnSymboleBed(Teams.BLUE));
        }

        // Mise à jour du grade
        Team team4 = scoreboard.getTeam("YELLOWTeam");
        if (team4 != null) {
            team4.setPrefix("§e " + manager.returnSymboleBed(Teams.YELLOW));
        }

        // Mise à jour du grade
        Team team5 = scoreboard.getTeam("GREENTeam");
        if (team5 != null) {
            team5.setPrefix("§a " + manager.returnSymboleBed(Teams.GREEN));
        }

    }

    public static InGameBoard getInstance(){
        return instance;
    }

}
