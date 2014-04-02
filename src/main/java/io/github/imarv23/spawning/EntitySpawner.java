package io.github.imarv23.spawning;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * 
 * 
 * @author iMarv23
 *
 */
public class EntitySpawner {
	
	protected Player pl;
	protected FileConfiguration conf;
	
	/**
	 * Constructor
	 * @param p Player
	 */
	public EntitySpawner(Player p, FileConfiguration c)
	{
		this.pl = p;
		this.conf = c;
	}
	
	/**
	 * Checks all sides of Block b for the material m
	 * 
	 * @param b Block to be checked
	 * @param m Material to be checked for
	 * 
	 * @return true if it finds a block, false if not
	 */
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