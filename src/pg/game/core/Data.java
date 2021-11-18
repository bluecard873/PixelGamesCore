package pg.game.core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Data {
    private Main plugin;
    public Data(Main plugin) {
        this.plugin = plugin;
    }
    File DataFile = new File(plugin.getDataFolder()+"/data.yml");
    FileConfiguration customConfig = YamlConfiguration.loadConfiguration(DataFile);
    public void setValue(Object value) { //saveCustomYml(customConfig, customYml);
        try {
            customConfig.set(plugin.getDataFolder()+"/data.yml", value);
            customConfig.save(DataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Object getValue() {
        return customConfig.get(plugin.getDataFolder()+"/data.yml");
    }
    // get : customConfig.getString("path");
}
