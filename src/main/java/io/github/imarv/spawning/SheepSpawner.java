package io.github.imarv.spawning;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SheepSpawner extends EntitySpawner{
	
	private Block 	pump;
	private Player 	player;
	
	private Block structureBlock1, structureBlock2;
	
	public SheepSpawner(Block b, Player p)
	{
		this.pump 	= b;
		this.player = p;
	}
	
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
	
	public boolean spawnSheepCustomColor()
	{
		return false;
	}
	
	private boolean isSpawnPossible()
	{
		if(this.structureBlock1 != null && this.structureBlock2 != null)
		{
			return true;
		}
		return false;
	}
}
