package com.slarmods.tmnmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockEnderPiston extends ItemBlock {

	public ItemBlockEnderPiston(Block block) {
		super(block);
	}

	public int getMetadata(int metadata) {
		return 7;
	}
}
