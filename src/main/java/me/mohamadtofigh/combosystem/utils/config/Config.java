package me.mohamadtofigh.combosystem.utils.config;

import me.mohamadtofigh.combosystem.Access;
import org.bukkit.configuration.Configuration;

public interface Config {
    Configuration config = Access.getMain.getConfig();
    String getConfigVersion = config.getString("Version");
    String getPluginVersion = Access.getMain.getDescription().getVersion();
    boolean getUpdate = config.getBoolean("Account.Update");
    boolean getRegisterHit = config.getBoolean("Combo.Register-Hit");
    double getLaunching = config.getDouble("Combo.Launching");
    String getPermReload = config.getString("Root.Permissions.Reload");
    String getPermDebug = config.getString("Root.Permissions.Debug");
    String getPrefix = config.getString("Messages.Prefix");
    String reloadMessage = config.getString("Messages.Reload");
    static String getReloadMessage(){
        return reloadMessage.replace("{prefix}", getPrefix);
    }
}
