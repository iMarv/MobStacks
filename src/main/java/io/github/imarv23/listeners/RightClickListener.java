package io.github.imarv23.listeners;

import io.github.imarv23.spawning.PigSpawner;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickListener implements Listener {
	
	private Player p;
	private Block b;
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			this.p = e.getPlayer();
			this.b = e.getClickedBlock();
			
			if(this.getItemInHand(this.p) == Material.PORK)
			{
				PigSpawner pig = new PigSpawner(this.p);
				
				if(pig.checkForValidStructure(this.b, Material.HAY_BLOCK))
				{
					pig.spawnPig();
				}
			}
		}
	}
	
	public Material getItemInHand(Player p)
	{
		return p.getItemInHand().getType();
	}
}
