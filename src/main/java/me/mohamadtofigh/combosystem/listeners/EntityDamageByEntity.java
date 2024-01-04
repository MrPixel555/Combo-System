package me.mohamadtofigh.combosystem.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {

    @EventHandler
    public static void onDamage(EntityDamageByEntityEvent event){
        Entity getDamager = event.getDamager();
        if (getDamager instanceof Player){
            
        }
    }
}
