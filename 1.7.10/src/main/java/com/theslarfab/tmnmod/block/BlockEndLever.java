package com.theslarfab.tmnmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.common.util.ForgeDirection;
import static net.minecraftforge.common.util.ForgeDirection.*;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.client.renderer.block.BlockRenderingIDs;

public class BlockEndLever extends Block {

	public BlockEndLever() {
		super(Material.circuits);
		this.setCreativeTab(TooMuchNatventure.tabEnderstone);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return BlockRenderingIDs.endLeverRenderID;
	}

	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		ForgeDirection dir = ForgeDirection.getOrientation(side);
		return (dir == DOWN && world.isSideSolid(x, y + 1, z, DOWN))
				|| (dir == UP && world.isSideSolid(x, y - 1, z, UP))
				|| (dir == NORTH && world.isSideSolid(x, y, z + 1, NORTH))
				|| (dir == SOUTH && world.isSideSolid(x, y, z - 1, SOUTH))
				|| (dir == WEST && world.isSideSolid(x + 1, y, z, WEST))
				|| (dir == EAST && world.isSideSolid(x - 1, y, z, EAST));
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isSideSolid(x - 1, y, z, EAST) || world.isSideSolid(x + 1, y, z, WEST)
				|| world.isSideSolid(x, y, z - 1, SOUTH) || world.isSideSolid(x, y, z + 1, NORTH)
				|| world.isSideSolid(x, y - 1, z, UP) || world.isSideSolid(x, y + 1, z, DOWN);
	}

	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int par9) {
		int k1 = par9 & 8;
		int j1 = par9 & 7;
		byte b0 = -1;

		if (side == 0 && world.isSideSolid(x, y + 1, z, DOWN)) {
			b0 = 0;
		}

		if (side == 1 && world.isSideSolid(x, y - 1, z, UP)) {
			b0 = 5;
		}

		if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH)) {
			b0 = 4;
		}

		if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH)) {
			b0 = 3;
		}

		if (side == 4 && world.isSideSolid(x + 1, y, z, WEST)) {
			b0 = 2;
		}

		if (side == 5 && world.isSideSolid(x - 1, y, z, EAST)) {
			b0 = 1;
		}

		return b0 + k1;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase,
			ItemStack itemStack) {
		int l = world.getBlockMetadata(x, y, z);
		int i1 = l & 7;
		int j1 = l & 8;

		if (i1 == invertMetadata(1)) {
			if ((MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 5 | j1, 2);
			} else {
				world.setBlockMetadataWithNotify(x, y, z, 6 | j1, 2);
			}
		} else if (i1 == invertMetadata(0)) {
			if ((MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 7 | j1, 2);
			} else {
				world.setBlockMetadataWithNotify(x, y, z, 0 | j1, 2);
			}
		}
	}

	public static int invertMetadata(int metadata) {
		switch (metadata) {
		case 0:
			return 0;
		case 1:
			return 5;
		case 2:
			return 4;
		case 3:
			return 3;
		case 4:
			return 2;
		case 5:
			return 1;
		default:
			return -1;
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (this.func_149820_e(world, x, y, z)) {
			int l = world.getBlockMetadata(x, y, z) & 7;
			boolean flag = false;

			if (!world.isSideSolid(x - 1, y, z, EAST) && l == 1) {
				flag = true;
			}

			if (!world.isSideSolid(x + 1, y, z, WEST) && l == 2) {
				flag = true;
			}

			if (!world.isSideSolid(x, y, z - 1, SOUTH) && l == 3) {
				flag = true;
			}

			if (!world.isSideSolid(x, y, z + 1, NORTH) && l == 4) {
				flag = true;
			}

			if (!world.isSideSolid(x, y - 1, z, UP) && l == 5) {
				flag = true;
			}

			if (!world.isSideSolid(x, y - 1, z, UP) && l == 6) {
				flag = true;
			}

			if (!world.isSideSolid(x, y + 1, z, DOWN) && l == 0) {
				flag = true;
			}

			if (!world.isSideSolid(x, y + 1, z, DOWN) && l == 7) {
				flag = true;
			}

			if (flag) {
				this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	private boolean func_149820_e(World world, int x, int y, int z) {
		if (!this.canPlaceBlockAt(world, x, y, z)) {
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
			return false;
		} else {
			return true;
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z) & 7;
		float f = 0.1875F;

		if (l == 1) {
			this.setBlockBounds(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
		} else if (l == 2) {
			this.setBlockBounds(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
		} else if (l == 3) {
			this.setBlockBounds(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
		} else if (l == 4) {
			this.setBlockBounds(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
		} else if (l != 5 && l != 6) {
			if (l == 0 || l == 7) {
				f = 0.25F;
				this.setBlockBounds(0.5F - f, 0.4F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
			}
		} else {
			f = 0.25F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX,
			float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		} else {
			int i1 = world.getBlockMetadata(x, y, z);
			int j1 = i1 & 7;
			int k1 = 8 - (i1 & 8);
			world.setBlockMetadataWithNotify(x, y, z, j1 + k1, 3);
			world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.click", 0.3F,
					k1 > 0 ? 0.6F : 0.5F);
			world.notifyBlocksOfNeighborChange(x, y, z, this);

			if (j1 == 1) {
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			} else if (j1 == 2) {
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			} else if (j1 == 3) {
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			} else if (j1 == 4) {
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			} else if (j1 != 5 && j1 != 6) {
				if (j1 == 0 || j1 == 7) {
					world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				}
			} else {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			}

			return true;
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int side) {
		if ((side & 8) > 0) {
			world.notifyBlocksOfNeighborChange(x, y, z, this);
			int i1 = side & 7;

			if (i1 == 1) {
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			} else if (i1 == 2) {
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			} else if (i1 == 3) {
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			} else if (i1 == 4) {
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			} else if (i1 != 5 && i1 != 6) {
				if (i1 == 0 || i1 == 7) {
					world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				}
			} else {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			}
		}

		super.breakBlock(world, x, y, z, block, side);
	}

	public int isProvidingWeakPower(IBlockAccess world, int p_149709_2_, int p_149709_3_, int p_149709_4_,
			int p_149709_5_) {
		return (world.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_) & 8) > 0 ? 15 : 0;
	}

	public int isProvidingStrongPower(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_,
			int p_149748_5_) {
		int i1 = p_149748_1_.getBlockMetadata(p_149748_2_, p_149748_3_, p_149748_4_);

		if ((i1 & 8) == 0) {
			return 0;
		} else {
			int j1 = i1 & 7;
			return j1 == 0 && p_149748_5_ == 0 ? 15
					: (j1 == 7 && p_149748_5_ == 0 ? 15
							: (j1 == 6 && p_149748_5_ == 1 ? 15
									: (j1 == 5 && p_149748_5_ == 1 ? 15
											: (j1 == 4 && p_149748_5_ == 2 ? 15
													: (j1 == 3 && p_149748_5_ == 3 ? 15
															: (j1 == 2 && p_149748_5_ == 4 ? 15
																	: (j1 == 1 && p_149748_5_ == 5 ? 15 : 0)))))));
		}
	}

	public boolean canProvidePower() {
		return true;
	}
}
