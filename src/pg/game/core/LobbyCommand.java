package pg.game.core;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
            Location loc = new Location(Bukkit.getWorld("lobby"), 15, 6, -4);
            player.teleport(loc);

        } else if (commandSender instanceof ConsoleCommandSender) {
            plugin.getLogger().info("console cannot to go lobby");
        }
        return true;
    }
}
