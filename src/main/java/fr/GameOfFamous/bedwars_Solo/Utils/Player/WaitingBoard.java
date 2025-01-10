package fr.GameOfFamous.bedwars_Solo.Utils.Player;

import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.states.Waiting;
import fr.GameOfFamous.hellstylia_API.Manager.BedwarsAccountManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public class WaitingBoard implements Runnable{

    private final static WaitingBoard instance = new WaitingBoard();

    public GameManager manager = GameManager.getInstance();

    private WaitingBoard(){

    }

    @Override
    public void run(){

        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getScoreboard() != null && player.getScoreboard().getObjective("Waiting") != null){
                updateScoreboard(player);
            }else{
                createNewScoreboard(player);
            }
        }

    }

    private void createNewScoreboard(Player player){

        UUID uuid = player.getUniqueId();

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("Waiting", "dummy");

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
        rankTeam.setPrefix("§b " + "§bDébut dans §f: ");
        rankTeam.setSuffix("§d0");
        objective.getScore(rankKey).setScore(7);

        // --- Argent ---
        Team REDTeam = scoreboard.registerNewTeam("REDTeam");
        String REDKey = ChatColor.RED.toString();
        REDTeam.addEntry(REDKey);
        REDTeam.setPrefix("§c " + "§aGame jouer §f: ");
        REDTeam.setSuffix("§d"+ BedwarsAccountManager.getGamePlayed(uuid));
        objective.getScore(REDKey).setScore(5);

        // --- Clan ---
        Team BlueTeam = scoreboard.registerNewTeam("BLUETeam");
        String BlueKey = ChatColor.BLUE.toString();
        BlueTeam.addEntry(BlueKey);
        BlueTeam.setPrefix("§9 " + "§aGame Gagner §f: ");
        BlueTeam.setSuffix("§d"+ BedwarsAccountManager.getGameWin(uuid));
        objective.getScore(BlueKey).setScore(4);

        // --- Grade ---
        Team YellowTeam = scoreboard.registerNewTeam("YELLOWTeam");
        String YellowKey = ChatColor.YELLOW.toString();
        YellowTeam.addEntry(YellowKey);
        YellowTeam.setPrefix("§e " + "§aKills §f: ");
        YellowTeam.setSuffix("§d"+ BedwarsAccountManager.getKills(uuid));
        objective.getScore(YellowKey).setScore(3);

        Team GreenTeam = scoreboard.registerNewTeam("GREENTeam");
        String GreedKey = ChatColor.GREEN.toString();
        GreenTeam.addEntry(GreedKey);
        GreenTeam.setPrefix("§a " + "§aDeath §f: ");
        GreenTeam.setSuffix("§d"+ BedwarsAccountManager.getDeath(uuid));
        objective.getScore(GreedKey).setScore(2);

        // Appliquer le scoreboard au joueur
        player.setScoreboard(scoreboard);

    }

    private void updateScoreboard(Player player){

        Scoreboard scoreboard = player.getScoreboard();

        // Mise à jour du rang
        Team team1 = scoreboard.getTeam("rankTeam");
        if (team1 != null) {
            team1.setSuffix("§d" +Waiting.countdown);
        }

    }

    public static WaitingBoard getInstance(){
        return instance;
    }

}
