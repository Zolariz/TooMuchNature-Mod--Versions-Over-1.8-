package com.theslarfab.tmnmod.handler;

import com.theslarfab.tmnmod.container.ContainerEnderWorkbench;
import com.theslarfab.tmnmod.gui.GuiEnderWorkbench;
import com.theslarfab.tmnmod.init.TMNBlocks;
import com.theslarfab.tmnmod.TooMuchNature;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == TooMuchNature.guiIDEnderWorkbench) {
			return ID == TooMuchNature.guiIDEnderWorkbench && world.getBlock(x, y, z) == TMNBlocks.ender_workbench
					? new ContainerEnderWorkbench(player.inventory, world, x, y, z) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == TooMuchNature.guiIDEnderWorkbench) {
			return ID == TooMuchNature.guiIDEnderWorkbench && world.getBlock(x, y, z) == TMNBlocks.ender_workbench
					? new GuiEnderWorkbench(player.inventory, world, x, y, z) : null;
		}
		return null;
	}
}
