package pg.game.core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {

    private Main plugin;
    public LobbyCommand(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location loc = new Location(Bukkit.getWorld("lobby"), 23, 6, 4);
            player.teleport(loc);
            plugin.datainstance.isLobby = plugin.datainstance.getValue().isLobby;
            plugin.datainstance.isLobby.put(player.getUniqueId(), true);
            plugin.datainstance.Save();
        }
        else if (commandSender instanceof ConsoleCommandSender) {
            plugin.getLogger().info("console cannot to go lobby");
        }
        return true;
    }
}
