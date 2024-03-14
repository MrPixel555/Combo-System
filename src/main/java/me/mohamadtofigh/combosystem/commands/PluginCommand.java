package me.mohamadtofigh.combosystem.commands;

import me.mohamadtofigh.combosystem.commands.sub.Debug;
import me.mohamadtofigh.combosystem.commands.sub.Help;
import me.mohamadtofigh.combosystem.commands.sub.Reload;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("combo")) {
            if (sender instanceof Player){
                getPlayerCommand(sender, command, label, args);
            } else {
                getConsoleCommand(sender, command, label, args);
            }
        }
        return false;
    }
    private void getPlayerCommand(CommandSender sender, Command command, String label, String[] args){
        onDupeCommand(sender, command, label, args);
    }
    private void getConsoleCommand(CommandSender sender, Command command, String label, String[] args){
        onDupeCommand(sender, command, label, args);
    }
    private void onDupeCommand(CommandSender sender, Command command, String label, String[] args){
        switch (args[0]){
            case "help":
                new Help(sender);
                break;
            case "reload":
                new Reload(sender);
                break;
            case "debug":
                new Debug(sender);
                break;
            default:
                sender.sendMessage(ChatColor.RED+"not find command in /combo [...]");
        }
    }
}
