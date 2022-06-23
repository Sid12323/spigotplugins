package me.sciencesid.calculate;

import me.sciencesid.calculate.commands.Calculate;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        System.out.println("Activating Calculate suite!");
        instance = this;
        System.out.println("Registering Calculate - listeners!");
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        System.out.println("Registering Calculate - commands!");
        getCommand("calculate").setExecutor(new Calculate());
        System.out.println("Activated Calculate!");
    }
    @Override
    public void onDisable() {System.out.println("Deactivating Calculate!");}

    public static Main getInstance() {
       return instance;
    }
}

