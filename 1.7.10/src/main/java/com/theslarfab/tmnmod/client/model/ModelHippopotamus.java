/**
	Copyright (C) <2016>  <TheSlarFab>

    This file is part of the TheSlarFab TooMuchNatventure Mod; as such, 
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.theslarfab.tmnmod.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelHippopotamus - TheSlarFab Created using Tabula 4.1.1
 */
public class ModelHippopotamus extends ModelBase {
	public ModelRenderer leg1;
	public ModelRenderer leg2;
	public ModelRenderer leg3;
	public ModelRenderer leg4;
	public ModelRenderer body;
	public ModelRenderer head;
	public ModelRenderer tailBase;
	public ModelRenderer nose;
	public ModelRenderer nostril1;
	public ModelRenderer nostril2;
	public ModelRenderer tailMid;
	public ModelRenderer tailBottom;
	protected float float1 = 8.0F;
	protected float float2 = 4.0F;

	public ModelHippopotamus() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.tailBase = new ModelRenderer(this, 57, 0);
		this.tailBase.setRotationPoint(0.0F, -0.7F, 17.0F);
		this.tailBase.addBox(-1.0F, -1.0F, 0.1F, 2, 2, 3, 0.0F);
		this.setRotateAngle(tailBase, -1.0471975511965976F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 1.0F, -15.0F);
		this.head.addBox(-5.5F, -5.0F, -5.0F, 11, 10, 5, 0.0F);
		this.nostril1 = new ModelRenderer(this, 0, 18);
		this.nostril1.setRotationPoint(-3.0F, 0.0F, -8.6F);
		this.nostril1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.leg4 = new ModelRenderer(this, 104, 66);
		this.leg4.setRotationPoint(8.0F, 12.0F, 14.0F);
		this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.leg1 = new ModelRenderer(this, 104, 66);
		this.leg1.setRotationPoint(-8.0F, 12.0F, -11.0F);
		this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.nostril2 = new ModelRenderer(this, 0, 18);
		this.nostril2.setRotationPoint(3.0F, 0.0F, -8.5F);
		this.nostril2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(nostril2, 0.0F, 0.0F, -0.00715584993317675F);
		this.tailMid = new ModelRenderer(this, 95, 82);
		this.tailMid.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailMid.addBox(-1.5F, 2.8F, -0.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(tailMid, 1.2747884856566583F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 104, 66);
		this.leg2.setRotationPoint(8.0F, 12.0F, -11.0F);
		this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.body = new ModelRenderer(this, 0, 15);
		this.body.setRotationPoint(0.0F, 2.0F, 1.0F);
		this.body.addBox(-11.0F, -9.0F, -16.0F, 22, 19, 32, 0.0F);
		this.nose = new ModelRenderer(this, 84, 0);
		this.nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.nose.addBox(-6.0F, 0.0F, -9.9F, 12, 5, 10, 0.0F);
		this.tailBottom = new ModelRenderer(this, 86, 90);
		this.tailBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailBottom.addBox(-1.5F, 5.9F, 0.7F, 3, 4, 3, 0.0F);
		this.setRotateAngle(tailBottom, -0.18203784098300857F, 0.0F, 0.0F);
		this.leg3 = new ModelRenderer(this, 104, 66);
		this.leg3.setRotationPoint(-8.0F, 12.0F, 14.0F);
		this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.nose.addChild(this.nostril1);
		this.nose.addChild(this.nostril2);
		this.tailBase.addChild(this.tailMid);
		this.head.addChild(this.nose);
		this.tailMid.addChild(this.tailBottom);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		{
			this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

			if (this.isChild) {
				float f6 = 2.0F;
				GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, this.float1 * f5, this.float2 * f5);
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
				GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
				this.tailBase.render(f5);
				this.body.render(f5);
				this.leg4.render(f5);
				this.leg1.render(f5);
				this.leg2.render(f5);
				this.leg3.render(f5);
				this.head.render(f5);
				GL11.glPopMatrix();
			} else {
				this.tailBase.render(f5);
				this.body.render(f5);
				this.leg4.render(f5);
				this.leg1.render(f5);
				this.leg2.render(f5);
				this.leg3.render(f5);
				this.head.render(f5);
			}
		}
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity) {
		float f7 = (180F / (float) Math.PI);
		this.head.rotateAngleX = f5 / (180F / (float) Math.PI);
		this.head.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.leg1.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
		this.leg2.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
		this.leg3.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
		this.leg4.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
	}
}
