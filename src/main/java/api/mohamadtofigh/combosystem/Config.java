package api.mohamadtofigh.combosystem;

import me.mohamadtofigh.combosystem.Access;
import org.bukkit.configuration.Configuration;

public class Config {
    private static final Configuration config = Access.getMain.getConfig();
    public String getConfigVersion = config.getString("Version");
    public String getPluginVersion = Access.getMain.getDescription().getVersion();
    public boolean getUpdate = config.getBoolean("Account.Update");
    public String getToken = config.getString("Account.Token");
    public String getUser = config.getString("Account.User");
    public String getPass = config.getString("Account.Pass");
    public boolean getExe = config.getBoolean("Exe");
    public boolean getRegisterHit = config.getBoolean("Combo.Register-Hit");
    public double getLaunching = config.getDouble("Combo.Launching");
    public String getPermReload = config.getString("Root.Permissions.Reload");
    public String getPermDebug = config.getString("Root.Permissions.Debug");
    public static String getPrefix = config.getString("Messages.Prefix");
    public static String reloadMessage = config.getString("Messages.Reload");
    public static String getReloadMessage(){
        return reloadMessage.replace("{prefix}", getPrefix);
    }
}
