package pg.game.core;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("PixelGames Core is now Enabled.");
        this.getCommand("pgcoreinfo").setExecutor(new InfoCommand());
        this.getCommand("lobby").setExecutor(new LobbyCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new OnFoodLevelChangeEvent(this), this);
        this.getCommand("fly").setExecutor(new FlyCommand(this));
    }
    @Override
    public void onDisable() {
        getLogger().info("PixelGames Core is now Disabled.");
    }

    public Data datainstance = new Data(this);
}
