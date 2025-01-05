package fr.GameOfFamous.bedwars_Solo.Utils.Minerals;

import fr.gameoffamous.bedwarssolo.BedwarsSolo;
import fr.gameoffamous.bedwarssolo.Utils.Enums.GameState;
import fr.gameoffamous.bedwarssolo.Utils.Enums.MineraisLoc;
import fr.gameoffamous.bedwarssolo.Utils.Manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class DiamondEmerald {

    GameManager manager = GameManager.getInstance();

    private static final DiamondEmerald instance = new DiamondEmerald();

    private final ItemStack diamond = new ItemStack(Material.DIAMOND);
    private final ItemStack emerald = new ItemStack(Material.EMERALD);

    private int diamondAmount = 1;
    private final int emeraldAmount = 1;

    private int diamondUpgradeTimer = 300; // Temps en secondes avant le prochain niveau de diamant
    private int diamondLevel = 0;

    private final World world;

    private static final long DIAMOND_EMERALD_DROP_DELAY = 300L; // 15 secondes (ticks)
    private static final long DIAMOND_UPGRADE_DELAY = 20L; // 1 seconde (ticks)

    private DiamondEmerald() {
        this.world = Bukkit.getWorld("world");
        if (this.world == null) {
            throw new IllegalStateException("World 'world' is not loaded or does not exist.");
        }
    }

    public void setupDiamsEmeraldMineral() {
        // Gestion de l'augmentation des niveaux de diamant
        new BukkitRunnable() {
            @Override
            public void run() {
                if (manager.gameState.equals(GameState.FINISHED)) {
                    cancel();
                    return;
                }

                // Mise à jour du niveau et de la quantité de diamants
                if (diamondUpgradeTimer <= 0) {
                    diamondLevel++;
                    diamondAmount = Math.min(3, diamondLevel + 1); // Limite à 3 diamants
                    diamondUpgradeTimer = 300; // Réinitialise le temps pour la prochaine augmentation
                }
                diamondUpgradeTimer--;
            }
        }.runTaskTimer(BedwarsSolo.instance, 0, DIAMOND_UPGRADE_DELAY);

        // Dépôt des diamants et des émeraudes
        new BukkitRunnable() {
            @Override
            public void run() {
                if (manager.gameState.equals(GameState.FINISHED)) {
                    cancel();
                    return;
                }

                // Déposer les objets
                dropItem(diamond, diamondAmount, MineraisLoc.DIAMOND1.getLocation());
                dropItem(diamond, diamondAmount, MineraisLoc.DIAMOND2.getLocation());
                dropItem(diamond, diamondAmount, MineraisLoc.DIAMOND3.getLocation());
                dropItem(diamond, diamondAmount, MineraisLoc.DIAMOND4.getLocation());
                dropItem(emerald, emeraldAmount, MineraisLoc.EMERALD1.getLocation());
                dropItem(emerald, emeraldAmount, MineraisLoc.EMERALD2.getLocation());
            }
        }.runTaskTimer(BedwarsSolo.instance, 0, DIAMOND_EMERALD_DROP_DELAY);
    }

    private void dropItem(ItemStack itemStack, int amount, Location location) {
        if (location == null) {
            Bukkit.getLogger().severe("Mineral spawn location is not defined.");
            return;
        }

        itemStack.setAmount(amount);
        Item item = world.dropItem(location, itemStack);

        item.setPickupDelay(0); // Temps avant que l'objet puisse être ramassé
        item.setVelocity(item.getVelocity().multiply(0)); // Empêche le mouvement des objets
    }

    public static DiamondEmerald getInstance() {
        return instance;
    }

}
