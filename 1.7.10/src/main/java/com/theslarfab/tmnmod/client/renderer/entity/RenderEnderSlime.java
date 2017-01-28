package com.theslarfab.tmnmod.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import com.theslarfab.tmnmod.TooMuchNature;
import com.theslarfab.tmnmod.entity.monster.EntityEnderSlime;

@SideOnly(Side.CLIENT)
public class RenderEnderSlime extends RenderLiving {

	private static final ResourceLocation slimeTextures = new ResourceLocation(
			TooMuchNature.modid + ":" + "textures/entity/slime/ender_slime.png");

	private ModelBase scaleAmount;

	public RenderEnderSlime(ModelBase modelbase1, ModelBase modelbase2, float par3) {
		super(modelbase1, par3);
		this.scaleAmount = modelbase2;
	}

	protected int shouldRenderPass(EntityEnderSlime enderSlime, int renderPass, float transparency) {
		if (enderSlime.isInvisible()) {
			return 0;
		} else if (renderPass == 0) {
			this.setRenderPassModel(this.scaleAmount);
			GL11.glEnable(GL11.GL_NORMALIZE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			return 1;
		} else {
			if (renderPass == 1) {
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}

			return -1;
		}
	}

	protected void preRenderCallback(EntityEnderSlime entityLiving, float partialTickTime) {
		float f1 = (float) entityLiving.getSlimeSize();
		float f2 = (entityLiving.prevSquishFactor
				+ (entityLiving.squishFactor - entityLiving.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
		float f3 = 1.0F / (f2 + 1.0F);
		GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}

	protected ResourceLocation getEntityTexture(EntityEnderSlime entityTexture) {
		return slimeTextures;
	}

	protected void preRenderCallback(EntityLivingBase entityLiving, float partialTickTime) {
		this.preRenderCallback((EntityEnderSlime) entityLiving, partialTickTime);
	}

	protected int shouldRenderPass(EntityLivingBase livingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityEnderSlime) livingBase, par2, par3);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityEnderSlime) entity);
	}
}
