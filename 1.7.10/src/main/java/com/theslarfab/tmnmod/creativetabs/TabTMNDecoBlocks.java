package com.theslarfab.tmnmod.creativetabs;

import com.theslarfab.tmnmod.init.TMNBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNDecoBlocks extends CreativeTabs {

	public TabTMNDecoBlocks(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(TMNBlocks.cherry_sapling);
	}
}
