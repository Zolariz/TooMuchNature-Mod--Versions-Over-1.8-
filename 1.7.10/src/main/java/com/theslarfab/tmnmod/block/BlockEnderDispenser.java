package com.theslarfab.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.client.renderer.block.BlockRenderingIDs;
import com.theslarfab.tmnmod.dispenser.BehaviorEnderDefaultDispenseItem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

public class BlockEnderDispenser extends BlockContainer {
	/** Registry for all dispense behaviors. */
	public static final IRegistry dispenseBehaviorRegistry = new RegistryDefaulted(
			new BehaviorEnderDefaultDispenseItem());
	protected Random field_149942_b = new Random();
	@SideOnly(Side.CLIENT)
	protected IIcon topIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon horizontalIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon verticalIcon;

	public BlockEnderDispenser() {
		super(Material.rock);
		this.setCreativeTab(TooMuchNatventure.tabEnderstone);
	}

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate(World p_149738_1_) {
		return 4;
	}

	/*
	 * public int getRenderType() { return
	 * BlockRenderingIDs.enderDispenserInvRenderID; }
	 */

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
		super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
		this.func_149938_m(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
	}

	private void func_149938_m(World p_149938_1_, int p_149938_2_, int p_149938_3_, int p_149938_4_) {
		if (!p_149938_1_.isRemote) {
			Block block = p_149938_1_.getBlock(p_149938_2_, p_149938_3_, p_149938_4_ - 1);
			Block block1 = p_149938_1_.getBlock(p_149938_2_, p_149938_3_, p_149938_4_ + 1);
			Block block2 = p_149938_1_.getBlock(p_149938_2_ - 1, p_149938_3_, p_149938_4_);
			Block block3 = p_149938_1_.getBlock(p_149938_2_ + 1, p_149938_3_, p_149938_4_);
			byte b0 = 3;

			if (block.func_149730_j() && !block1.func_149730_j()) {
				b0 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j()) {
				b0 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j()) {
				b0 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j()) {
				b0 = 4;
			}

			p_149938_1_.setBlockMetadataWithNotify(p_149938_2_, p_149938_3_, p_149938_4_, b0, 2);
		}
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		int k = p_149691_2_ & 7;
		return p_149691_1_ == k ? (k != 1 && k != 0 ? this.horizontalIcon : this.verticalIcon)
				: (k != 1 && k != 0 ? (p_149691_1_ != 1 && p_149691_1_ != 0 ? this.blockIcon : this.topIcon)
						: this.topIcon);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(TooMuchNatventure.modid + ":" + "end_furnace_side");
		this.topIcon = iconRegister.registerIcon(TooMuchNatventure.modid + ":" + "end_furnace_top");
		this.horizontalIcon = iconRegister.registerIcon(this.getTextureName() + "_front_horizontal");
		this.verticalIcon = iconRegister.registerIcon(this.getTextureName() + "_front_vertical");
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX,
			float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		} else {
			TileEntityDispenser TileEntityDispenser = (TileEntityDispenser) world.getTileEntity(x, y, z);

			if (TileEntityDispenser != null) {
				entityPlayer.func_146102_a(TileEntityDispenser);
			}

			return true;
		}
	}

	protected void func_149941_e(World world, int x, int y, int z) {
		BlockSourceImpl blocksourceimpl = new BlockSourceImpl(world, x, y, z);
		TileEntityDispenser TileEntityDispenser = (TileEntityDispenser) blocksourceimpl.getBlockTileEntity();

		if (TileEntityDispenser != null) {
			int l = TileEntityDispenser.func_146017_i();

			if (l < 0) {
				world.playAuxSFX(1001, x, y, z, 0);
			} else {
				ItemStack itemstack = TileEntityDispenser.getStackInSlot(l);
				IBehaviorDispenseItem ibehaviordispenseitem = this.func_149940_a(itemstack);

				if (ibehaviordispenseitem != IBehaviorDispenseItem.itemDispenseBehaviorProvider) {
					ItemStack itemstack1 = ibehaviordispenseitem.dispense(blocksourceimpl, itemstack);
					TileEntityDispenser.setInventorySlotContents(l, itemstack1.stackSize == 0 ? null : itemstack1);
				}
			}
		}
	}

	protected IBehaviorDispenseItem func_149940_a(ItemStack itemStack) {
		return (IBehaviorDispenseItem) dispenseBehaviorRegistry.getObject(itemStack.getItem());
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		boolean flag = world.isBlockIndirectlyGettingPowered(x, y, z)
				|| world.isBlockIndirectlyGettingPowered(x, y + 1, z);
		int l = world.getBlockMetadata(x, y, z);
		boolean flag1 = (l & 8) != 0;

		if (flag && !flag1) {
			world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		} else if (!flag && flag1) {
			world.setBlockMetadataWithNotify(x, y, z, l & -9, 4);
		}
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		if (!p_149674_1_.isRemote) {
			this.func_149941_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
		}
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityDispenser();
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_,
			EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
		int l = BlockEnderPistonBase.determineOrientation(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_,
				p_149689_5_);
		p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, l, 2);

		if (p_149689_6_.hasDisplayName()) {
			((TileEntityDispenser) p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_))
					.func_146018_a(p_149689_6_.getDisplayName());
		}
	}

	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_,
			int p_149749_6_) {
		TileEntityDispenser TileEntityDispenser = (TileEntityDispenser) p_149749_1_.getTileEntity(p_149749_2_,
				p_149749_3_, p_149749_4_);

		if (TileEntityDispenser != null) {
			for (int i1 = 0; i1 < TileEntityDispenser.getSizeInventory(); ++i1) {
				ItemStack itemstack = TileEntityDispenser.getStackInSlot(i1);

				if (itemstack != null) {
					float f = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
					float f1 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
					float f2 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j1 = this.field_149942_b.nextInt(21) + 10;

						if (j1 > itemstack.stackSize) {
							j1 = itemstack.stackSize;
						}

						itemstack.stackSize -= j1;
						EntityItem entityitem = new EntityItem(p_149749_1_, (double) ((float) p_149749_2_ + f),
								(double) ((float) p_149749_3_ + f1), (double) ((float) p_149749_4_ + f2),
								new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem()
									.setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}

						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.field_149942_b.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.field_149942_b.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.field_149942_b.nextGaussian() * f3);
						p_149749_1_.spawnEntityInWorld(entityitem);
					}
				}
			}

			p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
		}

		super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
	}

	public static IPosition func_149939_a(IBlockSource p_149939_0_) {
		EnumFacing enumfacing = func_149937_b(p_149939_0_.getBlockMetadata());
		double d0 = p_149939_0_.getX() + 0.7D * (double) enumfacing.getFrontOffsetX();
		double d1 = p_149939_0_.getY() + 0.7D * (double) enumfacing.getFrontOffsetY();
		double d2 = p_149939_0_.getZ() + 0.7D * (double) enumfacing.getFrontOffsetZ();
		return new PositionImpl(d0, d1, d2);
	}

	public static EnumFacing func_149937_b(int p_149937_0_) {
		return EnumFacing.getFront(p_149937_0_ & 7);
	}

	/**
	 * If this returns true, then comparators facing away from this block will
	 * use the value from getComparatorInputOverride instead of the actual
	 * redstone signal strength.
	 */
	public boolean hasComparatorInputOverride() {
		return true;
	}

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is
	 * used instead of the redstone signal strength when this block inputs to a
	 * comparator.
	 */
	public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_,
			int p_149736_5_) {
		return Container.calcRedstoneFromInventory(
				(IInventory) p_149736_1_.getTileEntity(p_149736_2_, p_149736_3_, p_149736_4_));
	}
}
