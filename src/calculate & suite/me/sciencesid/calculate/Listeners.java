package me.sciencesid.calculate;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listeners implements org.bukkit.event.Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Material type = event.getBlock().getType();
        if (type == Material.BARRIER) {
            Player player = event.getPlayer();
            System.out.println(player.getName() + " placed a barrier at " + event.getBlock().getLocation());
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        if (player != null) {
            int x = player.getLocation().getBlockX();
            int y = player.getLocation().getBlockY();
            int z = player.getLocation().getBlockZ();
            System.out.println(player.getName() + " died at " + x + ", " + y + ", " + z + ", " + " in " + player.getWorld());
        }
    }
}