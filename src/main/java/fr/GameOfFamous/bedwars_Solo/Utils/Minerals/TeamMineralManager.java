package fr.GameOfFamous.bedwars_Solo.Utils.Minerals;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.GameState;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.commons.TeamAccount;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.Supplier;

public abstract class TeamMineralManager {

    GameManager manager = GameManager.getInstance();

    protected final ItemStack iron = new ItemStack(Material.IRON_INGOT);
    protected final ItemStack gold = new ItemStack(Material.GOLD_INGOT);
    protected final ItemStack diamond = new ItemStack(Material.DIAMOND);
    protected final ItemStack emerald = new ItemStack(Material.EMERALD);

    protected int ironAmount;
    protected int goldAmount;
    protected int diamsAmount;
    protected int emeraldAmount;

    protected final TeamAccount team;
    protected final World world;
    protected final Location spawnLocation;

    protected TeamMineralManager(Teams team, Location spawnLocation) {
        this.team = manager.teamAccounts.get(team);
        this.world = Bukkit.getWorld("world");
        this.spawnLocation = spawnLocation;

        if (this.team == null) {
            throw new IllegalStateException("Team " + team + " is not initialized in GameManager.");
        }
        if (this.world == null) {
            throw new IllegalStateException("World 'world' is not loaded or does not exist.");
        }
        if (this.spawnLocation == null) {
            throw new IllegalStateException("Spawn location for team " + team + " is not defined.");
        }
    }

    public void setupMinerals() {
        // Mise à jour des quantités de minerais
        new BukkitRunnable() {
            @Override
            public void run() {
                updateMineralAmounts();
                if (manager.gameState.equals(GameState.FINISHED)) {
                    cancel();
                }
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, 20L);

        // Dépôts des minerais
        scheduleMineralDrop(iron, () -> ironAmount, 60L);
        scheduleMineralDrop(gold, () -> goldAmount, 200L);
        scheduleMineralDrop(diamond, () -> diamsAmount, 1200L);
        scheduleMineralDrop(emerald, () -> emeraldAmount, 1200L);
    }

    protected abstract void updateMineralAmounts();

    private void scheduleMineralDrop(ItemStack itemStack, Supplier<Integer> amountSupplier, long delay) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (manager.gameState.equals(GameState.FINISHED)) {
                    cancel();
                    return;
                }
                int amount = amountSupplier.get();
                if (amount > 0) {
                    dropItem(itemStack, amount, spawnLocation);
                }
            }
        }.runTaskTimer(Bedwars_Solo.instance, 0, delay);
    }

    private void dropItem(ItemStack itemStack, int amount, Location location) {
        itemStack.setAmount(amount);
        Item item = world.dropItem(location, itemStack);
        item.setPickupDelay(0);
        item.setVelocity(item.getVelocity().multiply(0));
    }

}
