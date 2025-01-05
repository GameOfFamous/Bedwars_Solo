package fr.GameOfFamous.commons;

import java.util.UUID;

public class BedwarsAccount implements Cloneable{

    private int id;
    private UUID uuid;
    private String pseudo;
    private int gamePlayed;
    private int gameWin;
    private int kills;
    private int death;
    private int bedDestroy;
    private int blockplaced;

    public BedwarsAccount(){}
    public BedwarsAccount(int id, UUID uuid, String pseudo, int gamePlayed, int gameWin, int kills, int death, int bedDestroy, int blockplaced) {
        this.id = id;
        this.uuid = uuid;
        this.pseudo = pseudo;
        this.gamePlayed = gamePlayed;
        this.gameWin = gameWin;
        this.kills = kills;
        this.death = death;
        this.bedDestroy = bedDestroy;
        this.blockplaced = blockplaced;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    public int getGameWin() {
        return gameWin;
    }

    public void setGameWin(int gameWin) {
        this.gameWin = gameWin;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getBedDestroy() {
        return bedDestroy;
    }

    public void setBedDestroy(int bedDestroy) {
        this.bedDestroy = bedDestroy;
    }

    public int getBlockplaced() {
        return blockplaced;
    }

    public void setBlockplaced(int blockplaced) {
        this.blockplaced = blockplaced;
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(!(o instanceof BedwarsAccount)){
            return false;
        }else{
            return ((BedwarsAccount)o).getId() == this.id;
        }
    }

    public BedwarsAccount clone(){
        try{
            return (BedwarsAccount) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return null;
    }
}
