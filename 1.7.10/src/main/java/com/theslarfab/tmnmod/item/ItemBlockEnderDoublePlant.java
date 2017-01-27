package com.theslarfab.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEnderDoublePlant extends ItemBlock {

	public static final String[] doubleplant = new String[] { "sunflower", "grass", "fern" };

	public ItemBlockEnderDoublePlant(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= doubleplant.length) {
			i = 0;
		}

		return super.getUnlocalizedName() + "." + doubleplant[i];
	}

	public int getMetadata(int metadata) {
		return 7;
	}
}
