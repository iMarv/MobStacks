package io.github.imarv23.spawning;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.material.Wool;

/**
 * Subclass of EntitySpawner can check for sheep structures and is able to spawn a sheep
 * 
 * @author iMarv23
 *
 */

public class SheepSpawner extends EntitySpawner{
	
	private Block 	pump;
	
	private Block structureBlock1, structureBlock2;
	
	/**
	 * Constructor
	 * 
	 * @param b Originally placed Block
	 * @param p Player who placed the block
	 */
	public SheepSpawner(Block b, Player p, FileConfiguration conf)
	{
		super(p, conf);
		this.pump 	= b;
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
			
			this.pl.getWorld().spawnEntity(l, EntityType.SHEEP);
		}
		return false;
	}
	
	/**
	 * Returns the color of the block that decides the color of the sheep (the closest one to the head)
	 * 
	 * @return returns the color of the closest wool block
	 */
	public DyeColor getDyeColor()
	{
		Block b = this.structureBlock1;
		Wool w = (Wool)b.getState().getData();
		return w.getColor();
	}
	
	/**
	 * Will spawn sheeps with custom colors
	 * 
	 * @return returns true if spawning the sheep was successful, returns false otherwise
	 */
	public boolean spawnSheepCustomColor()
	{
		if(this.isSpawnPossible())
		{
			Wool w = (Wool) this.structureBlock1.getState().getData();
			DyeColor color = w.getColor();
			
			Location l = this.structureBlock1.getLocation();
			
			this.pump.setType(Material.AIR);
			this.structureBlock1.setType(Material.AIR);
			this.structureBlock2.setType(Material.AIR);
			
			Sheep sheep = (Sheep) this.pl.getWorld().spawnEntity(l, EntityType.SHEEP);
			sheep.setColor(color);
			
			return true;
		}
		
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
