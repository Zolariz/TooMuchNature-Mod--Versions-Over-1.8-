package com.slarmods.tmnmod.client.renderer.entity;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.entity.EntityZebra;
import com.slarmods.tmnmod.client.model.ModelZebra;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderZebra extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(
			TooMuchNature.modid + ":" + "textures/entity/horse/zebra.png");

	protected ModelZebra modelEntity;

	public RenderZebra(ModelBase par1, float par2) {
		super(par1, par2);

		modelEntity = ((ModelZebra) mainModel);
	}

	public void renderZebra(EntityZebra entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderZebra((EntityZebra) entityLiving, x, y, z, u, v);
	}

	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderZebra((EntityZebra) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1) {
		return texture;
	}
}