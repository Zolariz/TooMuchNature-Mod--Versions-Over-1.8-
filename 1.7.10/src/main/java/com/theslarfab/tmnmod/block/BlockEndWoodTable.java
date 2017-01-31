package com.theslarfab.tmnmod.block;

import java.util.List;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.client.renderer.block.BlockRenderingIDs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEndWoodTable extends Block {

	public static final String[] tablePlanks = new String[] { "end_oak", "dark_end_oak", "light_end_oak" };

	@SideOnly(Side.CLIENT)
	private IIcon[] icon;

	public BlockEndWoodTable(Material material) {
		super(material);
		this.setHardness(2.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(TooMuchNatventure.tabTMNBlocks);
		this.setStepSound(soundTypeWood);
	}

	public int getRenderType() {
		return BlockRenderingIDs.tsfTableRenderID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.icon[meta % this.tablePlanks.length];
	}

	public int damageDropped(int damageDrop) {
		return damageDrop;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.icon = new IIcon[tablePlanks.length];

		for (int i = 0; i < this.icon.length; ++i) {
			this.icon[i] = iconRegister.registerIcon(this.getTextureName() + "_" + tablePlanks[i]);
		}
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack itemstack)
    {
        super.onBlockPlacedBy(world, x, y, z, livingBase, itemstack);
    }
}
