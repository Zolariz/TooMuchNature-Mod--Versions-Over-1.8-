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

package com.slarmods.tmnmod.client.renderer.entity;

import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.entity.EntityLonghorn;
import com.slarmods.tmnmod.client.model.ModelLonghorn;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderLonghorn extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(
			TooMuchNature.modid + ":" + "textures/entity/cow/txlonghorn.png");

	protected ModelLonghorn modelEntity;

	public RenderLonghorn(ModelBase par1, float par2) {
		super(par1, par2);

		modelEntity = ((ModelLonghorn) mainModel);
	}

	public void renderLonghorn(EntityLonghorn entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderLonghorn((EntityLonghorn) entityLiving, x, y, z, u, v);
	}

	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderLonghorn((EntityLonghorn) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
