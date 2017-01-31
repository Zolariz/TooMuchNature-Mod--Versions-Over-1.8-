package com.theslarfab.tmnmod.world.biome;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.gui.GuiRegistry;

public class BiomeIDRegistry {

	private static final BiomeIDRegistry INSTANCE = new BiomeIDRegistry();
	private int biomeID = 40;

	public static int getNextAvailableBiomeID() {
		return instance().biomeID++;
	}

	@Deprecated
	public static BiomeIDRegistry instance() {
		return INSTANCE;
	}
}
