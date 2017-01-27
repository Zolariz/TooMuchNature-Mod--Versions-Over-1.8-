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
 * ModelZebra - Created using Tabula 4.1.1
 */
public class ModelZebra extends ModelBase {
	public ModelRenderer leg2A;
	public ModelRenderer leg1A;
	public ModelRenderer body;
	public ModelRenderer leg4A;
	public ModelRenderer leg3A;
	public ModelRenderer neck;
	public ModelRenderer leg2B;
	public ModelRenderer foot2;
	public ModelRenderer leg1B;
	public ModelRenderer foot1;
	public ModelRenderer tailA;
	public ModelRenderer tailB;
	public ModelRenderer tailC;
	public ModelRenderer leg4B;
	public ModelRenderer foot4;
	public ModelRenderer leg3B;
	public ModelRenderer foot3;
	public ModelRenderer neckFur;
	public ModelRenderer head;
	public ModelRenderer nose;
	public ModelRenderer rEar;
	public ModelRenderer lEar;
	public ModelRenderer mouth;
	protected float float1 = 8.0F;
	protected float float2 = 4.0F;

	public ModelZebra() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.foot3 = new ModelRenderer(this, 96, 51);
		this.foot3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.foot3.addBox(-1.5F, 12.0F, -2.0F, 4, 3, 4, 0.0F);
		this.leg1A = new ModelRenderer(this, 60, 29);
		this.leg1A.setRotationPoint(-4.0F, 9.0F, -8.0F);
		this.leg1A.addBox(-1.1F, -1.0F, -2.1F, 3, 8, 4, 0.0F);
		this.body = new ModelRenderer(this, 0, 34);
		this.body.setRotationPoint(0.0F, 11.0F, 9.0F);
		this.body.addBox(-5.0F, -8.0F, -19.0F, 10, 10, 24, 0.0F);
		this.leg2B = new ModelRenderer(this, 44, 41);
		this.leg2B.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg2B.addBox(-1.9F, 7.0F, -1.6F, 3, 5, 3, 0.0F);
		this.nose = new ModelRenderer(this, 24, 18);
		this.nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.nose.addBox(-2.0F, -16.0F, -7.0F, 4, 3, 6, 0.0F);
		this.leg4B = new ModelRenderer(this, 78, 43);
		this.leg4B.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg4B.addBox(-2.0F, 7.0F, -1.5F, 3, 5, 3, 0.0F);
		this.tailA = new ModelRenderer(this, 44, 0);
		this.tailA.setRotationPoint(0.0F, -8.0F, 5.0F);
		this.tailA.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
		this.setRotateAngle(tailA, -1.1344640137963142F, 0.0F, 0.0F);
		this.mouth = new ModelRenderer(this, 24, 27);
		this.mouth.setRotationPoint(0.0F, -12.0F, 0.0F);
		this.mouth.addBox(-2.0F, -1.0F, -6.5F, 4, 2, 5, 0.0F);
		this.foot1 = new ModelRenderer(this, 60, 51);
		this.foot1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.foot1.addBox(-1.6F, 12.0F, -2.1F, 4, 3, 4, 0.0F);
		this.leg3A = new ModelRenderer(this, 96, 29);
		this.leg3A.setRotationPoint(-4.0F, 9.0F, 11.0F);
		this.leg3A.addBox(-1.5F, -2.0F, -2.5F, 4, 9, 5, 0.0F);
		this.tailC = new ModelRenderer(this, 24, 3);
		this.tailC.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailC.addBox(-1.5F, -4.5F, 9.0F, 3, 4, 7, 0.0F);
		this.setRotateAngle(tailC, -0.27314402793711257F, 0.0F, 0.0F);
		this.lEar = new ModelRenderer(this, 0, 0);
		this.lEar.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lEar.addBox(0.45F, -12.0F, 4.0F, 2, 3, 1, 0.0F);
		this.leg4A = new ModelRenderer(this, 78, 29);
		this.leg4A.setRotationPoint(4.0F, 9.0F, 11.0F);
		this.leg4A.addBox(-2.5F, -2.0F, -2.5F, 4, 9, 5, 0.0F);
		this.rEar = new ModelRenderer(this, 0, 0);
		this.rEar.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rEar.addBox(-2.45F, -12.0F, 4.0F, 2, 3, 1, 0.0F);
		this.tailB = new ModelRenderer(this, 38, 7);
		this.tailB.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailB.addBox(-1.5F, -2.0F, 3.0F, 3, 4, 7, 0.0F);
		this.foot2 = new ModelRenderer(this, 44, 51);
		this.foot2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.foot2.addBox(-2.4F, 12.0F, -2.1F, 4, 3, 4, 0.0F);
		this.neckFur = new ModelRenderer(this, 58, 0);
		this.neckFur.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neckFur.addBox(-1.0F, -17.5F, 5.0F, 2, 16, 4, 0.0F);
		this.leg3B = new ModelRenderer(this, 96, 43);
		this.leg3B.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg3B.addBox(-1.0F, 7.0F, -1.5F, 3, 5, 3, 0.0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.setRotationPoint(0.0F, 10.0F, -6.0F);
		this.neck.addBox(-2.05F, -15.8F, -2.0F, 4, 14, 8, 0.0F);
		this.setRotateAngle(neck, 0.5235987755982988F, 0.0F, 0.0F);
		this.leg1B = new ModelRenderer(this, 60, 41);
		this.leg1B.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg1B.addBox(-1.1F, 7.0F, -1.6F, 3, 5, 3, 0.0F);
		this.foot4 = new ModelRenderer(this, 78, 51);
		this.foot4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.foot4.addBox(-2.5F, 12.0F, -2.0F, 4, 3, 4, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.5F, -16.0F, -1.5F, 5, 5, 7, 0.0F);
		this.leg2A = new ModelRenderer(this, 44, 29);
		this.leg2A.setRotationPoint(4.0F, 9.0F, -8.0F);
		this.leg2A.addBox(-1.9F, -1.0F, -2.1F, 3, 8, 4, 0.0F);
		this.leg3B.addChild(this.foot3);
		this.leg2A.addChild(this.leg2B);
		this.head.addChild(this.nose);
		this.leg4A.addChild(this.leg4B);
		this.body.addChild(this.tailA);
		this.nose.addChild(this.mouth);
		this.leg1B.addChild(this.foot1);
		this.tailB.addChild(this.tailC);
		this.head.addChild(this.lEar);
		this.head.addChild(this.rEar);
		this.tailA.addChild(this.tailB);
		this.leg2B.addChild(this.foot2);
		this.neck.addChild(this.neckFur);
		this.leg3A.addChild(this.leg3B);
		this.leg1A.addChild(this.leg1B);
		this.leg4B.addChild(this.foot4);
		this.neck.addChild(this.head);
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
				this.leg1A.render(f5);
				this.leg4A.render(f5);
				this.leg2A.render(f5);
				this.leg3A.render(f5);
				this.body.render(f5);
				this.neck.render(f5);
				GL11.glPopMatrix();
			} else {
				this.leg1A.render(f5);
				this.leg4A.render(f5);
				this.leg2A.render(f5);
				this.leg3A.render(f5);
				this.body.render(f5);
				this.neck.render(f5);
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
		this.body.rotateAngleX = 0.0F;
		this.leg1A.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
		this.leg2A.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
		this.leg3A.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
		this.leg4A.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
	}
}
