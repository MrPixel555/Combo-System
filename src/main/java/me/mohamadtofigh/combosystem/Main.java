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

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
    private void connectionToken(){
        saveDefaultConfig();
        reloadConfig();
        booting("&7booting plugins...");

        if (Connection.isInternetAvailable()){
            booting("&abooted success");
            onLoaded();
            //isNewUpdate();

        } else {

            onError("internet wi-fi connection");
        }
    }
    private void isNewUpdate(){
        try {
            URL url = new URL("https://www.spigotmc.org/resources/combo-system-%E2%AD%90-in-beta-version-1-0-0-advanced-combo.114402/");
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Version: ")) {
                    String onlineVersion = line.split("Version: ")[1];
                    if (!onlineVersion.equals(getPluginVersion)) {
                        ServerLib.sendMessage(Prefix.getFixedPrefix+"&7new version is available&8: &b" + onlineVersion);
                        updatePlugin();
                    }
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updatePlugin() {
        if (!getUpdate) return;
        ServerLib.sendMessage(Prefix.getFixedPrefix+"&7downloading new version...");
        try {
            URL url = new URL("https://www.spigotmc.org/resources/combo-system-%E2%AD%90-in-beta-version-1-0-0-advanced-combo.114402/download?version=123456");
            File pluginsDir = this.getDataFolder().getParentFile();
            Path targetPath = new File(pluginsDir, getDescription().getName()+"-"+getPluginVersion+".jar").toPath();
            InputStream in = url.openStream();
            Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
            ServerLib.sendMessage(Prefix.getFixedPrefix+"&adownloaded and installed please restart your server");
        } catch (IOException e) {
            e.printStackTrace();
            ServerLib.sendMessage(Prefix.getErrorPrefix+"failed data loading");
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
        ServerLib.sendMessage(Prefix.getFixedPrefix+sended);
    }
}
