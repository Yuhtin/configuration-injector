package com.henryfabio.minecraft.configinjector.bukkit.loader;

import com.henryfabio.minecraft.configinjector.common.loader.ResourceLoader;
import org.bukkit.plugin.Plugin;

import java.io.InputStream;

public class BukkitResourceLoader extends ResourceLoader {

    private final Plugin plugin;

    public BukkitResourceLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public InputStream getResource(String fileName) {
        return plugin.getResource(fileName);
    }
}
