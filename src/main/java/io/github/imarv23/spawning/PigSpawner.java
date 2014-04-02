package io.github.imarv23.spawning;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PigSpawner extends RightClickSpawner {
	
	/**
	 * Constructor, initiates the constructor of RightClickSpawner and saves the sacrifice
	 * @param p Player
	 */
	public PigSpawner(Player p, FileConfiguration conf)
	{
		super(p, conf);
	}
	
	/**
	 * Spawns a pig and removes the structure
	 */
	public void spawnPig()
	{
		if(this.struct != null)
		{
			this.struct.removeBlocks();
			this.pl.getWorld().spawnEntity(this.struct.getSpawningLocation() , EntityType.PIG);
			this.paySacrifice();
		}
	}
	
	/**
	 * Removes the sacrifice from the players inventory
	 */
	private void paySacrifice()
	{
		this.pl.getInventory().removeItem(new ItemStack(Material.PORK, this.conf.getInt("Pig.Sacrifice")));
	}
}
