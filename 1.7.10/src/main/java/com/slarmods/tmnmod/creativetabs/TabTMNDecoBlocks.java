package com.slarmods.tmnmod.creativetabs;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNDecoBlocks extends CreativeTabs {

	public TabTMNDecoBlocks(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(TooMuchNature.cherry_sapling);
	}
}
