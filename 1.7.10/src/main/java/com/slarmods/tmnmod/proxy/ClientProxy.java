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

import com.slarmods.tmnmod.client.renderer.block.RenderBlockEndFire;
import com.slarmods.tmnmod.client.renderer.block.RenderBlockEndLever;
import com.slarmods.tmnmod.client.renderer.block.RenderBlockEndPlanksTable;
import com.slarmods.tmnmod.client.renderer.block.RenderBlockEnderPiston;
import com.slarmods.tmnmod.client.renderer.block.RenderBlockEnderPistonExtension;
import com.slarmods.tmnmod.client.renderer.block.RenderBlockEnderstoneComparator;
import com.slarmods.tmnmod.client.renderer.block.RenderBlockEnderstoneRepeater;
import com.slarmods.tmnmod.client.renderer.block.RenderBlockEnderstoneWire;
import com.slarmods.tmnmod.client.renderer.entity.RenderEnderBullet;
import com.slarmods.tmnmod.client.renderer.entity.RenderHippopotamus;
import com.slarmods.tmnmod.client.renderer.entity.RenderKangaroo;
import com.slarmods.tmnmod.client.renderer.entity.RenderLonghorn;
import com.slarmods.tmnmod.client.renderer.entity.RenderZebra;
import com.slarmods.tmnmod.client.renderer.item.ItemRenderEnderPistol;
import com.slarmods.tmnmod.client.renderer.item.block.ItemBlockEndWoodTableRenderer;
import com.slarmods.tmnmod.client.renderer.item.block.ItemRenderBlockEndWoodChest;
import com.slarmods.tmnmod.client.renderer.item.block.ItemRenderEnderPiston;
import com.slarmods.tmnmod.client.renderer.tileentity.TileEntityEndWoodChestRenderer;
import com.slarmods.tmnmod.client.renderer.tileentity.TileEntityRendererEnderPiston;
import com.slarmods.tmnmod.entity.EntityHippopotamus;
import com.slarmods.tmnmod.entity.EntityKangaroo;
import com.slarmods.tmnmod.entity.EntityLonghorn;
import com.slarmods.tmnmod.entity.EntityZebra;
import com.slarmods.tmnmod.entity.projectile.EntityEnderGunBullet;
import com.slarmods.tmnmod.tileentity.TileEntityEndWoodChest;
import com.slarmods.tmnmod.tileentity.TileEntityEnderPiston;
import com.slarmods.tmnmod.TooMuchNature;
import com.slarmods.tmnmod.client.model.ModelEnderBullet;
import com.slarmods.tmnmod.client.model.ModelHippopotamus;
import com.slarmods.tmnmod.client.model.ModelKangaroo;
import com.slarmods.tmnmod.client.model.ModelLonghorn;
import com.slarmods.tmnmod.client.model.ModelZebra;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() {
		// Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityKangaroo.class,
				new RenderKangaroo(new ModelKangaroo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLonghorn.class,
				new RenderLonghorn(new ModelLonghorn(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZebra.class, new RenderZebra(new ModelZebra(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHippopotamus.class,
				new RenderHippopotamus(new ModelHippopotamus(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderGunBullet.class,
				new RenderEnderBullet(new ModelEnderBullet(), 0.3F));

		// Block
		RenderingRegistry.registerBlockHandler(new RenderBlockEndFire());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderstoneWire());
		RenderingRegistry.registerBlockHandler(new RenderBlockEndPlanksTable());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderstoneRepeater());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderPiston());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderstoneComparator());
		RenderingRegistry.registerBlockHandler(new RenderBlockEndLever());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderPistonExtension());

		// Item
		MinecraftForgeClient.registerItemRenderer(TooMuchNature.ender_pistol, new ItemRenderEnderPistol());

		// Item Block
		
		// TileEntity
		TileEntitySpecialRenderer renderEndWoodChest = new TileEntityEndWoodChestRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndWoodChest.class, renderEndWoodChest);

		TileEntitySpecialRenderer renderEnderPiston = new TileEntityRendererEnderPiston();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderPiston.class, renderEnderPiston);
		GameRegistry.registerTileEntity(TileEntityEnderPiston.class, "enderPiston");

	}
}
