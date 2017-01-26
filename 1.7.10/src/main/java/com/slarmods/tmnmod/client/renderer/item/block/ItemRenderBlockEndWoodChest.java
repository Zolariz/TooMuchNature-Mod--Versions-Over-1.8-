package com.slarmods.tmnmod.client.renderer.item.block;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.slarmods.tmnmod.tileentity.TileEntityEndWoodChest;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderBlockEndWoodChest implements IItemRenderer {

	private ModelChest chestModel;

	public ItemRenderBlockEndWoodChest() {
		chestModel = new ModelChest();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityEndWoodChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	}
}
