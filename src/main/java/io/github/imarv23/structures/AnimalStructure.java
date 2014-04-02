package io.github.imarv23.structures;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class AnimalStructure {
	
	private Block head;
	private Block torso1;
	private Block torso2;
	
	public AnimalStructure(Block h, Block t1, Block t2)
	{
		this.head = h;
		this.torso1 = t1;
		this.torso2 = t2;
	}
	
	public void removeBlocks()
	{
		this.head.setType(Material.AIR);
		this.torso1.setType(Material.AIR);
		this.torso2.setType(Material.AIR);
	}
	
	public Location getSpawningLocation()
	{
		return this.torso1.getLocation();
	}
	
}
