package me.beardedorc.sandbox;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Sandbox extends JavaPlugin {

  //  private Map<String, ItemStack> customItemData = new HashMap<>();

    private static Sandbox instance;

    @Override
    public void onEnable() {
        setInstance(this);
        this.getCommand("test").setExecutor(new CommandClass());
        this.getCommand("test2").setExecutor(new CommandClass());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Sandbox getInstance() {
        return instance;
    }

    private  static void setInstance(Sandbox instance) {
        Sandbox.instance = instance;
    }

}
