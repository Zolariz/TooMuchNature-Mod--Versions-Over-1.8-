package com.slarmods.tmnmod.world.biome.ender;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEnderlands extends BiomeGenBase {

	public BiomeGenEnderlands(int id) {
		super(id);

		this.setColor(2595840);
		this.setTemperatureRainfall(0.7F, 0.8F);
		this.setHeight(height_LowPlains);

		this.topBlock = TooMuchNature.end_grass;
		this.fillerBlock = TooMuchNature.end_dirt;
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
