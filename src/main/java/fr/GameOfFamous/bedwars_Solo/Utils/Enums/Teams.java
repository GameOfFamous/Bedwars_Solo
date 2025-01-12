package fr.GameOfFamous.bedwars_Solo.Utils.Enums;

import org.bukkit.*;
import org.bukkit.block.BlockFace;

public enum Teams {

    RED(1, "§f[§cRed§f] ","§c",Color.RED,Material.RED_WOOL, Material.RED_BED, Material.RED_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), -87.5, 69, 0.5), new Location(Bukkit.getWorld("world"), -75, 69, 0), BlockFace.WEST, new Location(Bukkit.getWorld("world"), -70, 68, -8), new Location(Bukkit.getWorld("world"), -97, 88, 9)),
    BLUE(2, "§f[§9Blue§f] ","§9",Color.BLUE,Material.BLUE_WOOL, Material.BLUE_BED, Material.BLUE_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), 0.5, 69, -87.5), new Location(Bukkit.getWorld("world"), 0, 69, -75), BlockFace.NORTH, new Location(Bukkit.getWorld("world"), 9, 68, -70), new Location(Bukkit.getWorld("world"), -8, 88, -97)),
    YELLOW(3, "§f[§eYellow§f] ","§e",Color.YELLOW,Material.YELLOW_WOOL, Material.YELLOW_BED, Material.YELLOW_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), 88.5, 69, 0.5), new Location(Bukkit.getWorld("world"), 76, 69, 0), BlockFace.EAST, new Location(Bukkit.getWorld("world"), 71, 68, 9), new Location(Bukkit.getWorld("world"), 98, 88, -8)),
    GREEN(4, "§f[§aGreen§f] ","§a",Color.GREEN,Material.GREEN_WOOL, Material.GREEN_BED, Material.GREEN_STAINED_GLASS_PANE,new Location(Bukkit.getWorld("world"), 0.5, 69, 88.5), new Location(Bukkit.getWorld("world"), 0, 69, 76), BlockFace.SOUTH, new Location(Bukkit.getWorld("world"), -8, 68, 71), new Location(Bukkit.getWorld("world"), 9, 88, 98));

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
    private final Location corner1;
    private final Location corner2;

    Teams(int power, String prefix,String color,Color colour,Material wool, Material bed,Material border, Location spawnLoc, Location bedLocation, BlockFace blockFace, Location corner1, Location corner2) {
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
        this.corner1 = corner1;
        this.corner2 = corner2;
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

    public Location getCorner1() {
        return corner1;
    }

    public Location getCorner2() {
        return corner2;
    }

    public boolean isInZone(Location playerLocation){

        if(playerLocation == null && corner1 == null && corner2 == null) return false;

        double x = playerLocation.getX();
        double y = playerLocation.getY();
        double z = playerLocation.getZ();

        return (x >= Math.min(corner1.getX(), corner2.getX()) && x <= Math.max(corner1.getX(), corner2.getX()))
                && (y >= Math.min(corner1.getY(), corner2.getY()) && y <= Math.max(corner1.getY(), corner2.getY()))
                && (z >= Math.min(corner1.getZ(), corner2.getZ()) && z <= Math.max(corner1.getZ(), corner2.getZ()));

    }

}
