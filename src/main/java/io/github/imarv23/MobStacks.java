package io.github.imarv23;

import io.github.imarv23.listeners.BlockListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobStacks extends JavaPlugin {
	
	@Override
	public void onEnable()
	{
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockListener(), this);
	}
}
