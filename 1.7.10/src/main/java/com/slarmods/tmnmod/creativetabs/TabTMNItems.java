package com.slarmods.tmnmod.creativetabs;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.init.TMNItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNItems extends CreativeTabs {

	public TabTMNItems(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return TMNItems.enderald;
	}
}
