package me.mohamadtofigh.combosystem;

import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.connection.Connection;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Config {
    private static Main plugins;
    public static Main getInstance() {
        return plugins;
    }
    private static String isErrorMessage = "internet wi-fi";
    @Override
    public void onEnable() {
        plugins = this;
        if (Connection.isInternetAvailable()){
            if (getUserToken.equals("")){

            } else {

            }
        } else {

        }

        // Plugin startup logic
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
