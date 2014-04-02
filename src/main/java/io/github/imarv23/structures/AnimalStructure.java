package io.github.imarv23.structures;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class AnimalStructure {
	
	private Block head;
	private Block torso1;
	private Block torso2;
	
	/**
	 * Constructor
	 * 
	 * @param h Head-Block
	 * @param t1 Torso-Block 1
	 * @param t2 Torso-Block 2
	 */
	public AnimalStructure(Block h, Block t1, Block t2)
	{
		this.head = h;
		this.torso1 = t1;
		this.torso2 = t2;
	}
	
	/**
	 * Removes all blocks of the structure (sets their type to air)
	 */
	public void removeBlocks()
	{
		this.head.setType(Material.AIR);
		this.torso1.setType(Material.AIR);
		this.torso2.setType(Material.AIR);
	}
	
	/**
	 * Returns the location where the animal should be spawned
	 * @return Location of the Torso-Block 1
	 */
	public Location getSpawningLocation()
	{
		return this.torso1.getLocation();
	}
	
}
