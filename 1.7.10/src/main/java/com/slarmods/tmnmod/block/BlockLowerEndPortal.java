package com.slarmods.tmnmod.block;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.world.DimensionIDs;
import com.slarmods.tmnmod.world.teleporter.EnderlandsDimensionTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class BlockLowerEndPortal extends BlockPortal {

	public BlockLowerEndPortal() {
		super();
		this.setTickRandomly(true);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP))) {
			EntityPlayerMP player = (EntityPlayerMP) entity;

			MinecraftServer mServer = MinecraftServer.getServer();

			if (player.timeUntilPortal > 0) {
				player.timeUntilPortal = 10;
			} else if (player.dimension != DimensionIDs.ENDERLANDSDIMENSION) {
				player.timeUntilPortal = 10;

				player.mcServer.getConfigurationManager().transferPlayerToDimension(player,
						DimensionIDs.ENDERLANDSDIMENSION, new EnderlandsDimensionTeleporter(
								mServer.worldServerForDimension(DimensionIDs.ENDERLANDSDIMENSION)));
			} else {
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0,
						new EnderlandsDimensionTeleporter(mServer.worldServerForDimension(1)));
			}
		}
	}

	@Override
	public boolean func_150000_e(World world, int x, int y, int z) {
		byte b0 = 0;
		byte b1 = 0;

		if (world.getBlock(x - 1, y, z) == TooMuchNature.lower_end_portal
				|| world.getBlock(x + 1, y, z) == TooMuchNature.lower_end_portal) {
			b0 = 1;
		}

		if (world.getBlock(x, y, z - 1) == TooMuchNature.lower_end_portal
				|| world.getBlock(x, y, z + 1) == TooMuchNature.lower_end_portal) {
			b1 = 1;
		}

		if (b0 == b1) {
			return false;
		} else {
			if (world.isAirBlock(x - b0, y, z - b1)) {
				x -= b0;
				z -= b1;
			}

			int l;
			int i1;

			for (l = -1; l <= 2; ++l) {
				for (i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

					if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
						Block j1 = world.getBlock(x + b0 * l, y + i1, z + b1 * l);
						boolean isAirBlock = world.isAirBlock(x + b0 * l, y + i1, z + b1 * l);

						if (flag) {
							if (j1 != TooMuchNature.lower_end_portal) {
								return false;
							}
						} else if (!isAirBlock && j1 != TooMuchNature.end_fire) {
							return false;
						}
					}
				}
			}

			for (l = 0; l < 2; ++l) {
				for (i1 = 0; i1 < 3; ++i1) {
					world.setBlock(x + b0 * l, y + i1, z + b1 * l, TooMuchNature.lower_end_portal, 0, 2);
				}
			}

			return true;
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		byte b0 = 0;
		byte b1 = 1;

		if (world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1, y, z) == this) {
			b0 = 1;
			b1 = 0;
		}

		int i1;

		for (i1 = y; world.getBlock(x, i1 - 1, z) == this; --i1) {
			;
		}

		if (world.getBlock(x, i1 - 1, z) != TooMuchNature.lower_end_portal) {
			world.setBlockToAir(x, y, z);
		} else {
			int j1;

			for (j1 = 1; j1 < 4 && world.getBlock(x, i1 + j1, z) == this; ++j1) {
				;
			}

			if (j1 == 3 && world.getBlock(x, i1 + j1, z) == TooMuchNature.lower_end_portal) {
				boolean flag = world.getBlock(x - 1, y, z) == this || world.getBlock(x + 1, y, z) == this;
				boolean flag1 = world.getBlock(x, y, z - 1) == this || world.getBlock(x, y, z + 1) == this;

				if (flag && flag1) {
					world.setBlockToAir(x, y, z);
				} else {
					if ((world.getBlock(x + b0, y, z + b1) != TooMuchNature.lower_end_portal
							|| world.getBlock(x - b0, y, z - b1) != this)
							&& (world.getBlock(x - b0, y, z - b1) != TooMuchNature.lower_end_portal
									|| world.getBlock(x + b0, y, z + b1) != this)) {
						world.setBlockToAir(x, y, z);
					}
				}
			} else {
				world.setBlockToAir(x, y, z);
			}
		}
	}
}
