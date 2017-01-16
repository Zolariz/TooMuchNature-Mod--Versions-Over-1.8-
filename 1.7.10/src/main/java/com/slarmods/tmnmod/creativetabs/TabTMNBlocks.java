package com.slarmods.tmnmod.creativetabs;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNBlocks extends CreativeTabs {

	public TabTMNBlocks(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(TooMuchNature.cherry_log);
	}
}
