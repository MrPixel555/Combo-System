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
            new Help(sender);
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
        onOtherCommand(sender, args);
    }
    private void getConsoleCommand(CommandSender sender, Command command, String label, String[] args){
        onDupeCommand(sender, command, label, args);
        onOtherCommand(sender, args);
    }
    private void onDupeCommand(CommandSender sender, Command command, String label, String[] args){
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            new Reload(sender);
            return;
        } else if (args.length > 0 && args[0].equalsIgnoreCase("debug")){
            new Debug(sender);
            return;
        }
    }
    private void onOtherCommand(CommandSender sender, String[] args){
        if (args.length > 1) {
            sender.sendMessage(ChatColor.RED+"not fond command in /starac [...]");
        } else if (args.length > 0) {
            sender.sendMessage(ChatColor.RED+"not fond command in /starac [...]");
        } else {
            sender.sendMessage(ChatColor.RED+"not fond command in /starac [...]");
        }
    }
}
