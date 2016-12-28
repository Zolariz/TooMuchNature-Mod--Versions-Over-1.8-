package com.slarmods.tmnmod.world;

import net.minecraftforge.common.DimensionManager;

public class TMNDimensions {

	public static void registerDimensions() {
		DimensionManager.registerDimension(DimensionIDs.ENDERLANDSDIMENSION, DimensionIDs.ENDERLANDSDIMENSION);
	}

	/**
	 * Regster dimension world providers with the dimension manager.
	 */
	public static void registerWorldProvider() {
		DimensionManager.registerProviderType(DimensionIDs.ENDERLANDSDIMENSION, WorldProviderEnderlands.class, true);
	}
}
