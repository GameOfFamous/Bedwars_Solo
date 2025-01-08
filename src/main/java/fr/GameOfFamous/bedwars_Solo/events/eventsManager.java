package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class eventsManager implements Listener {

    @EventHandler
    public void onFoodLevel(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(p.getLocation().getY() <= 0){
            Teams team = GameManager.getInstance().returnPlayerTeam(p);
            if (GameManager.getInstance().teamAccounts.get(team).isBedAlive()) {
                // Respawn si le lit est intact
                PlayerManager.respawnPlayerWithBed(p);
            } else {
                // Sinon, fin du joueur
                PlayerManager.respawnPlayerWithoutBed(p);
            }
        }

    }

}
