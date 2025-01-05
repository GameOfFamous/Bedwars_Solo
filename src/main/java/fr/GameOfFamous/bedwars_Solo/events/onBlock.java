package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.GameState;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.AccountManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.commons.TeamAccount;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class onBlock implements Listener {

    public static final Set<Location> playerPlacedBlocks = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public GameManager manager = GameManager.getInstance();

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e){
        // Vérifiez que l'événement et ses données ne sont pas null
        if (e == null || e.getPlayer() == null || e.getBlockPlaced() == null) {
            System.out.println("BlockPlaceEvent : Événement ou données nulles.");
            return;
        }

        Player player = e.getPlayer();
        Location blockLocation = e.getBlockPlaced().getLocation();

        // Vérifiez l'état du jeu
        if (manager.gameState != GameState.IN_GAME) {
            e.setCancelled(true);
            return;
        }else {
            e.setCancelled(false);
        }

        // Ajoutez le bloc à la liste des blocs placés par les joueurs
        playerPlacedBlocks.add(blockLocation);

        // Ajoutez le placement du bloc au gestionnaire de compte
        AccountManager.addBlockPlace(player.getUniqueId());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Location blockLocation = event.getBlock().getLocation();
        Material block = event.getBlock().getType();
        Player p = event.getPlayer();

        if(manager.gameState != GameState.IN_GAME){
            event.setCancelled(true);
        }else {
            event.setCancelled(false);
        }

        if(Tag.BEDS.isTagged(block)){
            switch (block){
                case RED_BED:
                    deadBed(Teams.RED, p);
                    break;
                case BLUE_BED:
                    deadBed(Teams.BLUE, p);
                    break;
                case YELLOW_BED:
                    deadBed(Teams.YELLOW, p);
                    break;
                case GREEN_BED:
                    deadBed(Teams.GREEN, p);
                    break;
            }
        }

        // Vérifie si le bloc est dans la liste des blocs placés par les joueurs
        if (playerPlacedBlocks.contains(blockLocation)) {
            playerPlacedBlocks.remove(blockLocation); // Retire l'emplacement après destruction
        } else {
            if(block == Material.RED_BED || block == Material.GREEN_BED || block == Material.YELLOW_BED || block == Material.BLUE_BED){
                event.setCancelled(true);
                event.setDropItems(false);
                return;
            }
            event.setCancelled(true); // Bloque la destruction si le bloc n'a pas été placé par un joueur
            event.getPlayer().sendMessage("§cVous ne pouvez pas casser les structures");
        }
    }

    public void deadBed(Teams team, Player p){
        if (team == null || p == null) {
            return; // Évite les erreurs null
        }

        Teams teams = manager.returnPlayerTeam(p);
        if(teams == team){
            return;
        }

        manager.supprBedInWorld(team);
        AccountManager.addBedDestroy(p.getUniqueId());
        TeamAccount teamAccount = manager.teamAccounts.get(team);
        if (teamAccount == null) {
            return;
        }

        teamAccount.setBedAlive(false);
        Bukkit.broadcastMessage("Le lit " + team.getPrefix() + " a été cassé par " + p.getDisplayName());

        Player bedOwner = teamAccount.getPlayer();
        if (bedOwner != null) {
            bedOwner.playSound(bedOwner.getLocation(), Sound.ENTITY_GHAST_DEATH, 1.0f, 1.0f);
        }
    }

    public static void resetMap() {
        new BukkitRunnable() {
            private final Iterator<Location> iterator = playerPlacedBlocks.iterator();

            @Override
            public void run() {
                if (!iterator.hasNext()) {
                    cancel();
                    playerPlacedBlocks.clear();
                    Bukkit.getLogger().info("La carte a été réinitialisée !");
                    return;
                }

                Location loc = iterator.next();
                if (loc.getBlock().getType() != Material.AIR) {
                    loc.getBlock().setType(Material.AIR);
                }
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 1L);
    }

}
