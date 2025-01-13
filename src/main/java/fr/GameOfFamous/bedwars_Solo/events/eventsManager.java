package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.PlayerManager;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
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
            PlayerManager.respawnPlayer(p);
        }

    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){

        if(GameManager.getInstance().gameState != GameState.IN_GAME){
            e.setCancelled(true);
        }

        e.setCancelled(false);
    }

    @EventHandler
    public void onInventoryMove(InventoryMoveItemEvent e){
        if(GameManager.getInstance().gameState != GameState.IN_GAME){
            e.setCancelled(true);
        }

        e.setCancelled(false);
    }

}
