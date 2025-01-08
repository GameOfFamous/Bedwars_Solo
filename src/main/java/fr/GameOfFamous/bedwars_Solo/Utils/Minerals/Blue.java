package fr.GameOfFamous.bedwars_Solo.Utils.Minerals;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.MineraisLoc;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;

public class Blue extends TeamMineralManager{

    private static final Blue instance = new Blue();

    private Blue() {
        super(Teams.BLUE, MineraisLoc.BLUESPAWNMINERAIS.getLocation());
    }

    @Override
    protected void updateMineralAmounts() {
        switch (team.getForge()) {
            case 0:
                ironAmount = 2;
                goldAmount = 1;
                break;
            case 1:
                ironAmount = 4;
                goldAmount = 2;
                break;
            case 2:
                ironAmount = 6;
                goldAmount = 3;
                break;
            case 3:
                diamsAmount = 1;
                break;
            case 4:
                emeraldAmount = 1;
                break;
        }
    }

    public static Blue getInstance() {
        return instance;
    }

}
