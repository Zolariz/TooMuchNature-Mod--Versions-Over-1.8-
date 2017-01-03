package com.slarmods.tmnmod.item;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemBlockEndStoneSlab extends ItemSlab {

	public ItemBlockEndStoneSlab(Block block) {
		super(block, (BlockSlab) TooMuchNature.end_stone_slab,
				(BlockSlab) TooMuchNature.end_stone_double_slab, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
}
