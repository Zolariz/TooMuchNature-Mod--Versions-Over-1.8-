package com.slarmods.tmnmod.client.renderer.item.block;

import org.lwjgl.opengl.GL11;

import com.slarmods.tmnmod.tileentity.TileEntityEndWoodChest;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.Tessellator;
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
		
		Tessellator tessellator = Tessellator.instance;
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityEndWoodChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		tessellator.setNormal(0.0F, 0.0F, 0.0F);
		GL11.glPopMatrix();
	}
}
