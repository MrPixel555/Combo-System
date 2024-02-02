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

        Entity damager = event.getDamager();
        Entity defender = event.getEntity();

        Vector knockback = defender.getVelocity().multiply(getLaunching);
        if (damager instanceof Player) {
            defender.setVelocity(knockback);
            ServerLib.sendDebug("Set shod KB ro:"+knockback+" va ersal shod be defender");
        }
        if (getRegisterHit){
            if (defender instanceof LivingEntity) {
                double damaged = 1.5;
                LivingEntity livingEntity = (LivingEntity) defender;

                livingEntity.damage(damaged);
                ServerLib.sendDebug("tamam hit ha sabt shodan az:"+livingEntity+" be defender va inm hp kam shode:"+damaged);

            }
            event.setCancelled(true);
        }
    }
}
