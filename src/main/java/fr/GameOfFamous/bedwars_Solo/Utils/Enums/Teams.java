package fr.GameOfFamous.bedwars_Solo.Utils.Enums;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;

public enum Teams {

    RED(1, "§f[§cRed§f] ","§c",Color.RED,Material.RED_WOOL, Material.RED_BED, Material.RED_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), -87.5, 69, 0.5), new Location(Bukkit.getWorld("world"), -75, 69, 0), BlockFace.WEST),
    BLUE(2, "§f[§9Blue§f] ","§9",Color.BLUE,Material.BLUE_WOOL, Material.BLUE_BED, Material.BLUE_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), 0.5, 69, -87.5), new Location(Bukkit.getWorld("world"), 0, 69, -75), BlockFace.NORTH),
    YELLOW(3, "§f[§eYellow§f] ","§e",Color.YELLOW,Material.YELLOW_WOOL, Material.YELLOW_BED, Material.YELLOW_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), 88.5, 69, 0.5), new Location(Bukkit.getWorld("world"), 76, 69, 0), BlockFace.EAST),
    GREEN(4, "§f[§aGreen§f] ","§a",Color.GREEN,Material.GREEN_WOOL, Material.GREEN_BED, Material.GREEN_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), 0.5, 69, 88.5), new Location(Bukkit.getWorld("world"), 0, 69, 76), BlockFace.SOUTH);

    private final int power;
    private final String prefix;
    private final String color;

    private final Color colour;
    private final Material wool;
    private final Material bed;
    private final Material border;
    private final Location spawnLoc;
    private final Location bedLocation;
    private final BlockFace blockFace;

    Teams(int power, String prefix,String color,Color colour,Material wool, Material bed,Material border, Location spawnLoc, Location bedLocation, BlockFace blockFace) {
        this.power = power;
        this.prefix = prefix;
        this.color = color;
        this.colour = colour;
        this.wool = wool;
        this.bed = bed;
        this.border = border;
        this.spawnLoc = spawnLoc;
        this.bedLocation = bedLocation;
        this.blockFace = blockFace;
    }

    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }

    public Material getWool() {
        return wool;
    }

    public Material getBed() {
        return bed;
    }

    public Material getBorder() {
        return border;
    }

    public String getColor() {
        return color;
    }

    public Location getSpawnLoc() {
        return spawnLoc;
    }

    public Color getColour() {
        return colour;
    }

    public Location getBedLocation() {
        return bedLocation;
    }

    public BlockFace getBlockFace() {
        return blockFace;
    }
}
