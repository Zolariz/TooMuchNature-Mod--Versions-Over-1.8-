package com.theslarfab.tmnmod.world.genlayer;

import com.theslarfab.tmnmod.world.biome.EnderBiomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class EnderlandsGenLayerBiomes extends GenLayer {

	protected BiomeGenBase[] allowedBiomes = { EnderBiomes.enderlands, EnderBiomes.enderlandsRiver, };

	public EnderlandsGenLayerBiomes(long seed) {
		super(seed);
	}

	public EnderlandsGenLayerBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}
