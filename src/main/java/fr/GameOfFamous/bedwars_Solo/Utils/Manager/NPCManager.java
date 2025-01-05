package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class NPCManager {

    public static void createNPC(Location location, String name) {
        // Créer un PNJ en tant qu'ArmorStand (entité immobile)
        Villager npc = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);

        // Configurer les propriétés du Villager
        npc.setCustomName(ChatColor.AQUA + name); // Nom visible
        npc.setCustomNameVisible(true); // Afficher le nom
        npc.setAI(false); // Désactiver l'IA (immobile)
        npc.setInvulnerable(true); // PNJ invincible
        npc.setCollidable(false); // Désactiver les collisions
        npc.setProfession(Villager.Profession.CLERIC); // Profession du Villager
        npc.setPersistent(true); // Empêcher la disparition naturelle

    }

    public static void removeNPC(World world, String name) {
        // Parcourt toutes les entités du monde
        for (Entity entity : world.getEntities()) {
            // Vérifie si l'entité est un Villager avec le nom spécifié
            if (entity instanceof Villager villager && name.equals(ChatColor.stripColor(villager.getCustomName()))) {
                villager.remove();
            }
        }
    }

}
