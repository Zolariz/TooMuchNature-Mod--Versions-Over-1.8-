package com.slarmods.tmnmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockEndStoneBrick extends Block {
	public static final String[] brickTextures = new String[] { "default", "mossy", "cracked", "chiseled" };
	public static final String[] stonebrick = new String[] { null, "mossy", "cracked", "carved" };
	@SideOnly(Side.CLIENT)
	private IIcon[] endStoneBrickIcon;

	public BlockEndStoneBrick() {
		super(Material.rock);
		this.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta < 0 || meta >= stonebrick.length) {
			meta = 0;
		}

		return this.endStoneBrickIcon[meta];
	}

	public int damageDropped(int damageDrop) {
		return damageDrop;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < 4; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.endStoneBrickIcon = new IIcon[stonebrick.length];

		for (int i = 0; i < this.endStoneBrickIcon.length; ++i) {
			String s = this.getTextureName();

			if (stonebrick[i] != null) {
				s = s + "_" + stonebrick[i];
			}

			this.endStoneBrickIcon[i] = iconRegister.registerIcon(s);
		}
	}
}
