package com.theslarfab.tmnmod.world.biome.ender;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEnderlandsRiver extends BiomeGenBase {

	public BiomeGenEnderlandsRiver(int id) {
		super(id);
		this.setColor(2595840);
		this.setTemperatureRainfall(0.7F, 0.8F);
		this.setHeight(BiomeGenBase.height_ShallowWaters);
		this.spawnableCreatureList.clear();

		this.topBlock = TMNBlocks.end_grass;
		this.fillerBlock = TMNBlocks.end_dirt;
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 2595840;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 2928640;
	}
}