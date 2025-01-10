package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.InventoryUtils;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.PlayerManager;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Manager.BedwarsAccountManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onPlayerDamage implements Listener {

    public GameManager manager = GameManager.getInstance();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        // Si le jeu n'est pas en cours, annulez l'événement
        if (manager.gameState != GameState.IN_GAME) {
            e.setCancelled(true);
            return;
        }else {
            e.setCancelled(false);
        }

        // Vérification si les entités concernées sont des joueurs
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player p = (Player) e.getEntity();
            Player damager = (Player) e.getDamager();

            // Calcul de la santé finale du joueur après le dommage
            double finalHealth = p.getHealth() - e.getFinalDamage();

            if (finalHealth <= 0) {
                // Annulation du dommage et gestion de la mort du joueur
                e.setCancelled(true);

                // Transfert des objets au joueur qui a infligé le dommage
                transferPlayerItems(p, damager);

                // Mise à jour des statistiques de l'account
                BedwarsAccountManager.addKills(damager.getUniqueId());
                BedwarsAccountManager.addDeath(p.getUniqueId());

                // Respawn le joueur
                PlayerManager.respawnPlayer(p);
            }
        }

    }

    private void transferPlayerItems(Player from, Player to) {
        // Transfert des objets spécifiques de `from` à `to`
        InventoryUtils.transferItems(from, to, item -> item.getType() == Material.IRON_INGOT);
    }

}
