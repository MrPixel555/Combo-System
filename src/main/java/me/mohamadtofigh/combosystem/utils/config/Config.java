package me.mohamadtofigh.combosystem.utils.config;

import me.mohamadtofigh.combosystem.Access;
import org.bukkit.configuration.Configuration;

public interface Config {
    Configuration config = Access.getMain.getConfig();
    String getConfigVersion = config.getString("Version");
    String getUserToken = config.getString("Root.Token");
    boolean getExe = config.getBoolean("Exe");
    int getLaunching = config.getInt("Combo.Launching");
    String getPermAdmin = config.getString("Root.Permissions.Admin");
    String getPermReload = config.getString("Root.Permissions.Reload");
    String getPermDebug = config.getString("Root.Permissions.Debug");
    String getPrefix = config.getString("Messages.Prefix");
    String reloadMessage = config.getString("Messages.Reload");
    String debugMessage = config.getString("Messages.Debug");
    default String getReloadMessage(){
        return reloadMessage.replace("{prefix}", getPrefix);
    }
    default String getDebugMessage(String playerName, String debugMessages){
        return debugMessage
                .replace("{prefix}", getPrefix)
                .replace("{player}", playerName)
                .replace("{dev_message}", debugMessages);
    }
}
