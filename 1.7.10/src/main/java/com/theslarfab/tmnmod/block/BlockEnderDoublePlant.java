package com.theslarfab.tmnmod.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.client.renderer.BlockRenderingIDs;
import com.theslarfab.tmnmod.init.TMNBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockEnderDoublePlant extends BlockEnderBush implements IGrowable, IShearable {

	public static final String[] doubleTallgrassTexture = new String[] { TooMuchNature.modid + ":" + "ender_sunflower",
			TooMuchNature.modid + ":" + "ender_grass", TooMuchNature.modid + ":" + "ender_fern" };
	@SideOnly(Side.CLIENT)
	private IIcon[] doublePlantBottomIcons;
	@SideOnly(Side.CLIENT)
	private IIcon[] doublePlantTopIcons;
	@SideOnly(Side.CLIENT)
	public IIcon[] sunflowerIcons;

	public BlockEnderDoublePlant() {
		super(Material.plants);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
	}

	public int getRenderType() {
		return BlockRenderingIDs.doubleEnderPlantRenderID;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public int func_149885_e(IBlockAccess world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		return !func_149887_c(l) ? l & 7 : world.getBlockMetadata(x, y - 1, z) & 7;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && world.isAirBlock(x, y + 1, z);
	}

	protected void checkAndDropBlock(World world, int x, int y, int z) {
		if (!this.canBlockStay(world, x, y, z)) {
			int l = world.getBlockMetadata(x, y, z);

			if (!func_149887_c(l)) {
				this.dropBlockAsItem(world, x, y, z, l, 0);

				if (world.getBlock(x, y + 1, z) == this) {
					world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
				}
			}

			world.setBlock(x, y, z, Blocks.air, 0, 2);
		}
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z) != this)
			return super.canBlockStay(world, x, y, z);
		int l = world.getBlockMetadata(x, y, z);
		return func_149887_c(l) ? world.getBlock(x, y - 1, z) == this
				: world.getBlock(x, y + 1, z) == this && super.canBlockStay(world, x, y, z);
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		if (func_149887_c(meta)) {
			return null;
		} else {
			int k = func_149890_d(meta);
			return k != 3 && k != 2 ? Item.getItemFromBlock(this) : null;
		}
	}

	public int damageDropped(int damageDrop) {
		return func_149887_c(damageDrop) ? 0 : damageDrop & 7;
	}

	public static boolean func_149887_c(int par1) {
		return (par1 & 8) != 0;
	}

	public static int func_149890_d(int par1) {
		return par1 & 7;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return func_149887_c(meta) ? this.doublePlantBottomIcons[0] : this.doublePlantBottomIcons[meta & 7];
	}

	@SideOnly(Side.CLIENT)
	public IIcon func_149888_a(boolean getDoubleIcon, int meta) {
		return getDoubleIcon ? this.doublePlantTopIcons[meta] : this.doublePlantBottomIcons[meta];
	}

	public void func_149889_c(World world, int x, int y, int z, int meta, int side) {
		world.setBlock(x, y, z, this, meta, side);
		world.setBlock(x, y + 1, z, this, 8, side);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack itemstack) {
		int l = ((MathHelper.floor_double((double) (livingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
		world.setBlock(x, y + 1, z, this, 8 | l, 2);
	}

	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int side) {
		if (world.isRemote || player.getCurrentEquippedItem() == null
				|| player.getCurrentEquippedItem().getItem() != Items.shears || func_149887_c(side)
				|| !this.func_149886_b(world, x, y, z, side, player)) {
			super.harvestBlock(world, player, x, y, z, side);
		}
	}

	public void onBlockHarvested(World world, int x, int y, int z, int side, EntityPlayer player) {
		if (func_149887_c(side)) {
			if (world.getBlock(x, y - 1, z) == this) {
				if (!player.capabilities.isCreativeMode) {
					int i1 = world.getBlockMetadata(x, y - 1, z);
					int j1 = func_149890_d(i1);

					if (j1 != 3 && j1 != 2) {
						world.func_147480_a(x, y - 1, z, true);
					} else {
						if (!world.isRemote && player.getCurrentEquippedItem() != null
								&& player.getCurrentEquippedItem().getItem() == Items.shears) {
							this.func_149886_b(world, x, y, z, i1, player);
						}

						world.setBlockToAir(x, y - 1, z);
					}
				} else {
					world.setBlockToAir(x, y - 1, z);
				}
			}
		} else if (player.capabilities.isCreativeMode && world.getBlock(x, y + 1, z) == this) {
			world.setBlock(x, y + 1, z, Blocks.air, 0, 2);
		}

		super.onBlockHarvested(world, x, y, z, side, player);
	}

	private boolean func_149886_b(World world, int x, int y, int z, int side, EntityPlayer player) {
		int i1 = func_149890_d(side);

		if (i1 != 3 && i1 != 2) {
			return false;
		} else {
			player.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
			byte b0 = 1;

			if (i1 == 3) {
				b0 = 2;
			}

			this.dropBlockAsItem(world, x, y, z, new ItemStack(TMNBlocks.ender_tallgrass, 2, b0));
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.doublePlantBottomIcons = new IIcon[doubleTallgrassTexture.length];
		this.doublePlantTopIcons = new IIcon[doubleTallgrassTexture.length];

		for (int i = 0; i < this.doublePlantBottomIcons.length; ++i) {
			this.doublePlantBottomIcons[i] = iconRegister
					.registerIcon("ender_double_plant_" + doubleTallgrassTexture[i] + "_bottom");
			this.doublePlantTopIcons[i] = iconRegister
					.registerIcon("ender_double_plant_" + doubleTallgrassTexture[i] + "_top");
		}

		this.sunflowerIcons = new IIcon[2];
		this.sunflowerIcons[0] = iconRegister.registerIcon("double_plant_sunflower_front");
		this.sunflowerIcons[1] = iconRegister.registerIcon("double_plant_sunflower_back");
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		for (int i = 0; i < this.doublePlantBottomIcons.length; ++i) {
			p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
		}
	}

	public int getDamageValue(World world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		return func_149887_c(l) ? func_149890_d(world.getBlockMetadata(x, y - 1, z)) : func_149890_d(l);
	}

	public boolean func_149851_a(World world, int x, int y, int z, boolean par5) {
		int l = this.func_149885_e(world, x, y, z);
		return l != 2 && l != 3;
	}

	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		return true;
	}

	public void func_149853_b(World world, Random random, int x, int y, int z) {
		int l = this.func_149885_e(world, x, y, z);
		this.dropBlockAsItem(world, x, y, z, new ItemStack(this, 1, l));
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		int type = func_149890_d(metadata);
		return func_149887_c(metadata) && (type == 3 || type == 4);
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int type = func_149890_d(world.getBlockMetadata(x, y, z));
		if (type == 3 || type == 2)
			ret.add(new ItemStack(TMNBlocks.ender_tallgrass, 2, type == 3 ? 2 : 1));
		return ret;
	}
}
