package me.sciencesid.FsInChat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        System.out.println("Activated FsInChat!");
    }
    @Override
    public void onDisable() {System.out.println("Deactivating FsInChat!");}

    public static Main getInstance() {
        return instance;
    }
}

