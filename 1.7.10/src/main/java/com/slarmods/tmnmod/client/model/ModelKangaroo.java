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

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Kangaroo.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class ModelKangaroo extends ModelBase {
	public ModelRenderer rleg;
	public ModelRenderer lleg;
	public ModelRenderer body;
	public ModelRenderer neck;
	public ModelRenderer tail1;
	public ModelRenderer rarm;
	public ModelRenderer larm;
	public ModelRenderer rfoot;
	public ModelRenderer lfoot;
	public ModelRenderer neckhead;
	public ModelRenderer rear;
	public ModelRenderer lear;
	public ModelRenderer tail2;
	public ModelRenderer rhand;
	public ModelRenderer lhand;
	protected float float1 = 8.0F;
	protected float float2 = 4.0F;

	public ModelKangaroo() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.larm = new ModelRenderer(this, 40, 4);
		this.larm.setRotationPoint(4.0F, 9.0F, -2.0F);
		this.larm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(larm, -0.136659280431156F, -0.0F, 0.0F);
		this.tail1 = new ModelRenderer(this, 56, 28);
		this.tail1.setRotationPoint(0.0F, 15.0F, 4.7F);
		this.tail1.addBox(-1.0F, 0.0F, -1.0F, 2, 11, 2, 0.0F);
		this.setRotateAngle(tail1, 0.767944870877505F, -0.0F, 0.0F);
		this.tail2 = new ModelRenderer(this, 48, 21);
		this.tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail2.addBox(-1.0F, 6.9F, -8.6F, 2, 7, 2, 0.0F);
		this.setRotateAngle(tail2, 0.8028514559173915F, -0.0F, 0.0F);
		this.lleg = new ModelRenderer(this, 4, 20);
		this.lleg.setRotationPoint(2.0F, 16.0F, 3.0F);
		this.lleg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.body = new ModelRenderer(this, 6, 29);
		this.body.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.body.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 6, 0.0F);
		this.setRotateAngle(body, 0.5948577523231506F, -9.300982920179775E-17F, 0.0F);
		this.rear = new ModelRenderer(this, 16, 0);
		this.rear.setRotationPoint(-1.0F, -9.0F, 0.0F);
		this.rear.addBox(0.0F, -4.0F, 0.0F, 2, 4, 1, 0.0F);
		this.setRotateAngle(rear, 0.35220744305245566F, -0.5815437067645106F, -0.5897467542488839F);
		this.rarm = new ModelRenderer(this, 40, 4);
		this.rarm.setRotationPoint(-4.0F, 9.0F, -2.0F);
		this.rarm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(rarm, -0.14871443808078766F, -0.0F, 0.0F);
		this.rleg = new ModelRenderer(this, 4, 20);
		this.rleg.setRotationPoint(-2.0F, 16.0F, 3.0F);
		this.rleg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.lfoot = new ModelRenderer(this, 28, 14);
		this.lfoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lfoot.addBox(-1.0F, 7.0F, -7.0F, 2, 1, 8, 0.0F);
		this.lhand = new ModelRenderer(this, 48, 9);
		this.lhand.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.lhand.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 5, 0.0F);
		this.rfoot = new ModelRenderer(this, 28, 14);
		this.rfoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rfoot.addBox(-1.0F, 7.0F, -7.0F, 2, 1, 8, 0.0F);
		this.neckhead = new ModelRenderer(this, 0, 0);
		this.neckhead.setRotationPoint(0.0F, -8.0F, 0.0F);
		this.neckhead.addBox(-1.5F, -1.6F, -6.5F, 3, 3, 5, 0.0F);
		this.rhand = new ModelRenderer(this, 48, 9);
		this.rhand.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.rhand.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 5, 0.0F);
		this.lear = new ModelRenderer(this, 16, 0);
		this.lear.setRotationPoint(1.0F, -9.0F, 0.0F);
		this.lear.addBox(-2.0F, -4.0F, 0.0F, 2, 4, 1, 0.0F);
		this.setRotateAngle(lear, 0.35220744305245566F, 0.5815437067645106F, 0.5897467542488839F);
		this.neck = new ModelRenderer(this, 12, 8);
		this.neck.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.neck.addBox(-2.0F, -10.0F, -2.0F, 4, 10, 4, 0.0F);
		this.setRotateAngle(neck, 0.11153583228588103F, -0.0F, 1.2401310119076705E-16F);
		this.tail1.addChild(this.tail2);
		this.neck.addChild(this.rear);
		this.lleg.addChild(this.lfoot);
		this.larm.addChild(this.lhand);
		this.rleg.addChild(this.rfoot);
		this.neck.addChild(this.neckhead);
		this.rarm.addChild(this.rhand);
		this.neck.addChild(this.lear);
	}

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
				this.lleg.render(f5);
				this.tail1.render(f5);
				this.tail2.render(f5);
				this.rleg.render(f5);
				this.rarm.render(f5);
				this.larm.render(f5);
				this.body.render(f5);
				this.neck.render(f5);
				GL11.glPopMatrix();
			} else {
				this.lleg.render(f5);
				this.tail1.render(f5);
				this.tail2.render(f5);
				this.rleg.render(f5);
				this.rarm.render(f5);
				this.larm.render(f5);
				this.body.render(f5);
				this.neck.render(f5);
			}
		}
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		float f7 = (180F / (float) Math.PI);
		this.neck.rotateAngleX = f5 / (180F / (float) Math.PI);
		this.neck.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.neck.rotateAngleX = f5 / (180F / (float) Math.PI);
		this.neck.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.rleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
		this.lleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float) Math.PI) * 1.4F * f2;
	}
}
