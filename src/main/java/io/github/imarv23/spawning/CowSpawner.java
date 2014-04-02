package io.github.imarv23.spawning;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CowSpawner extends RightClickSpawner{

	public CowSpawner(Player p, FileConfiguration conf) {
		super(p, conf);
	}
	
	public void spawnCow()
	{
		if(this.struct != null)
		{
			this.struct.removeBlocks();
			this.pl.getWorld().spawnEntity(this.struct.getSpawningLocation() , EntityType.COW);
			this.paySacrifice();
		}
	}
	
	private void paySacrifice()
	{
		this.pl.getInventory().removeItem(new ItemStack(Material.LEATHER, this.conf.getInt("Cow.Sacrifice")));
	}
}
