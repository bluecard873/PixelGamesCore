package pg.game.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String message = "PixelGames Core 1.0.0 author: bluecard";
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.sendMessage(message);
        }
        else if (commandSender instanceof ConsoleCommandSender) {
            ConsoleCommandSender console = (ConsoleCommandSender) commandSender;
            console.sendMessage(message);
        }
        return true;
    }
}
