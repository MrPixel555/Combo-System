package me.mohamadtofigh.combosystem.commands.sub;

import me.mohamadtofigh.combosystem.Access;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
import org.bukkit.command.CommandSender;

public class Help {
    public Help(CommandSender sender){
        String[] messages = {
                "&f---------------------&b---------------------",
                "&7Developers&8: &b"+ Access.getMain.getDescription().getAuthors(),
                "&7",
                "&bOther Commands&8:",
                "&7   /combo &breload &8| &7for reload the plugin.",
                "&7   /combo &bdebug &8| &7for enable debug mode.",
                "&f---------------------&b---------------------"
        };
        for (String s : messages){
            sender.sendMessage(ServerLib.colorized(s));
        }
    }
}
