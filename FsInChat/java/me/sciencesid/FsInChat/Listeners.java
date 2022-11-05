package me.sciencesid.FsInChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Random;

public class Listeners implements org.bukkit.event.Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        if (player != null) {
            String message = "our condolences go to " + player.getName() + "; F's in chat.";
            StringBuilder sb = new StringBuilder();
            for (Character character : message.toCharArray()) {
                sb.append(ChatColor.getByChar(Integer.toHexString(new Random().nextInt(15)+1)));
                sb.append(character);
            }
            Bukkit.broadcast(sb.toString(), "fsinchat.listen");
            String msg = ChatColor.getByChar(Integer.toHexString(new Random().nextInt(15)+1)) +"F";
            new Thread(() -> {
                sendDeathF(msg, player);
            }).start();
        }
    }
    public void sendDeathF(String msg, Player player) {
        try {Thread.sleep(50);} catch (InterruptedException e) {System.out.println(e);}
        Bukkit.broadcast(msg, "fsinchat.listen");
        try { Thread.sleep(800); } catch (InterruptedException e) {System.out.println(e);}
        player.sendTitle(msg,"rip.",8,20,15);
        player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, .4f,1.0f);
    }
}