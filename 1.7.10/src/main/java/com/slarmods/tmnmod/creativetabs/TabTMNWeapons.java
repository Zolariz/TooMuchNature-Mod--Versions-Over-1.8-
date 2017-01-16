package com.slarmods.tmnmod.creativetabs;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNWeapons extends CreativeTabs {

	public TabTMNWeapons(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return TooMuchNature.ender_pistol;
	}
}
