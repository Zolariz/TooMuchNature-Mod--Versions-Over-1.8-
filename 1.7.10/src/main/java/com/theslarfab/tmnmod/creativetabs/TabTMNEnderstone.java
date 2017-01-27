package com.theslarfab.tmnmod.creativetabs;

import com.theslarfab.tmnmod.init.TMNItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNEnderstone extends CreativeTabs {

	public TabTMNEnderstone(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return TMNItems.enderstone_dust;
	}
}
