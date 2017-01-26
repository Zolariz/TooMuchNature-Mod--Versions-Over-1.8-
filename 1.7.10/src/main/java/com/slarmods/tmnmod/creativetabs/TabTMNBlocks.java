package com.slarmods.tmnmod.creativetabs;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.init.TMNBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNBlocks extends CreativeTabs {

	public TabTMNBlocks(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(TMNBlocks.cherry_log);
	}
}
