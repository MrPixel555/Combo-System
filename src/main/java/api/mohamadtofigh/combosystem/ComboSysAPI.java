package api.mohamadtofigh.combosystem;

import me.mohamadtofigh.combosystem.Access;
import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.data.Data;
import org.bukkit.configuration.Configuration;

public class ComboSysAPI implements Config{
    private final Configuration config = Access.getMain.getConfig();
    public boolean isRegisterEveryoneHit = getRegisterHit;
    public boolean isDebugMode = Data.isDebugged;

    public api.mohamadtofigh.combosystem.Config getConfig() {
        return new api.mohamadtofigh.combosystem.Config();
    }

    public void setConfig(String path, Object set){

        if (path == null) return;
        if (config.get(path) == null) return;

        config.set(path, set);
    }
    public Object getConfig(String path){

        if (path == null) return null;
        if (config.get(path) == null) return null;


        return config.get(path);
    }
}
