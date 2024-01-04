package me.mohamadtofigh.combosystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            getPlayerCommand(sender, command, label, args);
        } else {
            getConsoleCommand(sender, command, label, args);
        }
        return false;
    }
    private void getPlayerCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;
    }
    private void getConsoleCommand(CommandSender sender, Command command, String label, String[] args){

    }
}
