package fr.GameOfFamous.bedwars_Solo.Utils.Gestion;

import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.states.Waiting;
import fr.GameOfFamous.hellstylia_API.EnumsUtils.GameState;
import org.bukkit.entity.Player;

import java.util.List;

public class SendMessage {

    public static void sendTitleJoining(Player player){

        GameState state = GameManager.getInstance().gameState;
        List<Player> players = GameManager.getInstance().players;

        String title = "§aBienvenue sur §eBedwars Solo";

        String subtitle= "";

        int fadeIn = 10;
        int stay = 60;
        int fadeOut = 10;

        if(state == GameState.WAITING || state == GameState.STANDING){
            if(players.contains(player)){
                int countdown = Waiting.countdown;

                subtitle = "§aLa partie commence dans : §e" + countdown + " §asecondes";
            }else {
                subtitle = "§aLa partie est déja pleine, vous ete spectateur";
            }

        }else {
            subtitle = "§cUne partie est deja en cours ! §aVous ete Spectateur";
        }

        player.sendTitle(title, subtitle , fadeIn, stay, fadeOut);
    }

}
