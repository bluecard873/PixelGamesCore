package pg.game.core;
import java.sql.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends JavaPlugin {
    Connection connection;
    @Override
    public void onEnable() {
        getLogger().info("PixelGames Core is now Enabled.");
        this.getCommand("pgcoreinfo").setExecutor(new InfoCommand());
        this.getCommand("lobby").setExecutor(new LobbyCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this), this);
    }
    @Override
    public void onDisable() {
        getLogger().info("PixelGames Core is now Disabled.");
    }
    public Data datainstance = new Data();
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("pixelgames");
        dataSource.setUser("root");
        dataSource.setPassword("kms109209-");

        connection = dataSource.getConnection();
    }
    public void setIsLobby(Player player, boolean value) throws SQLException{

        PreparedStatement stat = connection.prepareStatement("UPDATE islobby SET value = ? WHERE Player_UUID = ?");
        stat.setString(1, player.getUniqueId().toString());
        stat.setBoolean(2, value);
        stat.execute();
    }
    public boolean getIsLobby(Player player) throws SQLException{
        boolean value = false;
        PreparedStatement stat = connection.prepareStatement("SELECT islobby FROM pixelgames WHERE Player_UUID = ?");
        stat.setString(1, player.getUniqueId().toString());
        ResultSet result = stat.executeQuery();
        while(result.next()) {
            value = result.getBoolean("value");
        }
        return value;
    }
}
