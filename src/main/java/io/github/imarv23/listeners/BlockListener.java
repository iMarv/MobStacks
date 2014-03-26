package io.github.imarv23.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import io.github.imarv.spawning.*;

public class BlockListener implements Listener {

	SheepSpawner shSpawner;
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e)
	/*
	 * Waiting for blocks to be placed
	 * */
	{
		Block b = e.getBlockPlaced();
		if(b.getType() == Material.PUMPKIN)
		{
			this.shSpawner = new SheepSpawner(b, e.getPlayer());
			if(this.shSpawner.checkIfSheep())
			{
				this.shSpawner.spawnSheep();
			}
		}
	}
	
	
}
