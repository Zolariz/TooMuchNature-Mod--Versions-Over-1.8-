package com.slarmods.tmnmod.world;

import com.slarmods.tmnmod.world.biome.EnderBiomes;
import com.slarmods.tmnmod.world.gen.ChunkProviderEnderlands;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderEnderlands extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(EnderBiomes.enderlands, 0.1F);
		this.dimensionId = DimensionIDs.ENDERLANDSDIMENSION;
	}
	
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderEnderlands(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public String getDimensionName()
	{
		return "The Enderlands";
	}
}