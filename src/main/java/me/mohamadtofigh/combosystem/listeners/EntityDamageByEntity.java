package me.mohamadtofigh.combosystem.listeners;

import me.mohamadtofigh.combosystem.utils.config.Config;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener, Config {
    @EventHandler
    public static void onDamage(EntityDamageByEntityEvent event){
        Player damagerPlayer = (Player) event.getDamager();
        Entity damager = event.getDamager();
        Player entityPlayer = (Player) event.getEntity();
        Entity entity = event.getEntity();

        // if (event.getDamager() instanceof Player && event.getEntity() instanceof Player)
        if (event.getDamager() instanceof Player) {
            entity.setVelocity(entity.getLocation().getDirection().multiply(getLaunching));
            if (getRegisterHit){
                entity.setLastDamageCause(event);
                entityPlayer.setHealth(entityPlayer.getHealth() - 0.5);
                event.setCancelled(true);
            }
        }

    }
}
