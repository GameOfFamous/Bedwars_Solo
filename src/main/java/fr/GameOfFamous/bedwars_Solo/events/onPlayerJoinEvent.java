package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.MineraisLoc;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SendMessage;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

public class onPlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        GameManager manager = GameManager.getInstance();

        player.teleport(MineraisLoc.LOBBY.getLocation());
        player.getInventory().clear();

        GameManager.getInstance().initPlayers(player);
        SendMessage.sendTitleJoining(player);
        if(manager.gameState == GameState.WAITING || manager.gameState == GameState.STANDING){
            player.getInventory().setItem(8, CreateItem.newItem(Material.RED_BED, 1, "§aRevenir au HUB", false, new String[]{}));
            player.setGameMode(GameMode.SURVIVAL);
            player.setFoodLevel(20);
            player.setHealth(20);
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }else {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }

}
