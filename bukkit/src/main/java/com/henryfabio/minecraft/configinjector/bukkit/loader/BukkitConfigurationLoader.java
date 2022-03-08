package com.henryfabio.minecraft.configinjector.bukkit.loader;

import com.google.common.base.Charsets;
import com.henryfabio.minecraft.configinjector.bukkit.configuration.BukkitConfiguration;
import com.henryfabio.minecraft.configinjector.common.configuration.Configuration;
import com.henryfabio.minecraft.configinjector.common.loader.ConfigurationLoader;
import com.henryfabio.minecraft.configinjector.common.loader.ResourceLoader;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Henry Fábio
 */
public final class BukkitConfigurationLoader extends ConfigurationLoader {

    private final ResourceLoader resourceLoader;
    private final Plugin plugin;

    public BukkitConfigurationLoader(Plugin plugin) {
        this.plugin = plugin;
        resourceLoader = new BukkitResourceLoader(plugin);
    }

    @Override
    public Configuration loadConfiguration(File dataFolder, String path) {
        return computeConfigurationIfAbsent(path, () -> {
            //YamlConfiguration configuration = YamlConfiguration.loadConfiguration(new File(dataFolder, path));
            plugin.reloadConfig();
            FileConfiguration configuration = plugin.getConfig();
            /*InputStream resource = resourceLoader.getResource(path);
            if (resource != null) {
                InputStreamReader reader = new InputStreamReader(resource, Charsets.UTF_8);
                configuration.setDefaults(YamlConfiguration.loadConfiguration(reader));
            }*/

            return new BukkitConfiguration(path, configuration);
        });
    }

}
