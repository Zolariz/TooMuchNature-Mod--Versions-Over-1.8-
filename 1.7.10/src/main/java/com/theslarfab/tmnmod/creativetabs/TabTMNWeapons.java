package com.theslarfab.tmnmod.creativetabs;

import com.theslarfab.tmnmod.init.TMNItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNWeapons extends CreativeTabs {

	public TabTMNWeapons(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return TMNItems.ender_pistol;
	}
}
