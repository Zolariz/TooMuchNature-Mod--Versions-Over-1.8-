package com.slarmods.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemEnderPiston extends ItemBlock {

	public ItemEnderPiston(Block block) {
		super(block);
	}

	public int getMetadata(int metadata) {
		return 7;
	}
}
