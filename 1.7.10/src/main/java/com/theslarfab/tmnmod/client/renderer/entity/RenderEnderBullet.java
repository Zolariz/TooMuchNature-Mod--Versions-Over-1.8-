package com.theslarfab.tmnmod.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.theslarfab.tmnmod.TooMuchNatventure;
import com.theslarfab.tmnmod.client.model.ModelEnderBullet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderEnderBullet extends Render {

	private static final ResourceLocation texture = new ResourceLocation(
			TooMuchNatventure.modid + ":" + "textures/entity/projectile/ender_bullet.png");

	protected ModelEnderBullet modelEntity;
	protected ModelBase mainModel;

	public RenderEnderBullet(ModelBase modelEnderBullet, float f) {
		super();

		modelEntity = ((ModelEnderBullet) mainModel);
	}

	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
