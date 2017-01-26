package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.client.renderer.BlockRenderingIDs;
import com.slarmods.tmnmod.init.TMNBlocks;
import com.slarmods.tmnmod.init.TMNItems;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnderstoneComparator extends BlockEnderstoneDiode implements ITileEntityProvider {

	public BlockEnderstoneComparator(boolean isPowerred) {
		super(isPowerred);
		this.isBlockContainer = true;
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return TMNItems.enderstone_comparator;
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return TMNItems.enderstone_comparator;
	}

	protected int func_149901_b(int par1) {
		return 2;
	}

	protected BlockEnderstoneDiode getBlockPowered() {
		return (BlockEnderstoneDiode) TMNBlocks.enderstone_comparator_powered;
	}

	protected BlockEnderstoneDiode getBlockUnpowered() {
		return (BlockEnderstoneDiode) TMNBlocks.enderstone_comparator_unpowered;
	}

	public int getRenderType() {
		return BlockRenderingIDs.enderstoneComparatorRenderID;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		boolean flag = this.isRepeaterPowered || (meta & 8) != 0;
		return side == 0
				? (flag ? TMNBlocks.lit_enderstone_torch.getBlockTextureFromSide(side)
						: TMNBlocks.unlit_enderstone_torch.getBlockTextureFromSide(side))
				: (side == 1 ? (flag ? TMNBlocks.enderstone_comparator_powered.blockIcon : this.blockIcon)
						: TMNBlocks.end_stone_slab.getBlockTextureFromSide(1));
	}

	protected boolean func_149905_c(int getPowered) {
		return this.isRepeaterPowered || (getPowered & 8) != 0;
	}

	protected int func_149904_f(IBlockAccess world, int x, int y, int z, int side) {
		return this.getTileEntityComparator(world, x, y, z).getOutputSignal();
	}

	private int getOutputStrength(World world, int x, int y, int z, int side) {
		return !this.func_149969_d(side) ? this.getInputStrength(world, x, y, z, side)
				: Math.max(this.getInputStrength(world, x, y, z, side) - this.func_149902_h(world, x, y, z, side), 0);
	}

	public static boolean func_149969_d(int p_149969_1_) {
		return (p_149969_1_ & 4) == 4;
	}

	protected boolean isGettingInput(World world, int x, int y, int z, int side) {
		int i1 = this.getInputStrength(world, x, y, z, side);

		if (i1 >= 15) {
			return true;
		} else if (i1 == 0) {
			return false;
		} else {
			int j1 = this.func_149902_h(world, x, y, z, side);
			return j1 == 0 ? true : i1 >= j1;
		}
	}

	protected int getInputStrength(World world, int x, int y, int z, int side) {
		int i1 = super.getInputStrength(world, x, y, z, side);
		int j1 = getDirection(side);
		int k1 = x + Direction.offsetX[j1];
		int l1 = z + Direction.offsetZ[j1];
		Block block = world.getBlock(k1, y, l1);

		if (block.hasComparatorInputOverride()) {
			i1 = block.getComparatorInputOverride(world, k1, y, l1, Direction.rotateOpposite[j1]);
		} else if (i1 < 15 && block.isNormalCube()) {
			k1 += Direction.offsetX[j1];
			l1 += Direction.offsetZ[j1];
			block = world.getBlock(k1, y, l1);

			if (block.hasComparatorInputOverride()) {
				i1 = block.getComparatorInputOverride(world, k1, y, l1, Direction.rotateOpposite[j1]);
			}
		}

		return i1;
	}

	public TileEntityComparator getTileEntityComparator(IBlockAccess world, int x, int y, int z) {
		return (TileEntityComparator) world.getTileEntity(x, y, z);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX,
			float hitY, float hitZ) {
		int i1 = world.getBlockMetadata(x, y, z);
		boolean flag = this.isRepeaterPowered | (i1 & 8) != 0;
		boolean flag1 = !this.func_149969_d(i1);
		int j1 = flag1 ? 4 : 0;
		j1 |= flag ? 8 : 0;
		world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.click", 0.3F,
				flag1 ? 0.55F : 0.5F);
		world.setBlockMetadataWithNotify(x, y, z, j1 | i1 & 3, 2);
		this.func_149972_c(world, x, y, z, world.rand);
		return true;
	}

	protected void func_149897_b(World p_149897_1_, int p_149897_2_, int p_149897_3_, int p_149897_4_,
			Block p_149897_5_) {
		if (!p_149897_1_.isBlockTickScheduledThisTick(p_149897_2_, p_149897_3_, p_149897_4_, this)) {
			int l = p_149897_1_.getBlockMetadata(p_149897_2_, p_149897_3_, p_149897_4_);
			int i1 = this.getOutputStrength(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, l);
			int j1 = this.getTileEntityComparator(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_).getOutputSignal();

			if (i1 != j1 || this.func_149905_c(l) != this.isGettingInput(p_149897_1_, p_149897_2_, p_149897_3_,
					p_149897_4_, l)) {
				if (this.func_149912_i(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, l)) {
					p_149897_1_.scheduleBlockUpdateWithPriority(p_149897_2_, p_149897_3_, p_149897_4_, this,
							this.func_149901_b(0), -1);
				} else {
					p_149897_1_.scheduleBlockUpdateWithPriority(p_149897_2_, p_149897_3_, p_149897_4_, this,
							this.func_149901_b(0), 0);
				}
			}
		}
	}

	private void func_149972_c(World p_149972_1_, int p_149972_2_, int p_149972_3_, int p_149972_4_,
			Random p_149972_5_) {
		int l = p_149972_1_.getBlockMetadata(p_149972_2_, p_149972_3_, p_149972_4_);
		int i1 = this.getOutputStrength(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_, l);
		int j1 = this.getTileEntityComparator(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_).getOutputSignal();
		this.getTileEntityComparator(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_).setOutputSignal(i1);

		if (j1 != i1 || !this.func_149969_d(l)) {
			boolean flag = this.isGettingInput(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_, l);
			boolean flag1 = this.isRepeaterPowered || (l & 8) != 0;

			if (flag1 && !flag) {
				p_149972_1_.setBlockMetadataWithNotify(p_149972_2_, p_149972_3_, p_149972_4_, l & -9, 2);
			} else if (!flag1 && flag) {
				p_149972_1_.setBlockMetadataWithNotify(p_149972_2_, p_149972_3_, p_149972_4_, l | 8, 2);
			}

			this.func_149911_e(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_);
		}
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		if (this.isRepeaterPowered) {
			int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);
			p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, this.getBlockUnpowered(), l | 8, 4);
		}

		this.func_149972_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
		super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
		p_149726_1_.setTileEntity(p_149726_2_, p_149726_3_, p_149726_4_, this.createNewTileEntity(p_149726_1_, 0));
	}

	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_,
			int p_149749_6_) {
		super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
		p_149749_1_.removeTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
		this.func_149911_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
	}

	public boolean onBlockEventReceived(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_,
			int p_149696_5_, int p_149696_6_) {
		super.onBlockEventReceived(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_5_, p_149696_6_);
		TileEntity tileentity = p_149696_1_.getTileEntity(p_149696_2_, p_149696_3_, p_149696_4_);
		return tileentity != null ? tileentity.receiveClientEvent(p_149696_5_, p_149696_6_) : false;
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityComparator();
	}

	@Override
	public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {
		if (y == tileY && world instanceof World) {
			onNeighborBlockChange((World) world, x, y, z, world.getBlock(tileX, tileY, tileZ));
		}
	}

	@Override
	public boolean getWeakChanges(IBlockAccess world, int x, int y, int z) {
		return true;
	}
}
