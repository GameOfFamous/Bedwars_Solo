package fr.GameOfFamous.bedwars_Solo.Utils.states;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.CustomNPC;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.MineraisLoc;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.events.onBlock;
import fr.GameOfFamous.commons.TeamAccount;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Manager.BedwarsAccountManager;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import fr.GameOfFamous.hellstylia_API.Utils.NPCcreator;
import fr.GameOfFamous.hellstylia_API.Utils.SendMessage;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Finish {

    public static void detectFinish(){

        GameManager manager = GameManager.getInstance();

        new BukkitRunnable(){
            @Override
            public void run() {
                if(Bukkit.getOnlinePlayers().isEmpty()){
                    cancel();
                }
                if(manager.gameState != GameState.IN_GAME){
                    cancel();
                    return;
                }

                if(manager.playTeams.size() == 1){

                    Teams team = manager.playTeams.get(0);
                    Player winner = manager.teamAccounts.get(team).getPlayer();
                    resetPlayer(winner, team, manager);
                    for(Player player : Bukkit.getOnlinePlayers()){
                        SendMessage.sendTitle(player, team.getPrefix(), "§bsont les gagnants !");
                    }
                    resetGame(manager);
                    reloadGame(manager);
                    cancel();
                }
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 1L);
    }

    private static void resetPlayer(Player player, Teams teams, GameManager manager){

        player.getInventory().clear();
        player.setGameMode(GameMode.SPECTATOR);

        player.setHealth(20);
        player.setFoodLevel(20);

        manager.playTeams.remove(teams);
        BedwarsAccountManager.addGamePlayed(player.getUniqueId());
        BedwarsAccountManager.addGameWin(player.getUniqueId());
    }

    private static void resetGame(GameManager manager){

        manager.setGameState(GameState.FINISHED);
        manager.allTasks.get("Hellstylia").cancel();
        manager.removeScordboard("Hellstylia");
        for(CustomNPC customNPC : manager.allPNJ){
            NPCcreator.removeNPC(customNPC.getName());
        }
        for(Player player : Bukkit.getOnlinePlayers()){
            player.setPlayerListName(player.getDisplayName());
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }

        manager.teamAccounts.clear();
        manager.marketAccounts.clear();
        manager.allTasks.clear();
        manager.playTeams.clear();
        manager.players.clear();
        manager.spectator.clear();

    }

    private static void reloadGame(GameManager manager){
        onBlock.resetMap();
        new BukkitRunnable(){
            int time = 60;

            @Override
            public void run() {
                if(Bukkit.getOnlinePlayers().isEmpty()){
                    cancel();
                }

                for(Player player : Bukkit.getOnlinePlayers()) {
                    SendMessage.sendActionBar(player, "§aRelancement du jeu dans : §f" + time);
                }
                if (time <= 0){
                    time = 60;
                    reFillPlayers(manager);
                    manager.setGameState(GameState.STANDING);
                    cancel();
                }

                time --;
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);
    }

    private static void reFillPlayers(GameManager manager){
        for(Player player : Bukkit.getOnlinePlayers()){
            SendMessage.sendActionBar(player, "§cAttente du reset de la map");
            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(MineraisLoc.LOBBY.getLocation());
            manager.initPlayers(player);
            player.getInventory().setItem(8, CreateItem.newItem(Material.RED_BED, 1, "§aRevenir au HUB", false, new String[]{}));
        }

    }

}
