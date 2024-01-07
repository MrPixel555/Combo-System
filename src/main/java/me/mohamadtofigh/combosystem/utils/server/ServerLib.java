package me.mohamadtofigh.combosystem.utils.server;

import me.mohamadtofigh.combosystem.Access;
import me.mohamadtofigh.combosystem.utils.data.Data;
import org.bukkit.ChatColor;

public class ServerLib extends Data implements Access {
    public static void sendMessage(String message){
        getMain.getServer().getConsoleSender().sendMessage(colorized(message));
    }
    public static String colorized(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public static void sendDebug(String debugMessage){
        if (isDebugged){
            ServerLib.sendMessage(Prefix.getDebugPrefix+debugMessage);
        }
    }
}
