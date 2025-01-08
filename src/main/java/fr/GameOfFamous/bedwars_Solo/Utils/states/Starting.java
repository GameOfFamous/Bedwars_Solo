package fr.GameOfFamous.bedwars_Solo.Utils.states;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Gestion.SetPlayerStuff;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Player.InGameBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class Starting {

    public static void setStarting(){

        GameManager manager = GameManager.getInstance();

        List<Teams> teams = manager.allTeams;

        Collections.shuffle(teams);

        manager.task = Bukkit.getServer().getScheduler().runTaskTimer(Bedwars_Solo.instance, InGameBoard.getInstance(), 0, 1);

        manager.setGameState(fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState.IN_GAME);

        Finish.detectFinish();

        for(int i = 0; i < manager.players.size(); i++){
            Player player = manager.players.get(i);
            Teams team = teams.get(i % teams.size());
            manager.assignPlayerToTeams(player, team);

            player.getInventory().clear();

            player.setPlayerListName(team.getPrefix() + team.getColor() + player.getDisplayName());

            manager.placeVillager();
            manager.setupmineral();

            player.teleport(team.getSpawnLoc());
            SetPlayerStuff.setPlayerArmor(player);
            SetPlayerStuff.setPlayerSword(player);
        }

    }

}
