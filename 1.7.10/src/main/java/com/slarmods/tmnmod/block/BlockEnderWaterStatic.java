package com.slarmods.tmnmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockEnderWaterStatic extends BlockEnderWaterLiquid {

	public BlockEnderWaterStatic(Material material) {
		super(material);
		this.setTickRandomly(false);

		if (material == Material.lava) {
			this.setTickRandomly(true);
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);

		if (world.getBlock(x, y, z) == this) {
			this.setNotStationary(world, x, y, z);
		}
	}

	private void setNotStationary(World world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		world.setBlock(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) - 1), l, 2);
		world.scheduleBlockUpdate(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) - 1), this.tickRate(world));
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (this.blockMaterial == Material.lava) {
			int l = random.nextInt(3);
			int i1;

			for (i1 = 0; i1 < l; ++i1) {
				x += random.nextInt(3) - 1;
				++y;
				z += random.nextInt(3) - 1;
				Block block = world.getBlock(x, y, z);

				if (block.getMaterial() == Material.air) {
					if (this.isFlammable(world, x - 1, y, z) || this.isFlammable(world, x + 1, y, z)
							|| this.isFlammable(world, x, y, z - 1) || this.isFlammable(world, x, y, z + 1)
							|| this.isFlammable(world, x, y - 1, z) || this.isFlammable(world, x, y + 1, z)) {
						world.setBlock(x, y, z, Blocks.fire);
						return;
					}
				} else if (block.getMaterial().blocksMovement()) {
					return;
				}
			}

			if (l == 0) {
				i1 = x;
				int k1 = z;

				for (int j1 = 0; j1 < 3; ++j1) {
					x = i1 + random.nextInt(3) - 1;
					z = k1 + random.nextInt(3) - 1;

					if (world.isAirBlock(x, y + 1, z) && this.isFlammable(world, x, y, z)) {
						world.setBlock(x, y + 1, z, Blocks.fire);
					}
				}
			}
		}
	}

	/**
	 * Checks to see if the block is flammable.
	 */
	private boolean isFlammable(World p_149817_1_, int p_149817_2_, int p_149817_3_, int p_149817_4_) {
		return p_149817_1_.getBlock(p_149817_2_, p_149817_3_, p_149817_4_).getMaterial().getCanBurn();
	}
}