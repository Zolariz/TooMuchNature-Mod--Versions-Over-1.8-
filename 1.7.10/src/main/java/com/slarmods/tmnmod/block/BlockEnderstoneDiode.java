package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockEnderstoneDiode extends BlockDirectional {

	protected final boolean isRepeaterPowered;

	protected BlockEnderstoneDiode(boolean isPowered) {
		super(Material.circuits);
		this.isRepeaterPowered = isPowered;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) ? false : super.canPlaceBlockAt(world, x, y, z);
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) ? false : super.canBlockStay(world, x, y, z);
	}

	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

		if (!this.func_149910_g(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, l)) {
			boolean flag = this.isGettingInput(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, l);

			if (this.isRepeaterPowered && !flag) {
				p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, this.getBlockUnpowered(), l, 2);
			} else if (!this.isRepeaterPowered) {
				p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, this.getBlockPowered(), l, 2);

				if (!flag) {
					p_149674_1_.scheduleBlockUpdateWithPriority(p_149674_2_, p_149674_3_, p_149674_4_,
							this.getBlockPowered(), this.func_149899_k(l), -1);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 0
				? (this.isRepeaterPowered ? Blocks.redstone_torch.getBlockTextureFromSide(side)
						: Blocks.unlit_redstone_torch.getBlockTextureFromSide(side))
				: (side == 1 ? this.blockIcon : TooMuchNature.end_stone_double_slab.getBlockTextureFromSide(1));
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		return side != 0 && side != 1;
	}

	public int getRenderType() {
		return 1942;
	}

	protected boolean func_149905_c(int powered) {
		return this.isRepeaterPowered;
	}

	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side) {
		return this.isProvidingWeakPower(world, x, y, z, side);
	}

	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
		int i1 = world.getBlockMetadata(x, y, z);

		if (!this.func_149905_c(i1)) {
			return 0;
		} else {
			int j1 = getDirection(i1);
			return j1 == 0 && side == 3 ? this.func_149904_f(world, x, y, z, i1)
					: (j1 == 1 && side == 4 ? this.func_149904_f(world, x, y, z, i1)
							: (j1 == 2 && side == 2 ? this.func_149904_f(world, x, y, z, i1)
									: (j1 == 3 && side == 5 ? this.func_149904_f(world, x, y, z, i1) : 0)));
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		} else {
			this.func_149897_b(world, x, y, z, block);
		}
	}

	protected void func_149897_b(World p_149897_1_, int p_149897_2_, int p_149897_3_, int p_149897_4_,
			Block p_149897_5_) {
		int l = p_149897_1_.getBlockMetadata(p_149897_2_, p_149897_3_, p_149897_4_);

		if (!this.func_149910_g(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, l)) {
			boolean flag = this.isGettingInput(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, l);

			if ((this.isRepeaterPowered && !flag || !this.isRepeaterPowered && flag)
					&& !p_149897_1_.isBlockTickScheduledThisTick(p_149897_2_, p_149897_3_, p_149897_4_, this)) {
				byte b0 = -1;

				if (this.func_149912_i(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, l)) {
					b0 = -3;
				} else if (this.isRepeaterPowered) {
					b0 = -2;
				}

				p_149897_1_.scheduleBlockUpdateWithPriority(p_149897_2_, p_149897_3_, p_149897_4_, this,
						this.func_149901_b(l), b0);
			}
		}
	}

	public boolean func_149910_g(IBlockAccess p_149910_1_, int p_149910_2_, int p_149910_3_, int p_149910_4_,
			int p_149910_5_) {
		return false;
	}

	protected boolean isGettingInput(World p_149900_1_, int p_149900_2_, int p_149900_3_, int p_149900_4_,
			int p_149900_5_) {
		return this.getInputStrength(p_149900_1_, p_149900_2_, p_149900_3_, p_149900_4_, p_149900_5_) > 0;
	}

	/**
	 * Returns the signal strength at one input of the block. Args: world, X, Y,
	 * Z, side
	 */
	protected int getInputStrength(World p_149903_1_, int p_149903_2_, int p_149903_3_, int p_149903_4_,
			int p_149903_5_) {
		int i1 = getDirection(p_149903_5_);
		int j1 = p_149903_2_ + Direction.offsetX[i1];
		int k1 = p_149903_4_ + Direction.offsetZ[i1];
		int l1 = p_149903_1_.getIndirectPowerLevelTo(j1, p_149903_3_, k1, Direction.directionToFacing[i1]);
		return l1 >= 15 ? l1
				: Math.max(l1, p_149903_1_.getBlock(j1, p_149903_3_, k1) == TooMuchNature.enderstone_wire
						? p_149903_1_.getBlockMetadata(j1, p_149903_3_, k1) : 0);
	}

	protected int func_149902_h(IBlockAccess p_149902_1_, int p_149902_2_, int p_149902_3_, int p_149902_4_,
			int p_149902_5_) {
		int i1 = getDirection(p_149902_5_);

		switch (i1) {
		case 0:
		case 2:
			return Math.max(this.func_149913_i(p_149902_1_, p_149902_2_ - 1, p_149902_3_, p_149902_4_, 4),
					this.func_149913_i(p_149902_1_, p_149902_2_ + 1, p_149902_3_, p_149902_4_, 5));
		case 1:
		case 3:
			return Math.max(this.func_149913_i(p_149902_1_, p_149902_2_, p_149902_3_, p_149902_4_ + 1, 3),
					this.func_149913_i(p_149902_1_, p_149902_2_, p_149902_3_, p_149902_4_ - 1, 2));
		default:
			return 0;
		}
	}

	protected int func_149913_i(IBlockAccess p_149913_1_, int p_149913_2_, int p_149913_3_, int p_149913_4_,
			int p_149913_5_) {
		Block block = p_149913_1_.getBlock(p_149913_2_, p_149913_3_, p_149913_4_);
		return this.func_149908_a(block) ? (block == TooMuchNature.enderstone_wire
				? p_149913_1_.getBlockMetadata(p_149913_2_, p_149913_3_, p_149913_4_)
				: p_149913_1_.isBlockProvidingPowerTo(p_149913_2_, p_149913_3_, p_149913_4_, p_149913_5_)) : 0;
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this
	 * change based on its state.
	 */
	public boolean canProvidePower() {
		return true;
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_,
			EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
		int l = ((MathHelper.floor_double((double) (p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
		p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, l, 3);
		boolean flag = this.isGettingInput(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, l);

		if (flag) {
			p_149689_1_.scheduleBlockUpdate(p_149689_2_, p_149689_3_, p_149689_4_, this, 1);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
		this.func_149911_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
	}

	protected void func_149911_e(World p_149911_1_, int p_149911_2_, int p_149911_3_, int p_149911_4_) {
		int l = getDirection(p_149911_1_.getBlockMetadata(p_149911_2_, p_149911_3_, p_149911_4_));

		if (l == 1) {
			p_149911_1_.notifyBlockOfNeighborChange(p_149911_2_ + 1, p_149911_3_, p_149911_4_, this);
			p_149911_1_.notifyBlocksOfNeighborChange(p_149911_2_ + 1, p_149911_3_, p_149911_4_, this, 4);
		}

		if (l == 3) {
			p_149911_1_.notifyBlockOfNeighborChange(p_149911_2_ - 1, p_149911_3_, p_149911_4_, this);
			p_149911_1_.notifyBlocksOfNeighborChange(p_149911_2_ - 1, p_149911_3_, p_149911_4_, this, 5);
		}

		if (l == 2) {
			p_149911_1_.notifyBlockOfNeighborChange(p_149911_2_, p_149911_3_, p_149911_4_ + 1, this);
			p_149911_1_.notifyBlocksOfNeighborChange(p_149911_2_, p_149911_3_, p_149911_4_ + 1, this, 2);
		}

		if (l == 0) {
			p_149911_1_.notifyBlockOfNeighborChange(p_149911_2_, p_149911_3_, p_149911_4_ - 1, this);
			p_149911_1_.notifyBlocksOfNeighborChange(p_149911_2_, p_149911_3_, p_149911_4_ - 1, this, 3);
		}
	}

	/**
	 * Called right before the block is destroyed by a player. Args: world, x,
	 * y, z, metaData
	 */
	public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_,
			int p_149664_5_) {
		if (this.isRepeaterPowered) {
			p_149664_1_.notifyBlocksOfNeighborChange(p_149664_2_ + 1, p_149664_3_, p_149664_4_, this);
			p_149664_1_.notifyBlocksOfNeighborChange(p_149664_2_ - 1, p_149664_3_, p_149664_4_, this);
			p_149664_1_.notifyBlocksOfNeighborChange(p_149664_2_, p_149664_3_, p_149664_4_ + 1, this);
			p_149664_1_.notifyBlocksOfNeighborChange(p_149664_2_, p_149664_3_, p_149664_4_ - 1, this);
			p_149664_1_.notifyBlocksOfNeighborChange(p_149664_2_, p_149664_3_ - 1, p_149664_4_, this);
			p_149664_1_.notifyBlocksOfNeighborChange(p_149664_2_, p_149664_3_ + 1, p_149664_4_, this);
		}

		super.onBlockDestroyedByPlayer(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	protected boolean func_149908_a(Block p_149908_1_) {
		return p_149908_1_.canProvidePower();
	}

	protected int func_149904_f(IBlockAccess p_149904_1_, int p_149904_2_, int p_149904_3_, int p_149904_4_,
			int p_149904_5_) {
		return 15;
	}

	public static boolean isRedstoneRepeaterBlockID(Block block) {
		return ((BlockEnderstoneDiode) TooMuchNature.enderstone_repeater_unpowered).func_149907_e(block)
				|| Blocks.unpowered_comparator.func_149907_e(block);
	}

	public boolean func_149907_e(Block block) {
		return block == this.getBlockPowered() || block == this.getBlockUnpowered();
	}

	public boolean func_149912_i(World p_149912_1_, int p_149912_2_, int p_149912_3_, int p_149912_4_,
			int p_149912_5_) {
		int i1 = getDirection(p_149912_5_);

		if (isRedstoneRepeaterBlockID(p_149912_1_.getBlock(p_149912_2_ - Direction.offsetX[i1], p_149912_3_,
				p_149912_4_ - Direction.offsetZ[i1]))) {
			int j1 = p_149912_1_.getBlockMetadata(p_149912_2_ - Direction.offsetX[i1], p_149912_3_,
					p_149912_4_ - Direction.offsetZ[i1]);
			int k1 = getDirection(j1);
			return k1 != i1;
		} else {
			return false;
		}
	}

	protected int func_149899_k(int p_149899_1_) {
		return this.func_149901_b(p_149899_1_);
	}

	protected abstract int func_149901_b(int p_149901_1_);

	protected abstract BlockEnderstoneDiode getBlockPowered();

	protected abstract BlockEnderstoneDiode getBlockUnpowered();

	public boolean isAssociatedBlock(Block block) {
		return this.func_149907_e(block);
	}
}
