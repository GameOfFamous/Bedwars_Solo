package fr.GameOfFamous.bedwars_Solo.Utils.Minerals;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.MineraisLoc;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;

public class Green extends TeamMineralManager{

    private static final Green instance = new Green();

    private Green() {
        super(Teams.GREEN, MineraisLoc.GREENSPAWNMINERAIS.getLocation());
    }

    @Override
    protected void updateMineralAmounts() {
        switch (team.getForge()) {
            case 0:
                ironAmount = 2;
                goldAmount = 1;
                break;
            case 1:
                ironAmount = 3;
                goldAmount = 1;
                break;
            case 2:
                ironAmount = 4;
                goldAmount = 2;
                break;
            case 3:
                emeraldAmount = 1;
                break;
            case 4:
                ironAmount = 6;
                goldAmount = 3;
                break;
        }
    }

    public static Green getInstance() {
        return instance;
    }

}
