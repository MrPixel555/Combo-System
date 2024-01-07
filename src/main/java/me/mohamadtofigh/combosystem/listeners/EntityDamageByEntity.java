package me.mohamadtofigh.combosystem.listeners;

import me.mohamadtofigh.combosystem.utils.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener, Config {

    @EventHandler
    public static void onDamage(EntityDamageByEntityEvent event){
        // if (event.getDamager() instanceof Player && event.getEntity() instanceof Player)
        if (event.getDamager() instanceof Player) {
            // Player damager = (Player) event.getDamager();
            Player entity = (Player) event.getEntity();
            entity.setVelocity(entity.getLocation().getDirection().multiply(getLaunching));
        }
    }
}
