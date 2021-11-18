package pg.game.core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class LobbyCommand implements CommandExecutor {

    private Main plugin;
    public LobbyCommand(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "mv tp " + player.getName() + " lobby");
            try {
                plugin.setIsLobby(player, true);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (commandSender instanceof ConsoleCommandSender) {
            ConsoleCommandSender console = (ConsoleCommandSender) commandSender;
            console.sendMessage("console cannot to go lobby");
        }
        return true;
    }
}
