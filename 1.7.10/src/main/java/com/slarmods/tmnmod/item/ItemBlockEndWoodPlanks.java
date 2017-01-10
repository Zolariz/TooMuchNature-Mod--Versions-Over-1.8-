package com.slarmods.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEndWoodPlanks extends ItemBlock {

	final static String[] planks = new String[] { "end_oak", "dark_end_oak" };

	public ItemBlockEndWoodPlanks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= planks.length) {
			i = 0;
		}

		return super.getUnlocalizedName() + "." + planks[i];
	}

	public int getMetadata(int metadata) {
		return metadata;
	}
}
