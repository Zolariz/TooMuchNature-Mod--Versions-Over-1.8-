package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.tileentity.TileEntityEndWoodChest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockEndWoodChest extends BlockContainer {
	private final Random field_149955_b = new Random();
	public final int field_149956_a;

	public BlockEndWoodChest(int p_i45397_1_) {
		super(Material.wood);
		this.field_149956_a = p_i45397_1_;
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 1945;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_,
			int p_149719_4_) {
		if (p_149719_1_.getBlock(p_149719_2_, p_149719_3_, p_149719_4_ - 1) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
		} else if (p_149719_1_.getBlock(p_149719_2_, p_149719_3_, p_149719_4_ + 1) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
		} else if (p_149719_1_.getBlock(p_149719_2_ - 1, p_149719_3_, p_149719_4_) == this) {
			this.setBlockBounds(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		} else if (p_149719_1_.getBlock(p_149719_2_ + 1, p_149719_3_, p_149719_4_) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
		} else {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		}
	}

	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
		super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
		this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
		Block block = p_149726_1_.getBlock(p_149726_2_, p_149726_3_, p_149726_4_ - 1);
		Block block1 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_, p_149726_4_ + 1);
		Block block2 = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_, p_149726_4_);
		Block block3 = p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_, p_149726_4_);

		if (block == this) {
			this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ - 1);
		}

		if (block1 == this) {
			this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ + 1);
		}

		if (block2 == this) {
			this.func_149954_e(p_149726_1_, p_149726_2_ - 1, p_149726_3_, p_149726_4_);
		}

		if (block3 == this) {
			this.func_149954_e(p_149726_1_, p_149726_2_ + 1, p_149726_3_, p_149726_4_);
		}
	}

	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_,
			EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
		Block block = p_149689_1_.getBlock(p_149689_2_, p_149689_3_, p_149689_4_ - 1);
		Block block1 = p_149689_1_.getBlock(p_149689_2_, p_149689_3_, p_149689_4_ + 1);
		Block block2 = p_149689_1_.getBlock(p_149689_2_ - 1, p_149689_3_, p_149689_4_);
		Block block3 = p_149689_1_.getBlock(p_149689_2_ + 1, p_149689_3_, p_149689_4_);
		byte b0 = 0;
		int l = MathHelper.floor_double((double) (p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			b0 = 2;
		}

		if (l == 1) {
			b0 = 5;
		}

		if (l == 2) {
			b0 = 3;
		}

		if (l == 3) {
			b0 = 4;
		}

		if (block != this && block1 != this && block2 != this && block3 != this) {
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, b0, 3);
		} else {
			if ((block == this || block1 == this) && (b0 == 4 || b0 == 5)) {
				if (block == this) {
					p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_ - 1, b0, 3);
				} else {
					p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_ + 1, b0, 3);
				}

				p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, b0, 3);
			}

			if ((block2 == this || block3 == this) && (b0 == 2 || b0 == 3)) {
				if (block2 == this) {
					p_149689_1_.setBlockMetadataWithNotify(p_149689_2_ - 1, p_149689_3_, p_149689_4_, b0, 3);
				} else {
					p_149689_1_.setBlockMetadataWithNotify(p_149689_2_ + 1, p_149689_3_, p_149689_4_, b0, 3);
				}

				p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, b0, 3);
			}
		}

		if (p_149689_6_.hasDisplayName()) {
			((TileEntityEndWoodChest) p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_))
					.func_145976_a(p_149689_6_.getDisplayName());
		}
	}

	public void func_149954_e(World p_149954_1_, int p_149954_2_, int p_149954_3_, int p_149954_4_) {
		if (!p_149954_1_.isRemote) {
			Block block = p_149954_1_.getBlock(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
			Block block1 = p_149954_1_.getBlock(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
			Block block2 = p_149954_1_.getBlock(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
			Block block3 = p_149954_1_.getBlock(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
			boolean flag = true;
			int l;
			Block block4;
			int i1;
			Block block5;
			boolean flag1;
			byte b0;
			int j1;

			if (block != this && block1 != this) {
				if (block2 != this && block3 != this) {
					b0 = 3;

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
				} else {
					l = block2 == this ? p_149954_2_ - 1 : p_149954_2_ + 1;
					block4 = p_149954_1_.getBlock(l, p_149954_3_, p_149954_4_ - 1);
					i1 = block2 == this ? p_149954_2_ - 1 : p_149954_2_ + 1;
					block5 = p_149954_1_.getBlock(i1, p_149954_3_, p_149954_4_ + 1);
					b0 = 3;
					flag1 = true;

					if (block2 == this) {
						j1 = p_149954_1_.getBlockMetadata(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
					} else {
						j1 = p_149954_1_.getBlockMetadata(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
					}

					if (j1 == 2) {
						b0 = 2;
					}

					if ((block.func_149730_j() || block4.func_149730_j()) && !block1.func_149730_j()
							&& !block5.func_149730_j()) {
						b0 = 3;
					}

					if ((block1.func_149730_j() || block5.func_149730_j()) && !block.func_149730_j()
							&& !block4.func_149730_j()) {
						b0 = 2;
					}
				}
			} else {
				l = block == this ? p_149954_4_ - 1 : p_149954_4_ + 1;
				block4 = p_149954_1_.getBlock(p_149954_2_ - 1, p_149954_3_, l);
				i1 = block == this ? p_149954_4_ - 1 : p_149954_4_ + 1;
				block5 = p_149954_1_.getBlock(p_149954_2_ + 1, p_149954_3_, i1);
				b0 = 5;
				flag1 = true;

				if (block == this) {
					j1 = p_149954_1_.getBlockMetadata(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
				} else {
					j1 = p_149954_1_.getBlockMetadata(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
				}

				if (j1 == 4) {
					b0 = 4;
				}

				if ((block2.func_149730_j() || block4.func_149730_j()) && !block3.func_149730_j()
						&& !block5.func_149730_j()) {
					b0 = 5;
				}

				if ((block3.func_149730_j() || block5.func_149730_j()) && !block2.func_149730_j()
						&& !block4.func_149730_j()) {
					b0 = 4;
				}
			}

			p_149954_1_.setBlockMetadataWithNotify(p_149954_2_, p_149954_3_, p_149954_4_, b0, 3);
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
		int l = 0;

		if (p_149742_1_.getBlock(p_149742_2_ - 1, p_149742_3_, p_149742_4_) == this) {
			++l;
		}

		if (p_149742_1_.getBlock(p_149742_2_ + 1, p_149742_3_, p_149742_4_) == this) {
			++l;
		}

		if (p_149742_1_.getBlock(p_149742_2_, p_149742_3_, p_149742_4_ - 1) == this) {
			++l;
		}

		if (p_149742_1_.getBlock(p_149742_2_, p_149742_3_, p_149742_4_ + 1) == this) {
			++l;
		}

		return l > 1 ? false
				: (this.func_149952_n(p_149742_1_, p_149742_2_ - 1, p_149742_3_, p_149742_4_) ? false
						: (this.func_149952_n(p_149742_1_, p_149742_2_ + 1, p_149742_3_, p_149742_4_) ? false
								: (this.func_149952_n(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_ - 1) ? false
										: !this.func_149952_n(p_149742_1_, p_149742_2_, p_149742_3_,
												p_149742_4_ + 1))));
	}

	private boolean func_149952_n(World p_149952_1_, int p_149952_2_, int p_149952_3_, int p_149952_4_) {
		return p_149952_1_.getBlock(p_149952_2_, p_149952_3_, p_149952_4_) != this ? false
				: (p_149952_1_.getBlock(p_149952_2_ - 1, p_149952_3_, p_149952_4_) == this ? true
						: (p_149952_1_.getBlock(p_149952_2_ + 1, p_149952_3_, p_149952_4_) == this ? true
								: (p_149952_1_.getBlock(p_149952_2_, p_149952_3_, p_149952_4_ - 1) == this ? true
										: p_149952_1_.getBlock(p_149952_2_, p_149952_3_, p_149952_4_ + 1) == this)));
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_,
			Block p_149695_5_) {
		super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
		TileEntityEndWoodChest TileEntityEndWoodChest = (TileEntityEndWoodChest) p_149695_1_.getTileEntity(p_149695_2_, p_149695_3_,
				p_149695_4_);

		if (TileEntityEndWoodChest != null) {
			TileEntityEndWoodChest.updateContainingBlockInfo();
		}
	}

	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_,
			int p_149749_6_) {
		TileEntityEndWoodChest TileEntityEndWoodChest = (TileEntityEndWoodChest) p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_,
				p_149749_4_);

		if (TileEntityEndWoodChest != null) {
			for (int i1 = 0; i1 < TileEntityEndWoodChest.getSizeInventory(); ++i1) {
				ItemStack itemstack = TileEntityEndWoodChest.getStackInSlot(i1);

				if (itemstack != null) {
					float f = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
					float f1 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.field_149955_b.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; p_149749_1_
							.spawnEntityInWorld(entityitem)) {
						int j1 = this.field_149955_b.nextInt(21) + 10;

						if (j1 > itemstack.stackSize) {
							j1 = itemstack.stackSize;
						}

						itemstack.stackSize -= j1;
						entityitem = new EntityItem(p_149749_1_, (double) ((float) p_149749_2_ + f),
								(double) ((float) p_149749_3_ + f1), (double) ((float) p_149749_4_ + f2),
								new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.field_149955_b.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.field_149955_b.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.field_149955_b.nextGaussian() * f3);

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem()
									.setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}

			p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
		}

		super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (p_149727_1_.isRemote) {
			return true;
		} else {
			IInventory iinventory = this.func_149951_m(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);

			if (iinventory != null) {
				p_149727_5_.displayGUIChest(iinventory);
			}

			return true;
		}
	}

	public IInventory func_149951_m(World world, int x, int y, int z) {
		Object object = (TileEntityEndWoodChest) world.getTileEntity(x, y, z);

		if (object == null) {
			return null;
		} else if (world.isSideSolid(x, y + 1, z, DOWN)) {
			return null;
		} else if (func_149953_o(world, x, y, z)) {
			return null;
		} else if (world.getBlock(x - 1, y, z) == this
				&& (world.isSideSolid(x - 1, y + 1, z, DOWN)
						|| func_149953_o(world, x - 1, y, z))) {
			return null;
		} else if (world.getBlock(x + 1, y, z) == this
				&& (world.isSideSolid(x + 1, y + 1, z, DOWN)
						|| func_149953_o(world, x + 1, y, z))) {
			return null;
		} else if (world.getBlock(x, y, z - 1) == this
				&& (world.isSideSolid(x, y + 1, z - 1, DOWN)
						|| func_149953_o(world, x, y, z - 1))) {
			return null;
		} else if (world.getBlock(x, y, z + 1) == this
				&& (world.isSideSolid(x, y + 1, z + 1, DOWN)
						|| func_149953_o(world, x, y, z + 1))) {
			return null;
		} else {
			if (world.getBlock(x - 1, y, z) == this) {
				object = new InventoryLargeChest("container.end_wood_chest_double",
						(TileEntityEndWoodChest) world.getTileEntity(x - 1, y, z),
						(IInventory) object);
			}

			if (world.getBlock(x + 1, y, z) == this) {
				object = new InventoryLargeChest("container.end_wood_chest_double", (IInventory) object,
						(TileEntityEndWoodChest) world.getTileEntity(x + 1, y, z));
			}

			if (world.getBlock(x, y, z - 1) == this) {
				object = new InventoryLargeChest("container.end_wood_chest_double",
						(TileEntityEndWoodChest) world.getTileEntity(x, y, z - 1),
						(IInventory) object);
			}

			if (world.getBlock(x, y, z + 1) == this) {
				object = new InventoryLargeChest("container.end_wood_chest_double", (IInventory) object,
						(TileEntityEndWoodChest) world.getTileEntity(x, y, z + 1));
			}

			return (IInventory) object;
		}
	}

	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		TileEntityEndWoodChest TileEntityEndWoodChest = new TileEntityEndWoodChest();
		return TileEntityEndWoodChest;
	}

	public boolean canProvidePower() {
		return this.field_149956_a == 1;
	}

	public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_,
			int p_149709_5_) {
		if (!this.canProvidePower()) {
			return 0;
		} else {
			int i1 = ((TileEntityEndWoodChest) p_149709_1_.getTileEntity(p_149709_2_, p_149709_3_,
					p_149709_4_)).numPlayersUsing;
			return MathHelper.clamp_int(i1, 0, 15);
		}
	}

	public int isProvidingStrongPower(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_,
			int p_149748_5_) {
		return p_149748_5_ == 1
				? this.isProvidingWeakPower(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_) : 0;
	}

	private static boolean func_149953_o(World p_149953_0_, int p_149953_1_, int p_149953_2_, int p_149953_3_) {
		Iterator iterator = p_149953_0_.getEntitiesWithinAABB(EntityOcelot.class,
				AxisAlignedBB.getBoundingBox((double) p_149953_1_, (double) (p_149953_2_ + 1), (double) p_149953_3_,
						(double) (p_149953_1_ + 1), (double) (p_149953_2_ + 2), (double) (p_149953_3_ + 1)))
				.iterator();
		EntityOcelot entityocelot;

		do {
			if (!iterator.hasNext()) {
				return false;
			}

			Entity entity = (Entity) iterator.next();
			entityocelot = (EntityOcelot) entity;
		} while (!entityocelot.isSitting());

		return true;
	}

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_,
			int p_149736_5_) {
		return Container
				.calcRedstoneFromInventory(this.func_149951_m(p_149736_1_, p_149736_2_, p_149736_3_, p_149736_4_));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("planks_end_oak");
	}
}
