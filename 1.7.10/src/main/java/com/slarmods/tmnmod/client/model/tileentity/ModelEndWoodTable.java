package com.slarmods.tmnmod.client.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelEndWoodTable - TheSlarFab Created using Tabula 4.1.1
 */
public class ModelEndWoodTable extends ModelBase {
	public ModelRenderer tableLeg1;
	public ModelRenderer tableLeg2;
	public ModelRenderer tableLeg3;
	public ModelRenderer tableLeg4;
	public ModelRenderer tablePlatform;

	public ModelEndWoodTable() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.tableLeg4 = new ModelRenderer(this, 0, 0);
		this.tableLeg4.setRotationPoint(5.0F, 11.0F, 5.0F);
		this.tableLeg4.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
		this.tablePlatform = new ModelRenderer(this, 0, 0);
		this.tablePlatform.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.tablePlatform.addBox(-8.0F, 0.0F, -8.0F, 16, 3, 16, 0.0F);
		this.tableLeg1 = new ModelRenderer(this, 0, 0);
		this.tableLeg1.setRotationPoint(5.0F, 11.0F, -7.0F);
		this.tableLeg1.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
		this.tableLeg2 = new ModelRenderer(this, 0, 0);
		this.tableLeg2.setRotationPoint(-7.0F, 11.0F, -7.0F);
		this.tableLeg2.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
		this.tableLeg3 = new ModelRenderer(this, 0, 0);
		this.tableLeg3.setRotationPoint(-7.0F, 11.0F, 5.0F);
		this.tableLeg3.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.tableLeg4.render(f5);
		this.tablePlatform.render(f5);
		this.tableLeg1.render(f5);
		this.tableLeg2.render(f5);
		this.tableLeg3.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
