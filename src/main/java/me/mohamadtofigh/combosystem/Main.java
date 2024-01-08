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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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

            try {
                URL url = new URL("http://127.0.0.1:5500/index.html");
                URLConnection conn = url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                getVerify(content, "<p class=\""+getUser+"\" id=\""+getPass+"\"", "</p>");
            } catch (IOException e) {

                onError("read from services: " + e.getMessage());
            }

        } else {

            onError("internet wi-fi connection");
        }
    }
    private void getVerify(StringBuilder content, String one, String two){
        String htmlContent = content.toString();
        int pStart = htmlContent.indexOf(one) + one.length()+1;
        int pEnd = htmlContent.indexOf(two);

        if (pStart != -1 && pEnd != -1) {
            String pText = htmlContent.substring(pStart, pEnd).trim();

            booting("&7booted plugin is loading token...");
            if (getToken.equals(pText)){

                booting("&aloaded token success.");
                onLoaded();
                isNewUpdate(content, pEnd);
            } else {

                onError("token on config file");
            }
        }
    }
    private void isNewUpdate(StringBuilder content, int pEnd){
        String htmlContent = content.toString();
        int pStart = htmlContent.indexOf("<p class=\"version\"") + 19;
        pEnd = htmlContent.indexOf("</p>", pStart);

        if (pStart != -1 && pEnd != -1) {
            String pText = htmlContent.substring(pStart, pEnd).trim();
            ServerLib.sendMessage(Prefix.getFixedPrefix+"&7checking for update...");

            if (!pText.equals(getDescription().getVersion())){
                ServerLib.sendMessage(Prefix.getFixedPrefix+"&7new update is available&8: &b"+ pText);
                isNewDesc(content, pEnd);
            }
        }
    }
    private void isNewDesc(StringBuilder content, int pEnd){
        String htmlContent = content.toString();
        int pStart = htmlContent.indexOf("<p class=\"desc\"") + 16;
        pEnd = htmlContent.indexOf("</p>", pStart);

        if (pStart != -1 && pEnd != -1) {
            String pText = htmlContent.substring(pStart, pEnd).trim();
            pText = pText.replace("\\n", "\n");
            String[] lines = pText.split("\n");
            for (String line : lines) {
                ServerLib.sendMessage(Prefix.getFixedPrefix+line);
            }
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
