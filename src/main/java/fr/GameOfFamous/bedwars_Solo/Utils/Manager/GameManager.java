package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.CustomNPC;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Minerals.*;
import fr.GameOfFamous.commons.MarketAccount;
import fr.GameOfFamous.commons.TeamAccount;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Utils.NPCcreator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GameManager {

    private static volatile GameManager instance;

    public GameState gameState = GameState.STANDING;

    public List<Teams> allTeams = new ArrayList<>();

    public List<CustomNPC> allPNJ = new ArrayList<>();

    public List<Player> players = new ArrayList<>();

    public List<Player> spectator = new ArrayList<>();

    public List<Teams> playTeams = new ArrayList<>();


    public final ConcurrentHashMap<Teams, TeamAccount> teamAccounts = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<Player, MarketAccount> marketAccounts = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, BukkitTask> allTasks = new ConcurrentHashMap<>();


    public final TeamAccount DEFAULT_ACCOUNT = new TeamAccount(null,true, true, false, 0, 0, 0, false, false, false, false,false, false);
    public final MarketAccount DEFAULT_MARKET = new MarketAccount(0,0,0);

    public GameManager(){}

    public void setGameState(GameState state){
        gameState = state;
    }

    public void clearWorldEntities() {

        World world = Bukkit.getWorld("world");

        for(Teams team : allTeams){
            supprBedInWorld(team);
        }

        if (world == null) {
            System.out.println("Le monde spécifié est null.");
            return;
        }

        // Parcourir toutes les entités dans le monde
        for (Entity entity : world.getEntities()) {
            // Vérifiez si l'entité ne doit pas être exclue
            if (!(entity instanceof Player)) { // Ne supprimez pas les joueurs
                entity.remove(); // Supprime l'entité
            }
        }
    }

    public void supprBedInWorld(Teams teams){

        World world = Bukkit.getWorld("world");

        if(world == null) return;

        Block block = world.getBlockAt(teams.getBedLocation());

        if(block.getType() == Material.RED_BED || block.getType() == Material.GREEN_BED || block.getType() == Material.YELLOW_BED || block.getType() == Material.BLUE_BED){
            block.setType(Material.AIR);
        }
    }

    public void initPlayers(Player player){
        if(players.size() == 4){
            spectator.add(player);
        }
        players.add(player);
    }

    public void updatePlayers(Player player){
        if(players.contains(player)){
            Bukkit.broadcastMessage("§cLe joueur §a" + player.getDisplayName() + " §cviens de quitter la partie");
            players.remove(player);
            if(!(returnPlayerTeam(player) == null)){
                playTeams.remove(returnPlayerTeam(player));
            }
        }
        spectator.remove(player);
    }

    public Teams returnPlayerTeam(Player player){

        for(Teams team : playTeams){

            TeamAccount account = teamAccounts.get(team);

            if(account.getPlayer().equals(player)){
                return team;
            }
        }

        return null;
    }

    public void assignPlayerToTeams(Player player, Teams team){

        if (player == null || team == null) {
            throw new IllegalArgumentException("Player or team cannot be null.");
        }

        final TeamAccount teamAccount = DEFAULT_ACCOUNT.clone();
        final MarketAccount marketAccount = DEFAULT_MARKET.clone();

        teamAccount.setPlayer(player);

        synchronized (teamAccounts) {
            teamAccounts.put(team, teamAccount);
        }

        synchronized (marketAccounts) {
            marketAccounts.put(player, marketAccount);
        }

        synchronized (playTeams) {
            if (!playTeams.contains(team)) {
                playTeams.add(team);
                placeBedInWorld(team);
            }
        }
    }

    public void placeBedInWorld(Teams teams){
        // Vérifiez si le monde existe
        World world = Bukkit.getWorld("world");
        if (world == null) {
            Bukkit.getLogger().warning("Le monde spécifié est introuvable !");
            return;
        }

        Location loc = teams.getBedLocation();
        BlockFace face = teams.getBlockFace();
        Material material = teams.getBed();

        // Vérifiez que le matériau est un lit
        if (!material.name().endsWith("_BED")) {
            Bukkit.getLogger().warning("Le matériau spécifié n'est pas un lit !");
            return;
        }

        Block bedblock = world.getBlockAt(loc);

        bedblock.setType(material);
        Bed bedData = (Bed) bedblock.getBlockData();
        bedData.setPart(Bed.Part.HEAD);
        bedData.setFacing(face);
        bedblock.setBlockData(bedData);

        Block footblock = bedblock.getRelative(bedData.getFacing().getOppositeFace());

        footblock.setType(material);
        Bed footData = (Bed) footblock.getBlockData();
        footData.setPart(Bed.Part.FOOT);
        footData.setFacing(face);
        footblock.setBlockData(footData);

    }

    public void placeVillager(){

        for(Teams team : playTeams){
            for(CustomNPC customNPC : allPNJ){
                if(customNPC.getTeam() == team){
                    NPCcreator.createNPC(customNPC.getLocation(), customNPC.getName());
                }
            }
        }
    }

    public void setupmineral(){

        for (Teams team : playTeams){
            if(team.equals(Teams.BLUE)){
                Blue.getInstance().setupMinerals();
            } else if (team.equals(Teams.GREEN)) {
                Green.getInstance().setupMinerals();
            } else if (team.equals(Teams.YELLOW)) {
                Yellow.getInstance().setupMinerals();
            } else if (team.equals(Teams.RED)) {
                Red.getInstance().setupMinerals();
            }
        }
        DiamondEmerald.getInstance().setupDiamsEmeraldMineral();
    }

    public void setupTeams(){
        Collections.addAll(allTeams, Teams.values());
    }

    public void setupPnj(){
        Collections.addAll(allPNJ, CustomNPC.values());
    }

    public boolean isBedAlive(Teams team){
        if(teamAccounts.get(team) == null){
            return false;
        }
        return teamAccounts.get(team).isBedAlive();
    }

    public boolean isPlayerAlive(Teams teams){
        if(teamAccounts.get(teams) == null) return  false;

        return teamAccounts.get(teams).isPlayerAlive();
    }

    public String returnSymboleBed(Teams team){
        if(isBedAlive(team)){
            return "§a✓ ";
        }else{
            if(isPlayerAlive(team)) return "§7[§a1§7]";
        }
        return "§c✗ ";
    }

    public String detectPlayerTeam(Player player, Teams teams){
        if(returnPlayerTeam(player).equals(teams)){
            return "§7YOU";
        }
        return " ";
    }

    public static GameManager getInstance() {
        if (instance == null) {
            synchronized (GameManager.class) {
                if (instance == null) {
                    instance = new GameManager();
                }
            }
        }
        return instance;
    }

    public void removeScordboard(String objectiveName){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        Objective objective = scoreboard.getObjective(objectiveName);
        if(objective != null){
            objective.unregister();
        }
    }

    public void cancelAllTasks(Plugin plugin){
        BukkitScheduler scheduler = Bukkit.getScheduler();

        List<BukkitTask> tasks = scheduler.getPendingTasks();

        for(BukkitTask task : tasks){
            if(task.getOwner().equals(plugin)){
                scheduler.cancelTask(task.getTaskId());
            }
        }
    }

}
