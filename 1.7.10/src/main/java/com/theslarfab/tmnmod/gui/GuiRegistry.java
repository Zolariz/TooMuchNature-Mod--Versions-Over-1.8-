package com.theslarfab.tmnmod.gui;

import com.theslarfab.tmnmod.TooMuchNatventure;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class GuiRegistry {
	
	private static final GuiRegistry INSTANCE = new GuiRegistry();
	
	private int guiID = 0;
	
	public static int getNextAvailableGuiID() {
		return instance().guiID++;
	}

	@Deprecated
	public static GuiRegistry instance() {
		return INSTANCE;
	}
}
