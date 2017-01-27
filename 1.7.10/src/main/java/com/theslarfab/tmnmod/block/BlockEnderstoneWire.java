package com.theslarfab.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.client.renderer.BlockRenderingIDs;
import com.theslarfab.tmnmod.init.TMNBlocks;
import com.theslarfab.tmnmod.init.TMNItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnderstoneWire extends Block {
	private boolean isPowered = true;
	private Set field_150179_b = new HashSet();
	@SideOnly(Side.CLIENT)
	private static IIcon crossIcon;
	@SideOnly(Side.CLIENT)
	private static IIcon lineIcon;
	@SideOnly(Side.CLIENT)
	private static IIcon crossOverlayIcon;
	@SideOnly(Side.CLIENT)
	private static IIcon lineOverlayIcon;

	public BlockEnderstoneWire() {
		super(Material.circuits);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
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
		return BlockRenderingIDs.enderstoneWireRenderID;
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
		return 34152;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
				|| world.getBlock(x, y - 1, z) == Blocks.glowstone;
	}

	private void func_150177_e(World world, int x, int y, int z) {
		this.func_150175_a(world, x, y, z, x, y, z);
		ArrayList arraylist = new ArrayList(this.field_150179_b);
		this.field_150179_b.clear();

		for (int l = 0; l < arraylist.size(); ++l) {
			ChunkPosition chunkposition = (ChunkPosition) arraylist.get(l);
			world.notifyBlocksOfNeighborChange(chunkposition.chunkPosX, chunkposition.chunkPosY,
					chunkposition.chunkPosZ, this);
		}
	}

	private void func_150175_a(World world, int x, int y, int z, int side, int par6, int par7) {
		int k1 = world.getBlockMetadata(x, y, z);
		byte b0 = 0;
		int i3 = this.func_150178_a(world, side, par6, par7, b0);
		this.isPowered = false;
		int l1 = world.getStrongestIndirectPower(x, y, z);
		this.isPowered = true;

		if (l1 > 0 && l1 > i3 - 1) {
			i3 = l1;
		}

		int i2 = 0;

		for (int j2 = 0; j2 < 4; ++j2) {
			int k2 = x;
			int l2 = z;

			if (j2 == 0) {
				k2 = x - 1;
			}

			if (j2 == 1) {
				++k2;
			}

			if (j2 == 2) {
				l2 = z - 1;
			}

			if (j2 == 3) {
				++l2;
			}

			if (k2 != side || l2 != par7) {
				i2 = this.func_150178_a(world, k2, y, l2, i2);
			}

			if (world.getBlock(k2, y, l2).isNormalCube() && !world.getBlock(x, y + 1, z).isNormalCube()) {
				if ((k2 != side || l2 != par7) && y >= par6) {
					i2 = this.func_150178_a(world, k2, y + 1, l2, i2);
				}
			} else if (!world.getBlock(k2, y, l2).isNormalCube() && (k2 != side || l2 != par7) && y <= par6) {
				i2 = this.func_150178_a(world, k2, y - 1, l2, i2);
			}
		}

		if (i2 > i3) {
			i3 = i2 - 1;
		} else if (i3 > 0) {
			--i3;
		} else {
			i3 = 0;
		}

		if (l1 > i3 - 1) {
			i3 = l1;
		}

		if (k1 != i3) {
			world.setBlockMetadataWithNotify(x, y, z, i3, 2);
			this.field_150179_b.add(new ChunkPosition(x, y, z));
			this.field_150179_b.add(new ChunkPosition(x - 1, y, z));
			this.field_150179_b.add(new ChunkPosition(x + 1, y, z));
			this.field_150179_b.add(new ChunkPosition(x, y - 1, z));
			this.field_150179_b.add(new ChunkPosition(x, y + 1, z));
			this.field_150179_b.add(new ChunkPosition(x, y, z - 1));
			this.field_150179_b.add(new ChunkPosition(x, y, z + 1));
		}
	}

	private void func_150172_m(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z) == this) {
			world.notifyBlocksOfNeighborChange(x, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		}
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if (!world.isRemote) {
			this.func_150177_e(world, x, y, z);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			this.func_150172_m(world, x - 1, y, z);
			this.func_150172_m(world, x + 1, y, z);
			this.func_150172_m(world, x, y, z - 1);
			this.func_150172_m(world, x, y, z + 1);

			if (world.getBlock(x - 1, y, z).isNormalCube()) {
				this.func_150172_m(world, x - 1, y + 1, z);
			} else {
				this.func_150172_m(world, x - 1, y - 1, z);
			}

			if (world.getBlock(x + 1, y, z).isNormalCube()) {
				this.func_150172_m(world, x + 1, y + 1, z);
			} else {
				this.func_150172_m(world, x + 1, y - 1, z);
			}

			if (world.getBlock(x, y, z - 1).isNormalCube()) {
				this.func_150172_m(world, x, y + 1, z - 1);
			} else {
				this.func_150172_m(world, x, y - 1, z - 1);
			}

			if (world.getBlock(x, y, z + 1).isNormalCube()) {
				this.func_150172_m(world, x, y + 1, z + 1);
			} else {
				this.func_150172_m(world, x, y - 1, z + 1);
			}
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int side) {
		super.breakBlock(world, x, y, z, block, side);

		if (!world.isRemote) {
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			this.func_150177_e(world, x, y, z);
			this.func_150172_m(world, x - 1, y, z);
			this.func_150172_m(world, x + 1, y, z);
			this.func_150172_m(world, x, y, z - 1);
			this.func_150172_m(world, x, y, z + 1);

			if (world.getBlock(x - 1, y, z).isNormalCube()) {
				this.func_150172_m(world, x - 1, y + 1, z);
			} else {
				this.func_150172_m(world, x - 1, y - 1, z);
			}

			if (world.getBlock(x + 1, y, z).isNormalCube()) {
				this.func_150172_m(world, x + 1, y + 1, z);
			} else {
				this.func_150172_m(world, x + 1, y - 1, z);
			}

			if (world.getBlock(x, y, z - 1).isNormalCube()) {
				this.func_150172_m(world, x, y + 1, z - 1);
			} else {
				this.func_150172_m(world, x, y - 1, z - 1);
			}

			if (world.getBlock(x, y, z + 1).isNormalCube()) {
				this.func_150172_m(world, x, y + 1, z + 1);
			} else {
				this.func_150172_m(world, x, y - 1, z + 1);
			}
		}
	}

	private int func_150178_a(World world, int x, int y, int z, int side) {
		if (world.getBlock(x, y, z) != this) {
			return side;
		} else {
			int i1 = world.getBlockMetadata(x, y, z);
			return i1 > side ? i1 : side;
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (!world.isRemote) {
			boolean flag = this.canPlaceBlockAt(world, x, y, z);

			if (flag) {
				this.func_150177_e(world, x, y, z);
			} else {
				this.dropBlockAsItem(world, x, y, z, 0, 0);
				world.setBlockToAir(x, y, z);
			}

			super.onNeighborBlockChange(world, x, y, z, block);
		}
	}

	public Item getItemDropped(int metadata, Random random, int fortune) {
		return TMNItems.enderstone_dust;
	}

	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side) {
		return !this.isPowered ? 0 : this.isProvidingWeakPower(world, x, y, z, side);
	}

	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
		if (!this.isPowered) {
			return 0;
		} else {
			int i1 = world.getBlockMetadata(x, y, z);

			if (i1 == 0) {
				return 0;
			} else if (side == 1) {
				return i1;
			} else {
				boolean flag = func_150176_g(world, x - 1, y, z, 1)
						|| !world.getBlock(x - 1, y, z).isNormalCube() && func_150176_g(world, x - 1, y - 1, z, -1);
				boolean flag1 = func_150176_g(world, x + 1, y, z, 3)
						|| !world.getBlock(x + 1, y, z).isNormalCube() && func_150176_g(world, x + 1, y - 1, z, -1);
				boolean flag2 = func_150176_g(world, x, y, z - 1, 2)
						|| !world.getBlock(x, y, z - 1).isNormalCube() && func_150176_g(world, x, y - 1, z - 1, -1);
				boolean flag3 = func_150176_g(world, x, y, z + 1, 0)
						|| !world.getBlock(x, y, z + 1).isNormalCube() && func_150176_g(world, x, y - 1, z + 1, -1);

				if (!world.getBlock(x, y + 1, z).isNormalCube()) {
					if (world.getBlock(x - 1, y, z).isNormalCube() && func_150176_g(world, x - 1, y + 1, z, -1)) {
						flag = true;
					}

					if (world.getBlock(x + 1, y, z).isNormalCube() && func_150176_g(world, x + 1, y + 1, z, -1)) {
						flag1 = true;
					}

					if (world.getBlock(x, y, z - 1).isNormalCube() && func_150176_g(world, x, y + 1, z - 1, -1)) {
						flag2 = true;
					}

					if (world.getBlock(x, y, z + 1).isNormalCube() && func_150176_g(world, x, y + 1, z + 1, -1)) {
						flag3 = true;
					}
				}

				return !flag2 && !flag1 && !flag && !flag3 && side >= 2 && side <= 5 ? i1
						: (side == 2 && flag2 && !flag && !flag1 ? i1
								: (side == 3 && flag3 && !flag && !flag1 ? i1
										: (side == 4 && flag && !flag2 && !flag3 ? i1
												: (side == 5 && flag1 && !flag2 && !flag3 ? i1 : 0))));
			}
		}
	}

	public boolean canProvidePower() {
		return this.isPowered;
	}

	public static boolean isPowerProviderOrWire(IBlockAccess world, int x, int y, int z, int side) {
		Block block = world.getBlock(x, y, z);

		if (block == TMNBlocks.enderstone_wire) {
			return true;
		} else if (!Blocks.unpowered_repeater.func_149907_e(block)) {
			return block.canConnectRedstone(world, x, y, z, side);
		} else {
			int i1 = world.getBlockMetadata(x, y, z);
			return side == (i1 & 3) || side == Direction.rotateOpposite[i1 & 3];
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		int l = world.getBlockMetadata(x, y, z);

		if (l > 0) {
			double d0 = (double) x + 0.5D + ((double) random.nextFloat() - 0.5D) * 0.2D;
			double d1 = (double) ((float) y + 0.0625F);
			double d2 = (double) z + 0.5D + ((double) random.nextFloat() - 0.5D) * 0.2D;
			float f = (float) l / 15.0F;
			float f1 = f * 0.6F + 0.4F;

			if (l == 0) {
				f1 = 0.0F;
			}

			float f2 = f * f * 0.7F - 0.5F;
			float f3 = f * f * 0.6F - 0.7F;

			if (f2 < 0.0F) {
				f2 = 0.0F;
			}

			if (f3 < 0.0F) {
				f3 = 0.0F;
			}

			world.spawnParticle("reddust", d0, d1, d2, (double) f1, (double) f2, (double) f3);
		}
	}

	public static boolean func_150176_g(IBlockAccess world, int x, int y, int z, int side) {
		if (isPowerProviderOrWire(world, x, y, z, side)) {
			return true;
		} else if (world.getBlock(x, y, z) == Blocks.powered_repeater) {
			int i1 = world.getBlockMetadata(x, y, z);
			return side == (i1 & 3);
		} else {
			return false;
		}
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return TMNItems.enderstone_dust;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.crossIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "cross");
		this.lineIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "line");
		this.crossOverlayIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "cross_overlay");
		this.lineOverlayIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "line_overlay");
		this.blockIcon = this.crossIcon;
	}

	@SideOnly(Side.CLIENT)
	public static IIcon getRedstoneWireIcon(String icon) {
		return icon.equals("cross") ? TMNBlocks.enderstone_wire.crossIcon
				: (icon.equals("line") ? TMNBlocks.enderstone_wire.lineIcon
						: (icon.equals("cross_overlay") ? TMNBlocks.enderstone_wire.crossOverlayIcon
								: (icon.equals("line_overlay") ? TMNBlocks.enderstone_wire.lineOverlayIcon : null)));
	}
}
