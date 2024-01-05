package me.mohamadtofigh.combosystem.utils.server;

import me.mohamadtofigh.combosystem.Access;
import org.bukkit.ChatColor;

public class ServerLib implements Access {
    public static void sendMessage(String message){
        getMain.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
    public static String coloring(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
