package com.slarmods.tmnmod.handler;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.block.TMNBlocks;
import com.slarmods.tmnmod.container.ContainerEnderWorkbench;
import com.slarmods.tmnmod.gui.GuiEnderWorkbench;

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
