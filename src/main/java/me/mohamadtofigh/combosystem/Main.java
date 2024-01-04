package me.mohamadtofigh.combosystem;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main plugins;
    public static Main getInstance() {
        return plugins;
    }
    @Override
    public void onEnable() {
        plugins = this;
        // Plugin startup logic
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
