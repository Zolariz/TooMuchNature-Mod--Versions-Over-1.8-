package com.theslarfab.tmnmod.item;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemBlockEndStoneSlab extends ItemSlab {

	public ItemBlockEndStoneSlab(Block block) {
		super(block, (BlockSlab) TMNBlocks.end_stone_slab, (BlockSlab) TMNBlocks.end_stone_double_slab, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
}
