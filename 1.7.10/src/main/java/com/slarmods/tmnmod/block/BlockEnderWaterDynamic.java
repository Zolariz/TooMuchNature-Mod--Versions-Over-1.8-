package com.slarmods.tmnmod.block;

import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockEnderWaterDynamic extends BlockLiquid {

	int liquid;
	boolean[] isFlowing = new boolean[4];
	int[] blockModel = new int[4];

	public BlockEnderWaterDynamic(Material material) {
		super(material);
	}

	private void func_149811_n(World world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		world.setBlock(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) + 1), l, 2);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random random) {
		int l = this.func_149804_e(world, x, y, z);
		byte b0 = 1;

		if (this.blockMaterial == Material.lava && !world.provider.isHellWorld) {
			b0 = 2;
		}

		boolean flag = true;
		int i1 = this.tickRate(world);
		int j1;

		if (l > 0) {
			byte b1 = -100;
			this.liquid = 0;
			int l1 = this.func_149810_a(world, x - 1, y, z, b1);
			l1 = this.func_149810_a(world, x + 1, y, z, l1);
			l1 = this.func_149810_a(world, x, y, z - 1, l1);
			l1 = this.func_149810_a(world, x, y, z + 1, l1);
			j1 = l1 + b0;

			if (j1 >= 8 || l1 < 0) {
				j1 = -1;
			}

			if (this.func_149804_e(world, x, y + 1, z) >= 0) {
				int k1 = this.func_149804_e(world, x, y + 1, z);

				if (k1 >= 8) {
					j1 = k1;
				} else {
					j1 = k1 + 8;
				}
			}

			if (this.liquid >= 2 && this.blockMaterial == Material.water) {
				if (world.getBlock(x, y - 1, z).getMaterial().isSolid()) {
					j1 = 0;
				} else if (world.getBlock(x, y - 1, z).getMaterial() == this.blockMaterial
						&& world.getBlockMetadata(x, y - 1, z) == 0) {
					j1 = 0;
				}
			}

			if (this.blockMaterial == Material.lava && l < 8 && j1 < 8 && j1 > l && random.nextInt(4) != 0) {
				i1 *= 4;
			}

			if (j1 == l) {
				if (flag) {
					this.func_149811_n(world, x, y, z);
				}
			} else {
				l = j1;

				if (j1 < 0) {
					world.setBlockToAir(x, y, z);
				} else {
					world.setBlockMetadataWithNotify(x, y, z, j1, 2);
					world.scheduleBlockUpdate(x, y, z, this, i1);
					world.notifyBlocksOfNeighborChange(x, y, z, this);
				}
			}
		} else {
			this.func_149811_n(world, x, y, z);
		}

		if (this.func_149809_q(world, x, y - 1, z)) {
			if (this.blockMaterial == Material.lava && world.getBlock(x, y - 1, z).getMaterial() == Material.water) {
				world.setBlock(x, y - 1, z, TooMuchNature.end_stone_smooth);
				this.func_149799_m(world, x, y - 1, z);
				return;
			}

			if (l >= 8) {
				this.func_149813_h(world, x, y - 1, z, l);
			} else {
				this.func_149813_h(world, x, y - 1, z, l + 8);
			}
		} else if (l >= 0 && (l == 0 || this.func_149807_p(world, x, y - 1, z))) {
			boolean[] aboolean = this.func_149808_o(world, x, y, z);
			j1 = l + b0;

			if (l >= 8) {
				j1 = 1;
			}

			if (j1 >= 8) {
				return;
			}

			if (aboolean[0]) {
				this.func_149813_h(world, x - 1, y, z, j1);
			}

			if (aboolean[1]) {
				this.func_149813_h(world, x + 1, y, z, j1);
			}

			if (aboolean[2]) {
				this.func_149813_h(world, x, y, z - 1, j1);
			}

			if (aboolean[3]) {
				this.func_149813_h(world, x, y, z + 1, j1);
			}
		}
	}

	private void func_149813_h(World world, int x, int y, int z, int side) {
		if (this.func_149809_q(world, x, y, z)) {
			Block block = world.getBlock(x, y, z);

			if (this.blockMaterial == Material.lava) {
				this.func_149799_m(world, x, y, z);
			} else {
				block.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			}

			world.setBlock(x, y, z, this, side, 3);
		}
	}

	private int func_149812_c(World world, int x, int y, int z, int side, int p_149812_6_) {
		int j1 = 1000;

		for (int k1 = 0; k1 < 4; ++k1) {
			if ((k1 != 0 || p_149812_6_ != 1) && (k1 != 1 || p_149812_6_ != 0) && (k1 != 2 || p_149812_6_ != 3)
					&& (k1 != 3 || p_149812_6_ != 2)) {
				int l1 = x;
				int i2 = z;

				if (k1 == 0) {
					l1 = x - 1;
				}

				if (k1 == 1) {
					++l1;
				}

				if (k1 == 2) {
					i2 = z - 1;
				}

				if (k1 == 3) {
					++i2;
				}

				if (!this.func_149807_p(world, l1, y, i2)
						&& (world.getBlock(l1, y, i2).getMaterial() != this.blockMaterial
								|| world.getBlockMetadata(l1, y, i2) != 0)) {
					if (!this.func_149807_p(world, l1, y - 1, i2)) {
						return side;
					}

					if (side < 4) {
						int j2 = this.func_149812_c(world, l1, y, i2, side + 1, k1);

						if (j2 < j1) {
							j1 = j2;
						}
					}
				}
			}
		}

		return j1;
	}

	private boolean[] func_149808_o(World world, int x, int y, int z) {
		int l;
		int i1;

		for (l = 0; l < 4; ++l) {
			this.blockModel[l] = 1000;
			i1 = x;
			int j1 = z;

			if (l == 0) {
				i1 = x - 1;
			}

			if (l == 1) {
				++i1;
			}

			if (l == 2) {
				j1 = z - 1;
			}

			if (l == 3) {
				++j1;
			}

			if (!this.func_149807_p(world, i1, y, j1) && (world.getBlock(i1, y, j1).getMaterial() != this.blockMaterial
					|| world.getBlockMetadata(i1, y, j1) != 0)) {
				if (this.func_149807_p(world, i1, y - 1, j1)) {
					this.blockModel[l] = this.func_149812_c(world, i1, y, j1, 1, l);
				} else {
					this.blockModel[l] = 0;
				}
			}
		}

		l = this.blockModel[0];

		for (i1 = 1; i1 < 4; ++i1) {
			if (this.blockModel[i1] < l) {
				l = this.blockModel[i1];
			}
		}

		for (i1 = 0; i1 < 4; ++i1) {
			this.isFlowing[i1] = this.blockModel[i1] == l;
		}

		return this.isFlowing;
	}

	private boolean func_149807_p(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return block != Blocks.wooden_door && block != Blocks.iron_door && block != Blocks.standing_sign
				&& block != Blocks.ladder && block != Blocks.reeds
						? (block.getMaterial() == Material.portal ? true : block.getMaterial().blocksMovement()) : true;
	}

	protected int func_149810_a(World world, int x, int y, int z, int side) {
		int i1 = this.func_149804_e(world, x, y, z);

		if (i1 < 0) {
			return side;
		} else {
			if (i1 == 0) {
				++this.liquid;
			}

			if (i1 >= 8) {
				i1 = 0;
			}

			return side >= 0 && i1 >= side ? side : i1;
		}
	}

	private boolean func_149809_q(World world, int x, int y, int z) {
		Material material = world.getBlock(x, y, z).getMaterial();
		return material == this.blockMaterial ? false
				: (material == Material.lava ? false : !this.func_149807_p(world, x, y, z));
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if (world.getBlock(x, y, z) == this) {
			world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
		}
	}

	public boolean func_149698_L() {
		return true;
	}
}
