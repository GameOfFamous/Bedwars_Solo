package fr.GameOfFamous.bedwars_Solo.Utils.Minerals;

import fr.gameoffamous.bedwarssolo.Utils.Enums.MineraisLoc;
import fr.gameoffamous.bedwarssolo.Utils.Enums.Teams;

public class Red extends TeamMineralManager{

    private static final Red instance = new Red();

    private Red() {
        super(Teams.RED, MineraisLoc.REDSPAWNMINERAIS.getLocation());
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

    public static Red getInstance() {
        return instance;
    }
}
