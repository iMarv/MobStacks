package io.github.imarv23.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

import io.github.imarv.spawning.*;

/**
 * A Block listener that listens for certain blocks to be placed
 * Depending on the type of the block and its surroundings an animal will be spawned
 * 
 * @author iMarv23
 * 
 */

public class BlockListener implements Listener {

	SheepSpawner shSpawner;
	
	/**
	 * Main method that listens for placed blocks and is spawning the animals
	 * 
	 * @param e BlockPlaceEvent
	 */
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e)
	/*
	 * Waiting for blocks to be placed 
	 */
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
