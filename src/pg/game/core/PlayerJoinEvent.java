package pg.game.core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    private Main plugin;
    public PlayerJoinEvent(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.performCommand("lobby");
    }
}
