package fr.GameOfFamous.bedwars_Solo;

import fr.GameOfFamous.bedwars_Solo.Commands.CommandHub;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.GameState;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.Border;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Redis.RedisAccess;
import fr.GameOfFamous.bedwars_Solo.Utils.states.Standing;
import fr.GameOfFamous.bedwars_Solo.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedwars_Solo extends JavaPlugin {

    public static Bedwars_Solo instance;

    @Override
    public void onEnable() {

        instance = this;

        RedisAccess.init();

        Standing.gameLauncher();

        Border.setBorder();

        GameManager.getInstance().setGameState(GameState.STANDING);

        getServer().getPluginManager().registerEvents(new eventsManager(), this);
        getServer().getPluginManager().registerEvents(new onArmorRemove(), this);
        getServer().getPluginManager().registerEvents(new onBlock(), this);
        getServer().getPluginManager().registerEvents(new onInventory(), this);
        getServer().getPluginManager().registerEvents(new onPlayerDamage(), this);
        getServer().getPluginManager().registerEvents(new onPlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new onPlayerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new onVillager(), this);

        getCommand("hub").setExecutor(new CommandHub());

        GameManager.getInstance().setupTeams();
        GameManager.getInstance().setupPnj();

    }

    @Override
    public void onDisable() {

        RedisAccess.close();

    }
}
