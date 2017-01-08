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
import com.slarmods.tmnmod.entity.EntityZebra;
import com.slarmods.tmnmod.client.model.ModelZebra;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderZebra extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(
			TooMuchNature.modid + ":" + "textures/entity/horse/zebra.png");

	protected ModelZebra modelEntity;

	public RenderZebra(ModelBase par1, float par2) {
		super(par1, par2);

		modelEntity = ((ModelZebra) mainModel);
	}

	public void renderZebra(EntityZebra entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderZebra((EntityZebra) entityLiving, x, y, z, u, v);
	}

	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderZebra((EntityZebra) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1) {
		return texture;
	}
}