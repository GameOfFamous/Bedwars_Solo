package fr.GameOfFamous.bedwars_Solo.Commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub implements CommandExecutor {

    final ByteArrayDataOutput out = ByteStreams.newDataOutput();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equals("hub")){
            if(args.length == 0){
                if(sender instanceof Player){
                    final Player p = (Player) sender;

                    out.writeUTF("Connect");
                    out.writeUTF("lobby");
                    p.sendPluginMessage(Bedwars_Solo.instance, "BungeeCord", out.toByteArray());
                }
            }else {
                sender.sendMessage(ChatColor.RED+ "Utiliser la commande /hub");
            }
        }

        return false;
    }
}
