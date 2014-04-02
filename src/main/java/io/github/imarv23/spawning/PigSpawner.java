package io.github.imarv23.spawning;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class PigSpawner extends RightClickSpawner {
	
	public PigSpawner(Player p)
	{
		super(p);
	}
	
	public void spawnPig()
	{
		if(this.struct != null)
		{
			this.pl.getWorld().spawnEntity(this.struct.getSpawningLocation() , EntityType.PIG);
			this.struct.removeBlocks();
		}
	}
}
