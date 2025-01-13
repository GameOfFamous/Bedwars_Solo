package fr.GameOfFamous.bedwars_Solo.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class onInteract implements Listener {

    @EventHandler
    public void onInteractPlayer(PlayerInteractEvent e){
        Player player = e.getPlayer();
        ItemStack it = e.getItem();
        GameManager manager = GameManager.getInstance();

        if(manager.gameState == GameState.WAITING || manager.gameState == GameState.STANDING){
            if(it.getType() == Material.RED_BED && it.hasItemMeta() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§aRevenir au HUB")){
                final ByteArrayDataOutput out = ByteStreams.newDataOutput();

                connectToServer(player, out);
            }
        }
    }

    private void connectToServer(Player player, ByteArrayDataOutput out) {
        out.writeUTF("Connect");
        out.writeUTF("lobby");
        player.sendPluginMessage(Bedwars_Solo.instance, "BungeeCord", out.toByteArray());
        player.closeInventory();
    }

}
