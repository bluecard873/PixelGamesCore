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

    public void Save() { //saveCustomYml(customConfig, customYml);
        File DataFile = new File(plugin.getDataFolder(), "/data.yml");
        FileConfiguration customConfig = YamlConfiguration.loadConfiguration(DataFile);
        try {
            customConfig.set(DataFile.getPath(), this);
            customConfig.save(DataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Data getValue() {
        File DataFile = new File(plugin.getDataFolder(), "/data.yml");
        FileConfiguration customConfig = YamlConfiguration.loadConfiguration(DataFile);
        return (Data)customConfig.get(DataFile.getPath());
    }
    // get : customConfig.getString("path");
}
