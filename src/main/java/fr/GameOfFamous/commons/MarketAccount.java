package fr.GameOfFamous.commons;

public class MarketAccount implements Cloneable{

    private int armor;
    private int sword;
    private int pickaxe;

    public MarketAccount(int armor, int sword, int pickaxe) {
        this.armor = armor;
        this.sword = sword;
        this.pickaxe = pickaxe;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSword() {
        return sword;
    }

    public void setSword(int sword) {
        this.sword = sword;
    }

    public int getPickaxe() {
        return pickaxe;
    }

    public void setPickaxe(int pickaxe) {
        this.pickaxe = pickaxe;
    }

    public MarketAccount clone(){
        try{
            return (MarketAccount) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return null;
    }
}
