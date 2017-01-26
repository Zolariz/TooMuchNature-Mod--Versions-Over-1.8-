package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

public class BlockEnderTallGrass extends BlockEnderBush implements IGrowable, IShearable {

	private static final String[] tallgrass = new String[] { (TooMuchNature.modid + ":" + "ender_deadbush"),
			(TooMuchNature.modid + ":" + "ender_tallgrass"), (TooMuchNature.modid + ":" + "ender_fern") };
	@SideOnly(Side.CLIENT)
	private IIcon[] tallgrassIcon;

	public BlockEnderTallGrass() {
		super(Material.vine);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta >= this.tallgrassIcon.length) {
			meta = 0;
		}

		return this.tallgrassIcon[meta];
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return super.canBlockStay(world, x, y, z);
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return null;
	}

	public int quantityDroppedWithBonus(int fortune, Random random) {
		return 1 + random.nextInt(fortune * 2 + 1);
	}

	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int side) {
		{
			super.harvestBlock(world, player, x, y, z, side);
		}
	}

	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		for (int i = 1; i < 3; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.tallgrassIcon = new IIcon[tallgrass.length];

		for (int i = 0; i < this.tallgrassIcon.length; ++i) {
			this.tallgrassIcon[i] = iconRegister.registerIcon(tallgrass[i]);
		}
	}

	public boolean func_149851_a(World world, int x, int y, int z, boolean par5) {
		int l = world.getBlockMetadata(x, y, z);
		return l != 0;
	}

	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		return true;
	}

	public void func_149853_b(World world, Random random, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		byte b0 = 2;

		if (l == 2) {
			b0 = 3;
		}

		if (Blocks.double_plant.canPlaceBlockAt(world, x, y, z)) {
			Blocks.double_plant.func_149889_c(world, x, y, z, b0, 2);
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (world.rand.nextInt(8) != 0)
			return ret;
		ItemStack seed = ForgeHooks.getGrassSeed(world);
		if (seed != null)
			ret.add(seed);
		return ret;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
		return ret;
	}
}