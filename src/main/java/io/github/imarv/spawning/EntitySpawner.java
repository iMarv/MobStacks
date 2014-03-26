package io.github.imarv.spawning;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class EntitySpawner {
	
	public EntitySpawner()
	{
		
	}
	
	protected Block checkAllDirections(Block b, Material m)
	{
		if(b.getRelative(BlockFace.NORTH).getType() == m) {
			
			return b.getRelative(BlockFace.NORTH);

		}else if(b.getRelative(BlockFace.EAST).getType() == m) {
			
			return b.getRelative(BlockFace.EAST);

		}else if(b.getRelative(BlockFace.SOUTH).getType() == m) {
			
			return b.getRelative(BlockFace.SOUTH);

		}else if(b.getRelative(BlockFace.WEST).getType() == m) {
			
			return b.getRelative(BlockFace.WEST);
		}

		return b;
	}
	
	
	
	
}
