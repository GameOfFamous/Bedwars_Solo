package fr.GameOfFamous.bedwars_Solo.Utils.states;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.CustomNPC;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.GameState;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.MineraisLoc;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.CreateItem;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SendMessage;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.AccountManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.NPCManager;
import fr.GameOfFamous.bedwars_Solo.events.onBlock;
import fr.GameOfFamous.commons.TeamAccount;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.ConcurrentHashMap;

public class Finish {

    public static void detectFinish(){

        GameManager manager = GameManager.getInstance();

        ConcurrentHashMap<Teams, TeamAccount> teamAccounts = manager.teamAccounts;

        new BukkitRunnable(){
            @Override
            public void run() {
                if(Bukkit.getOnlinePlayers().size() == 0){
                    cancel();
                }
                if(manager.gameState != GameState.IN_GAME){
                    cancel();
                    return;
                }

                if(manager.playTeams.size() == 1){
                    cancel();
                    Teams team = manager.playTeams.get(0);
                    if(manager.task != null){
                        manager.task.cancel();
                        manager.task = null;
                    }
                    Player winner = teamAccounts.get(team).getPlayer();
                    AccountManager.addGameWin(winner.getUniqueId());
                    AccountManager.addGamePlayed(winner.getUniqueId());
                    manager.setGameState(GameState.FINISHED);
                    for(Player player : Bukkit.getOnlinePlayers()){
                        SendMessage.sendTitle(player, team.getPrefix(), "§bsont les gagnants !");
                        player.getInventory().clear();
                        player.setGameMode(GameMode.SPECTATOR);
                    }
                    reloadGame();
                }
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 1L);
    }

    public static void reloadGame(){
        GameManager manager = GameManager.getInstance();
        onBlock.resetMap();
        for(CustomNPC customNPC : manager.allPNJ){
            NPCManager.removeNPC(Bukkit.getWorld("world"), customNPC.getName());
        }
        new BukkitRunnable(){
            int time = 60;

            @Override
            public void run() {
                if(Bukkit.getOnlinePlayers().size() == 0){
                    cancel();
                }

                for(Player player : Bukkit.getOnlinePlayers()) {
                    SendMessage.sendActionBar(player, "§aRelancement du jeu dans : §f" + time);
                }
                    if (time <= 0){
                        time = 60;
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            SendMessage.sendActionBar(player, "§cAttente du reset de la map");
                            player.setPlayerListName(player.getDisplayName());
                            player.teleport(MineraisLoc.LOBBY.getLocation());
                            player.getInventory().clear();
                            player.setGameMode(GameMode.SURVIVAL);
                            manager.initPlayers(player);
                            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                            player.getInventory().setItem(8, CreateItem.newItem(Material.RED_BED, 1, "§aRevenir au HUB", false, new String[]{}));
                        }
                        manager.teamAccounts.clear();
                        manager.playTeams.clear();
                        manager.marketAccounts.clear();
                        manager.players.clear();
                        manager.setGameState(GameState.STANDING);
                        cancel();
                    }

                time --;
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);
    }

}
