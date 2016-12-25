/**
	Copyright (C) <2016>  <TheSlarFab>

    This file is part of the TheSlarFab TooMuchNature Mod; as such, 
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

package com.slarmods.tmnmod.proxy;

import com.slarmods.tmnmod.client.renderer.entity.RenderHippopotamus;
import com.slarmods.tmnmod.client.renderer.entity.RenderKangaroo;
import com.slarmods.tmnmod.client.renderer.entity.RenderLonghorn;
import com.slarmods.tmnmod.client.renderer.entity.RenderZebra;
import com.slarmods.tmnmod.entity.EntityHippopotamus;
import com.slarmods.tmnmod.entity.EntityKangaroo;
import com.slarmods.tmnmod.entity.EntityLonghorn;
import com.slarmods.tmnmod.entity.EntityZebra;
import com.slarmods.tmnmod.client.model.ModelHippopotamus;
import com.slarmods.tmnmod.client.model.ModelKangaroo;
import com.slarmods.tmnmod.client.model.ModelLonghorn;
import com.slarmods.tmnmod.client.model.ModelZebra;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() {
		// Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityKangaroo.class,
				new RenderKangaroo(new ModelKangaroo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLonghorn.class,
				new RenderLonghorn(new ModelLonghorn(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZebra.class, new RenderZebra(new ModelZebra(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHippopotamus.class,
				new RenderHippopotamus(new ModelHippopotamus(), 0.3F));

		// Blocks

		// Tile Entities
	}
}
