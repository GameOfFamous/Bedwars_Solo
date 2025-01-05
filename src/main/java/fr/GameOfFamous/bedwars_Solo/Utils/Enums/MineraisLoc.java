package fr.GameOfFamous.bedwars_Solo.Utils.Enums;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum MineraisLoc {

    LOBBY(new Location(Bukkit.getWorld("world"), 0.5, 141, 0.5)),

    GREENSPAWNMINERAIS(new Location(Bukkit.getWorld("world"), 0.5, 70, 96.5)),

    REDSPAWNMINERAIS(new Location(Bukkit.getWorld("world"), -95.5, 70, 0.5)),

    YELLOWSPAWNMINERAIS(new Location(Bukkit.getWorld("world"), 96.5, 70, 0.5)),

    BLUESPAWNMINERAIS(new Location(Bukkit.getWorld("world"), 0.5, 70, -95.5)),


    DIAMOND1(new Location(Bukkit.getWorld("world"), -41.5, 70, 41.5)),
    DIAMOND2(new Location(Bukkit.getWorld("world"), 41.5, 70, 42.5)),
    DIAMOND3(new Location(Bukkit.getWorld("world"), 42.5, 70, -40.5)),
    DIAMOND4(new Location(Bukkit.getWorld("world"), -40.5, 70, -41.5)),

    EMERALD1(new Location(Bukkit.getWorld("world"), 0.5, 78, -11.5)),
    EMERALD2(new Location(Bukkit.getWorld("world"), 0.5, 78, 12.5));

    private Location location;

    MineraisLoc(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
