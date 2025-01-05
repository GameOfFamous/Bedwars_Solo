package fr.GameOfFamous.bedwars_Solo.Utils.Enums;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum CustomNPC {

    GREENSPAWNMARKET("§aKevin",new Location(Bukkit.getWorld("world"), -4.5, 69, 88.5), Teams.GREEN),
    GREENSPAWNUPGRADE("§aDydou",new Location(Bukkit.getWorld("world"), 5.5, 69, 88.5), Teams.GREEN),

    REDSPAWNMARKET("§cKevin",new Location(Bukkit.getWorld("world"), -87.5, 69, -4.5), Teams.RED),
    REDSPAWNUPGRADE("§cDydou",new Location(Bukkit.getWorld("world"), -87.5, 69, 5.5), Teams.RED),

    YELLOWSPAWNMARKET("§eKevin",new Location(Bukkit.getWorld("world"), 88.5, 69, 5.5), Teams.YELLOW),
    YELLOWSPAWNUPGRADE("§eDydou",new Location(Bukkit.getWorld("world"), 88.5, 69, -4.5), Teams.YELLOW),

    BLUESPAWNMARKET("§9Kevin",new Location(Bukkit.getWorld("world"), 5.5, 69, -87.5), Teams.BLUE),
    BLUESPAWNUPGRADE("§9Dydou",new Location(Bukkit.getWorld("world"), -4.5, 69, -87.5), Teams.BLUE);

    private final String name;
    private final Location location;

    private final Teams team;

    CustomNPC(String name, Location location, Teams team) {
        this.name = name;
        this.location = location;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Teams getTeam() {
        return team;
    }
}
