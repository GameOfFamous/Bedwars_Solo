package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.MineraisLoc;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SetPlayerStuff;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Manager.BedwarsAccountManager;
import fr.GameOfFamous.hellstylia_API.Utils.SendMessage;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerManager {

    public static void respawnPlayer(Player player){

        Teams teams = GameManager.getInstance().returnPlayerTeam(player);
        GameManager manager = GameManager.getInstance();

        if(manager.teamAccounts.get(teams).isBedAlive()){
            resetPlayerStats(player, teams, manager);
            return;
        }

        resetPlayer(player, teams, manager);

    }

    private static void resetPlayerStats(Player player, Teams teams, GameManager manager){
        player.getInventory().clear();
        player.setGameMode(GameMode.SPECTATOR);
        player.teleport(MineraisLoc.LOBBY.getLocation());
        manager.marketAccounts.get(player).setSword(0);

        startRespawnTimer(player, teams, manager);
    }

    private static void startRespawnTimer(Player player, Teams teams, GameManager manager){

        new BukkitRunnable(){
            int timer = 5;

            @Override
            public void run() {
                // Vérifier si le jeu est toujours en cours
                if (manager.gameState != GameState.IN_GAME) {
                    cancel();
                    return;
                }

                // Fin du décompte, réinitialisation du joueur
                if (timer <= 0) {
                    respawnPlayer(player, teams);
                    cancel();
                    return;
                }

                // Envoyer le message de décompte
                SendMessage.sendActionBar(player, "Respawn dans : §e" + timer + " §fsecondes");
                timer--;
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);

    }

    private static void respawnPlayer(Player player, Teams teams){
        // Réinitialisation complète du joueur après respawn
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(20.0);
        player.setFoodLevel(20);

        // Donner l'équipement
        SetPlayerStuff.setPlayerArmor(player);
        SetPlayerStuff.setPlayerSword(player);

        // Téléporter le joueur au spawn de son équipe
        player.teleport(teams.getSpawnLoc());
    }

    private static void resetPlayer(Player player, Teams teams, GameManager manager){

        player.getInventory().clear();
        player.setGameMode(GameMode.SPECTATOR);

        player.setHealth(20);
        player.setFoodLevel(20);

        GameManager.getInstance().playTeams.remove(teams);
        BedwarsAccountManager.addGamePlayed(player.getUniqueId());

        SendMessage.sendTitle(player, "§cLit détruit", "§aVous êtes maintenant spectateur");
    }

}
