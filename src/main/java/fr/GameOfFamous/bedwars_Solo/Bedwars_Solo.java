package fr.GameOfFamous.bedwars_Solo;

import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.states.Standing;
import fr.GameOfFamous.bedwars_Solo.events.*;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import fr.GameOfFamous.hellstylia_API.Hellstylia_API;
import fr.GameOfFamous.hellstylia_API.Utils.Border;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedwars_Solo extends JavaPlugin {

    public static Bedwars_Solo instance;

    private Hellstylia_API apiPlugin;

    @Override
    public void onEnable() {

        instance = this;

        Plugin api = getServer().getPluginManager().getPlugin("Hellstylia_API");

        if (api != null && api.isEnabled() && api instanceof Hellstylia_API) {
            this.apiPlugin = (Hellstylia_API) api;
            getLogger().info("Hellstylia_API détecté et initialisé !");
        } else {
            getLogger().severe("Hellstylia_API introuvable ou désactivé ! Assurez-vous qu'il est correctement installé.");
            getServer().getPluginManager().disablePlugin(this);
            return; // Arrête l'exécution de la méthode `onEnable`
        }

        Standing.gameLauncher();

        Border.setBorder();

        GameManager.getInstance().setGameState(GameState.STANDING);

        getServer().getPluginManager().registerEvents(new eventsManager(), this);
        getServer().getPluginManager().registerEvents(new onArmorRemove(), this);
        getServer().getPluginManager().registerEvents(new onBlock(), this);
        getServer().getPluginManager().registerEvents(new onUpgradeMenu(), this);
        getServer().getPluginManager().registerEvents(new onPlayerDamage(), this);
        getServer().getPluginManager().registerEvents(new onPlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new onPlayerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new onMenuOpen(), this);
        getServer().getPluginManager().registerEvents(new onMarketMenu(), this);
        getServer().getPluginManager().registerEvents(new onTeamUpgrade(), this);

        GameManager.getInstance().setupTeams();
        GameManager.getInstance().setupPnj();

    }

    @Override
    public void onDisable() {

        GameManager.getInstance().cancelAllTasks(this);
    }
}
