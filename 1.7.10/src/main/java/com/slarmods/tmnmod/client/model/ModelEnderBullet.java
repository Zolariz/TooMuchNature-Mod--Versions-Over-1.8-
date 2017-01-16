package com.slarmods.tmnmod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelBullet - TheSlarFab Created using Tabula 4.1.1
 */
public class ModelEnderBullet extends ModelBase {
	public ModelRenderer bullet_front_1;
	public ModelRenderer bullet_front_2;
	public ModelRenderer bullet_front_3;
	public ModelRenderer bullet_back_small;
	public ModelRenderer bullet_middle;
	public ModelRenderer bullet_back;
	public ModelRenderer bullet_ring;
	public ModelRenderer bullet_ring_top;
	public ModelRenderer bullet_ring_bottom;
	public ModelRenderer bullet_ring_left;
	public ModelRenderer bullet_ring_right;

	public ModelEnderBullet() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.bullet_ring_top = new ModelRenderer(this, 23, 0);
		this.bullet_ring_top.setRotationPoint(-2.5F, 18.75F, 2.1F);
		this.bullet_ring_top.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.bullet_front_2 = new ModelRenderer(this, 0, 9);
		this.bullet_front_2.setRotationPoint(0.5F, 22.0F, -3.1F);
		this.bullet_front_2.addBox(-1.5F, -1.5F, -2.5F, 2, 2, 3, 0.0F);
		this.bullet_front_3 = new ModelRenderer(this, 20, 9);
		this.bullet_front_3.setRotationPoint(0.0F, 21.5F, -0.6F);
		this.bullet_front_3.addBox(-1.5F, -1.5F, -2.5F, 3, 3, 3, 0.0F);
		this.bullet_ring_bottom = new ModelRenderer(this, 23, 0);
		this.bullet_ring_bottom.setRotationPoint(-2.5F, 22.25F, 2.1F);
		this.bullet_ring_bottom.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.bullet_ring_left = new ModelRenderer(this, 34, 2);
		this.bullet_ring_left.setRotationPoint(-2.25F, 18.5F, 2.1F);
		this.bullet_ring_left.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
		this.bullet_back_small = new ModelRenderer(this, 0, 5);
		this.bullet_back_small.setRotationPoint(0.0F, 21.5F, 4.9F);
		this.bullet_back_small.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
		this.bullet_front_1 = new ModelRenderer(this, 0, 14);
		this.bullet_front_1.setRotationPoint(1.0F, 22.5F, -4.1F);
		this.bullet_front_1.addBox(-1.5F, -1.5F, -2.5F, 1, 1, 1, 0.0F);
		this.bullet_ring = new ModelRenderer(this, 0, 0);
		this.bullet_ring.setRotationPoint(0.0F, 0.5F, 0.0F);
		this.bullet_ring.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		this.bullet_middle = new ModelRenderer(this, 10, 0);
		this.bullet_middle.setRotationPoint(0.0F, 21.5F, 0.4F);
		this.bullet_middle.addBox(-2.0F, -2.0F, -0.5F, 4, 4, 5, 0.0F);
		this.bullet_back = new ModelRenderer(this, 0, 0);
		this.bullet_back.setRotationPoint(0.0F, 21.5F, 5.6F);
		this.bullet_back.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 1, 0.0F);
		this.bullet_ring_right = new ModelRenderer(this, 34, 2);
		this.bullet_ring_right.setRotationPoint(1.25F, 18.5F, 2.1F);
		this.bullet_ring_right.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
		this.bullet_ring.addChild(this.bullet_ring_top);
		this.bullet_ring.addChild(this.bullet_ring_bottom);
		this.bullet_ring.addChild(this.bullet_ring_left);
		this.bullet_ring.addChild(this.bullet_ring_right);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.bullet_front_2.render(f5);
		this.bullet_front_3.render(f5);
		this.bullet_back_small.render(f5);
		this.bullet_front_1.render(f5);
		this.bullet_ring.render(f5);
		this.bullet_middle.render(f5);
		this.bullet_back.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
