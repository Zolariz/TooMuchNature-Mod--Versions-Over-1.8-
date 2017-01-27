package com.theslarfab.tmnmod.client.renderer.item;

import org.lwjgl.opengl.GL11;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.client.model.item.ModelItemEnderPistol;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderEnderPistol implements IItemRenderer {

	private ModelItemEnderPistol ender_pistol;

	public static ResourceLocation texture = new ResourceLocation(
			TooMuchNature.modid + ":" + "textures/model/item/ender_pistol.png");

	public ItemRenderEnderPistol() {
		ender_pistol = new ModelItemEnderPistol();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case EQUIPPED:
			return false;
		case EQUIPPED_FIRST_PERSON:
			return false;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case EQUIPPED: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);

			float scale = 0.7F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(90, 0F, 1F, 0F);
			GL11.glRotatef(130, 1F, 0F, 0F);
			GL11.glRotatef(20, 1F, 0F, 1F);

			GL11.glTranslatef(0.1F, 0F, -0.5F);

			this.ender_pistol.renderModel(0.0625F);
			GL11.glPopMatrix();
		}

		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);

			float scale = 0.7F;

			GL11.glScalef(scale, scale, scale);

			GL11.glRotatef(90, 0F, 1F, 0F);
			GL11.glRotatef(130, 1F, 0F, 0F);
			GL11.glRotatef(20, 1F, 0F, 1F);

			boolean isFirstPerson = false;

			if (data[1] != null && data[1] instanceof EntityPlayer) {
				if (!((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity
						&& Minecraft.getMinecraft().gameSettings.thirdPersonView == 0
						&& !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory
								|| Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative)
								&& RenderManager.instance.playerViewY == 180.0F))) {
					GL11.glTranslatef(0.1F, 0F, -0.5F);
				} else {
					isFirstPerson = true;

				}
			} else {
				GL11.glTranslatef(0.1F, 0F, -0.5F);
			}

			this.ender_pistol.renderModel(0.0625F);
			GL11.glPopMatrix();
		}
		
		default:
			break;
		}
	}
}
