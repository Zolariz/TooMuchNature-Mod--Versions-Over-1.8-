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

package com.slarmods.tmnmod.client.model;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelLonghorn - Created using Tabula 4.1.1
 */
@SideOnly(Side.CLIENT)
public class ModelLonghorn extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer lleg2;
	public ModelRenderer lleg1;
	public ModelRenderer rleg2;
	public ModelRenderer rleg1;
	public ModelRenderer head;
	public ModelRenderer udders;
	public ModelRenderer llonghornA;
	public ModelRenderer rlonghornA;
	public ModelRenderer llonghornB;
	public ModelRenderer rlonghornB;
	protected float float1 = 8.0F;
	protected float float2 = 4.0F;

	public ModelLonghorn() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.rleg1 = new ModelRenderer(this, 0, 16);
		this.rleg1.setRotationPoint(-4.0F, 12.0F, -6.0F);
		this.rleg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.llonghornA = new ModelRenderer(this, 0, 32);
		this.llonghornA.setRotationPoint(4.0F, -3.0F, -3.0F);
		this.llonghornA.addBox(0.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.rlonghornB = new ModelRenderer(this, 20, 34);
		this.rlonghornB.setRotationPoint(-8.64F, -1.14F, 0.0F);
		this.rlonghornB.addBox(-8.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F);
		this.setRotateAngle(rlonghornB, 0.0F, 0.0F, 0.8196066167365371F);
		this.lleg2 = new ModelRenderer(this, 0, 16);
		this.lleg2.setRotationPoint(4.0F, 12.0F, 7.0F);
		this.lleg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.rlonghornA = new ModelRenderer(this, 0, 32);
		this.rlonghornA.setRotationPoint(-4.0F, -3.0F, -3.0F);
		this.rlonghornA.addBox(-8.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.udders = new ModelRenderer(this, 52, 0);
		this.udders.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.udders.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
		this.lleg1 = new ModelRenderer(this, 0, 16);
		this.lleg1.setRotationPoint(4.0F, 12.0F, -6.0F);
		this.lleg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.llonghornB = new ModelRenderer(this, 20, 34);
		this.llonghornB.setRotationPoint(7.26F, 0.32F, 0.0F);
		this.llonghornB.addBox(0.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F);
		this.setRotateAngle(llonghornB, 0.0F, 0.0F, -0.8196066167365371F);
		this.rleg2 = new ModelRenderer(this, 0, 16);
		this.rleg2.setRotationPoint(-4.0F, 12.0F, 7.0F);
		this.rleg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.body = new ModelRenderer(this, 18, 4);
		this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
		this.body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
		this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
		this.head.addChild(this.llonghornA);
		this.rlonghornA.addChild(this.rlonghornB);
		this.head.addChild(this.rlonghornA);
		this.body.addChild(this.udders);
		this.llonghornA.addChild(this.llonghornB);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		{
			this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

			if (this.isChild) {
				float f6 = 2.0F;
				GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, this.float1 * f5, this.float2 * f5);
				this.head.render(f5);
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
				GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
				this.rleg1.render(f5);
				this.lleg2.render(f5);
				this.lleg1.render(f5);
				this.rleg2.render(f5);
				this.body.render(f5);
				GL11.glPopMatrix();
			} else {
				this.rleg1.render(f5);
				this.lleg2.render(f5);
				this.head.render(f5);
				this.lleg1.render(f5);
				this.rleg2.render(f5);
				this.body.render(f5);
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
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.rleg1.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
		this.lleg1.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
		this.rleg2.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
		this.lleg2.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
	}
}
