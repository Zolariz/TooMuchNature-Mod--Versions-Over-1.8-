package com.slarmods.tmnmod.creativetabs;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.item.TMNItems;

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
