package io.github.imarv23.spawning;

import io.github.imarv23.structures.AnimalStructure;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class RightClickSpawner extends EntitySpawner{
	
	protected AnimalStructure struct;
	
	public RightClickSpawner(Player p)
	{
		super(p);
	}
	
	
	public boolean checkForValidStructure(Block b, Material m)
	{
		Block buffer;
		if(b.getType() == Material.PUMPKIN)
		{
			if(this.checkAllDirections(b, m) != b)
			{
				buffer = this.checkAllDirections(b, m);
				
				if(this.checkAllDirections(buffer, m) != buffer)
				{
					this.struct = new AnimalStructure(b, buffer, this.checkAllDirections(buffer, m));
					return true;
				}
			}
		}
		
		return false;
	}
	
	
}
