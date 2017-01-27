package com.theslarfab.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEndStoneBrick extends ItemBlock {

	final static String[] endStonebricks = new String[] { "default", "mossy", "cracked", "carved" };

	public ItemBlockEndStoneBrick(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= endStonebricks.length) {
			i = 0;
		}

		return super.getUnlocalizedName() + "." + endStonebricks[i];
	}

	public int getMetadata(int meta) {
		return meta;
	}
}
