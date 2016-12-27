package com.slarmods.tmnmod.block;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.slarmods.tmnmod.TooMuchNature;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCherryGrass extends Block implements IGrowable {
	private static final Logger logger = LogManager.getLogger();
	@SideOnly(Side.CLIENT)
	private IIcon field_149991_b;
	@SideOnly(Side.CLIENT)
	private IIcon field_149993_M;

	public BlockCherryGrass(Material material) {
		super(Material.grass);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeGrass);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.field_149991_b
				: (side == 0 ? Blocks.dirt.getBlockTextureFromSide(side) : this.blockIcon);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (!world.isRemote) {
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
				world.setBlock(x, y, z, Blocks.dirt);
			} else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = x + random.nextInt(3) - 1;
					int j1 = y + random.nextInt(5) - 3;
					int k1 = z + random.nextInt(3) - 1;
					// Block block = p_149674_1_.getBlock(i1, j1 + 1, k1);

					if (world.getBlock(i1, j1, k1) == Blocks.dirt && world.getBlockMetadata(i1, j1, k1) == 0
							&& world.getBlockLightValue(i1, j1 + 1, k1) >= 4
							&& world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						world.setBlock(i1, j1, k1, Blocks.dirt);
					}
				}
			}
		}
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return Blocks.dirt.getItemDropped(0, random, fortune);
	}

	public boolean func_149851_a(World world, int x, int y, int z, boolean isGrowing) {
		return true;
	}

	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
		if (side == 1) {
			return this.field_149991_b;
		} else if (side == 0) {
			return Blocks.dirt.getBlockTextureFromSide(side);
		} else {
			Material material = blockAccess.getBlock(x, y + 1, z).getMaterial();
			return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.field_149993_M;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister
				.registerIcon(TooMuchNature.modid + ":" + this.getTextureName().substring(23) + "_side");
		this.field_149991_b = iconRegister
				.registerIcon(TooMuchNature.modid + ":" + this.getTextureName().substring(23) + "_top");
		this.field_149993_M = iconRegister
				.registerIcon(TooMuchNature.modid + ":" + this.getTextureName().substring(23) + "_side_snowed");
	}

	public void func_149853_b(World world, Random random, int x, int y, int z) {
		int l = 0;

		while (l < 128) {
			int i1 = x;
			int j1 = y + 1;
			int k1 = z;
			int l1 = 0;

			while (true) {
				if (l1 < l / 16) {
					i1 += random.nextInt(3) - 1;
					j1 += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
					k1 += random.nextInt(3) - 1;

					if (world.getBlock(i1, j1 - 1, k1) == TooMuchNature.cherry_grass
							&& !world.getBlock(i1, j1, k1).isNormalCube()) {
						++l1;
						continue;
					}
				} else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air) {
					if (random.nextInt(8) != 0) {
						if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
						}
					} else {
						world.getBiomeGenForCoords(i1, k1).plantFlower(world, random, i1, j1, k1);
					}
				}

				++l;
				break;
			}
		}
	}
}
