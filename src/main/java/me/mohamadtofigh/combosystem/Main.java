package me.mohamadtofigh.combosystem;

import me.mohamadtofigh.combosystem.commands.PluginCommand;
import me.mohamadtofigh.combosystem.commands.TabComplete;
import me.mohamadtofigh.combosystem.listeners.EntityDamageByEntity;
import me.mohamadtofigh.combosystem.listeners.JoinEvent;
import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.connection.Connection;
import me.mohamadtofigh.combosystem.utils.server.Prefix;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Scanner;

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
    private void checkUpdate(){
    }
    private void connectionToken(){
        saveDefaultConfig();
        reloadConfig();
        booting("&7booting plugins...");

        if (getConfigVersion.equalsIgnoreCase(getPluginVersion)){
            onError("please update your config.yml!");
        }
        if (Connection.isInternetAvailable()){
            booting("&abooted success");
            onLoaded();
            checkUpdate();

        } else {

            onError("please check your internet wi-fi connection!");
        }
    }
    private void onError(String error){
        ServerLib.sendMessage(Prefix.getErrorPrefix+"ohh, "+error);
    }
    private void onLoaded(){
        Listener[] listeners = {
                new EntityDamageByEntity(),
                new JoinEvent()
        };
        for (Listener l : listeners){
            getServer().getPluginManager().registerEvents(l, this);
        }

        Objects.requireNonNull(getCommand("combo")).setExecutor(new PluginCommand());
        Objects.requireNonNull(getCommand("combo")).setTabCompleter(new TabComplete());

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
                Prefix.getFixedPrefix+"&aloaded success.",
                Prefix.getFixedPrefix+"&4 -- &cif you finded bug&7, &efast come to creator for fix the bug! &4--",
                Prefix.getFixedPrefix+"&4 -- &cif you finded bug&7, &efast come to creator for fix the bug! &4--",
                Prefix.getFixedPrefix+"&4 -- &cif you finded bug&7, &efast come to creator for fix the bug! &4--"
        };

        for (String s : messages){
            ServerLib.sendMessage(s);
        }
    }
    private void booting(String sended){
        ServerLib.sendMessage(Prefix.getFixedPrefix+sended);
    }
}
