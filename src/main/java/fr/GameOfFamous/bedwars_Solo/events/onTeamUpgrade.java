package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.commons.TeamAccount;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Utils.SendMessage;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class onTeamUpgrade implements Listener {

    private final Map<UUID, Teams> playerZone = new HashMap<>();

    @EventHandler
    public void playerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        Location to = e.getTo();
        GameManager manager = GameManager.getInstance();

        if(manager.gameState != GameState.IN_GAME){
            return;
        }

        if(manager.spectator.contains(player)){
            return;
        }

        Teams teams = manager.returnPlayerTeam(player);
        TeamAccount account = manager.teamAccounts.get(teams);

        Teams currentZone = getZoneAtLocation(to, manager);
        Teams lastZone = playerZone.get(player.getUniqueId());

        if(currentZone != null && currentZone != lastZone){
            playerZone.put(player.getUniqueId(), currentZone);
            if(teams == currentZone){
                player.sendMessage("Vous etes entre dans la zone : "+ currentZone.getPrefix());
                if(account.isHealPool()){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0, true, true));
                }
                if(account.isSpeedPool()){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, true));
                }
            }else{
                TeamAccount ennemiAccount = manager.teamAccounts.get(currentZone);
                Player basePlayer = ennemiAccount.getPlayer();

                if(ennemiAccount.isAlarmTrap()){
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
                    ennemiAccount.setAlarmTrap(false);
                    SendMessage.sendTitle(basePlayer, "§7Trap Activée", "§eUn joueur est entré dans vôtre base");
                    SendMessage.sendTitle(player, "§7Trap Activée", "§eVous avez déclenchez un piège !");
                }else if(ennemiAccount.isTrapBlindness()){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, true, true));
                    ennemiAccount.setTrapBlindness(false);
                    SendMessage.sendTitle(basePlayer, "§7Trap Blindness", "§eVôtre trap blindness à été activé !");
                    SendMessage.sendTitle(player, "§7Trap Blindness", "§eVous avez déclenchez un piège !");
                } else if (ennemiAccount.isTrapSlowness()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0, true, true));
                    ennemiAccount.setTrapSlowness(false);
                    SendMessage.sendTitle(basePlayer, "§7Trap Slowness", "§eVôtre trap slowness à été activé !");
                    SendMessage.sendTitle(player, "§7Trap Slowness", "§eVous avez déclenchez un piège !");
                } else if (ennemiAccount.isTrapMiningFatigue()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 0, true, true));
                    ennemiAccount.setTrapMiningFatigue(false);
                    SendMessage.sendTitle(basePlayer, "§7Trap Mining Fatigue", "§eVôtre trap mining fatigue à été activé !");
                    SendMessage.sendTitle(player, "§7Trap Mining Fatigue", "§eVous avez déclenchez un piège !");
                }
            }


        }else if(currentZone == null && lastZone != null){
            playerZone.remove(player.getUniqueId());
            player.sendMessage("Vous avez quitté la zone : "+ lastZone.getPrefix());
            player.removePotionEffect(PotionEffectType.SPEED);
            player.removePotionEffect(PotionEffectType.REGENERATION);
        }
    }

    public static Teams getZoneAtLocation(Location location, GameManager manager){
        for(Teams zone : manager.allTeams){
            if(zone.isInZone(location)){
                return zone;
            }
        }
        return null;
    }

}
