package com.slarmods.tmnmod.gui;

import org.lwjgl.opengl.GL11;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.container.ContainerEnderWorkbench;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiEnderWorkbench extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(
			TooMuchNature.modid + ":" + "textures/gui/container/ender_workbench.png");

	public GuiEnderWorkbench(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerEnderWorkbench(invPlayer, world, x, y, z));

		this.xSize = 176;
		this.ySize = 166;
	}

	public void onGuiClosed() {
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.enderWorkbench"), 100, 5, 0x006B60);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
