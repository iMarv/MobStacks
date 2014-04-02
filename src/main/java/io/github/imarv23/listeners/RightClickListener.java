package io.github.imarv23.listeners;

import io.github.imarv23.spawning.CowSpawner;
import io.github.imarv23.spawning.PigSpawner;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickListener implements Listener {
	
	private Player p;
	private Block b;
	private FileConfiguration config;
	
	/**
	 * Constructor of the class
	 * 
	 * @param config Everything that is stored in the config.yml
	 */
	public RightClickListener(FileConfiguration config) {
		this.config = config;
	}

	/**
	 * Listens for rightclicks on pumpkins
	 * Initiates the process of spawning an animal if the player who is clicking got a material in his hand that matches the identifier of a specific animal
	 * 
	 * @param e PlayerInteractEvent
	 */
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			this.p = e.getPlayer();
			this.b = e.getClickedBlock();
			
			if(this.getItemInHand(this.p) == Material.PORK && this.p.getItemInHand().getAmount() >= config.getInt("Pig.Sacrifice"))
			{
				PigSpawner pig = new PigSpawner(this.p, this.config);
				
				if(pig.checkForValidStructure(this.b, Material.HAY_BLOCK))
				{
					pig.spawnPig();
				}
			}else if(this.getItemInHand(this.p) == Material.LEATHER && this.p.getItemInHand().getAmount() >= config.getInt("Cow.Sacrifice"))
			{
				CowSpawner cow = new CowSpawner(this.p, this.config);
				
				if(cow.checkForValidStructure(this.b, Material.HAY_BLOCK))
				{
					cow.spawnCow();
				}
			}
		}
	}
	
	/**
	 * Returns the item the player is holding in his hand
	 * 
	 * @param p Player
	 * @return Material of the item in the hand of the player
	 */
	public Material getItemInHand(Player p)
	{
		return p.getItemInHand().getType();
	}
}
