package io.github.imarv23.spawning;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PigSpawner extends RightClickSpawner {
	
	private int sacrifice;
	
	public PigSpawner(Player p, int s)
	{
		super(p);
		this.sacrifice = s;
	}
	
	public void spawnPig()
	{
		if(this.struct != null)
		{
			this.struct.removeBlocks();
			this.pl.getWorld().spawnEntity(this.struct.getSpawningLocation() , EntityType.PIG);
			this.paySacrifice();
		}
	}
	
	private void paySacrifice()
	{
		this.pl.getInventory().removeItem(new ItemStack(Material.PORK, this.sacrifice));
	}
}
