package com.theslarfab.tmnmod.client.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelItemEnderGun - TheSlarFab Created using Tabula 4.1.1
 */
public class ModelItemEnderPistol extends ModelBase {
	public ModelRenderer ender_pistol_top;
	public ModelRenderer ender_pistol_bottom;
	public ModelRenderer ender_pistol_handle;
	public ModelRenderer ender_pistol_trigger_1;
	public ModelRenderer ender_pistol_trigger_2;
	public ModelRenderer ender_pistol_trigger_in_1;
	public ModelRenderer ender_pistol_trigger_in_2;
	public ModelRenderer ender_pistol_auto_trigger_1;
	public ModelRenderer ender_pistol_auto_trigger_2;
	public ModelRenderer ender_pistol_front;

	public ModelItemEnderPistol() {
		this.textureWidth = 64;
        this.textureHeight = 64;
        this.ender_pistol_bottom = new ModelRenderer(this, 28, 0);
        this.ender_pistol_bottom.setRotationPoint(-2.0F, -4.000000000000002F, -9.7F);
        this.ender_pistol_bottom.addBox(0.0F, 0.0F, 0.0F, 4, 2, 14, 0.0F);
        this.ender_pistol_auto_trigger_2 = new ModelRenderer(this, 28, 25);
        this.ender_pistol_auto_trigger_2.setRotationPoint(-0.5F, -8.169999999999993F, 4.87F);
        this.ender_pistol_auto_trigger_2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ender_pistol_auto_trigger_2, -0.22759093446006054F, 0.0F, 0.0F);
        this.ender_pistol_auto_trigger_1 = new ModelRenderer(this, 28, 25);
        this.ender_pistol_auto_trigger_1.setRotationPoint(-0.5F, -6.599999999999998F, 4.6F);
        this.ender_pistol_auto_trigger_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ender_pistol_auto_trigger_1, -0.6373942428283291F, 0.0F, 0.0F);
        this.ender_pistol_front = new ModelRenderer(this, 31, 22);
        this.ender_pistol_front.setRotationPoint(1.5F, 0.5F, -0.5F);
        this.ender_pistol_front.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.ender_pistol_trigger_in_1 = new ModelRenderer(this, 13, 22);
        this.ender_pistol_trigger_in_1.setRotationPoint(-1.0F, -3.180000000000001F, -1.8F);
        this.ender_pistol_trigger_in_1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(ender_pistol_trigger_in_1, -1.1838568316277536F, 0.0F, 0.0F);
        this.ender_pistol_handle = new ModelRenderer(this, 48, 16);
        this.ender_pistol_handle.setRotationPoint(-2.0F, -2.0000000000000004F, -0.7F);
        this.ender_pistol_handle.addBox(0.0F, 0.0F, 0.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(ender_pistol_handle, 0.36425021489121656F, 0.0F, 0.0F);
        this.ender_pistol_trigger_1 = new ModelRenderer(this, 19, 16);
        this.ender_pistol_trigger_1.setRotationPoint(-1.0F, 1.0000000000000007F, -3.6F);
        this.ender_pistol_trigger_1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.ender_pistol_trigger_in_2 = new ModelRenderer(this, 13, 22);
        this.ender_pistol_trigger_in_2.setRotationPoint(-1.0F, -1.3400000000000014F, -1.04F);
        this.ender_pistol_trigger_in_2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(ender_pistol_trigger_in_2, -1.730144887501979F, 0.0F, 0.0F);
        this.ender_pistol_top = new ModelRenderer(this, 28, 30);
        this.ender_pistol_top.setRotationPoint(-2.0F, -5.999999999999998F, -9.7F);
        this.ender_pistol_top.addBox(0.0F, 0.0F, 0.0F, 4, 2, 14, 0.0F);
        this.ender_pistol_trigger_2 = new ModelRenderer(this, 19, 16);
        this.ender_pistol_trigger_2.setRotationPoint(-1.0F, -3.0100000000000016F, -4.58F);
        this.ender_pistol_trigger_2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(ender_pistol_trigger_2, -1.1838568316277536F, 0.0F, 0.0F);
        this.ender_pistol_top.addChild(this.ender_pistol_front);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.ender_pistol_auto_trigger_1.render(f5);
		this.ender_pistol_auto_trigger_2.render(f5);
		this.ender_pistol_top.render(f5);
		this.ender_pistol_bottom.render(f5);
		this.ender_pistol_trigger_in_1.render(f5);
		this.ender_pistol_handle.render(f5);
		this.ender_pistol_trigger_in_2.render(f5);
		this.ender_pistol_trigger_2.render(f5);
		this.ender_pistol_trigger_1.render(f5);
	}

	public void renderModel(float f5) {
		this.ender_pistol_auto_trigger_1.render(f5);
		this.ender_pistol_auto_trigger_2.render(f5);
		this.ender_pistol_top.render(f5);
		this.ender_pistol_bottom.render(f5);
		this.ender_pistol_trigger_in_1.render(f5);
		this.ender_pistol_handle.render(f5);
		this.ender_pistol_trigger_in_2.render(f5);
		this.ender_pistol_trigger_2.render(f5);
		this.ender_pistol_trigger_1.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
