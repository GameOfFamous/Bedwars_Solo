package fr.GameOfFamous.bedwars_Solo.Utils.Gestion;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.GameState;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.states.Waiting;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.List;

public class SendMessage {

    public static void sendClickableMessage(Player player, String text, String URL){
        TextComponent message = new TextComponent(text);
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, URL));

        player.spigot().sendMessage(message);
    }

    public static void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(message));
    }

    public static void sendTitle(Player player, String title, String subtitle){
        int fadeIn = 10;
        int stay = 60;
        int fadeOut = 10;

        player.sendTitle(title, subtitle , fadeIn, stay, fadeOut);
    }

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
