package io.github.mabi19.boostedminecarts;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class BoostedMinecarts extends JavaPlugin {

    @Override
    public void onEnable() {
        // Config file
        Map<Material, Double> multipliers = new HashMap<>();

        saveDefaultConfig();
        var config = getConfig();
        var section = config.getConfigurationSection("modifiers");
        if (section == null) {
            Bukkit.getLogger().severe("Invalid configuration file");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        var values = section.getValues(false);
        try {
            for (var entry : values.entrySet()) {
                var material = Material.valueOf(entry.getKey());
                if (entry.getValue() instanceof Double multiplier) {
                    multipliers.put(material, multiplier);
                } else {
                    Bukkit.getLogger().severe("Invalid speed multiplier in configuration file");
                    Bukkit.getPluginManager().disablePlugin(this);
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            Bukkit.getLogger().severe("Invalid block in configuration file");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        // Event listener
        getServer().getPluginManager().registerEvents(new EventListener(multipliers), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
