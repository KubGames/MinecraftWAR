package me.gianzin.kub.minecraftwar.Files;

import me.gianzin.kub.minecraftwar.MinecraftWar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataManager {

    private MinecraftWar plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public DataManager(MinecraftWar plugin){
        this.plugin = plugin;
    }

    public void reloadConfig(){
        if(this.configFile==null)
            this.configFile = new File(this.plugin.getDataFolder(), "data.yml");

        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("data.yml");

        if(defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

}
