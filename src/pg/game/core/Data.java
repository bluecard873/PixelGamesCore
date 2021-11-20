package pg.game.core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Data implements Serializable {
    private transient Main plugin;
    public Data(Main plugin) {
        this.plugin = plugin;
    }
    public Map<String, Boolean> isLobby = new HashMap<>();
    transient File DataFile = new File(plugin.getDataFolder()+"/data.yml");
    transient FileConfiguration customConfig = YamlConfiguration.loadConfiguration(DataFile);
    public void Save() { //saveCustomYml(customConfig, customYml);
        try {
            customConfig.set(plugin.getDataFolder()+"/data.yml", this);
            customConfig.save(DataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Data getValue() {
        return (Data)customConfig.get(plugin.getDataFolder()+"/data.yml");
    }
    // get : customConfig.getString("path");
}
