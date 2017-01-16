package com.slarmods.tmnmod.creativetabs;

import com.slarmods.tmnmod.TooMuchNature;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMNMobs extends CreativeTabs {

	public TabTMNMobs(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return TooMuchNature.tmn_spawn_egg;
	}
}
