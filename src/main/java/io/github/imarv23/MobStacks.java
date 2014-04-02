package io.github.imarv23;

import io.github.imarv23.listeners.BlockListener;
import io.github.imarv23.listeners.RightClickListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin that spawns animals like snowmen by building structures
 * 
 * @author iMarv23
 *
 */
public final class MobStacks extends JavaPlugin {
	
	@Override
	public void onEnable()
	{
		this.loadConfiguration();
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockListener(), this);
		pm.registerEvents(new RightClickListener(this.getConfig()), this);
	}
	
	private void loadConfiguration()
	{
		this.createDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
	private void createDefaultConfig()
	{
		this.getConfig().addDefault("Pig.Sacrifice", 5);
	}
	
	
}
