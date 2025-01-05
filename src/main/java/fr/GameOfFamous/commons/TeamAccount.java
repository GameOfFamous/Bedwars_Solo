package fr.GameOfFamous.commons;

import org.bukkit.entity.Player;

public class TeamAccount implements Cloneable{

    private Player player;

    private boolean playerAlive;

    private boolean bedAlive;

    private boolean sharpness;

    private int protection;

    private int hast;

    private int forge;

    private boolean healPool;

    private boolean speedPool;

    private boolean trapSlowness;

    private boolean trapBlindness;

    private boolean alarmTrap;

    private boolean trapMiningFatigue;

    public TeamAccount(Player player,boolean playerAlive,boolean bedAlive, boolean sharpness, int protection, int hast, int forge, boolean healPool,boolean speedPool, boolean trapSlowness, boolean trapBlindness, boolean alarmTrap, boolean trapMiningFatigue) {
        this.player = player;
        this.playerAlive = playerAlive;
        this.bedAlive = bedAlive;
        this.sharpness = sharpness;
        this.protection = protection;
        this.hast = hast;
        this.forge = forge;
        this.healPool = healPool;
        this.speedPool = speedPool;
        this.trapSlowness = trapSlowness;
        this.trapBlindness = trapBlindness;
        this.alarmTrap = alarmTrap;
        this.trapMiningFatigue = trapMiningFatigue;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isPlayerAlive() {
        return playerAlive;
    }

    public void setPlayerAlive(boolean playerAlive) {
        this.playerAlive = playerAlive;
    }

    public boolean isBedAlive() {
        return bedAlive;
    }

    public void setBedAlive(boolean bedAlive) {
        this.bedAlive = bedAlive;
    }

    public boolean isSharpness() {
        return sharpness;
    }

    public void setSharpness(boolean sharpness) {
        this.sharpness = sharpness;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getHast() {
        return hast;
    }

    public void setHast(int hast) {
        this.hast = hast;
    }

    public int getForge() {
        return forge;
    }

    public void setForge(int forge) {
        this.forge = forge;
    }

    public boolean isHealPool() {
        return healPool;
    }

    public void setHealPool(boolean healPool) {
        this.healPool = healPool;
    }

    public boolean isSpeedPool() {
        return speedPool;
    }

    public void setSpeedPool(boolean speedPool) {
        this.speedPool = speedPool;
    }

    public boolean isTrapSlowness() {
        return trapSlowness;
    }

    public void setTrapSlowness(boolean trapSlowness) {
        this.trapSlowness = trapSlowness;
    }

    public boolean isTrapBlindness() {
        return trapBlindness;
    }

    public void setTrapBlindness(boolean trapBlindness) {
        this.trapBlindness = trapBlindness;
    }

    public boolean isAlarmTrap() {
        return alarmTrap;
    }

    public void setAlarmTrap(boolean alarmTrap) {
        this.alarmTrap = alarmTrap;
    }

    public boolean isTrapMiningFatigue() {
        return trapMiningFatigue;
    }

    public void setTrapMiningFatigue(boolean trapMiningFatigue) {
        this.trapMiningFatigue = trapMiningFatigue;
    }

    public TeamAccount clone(){
        try{
            return (TeamAccount) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return null;
    }
}
