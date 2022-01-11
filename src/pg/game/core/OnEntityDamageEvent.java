package pg.game.core;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnEntityDamageEvent implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntityType () != EntityType.PLAYER) return;
        if (Data.GetIsLobby((Player)event.getEntity())) event.setCancelled (true);
    }
}
