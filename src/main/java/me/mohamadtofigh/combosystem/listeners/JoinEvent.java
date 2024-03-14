package me.mohamadtofigh.combosystem.listeners;

import me.mohamadtofigh.combosystem.Access;
import me.mohamadtofigh.combosystem.utils.server.ServerLib;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;
import java.util.UUID;

public class JoinEvent implements Listener, Access {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        // this is not for attack, for view my plugin version and your platform for fix other bug(if reported by you)!
        // this is not for attack, for view my plugin version and your platform for fix other bug(if reported by you)!
        // this is not for attack, for view my plugin version and your platform for fix other bug(if reported by you)!
        if (Objects.equals(player.getUniqueId(), UUID.fromString("d3b0454f-8e0f-4dd5-9860-3120b4b12062"))) {
            String[] messages = {
                    "&8=ComboSystem=======================",
                    "&7Hello my creator. im &bComboSystem",
                    "&7My version&8: &b"+ getMain.getDescription().getVersion(),
                    "&7This Platform&8: &b"+ Bukkit.getVersion(),
                    "&8==================================="
            };
            for (String message : messages){
                player.sendMessage(ServerLib.colorized(message));
            }
        }
    }
}
