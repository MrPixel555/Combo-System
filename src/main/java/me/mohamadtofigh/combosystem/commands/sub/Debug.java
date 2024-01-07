package me.mohamadtofigh.combosystem.commands.sub;

import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.data.Data;
import me.mohamadtofigh.combosystem.utils.server.Prefix;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
import org.bukkit.command.CommandSender;

public class Debug extends Data {
    public Debug(CommandSender sender){
        if (sender.hasPermission(Config.getPermDebug)){
            isDebugged = !isDebugged;
            sender.sendMessage(ServerLib.colorized(Prefix.getPrefix+
                    "&7is debug mode for developers"+(isDebugged ? " &aenabled" : " &cdisabled"))
            );
        }
    }
}
