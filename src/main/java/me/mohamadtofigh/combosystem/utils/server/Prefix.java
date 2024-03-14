package me.mohamadtofigh.combosystem.utils.server;

import me.mohamadtofigh.combosystem.utils.config.Config;

public interface Prefix{
    String getPrefix = Config.getPrefix;
    String getFixedPrefix = Config.getPrefix.replace("&l", "");
    String getErrorPrefix = "&7[&fCombo&bSystem&7] &8[&4ERROR&8] &c";
    String getDebugPrefix = "&7[&fCombo&bSystem&7] &8[&6DEBUG&8] &e";
}
