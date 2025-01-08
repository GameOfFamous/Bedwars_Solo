package fr.GameOfFamous.bedwars_Solo.Utils.states;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Player.InGameBoard;
import fr.GameOfFamous.bedwars_Solo.Utils.Player.WaitingBoard;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Utils.SendMessage;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Waiting {

    public static int countdown = 60;

    public static void setWaiting() {

        GameManager manager = GameManager.getInstance();

        GameManager.getInstance().setGameState(GameState.WAITING);

        GameManager.getInstance().clearWorldEntities();

        manager.task2 = Bukkit.getServer().getScheduler().runTaskTimer(Bedwars_Solo.instance, WaitingBoard.getInstance(), 0, 1);

        new BukkitRunnable() {

            @Override
            public void run() {
                if (manager.gameState != GameState.WAITING) {
                    System.out.println("pas en waiting");
                    cancel();
                    return;
                }

                if (!manager.players.isEmpty()) {
                    for (Player player : manager.players) {
                        // Normalisez countdown pour qu'il soit compris entre 0.0 et 1.0
                        float progress = (float) countdown / 60;

                        // Clamp entre 0.0 et 1.0 pour éviter les erreurs
                        progress = Math.min(1.0f, Math.max(0.0f, progress));

                        // Appliquez la valeur normalisée
                        player.setExp(progress);
                        player.setLevel(countdown);

                        if(countdown <= 5){
                            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                        }
                        if(countdown == 30){
                            SendMessage.sendClickableMessage(player, "§aN'oublie pas de rejoindre le Discord ! Click ici !", "https://discord.gg/JU5QP2fCVG");
                        }

                    }
                }

                if (countdown <= 0) {
                    countdown = 60;
                    Starting.setStarting();
                    cancel();
                }

                countdown--;
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);
    }

}
