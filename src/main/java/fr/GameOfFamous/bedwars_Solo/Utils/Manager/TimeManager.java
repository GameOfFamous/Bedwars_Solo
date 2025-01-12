package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeManager {

    public static int minutes = 0;
    public static int secondes = 0;

    public static void initGameTime(){

        GameManager manager = GameManager.getInstance();

        new BukkitRunnable(){

            @Override
            public void run() {

                if(manager.gameState != GameState.IN_GAME){
                    minutes = 0;
                    secondes = 0;
                    cancel();
                }

                if(secondes == 60){
                    minutes ++;
                    secondes = 0;
                }

                secondes ++;
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);
    }

}
