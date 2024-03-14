package me.mohamadtofigh.combosystem.commands;

import me.mohamadtofigh.combosystem.utils.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter, Config {
    private final ArrayList<String> tabCMD = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length >= 1) {
            if (command.getName().equalsIgnoreCase("combo")) {
                tabCMD.clear();
                assert Config.getPermReload != null || Config.getPermDebug != null;
                if (sender.hasPermission(Config.getPermReload)) tabCMD.add("reload");
                if (sender.hasPermission(Config.getPermDebug)) tabCMD.add("debug");
                tabCMD.add("help");
                return tabCMD;
            }
        }
        return null;
    }
}
