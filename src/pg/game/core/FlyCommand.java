package pg.game.core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    private Main plugin;
    public FlyCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (!Data.GetIsLobby(player)) return true;
            player.setAllowFlight(!player.getAllowFlight());
            if (player.getAllowFlight()) {
                player.sendMessage("enabled flight");
            }
            else {
                player.sendMessage("disabled flight");
            }
        } else if (commandSender instanceof ConsoleCommandSender) {
            plugin.getLogger().info("console cannot fly");
        }


        return true;
    }
}
