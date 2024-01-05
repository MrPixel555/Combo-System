package me.mohamadtofigh.combosystem;

import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.connection.Connection;
import me.mohamadtofigh.combosystem.utils.server.Prefix;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
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
        connectionToken();
    }
    private void connectionToken(){
        if (Connection.isInternetAvailable()){
            if (getUserToken.equals("")){

            } else {

            }
        } else {
            ServerLib.sendMessage(Prefix.getErrorPrefix+"ohh, please check your "+isErrorMessage);
        }
    }
}
