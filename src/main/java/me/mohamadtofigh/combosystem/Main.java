package me.mohamadtofigh.combosystem;

import me.mohamadtofigh.combosystem.commands.PluginCommand;
import me.mohamadtofigh.combosystem.commands.TabComplete;
import me.mohamadtofigh.combosystem.listeners.EntityDamageByEntity;
import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.connection.Connection;
import me.mohamadtofigh.combosystem.utils.server.Prefix;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Config {
    private static Main plugins;
    public static Main getInstance() {
        return plugins;
    }
    @Override
    public void onEnable() {
        plugins = this;
        connectionToken();
    }
    private void connectionToken(){
        booting("&7booting plugins...");
        if (Connection.isInternetAvailable()){
            booting("&7booted plugin is loading token...");
            if (getUserToken.equals("developer_mode")){
                booting("&aloaded token success.");
                onLoaded();
            } else {
                onError("token on config file");
            }
        } else {
            onError("internet wi-fi connection");
        }
    }
    private void onError(String error){
        ServerLib.sendMessage(Prefix.getErrorPrefix+"ohh, please check your "+error);
    }
    private void onLoaded(){
        Listener[] listeners = {
                new EntityDamageByEntity()
        };
        for (Listener l : listeners){
            getServer().getPluginManager().registerEvents(l, this);
        }
        getCommand("combo").setExecutor(new PluginCommand());
        getCommand("combo").setTabCompleter(new TabComplete());
        String[] messages = {
                getPrefix+"&8==================================================",
                getPrefix+"&7Developers&8: &b"+getDescription().getAuthors() ,
                getPrefix+"&7Plugin Version&8: &b"+getDescription().getVersion(),
                getPrefix+"&7Server Version&8: &b"+getServer().getVersion(),
                getPrefix+"&7Bukkit Version&8: &b"+Bukkit.getBukkitVersion(),
                getPrefix+"&8==================================================",
                getPrefix+"&7summary class...",
                getPrefix+"&7loading command...",
                getPrefix+"&7registering config...",
                getPrefix+"&aloaded success."
        };
    }
    private void booting(String sended){
        ServerLib.sendMessage(getPrefix+sended);
    }
}
