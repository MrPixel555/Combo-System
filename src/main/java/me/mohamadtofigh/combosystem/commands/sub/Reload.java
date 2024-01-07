package me.mohamadtofigh.combosystem.commands.sub;

import me.mohamadtofigh.combosystem.Access;
import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
import org.bukkit.command.CommandSender;

public class Reload implements Access {
    public Reload(CommandSender sender){
        if (sender.hasPermission(Config.getPermReload)) {
            getMain.getServer().getPluginManager().disablePlugin(getMain);
            getMain.getServer().getPluginManager().enablePlugin(getMain);
            sender.sendMessage(ServerLib.colorized(Config.getReloadMessage()));
        }
    }
}
