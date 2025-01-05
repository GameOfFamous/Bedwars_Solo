package fr.GameOfFamous.bedwars_Solo.Utils.states;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.GameState;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import org.bukkit.scheduler.BukkitRunnable;

public class Standing {

    public static void gameLauncher(){

        GameManager manager = GameManager.getInstance();

        new BukkitRunnable(){

            @Override
            public void run() {
                if(manager.gameState.equals(GameState.STANDING)){
                    if(manager.players.size() >= 2){
                        Waiting.setWaiting();
                    }
                }else {
                    if(manager.players.isEmpty()){
                        //Reload du serveur
                        GameManager.getInstance().setGameState(GameState.STANDING);
                    }
                }
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);
    }

}
