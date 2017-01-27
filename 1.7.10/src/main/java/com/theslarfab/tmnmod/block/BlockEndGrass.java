package com.theslarfab.tmnmod.block;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.init.TMNBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEndGrass extends Block implements IGrowable {
	private static final Logger logger = LogManager.getLogger();
	@SideOnly(Side.CLIENT)
	private IIcon topTexture;
	@SideOnly(Side.CLIENT)
	private IIcon sideSnowed;

	public BlockEndGrass(Material material) {
		super(Material.grass);
		this.setTickRandomly(true);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
		this.setHarvestLevel("shovel", 0);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.topTexture
				: (side == 0 ? TMNBlocks.end_dirt.getBlockTextureFromSide(side) : this.blockIcon);
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (!world.isRemote) {
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
				world.setBlock(x, y, z, TMNBlocks.end_dirt);
			} else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = x + random.nextInt(3) - 1;
					int j1 = y + random.nextInt(5) - 3;
					int k1 = z + random.nextInt(3) - 1;
					Block block = world.getBlock(i1, j1 + 1, k1);

					if (world.getBlock(i1, j1, k1) == TMNBlocks.end_dirt && world.getBlockMetadata(i1, j1, k1) == 0
							&& world.getBlockLightValue(i1, j1 + 1, k1) >= 4
							&& world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						world.setBlock(i1, j1, k1, TMNBlocks.end_grass);
					}
				}
			}
		}
	}

	public Item getItemDropped(int metadata, Random random, int fortune) {
		return TMNBlocks.end_dirt.getItemDropped(0, random, fortune);
	}

	public boolean func_149851_a(World world, int x, int y, int z, boolean doesGrowOnDirt) {
		return true;
	}

	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
		if (side == 1) {
			return this.topTexture;
		} else if (side == 0) {
			return TMNBlocks.end_dirt.getBlockTextureFromSide(side);
		} else {
			Material material = blockAccess.getBlock(x, y + 1, z).getMaterial();
			return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.sideSnowed;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_side");
		this.topTexture = iconRegister.registerIcon(this.getTextureName() + "_top");
		this.sideSnowed = iconRegister.registerIcon(this.getTextureName() + "_side_snowed");
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

					if (world.getBlock(i1, j1 - 1, k1) == TMNBlocks.end_grass
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