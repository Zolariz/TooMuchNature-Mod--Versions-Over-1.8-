package com.theslarfab.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.tileentity.TileEntityEnderPiston;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnderPistonMoving extends Block {

	public BlockEnderPistonMoving() {
		super(Material.piston);
		this.setHardness(-1.0F);
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return null;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
	}

	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_,
			int p_149749_6_) {
		TileEntity tileentity = p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

		if (tileentity instanceof TileEntityEnderPiston) {
			((TileEntityEnderPiston) tileentity).clearPistonTileEntity();
		} else {
			super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
		}
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return false;
	}

	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		return false;
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7,
			float par8, float par9) {
		if (!world.isRemote && world.getTileEntity(x, y, z) == null) {
			world.setBlockToAir(x, y, z);
			return true;
		} else {
			return false;
		}
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return null;
	}

	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(world, x, y, z, par5, par6, par7);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (!world.isRemote) {
			world.getTileEntity(x, y, z);
		}
	}

	public static TileEntity getTileEntity(Block p_149962_0_, int p_149962_1_, int p_149962_2_, boolean p_149962_3_,
			boolean p_149962_4_) {
		return new TileEntityEnderPiston(p_149962_0_, p_149962_1_, p_149962_2_, p_149962_3_, p_149962_4_);
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_,
			int p_149668_4_) {
		TileEntityEnderPiston TileEntityEnderPiston = this.func_149963_e(p_149668_1_, p_149668_2_, p_149668_3_,
				p_149668_4_);

		if (TileEntityEnderPiston == null) {
			return null;
		} else {
			float f = TileEntityEnderPiston.func_145860_a(0.0F);

			if (TileEntityEnderPiston.isExtending()) {
				f = 1.0F - f;
			}

			return this.func_149964_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_,
					TileEntityEnderPiston.getStoredBlockID(), f, TileEntityEnderPiston.getPistonOrientation());
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		TileEntityEnderPiston TileEntityEnderPiston = this.func_149963_e(world, x, y, z);

		if (TileEntityEnderPiston != null) {
			Block block = TileEntityEnderPiston.getStoredBlockID();

			if (block == this || block.getMaterial() == Material.air) {
				return;
			}

			block.setBlockBoundsBasedOnState(world, x, y, z);
			float f = TileEntityEnderPiston.func_145860_a(0.0F);

			if (TileEntityEnderPiston.isExtending()) {
				f = 1.0F - f;
			}

			int l = TileEntityEnderPiston.getPistonOrientation();
			this.minX = block.getBlockBoundsMinX() - (double) ((float) Facing.offsetsXForSide[l] * f);
			this.minY = block.getBlockBoundsMinY() - (double) ((float) Facing.offsetsYForSide[l] * f);
			this.minZ = block.getBlockBoundsMinZ() - (double) ((float) Facing.offsetsZForSide[l] * f);
			this.maxX = block.getBlockBoundsMaxX() - (double) ((float) Facing.offsetsXForSide[l] * f);
			this.maxY = block.getBlockBoundsMaxY() - (double) ((float) Facing.offsetsYForSide[l] * f);
			this.maxZ = block.getBlockBoundsMaxZ() - (double) ((float) Facing.offsetsZForSide[l] * f);
		}
	}

	public AxisAlignedBB func_149964_a(World world, int x, int y, int z, Block block, float pushed, int side) {
		if (block != this && block.getMaterial() != Material.air) {
			AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(world, x, y, z);

			if (axisalignedbb == null) {
				return null;
			} else {
				if (Facing.offsetsXForSide[side] < 0) {
					axisalignedbb.minX -= (double) ((float) Facing.offsetsXForSide[side] * pushed);
				} else {
					axisalignedbb.maxX -= (double) ((float) Facing.offsetsXForSide[side] * pushed);
				}

				if (Facing.offsetsYForSide[side] < 0) {
					axisalignedbb.minY -= (double) ((float) Facing.offsetsYForSide[side] * pushed);
				} else {
					axisalignedbb.maxY -= (double) ((float) Facing.offsetsYForSide[side] * pushed);
				}

				if (Facing.offsetsZForSide[side] < 0) {
					axisalignedbb.minZ -= (double) ((float) Facing.offsetsZForSide[side] * pushed);
				} else {
					axisalignedbb.maxZ -= (double) ((float) Facing.offsetsZForSide[side] * pushed);
				}

				return axisalignedbb;
			}
		} else {
			return null;
		}
	}

	private TileEntityEnderPiston func_149963_e(IBlockAccess world, int x, int y, int z) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		return tileentity instanceof TileEntityEnderPiston ? (TileEntityEnderPiston) tileentity : null;
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemById(0);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(TooMuchNatventure.modid + ":" + "ender_piston_top_normal");
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		TileEntityEnderPiston te = this.func_149963_e(world, x, y, z);
		if (te != null)
			return te.getStoredBlockID().getDrops(world, x, y, z, te.getBlockMetadata(), 0);
		return new ArrayList<ItemStack>();
	}
}
