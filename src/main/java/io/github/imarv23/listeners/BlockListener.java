package io.github.imarv23.listeners;

import io.github.imarv23.spawning.SheepSpawner;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;


/**
 * A Block listener that listens for certain blocks to be placed
 * Depending on the type of the block and its surroundings an animal will be spawned
 * 
 * @author iMarv23
 * 
 */

public class BlockListener implements Listener {

	private SheepSpawner shSpawner;
	private FileConfiguration conf;
	
	public BlockListener(FileConfiguration conf)
	{
		this.conf = conf;
	}
	
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
			this.shSpawner = new SheepSpawner(b, e.getPlayer(), this.conf);
			if(this.shSpawner.checkIfSheep())
			{
				if(this.shSpawner.getDyeColor() == DyeColor.WHITE)
				{
					this.shSpawner.spawnSheep();
				}else{
					this.shSpawner.spawnSheepCustomColor();
				}
			}
		}
	}
	
	
}
