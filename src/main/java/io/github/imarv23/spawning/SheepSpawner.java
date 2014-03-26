package io.github.imarv23.spawning;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/**
 * Subclass of EntitySpawner can check for sheep structures and is able to spawn a sheep
 * 
 * @author iMarv23
 *
 */

public class SheepSpawner extends EntitySpawner{
	
	private Block 	pump;
	private Player 	player;
	
	private Block structureBlock1, structureBlock2;
	
	/**
	 * Constructor
	 * 
	 * @param b Originally placed Block
	 * @param p Player who placed the block
	 */
	public SheepSpawner(Block b, Player p)
	{
		this.pump 	= b;
		this.player = p;
	}
	
	/**
	 * Checks for a structure in shape of a "sheep"
	 * 
	 * @return returns true if there is a structure meant for a sheep and returns false if there is no structure
	 */
	public boolean checkIfSheep()
	{
		if(this.checkAllDirections(this.pump, Material.WOOL) != this.pump)
		{
			this.structureBlock1 = this.checkAllDirections(this.pump, Material.WOOL);
			
			if(this.checkAllDirections(this.structureBlock1, Material.WOOL) != this.structureBlock1)
			{
				this.structureBlock2 = this.checkAllDirections(this.structureBlock1, Material.WOOL);
				return true;
			}
			
		}
		
		return false;
	}
	
	/**
	 * Spawns a white sheep and removes the structure blocks
	 * 
	 * @return returns true if spawning the sheep was successful, returns false otherwise
	 */
	public boolean spawnSheep()
	{
		if(this.isSpawnPossible())
		{
			Location l = this.structureBlock1.getLocation();
			
			this.pump.setType(Material.AIR);
			this.structureBlock1.setType(Material.AIR);
			this.structureBlock2.setType(Material.AIR);
			
			this.player.getWorld().spawnEntity(l, EntityType.SHEEP);
		}
		return false;
	}
	
	/**
	 * Will spawn sheeps with custom colors
	 * 
	 * To be done
	 * 
	 * @return returns true if spawning the sheep was successful, returns false otherwise
	 */
	public boolean spawnSheepCustomColor()
	{
		return false;
	}
	
	/**
	 * Checks if there is a "sheep-structure"
	 * 
	 * @return true if a structure is built, false if not
	 */
	private boolean isSpawnPossible()
	{
		if(this.structureBlock1 != null && this.structureBlock2 != null)
		{
			return true;
		}
		return false;
	}
}
