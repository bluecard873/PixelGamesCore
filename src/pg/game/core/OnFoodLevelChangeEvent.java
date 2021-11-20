package pg.game.core;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OnFoodLevelChangeEvent implements Listener {
    Main plugin;
    public OnFoodLevelChangeEvent(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onFoodLevelChange (FoodLevelChangeEvent event) {
        if (event.getEntityType () != EntityType.PLAYER) return;
        if (plugin.datainstance.isLobby.get(event.getEntity().getUniqueId().toString())) event.setCancelled (true);

    }
}
