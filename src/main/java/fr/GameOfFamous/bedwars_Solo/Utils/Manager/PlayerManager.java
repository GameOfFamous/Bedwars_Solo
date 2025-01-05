package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.GameState;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.MineraisLoc;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SendMessage;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SetPlayerStuff;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerManager {

    public static void respawnPlayerWithBed(Player p){
        Teams team = GameManager.getInstance().returnPlayerTeam(p);

        GameState state = GameManager.getInstance().gameState;

        p.getInventory().clear();
        p.setGameMode(GameMode.SPECTATOR);
        p.teleport(MineraisLoc.LOBBY.getLocation());

        new BukkitRunnable(){
            int timer = 5;
            @Override
            public void run() {

                if(state != GameState.IN_GAME){
                    cancel();
                    return;
                }

                if(timer <= 0){
                    p.setGameMode(GameMode.SURVIVAL);
                    SetPlayerStuff.setPlayerArmor(p);
                    SetPlayerStuff.setPlayerSword(p);
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.teleport(team.getSpawnLoc());
                    timer = 5;
                    cancel();
                }

                SendMessage.sendActionBar(p, "Respawn dans : " + timer + " secondes");

                timer --;
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);
    }

    public static void respawnPlayerWithoutBed(Player p){
        Teams team = GameManager.getInstance().returnPlayerTeam(p);

        p.getInventory().clear();
        p.setGameMode(GameMode.SPECTATOR);

        p.setHealth(20);
        p.setFoodLevel(20);

        GameManager.getInstance().playTeams.remove(team);
        AccountManager.addGamePlayed(p.getUniqueId());

        SendMessage.sendTitle(p, "§cLit détruit", "§aVous êtes maintenant spectateur");
    }

}
