package com.theslarfab.tmnmod.item;

import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEnderTallgrass extends ItemBlock {

	public static final String[] tallgrass = new String[] { "dead_shrub", "tallgrass", "fern" };

	public ItemBlockEnderTallgrass(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= tallgrass.length) {
			i = 0;
		}

		return super.getUnlocalizedName() + "." + tallgrass[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}
}
