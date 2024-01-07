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
        saveDefaultConfig();
        reloadConfig();

        Listener[] listeners = {
                new EntityDamageByEntity()
        };
        for (Listener l : listeners){
            getServer().getPluginManager().registerEvents(l, this);
        }

        getCommand("combo").setExecutor(new PluginCommand());
        getCommand("combo").setTabCompleter(new TabComplete());

        String[] messages = {
                Prefix.getFixedPrefix+"&8==================================================",
                Prefix.getFixedPrefix+"&7Developers&8: &b"+getDescription().getAuthors() ,
                Prefix.getFixedPrefix+"&7Plugin Version&8: &b"+getDescription().getVersion(),
                Prefix.getFixedPrefix+"&7Server Version&8: &b"+getServer().getVersion(),
                Prefix.getFixedPrefix+"&7Bukkit Version&8: &b"+Bukkit.getBukkitVersion(),
                Prefix.getFixedPrefix+"&8==================================================",
                Prefix.getFixedPrefix+"&7summary class...",
                Prefix.getFixedPrefix+"&7loading command...",
                Prefix.getFixedPrefix+"&7registering config...",
                Prefix.getFixedPrefix+"&aloaded success."
        };

        for (String s : messages){
            ServerLib.sendMessage(s);
        }
    }
    private void booting(String sended){
        ServerLib.sendMessage(getPrefix+sended);
    }
}
