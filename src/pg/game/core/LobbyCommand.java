package pg.game.core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LobbyCommand implements CommandExecutor {

    private Main plugin;
    public LobbyCommand(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            UUID uuid = player.getUniqueId();
            Location loc = new Location(Bukkit.getWorld("lobby"), 23, 6, 4);
            player.teleport(loc);
            try {
                plugin.datainstance.isLobby = plugin.datainstance.getValue().isLobby;
            }
            catch (NullPointerException e) {
                // Do Nothing
            }
            plugin.datainstance.isLobby.put(uuid.toString(), true);
            plugin.datainstance.Save();
        }
        else if (commandSender instanceof ConsoleCommandSender) {
            plugin.getLogger().info("console cannot to go lobby");
        }
        return true;
    }
}
