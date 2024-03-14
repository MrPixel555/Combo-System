package me.mohamadtofigh.combosystem.listeners;

import me.mohamadtofigh.combosystem.utils.config.Config;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class EntityDamageByEntity implements Listener, Config {
    @EventHandler
    public static void onDamage(EntityDamageByEntityEvent event){
        if (event.isCancelled()) return;

        Entity damager = event.getDamager();
        Entity defender = event.getEntity();

        Vector knockback = defender.getVelocity().multiply(getLaunching);

        if (damager instanceof Player) {
            defender.setVelocity(knockback);
            ServerLib.sendDebug("KB:"+knockback+" DF:"+defender.getName());
        }

        if (getRegisterHit){

            if (event.isCancelled()) return;
            if (defender instanceof LivingEntity) {

                LivingEntity livingEntity = (LivingEntity) defender;

                double damaged = livingEntity.getLastDamage();

                livingEntity.damage(damaged);
                ServerLib.sendDebug("HR:"+livingEntity+" CH:"+damaged);

                event.setCancelled(true);

            }

        }

    }
}
