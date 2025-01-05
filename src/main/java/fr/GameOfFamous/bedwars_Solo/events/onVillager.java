package fr.GameOfFamous.bedwars_Solo.events;

import fr.GameOfFamous.bedwars_Solo.Utils.Enums.Teams;
import fr.GameOfFamous.bedwars_Solo.Utils.Manager.GameManager;
import fr.GameOfFamous.bedwars_Solo.Utils.Menus.UpgradeMenu;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class onVillager implements Listener {

    public GameManager manager = GameManager.getInstance();

    @EventHandler
    public void onVillagerInteract(PlayerInteractEntityEvent e){

        if(!(e.getRightClicked() instanceof Villager)){return;}

        Villager villager = (Villager) e.getRightClicked();

        if(villager.getCustomName() == null){
            return;
        }

        String villagerName = villager.getCustomName();
        Player p = e.getPlayer();

        Teams team = manager.returnPlayerTeam(p);

        switch (villagerName){
            case "§cKevin":
                break;
            case "§aKevin":
                break;
            case "§9Kevin":
                break;
            case "§eKevin":
                break;
            case "§aDydou":
                if(team.equals(Teams.GREEN)){
                    if(manager.playTeams.contains(Teams.GREEN)){
                        e.setCancelled(true);
                        p.closeInventory();
                        UpgradeMenu.openUpgradeMenu(p, "Upgrade", Teams.GREEN);
                    }
                }
                break;
            case "§cDydou":
                if(team.equals(Teams.RED)){
                    if(manager.playTeams.contains(Teams.RED)){
                        e.setCancelled(true);
                        p.closeInventory();
                        UpgradeMenu.openUpgradeMenu(p, "Upgrade", Teams.RED);
                    }
                }
                break;
            case "§eDydou":
                if(team.equals(Teams.YELLOW)){
                    if(manager.playTeams.contains(Teams.YELLOW)){
                        e.setCancelled(true);
                        p.closeInventory();
                        UpgradeMenu.openUpgradeMenu(p, "Upgrade", Teams.YELLOW);
                    }
                }
                break;
            case "§9Dydou":
                if(team.equals(Teams.BLUE)){
                    if(manager.playTeams.contains(Teams.BLUE)){
                        e.setCancelled(true);
                        p.closeInventory();
                        UpgradeMenu.openUpgradeMenu(p, "Upgrade", Teams.BLUE);
                    }
                }
                break;
            default:
                p.sendMessage("§cCe villageois n'a pas de menu");
                break;
        }

    }

}
