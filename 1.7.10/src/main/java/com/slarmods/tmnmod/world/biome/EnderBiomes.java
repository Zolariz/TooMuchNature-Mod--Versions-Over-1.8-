package com.slarmods.tmnmod.world.biome;

import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.init.TMNBlocks;
import com.slarmods.tmnmod.world.biome.ender.BiomeGenEnderlands;
import com.slarmods.tmnmod.world.biome.ender.BiomeGenEnderlandsRiver;
import com.slarmods.tmnmod.world.biome.ender.decorator.EnderBiomeDecorator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class EnderBiomes extends BiomeGenBase {

	/** The biome height */
	public static final BiomeGenBase.Height biomeHeight = new BiomeGenBase.Height(0.3F, 0.6F);

	public static BiomeGenBase enderlands;
	public static BiomeGenBase enderlandsRiver;

	public EnderBiomes(int biomeId) {
		super(biomeId);
		this.theBiomeDecorator = new EnderBiomeDecorator();
	}

	public static void init() {
		EnderBiomes.initBiomes();
		EnderBiomes.registerWithBiomeDictionary();
	}

	public static void initBiomes() {
		enderlands = new BiomeGenEnderlands(42).setBiomeName("Forest Of Light");
		enderlandsRiver = new BiomeGenEnderlandsRiver(43).setBiomeName("Darkness Forest");
	}

	public WorldGenerator getRandomWorldGenForGrass(Random random) {
		if (random.nextInt(4) == 0)
			return new WorldGenTallGrass(Blocks.tallgrass, 2);
		else
			return new WorldGenTallGrass(Blocks.tallgrass, 1);
	}

	public static void registerWithBiomeDictionary() {
		BiomeDictionary.registerBiomeType(enderlands, Type.PLAINS);
		BiomeDictionary.registerBiomeType(enderlandsRiver, Type.RIVER);
		BiomeDictionary.registerAllBiomes();
	}

	@Override
	public void genTerrainBlocks(World world, Random random, Block[] blockTerrain, byte[] bByte, int x, int y,
			double z) {
		genBiomeModdedTerrain(world, random, blockTerrain, bByte, x, y, z);
	}

	/**
	 * Replaces custom Stone to allow top/filler blocks to work in dimension.
	 * 
	 * @param world
	 * @param random
	 * @param replacableBlock
	 * @param aByte
	 * @param x
	 * @param y
	 * @param z
	 */
	public void genBiomeModdedTerrain(World world, Random random, Block[] replacableBlock, byte[] aByte, int x, int y,
			double z) {
		Block block = this.topBlock;
		byte b0 = (byte) (this.field_150604_aj & 255);
		Block block1 = this.fillerBlock;
		int k = -1;
		int l = (int) (z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		int i1 = x & 15;
		int j1 = y & 15;
		int k1 = replacableBlock.length / 256;
		for (int l1 = 255; l1 >= 0; --l1) {
			int i2 = (j1 * 16 + i1) * k1 + l1;

			if (l1 <= 0 + random.nextInt(5)) {
				replacableBlock[i2] = Blocks.bedrock;
			} else {
				Block block2 = replacableBlock[i2];

				if (block2 != null && block2.getMaterial() != Material.air) {
					if (block2 == TMNBlocks.end_stone_smooth) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = TMNBlocks.end_stone_smooth;
							} else if (l1 >= 59 && l1 <= 64) {
								block = this.topBlock;
								b0 = (byte) (this.field_150604_aj & 255);
								block1 = this.fillerBlock;
							}

							if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if (this.getFloatTemperature(x, l1, y) < 0.15F) {
									block = Blocks.ice;
									b0 = 0;
								} else {
									block = Blocks.water;
									b0 = 0;
								}
							}

							k = l;

							if (l1 >= 62) {
								replacableBlock[i2] = block;
								aByte[i2] = b0;
							} else if (l1 < 56 - l) {
								block = null;
								block1 = TMNBlocks.end_stone_smooth;
								replacableBlock[i2] = Blocks.gravel;
							} else {
								replacableBlock[i2] = block1;
							}
						} else if (k > 0) {
							--k;
							replacableBlock[i2] = block1;

							if (k == 0 && block1 == Blocks.sand) {
								k = random.nextInt(4) + Math.max(0, l1 - 63);
								block1 = Blocks.sandstone;
							}
						}
					}
				} else {
					k = -1;
				}
			}
		}
	}
}