package com.slarmods.tmnmod.world.gen;

import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class TMNWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		}
	}

	public void generateEnd(World world, Random random, int x, int z) {
		generateOre(TooMuchNature.end_obsidian, world, random, x, z, 1, 3, 5, 0, 100, Blocks.end_stone);
	}

	public void generateOverworld(World world, Random random, int x, int z) {

	}

	public void generateNether(World world, Random random, int x, int z) {

	}

	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize,
			int maxVeinSize, int chance, int minY, int maxY, Block generateIn) {
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY + minY;
		WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}
