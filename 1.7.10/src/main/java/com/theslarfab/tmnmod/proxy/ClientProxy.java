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

package com.theslarfab.tmnmod.proxy;

import com.theslarfab.tmnmod.client.model.ModelEnderBullet;
import com.theslarfab.tmnmod.client.model.ModelEnderSlime;
import com.theslarfab.tmnmod.client.model.ModelHippopotamus;
import com.theslarfab.tmnmod.client.model.ModelKangaroo;
import com.theslarfab.tmnmod.client.model.ModelLonghorn;
import com.theslarfab.tmnmod.client.model.ModelZebra;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEndFire;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEndLever;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderBeacon;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderDoublePlant;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderPiston;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderPistonExtension;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderSlimeBlock;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderstoneComparator;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderstoneDiode;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderstoneRepeater;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockEnderstoneWire;
import com.theslarfab.tmnmod.client.renderer.block.RenderBlockTSFTable;
import com.theslarfab.tmnmod.client.renderer.block.inventory.RenderInvBlockEnderDispenser;
import com.theslarfab.tmnmod.client.renderer.entity.RenderEnderBullet;
import com.theslarfab.tmnmod.client.renderer.entity.RenderEnderSlime;
import com.theslarfab.tmnmod.client.renderer.entity.RenderKangaroo;
import com.theslarfab.tmnmod.client.renderer.entity.RenderLonghorn;
import com.theslarfab.tmnmod.client.renderer.entity.RenderZebra;
import com.theslarfab.tmnmod.client.renderer.item.ItemRenderEnderPistol;
import com.theslarfab.tmnmod.client.renderer.item.block.ItemRenderBlockEndWoodChest;
import com.theslarfab.tmnmod.client.renderer.tileentity.TileEntityEndWoodChestRenderer;
import com.theslarfab.tmnmod.client.renderer.tileentity.TileEntityRendererEnderPiston;
import com.theslarfab.tmnmod.entity.EntityKangaroo;
import com.theslarfab.tmnmod.entity.EntityLonghorn;
import com.theslarfab.tmnmod.entity.EntityZebra;
import com.theslarfab.tmnmod.entity.monster.EntityEnderSlime;
import com.theslarfab.tmnmod.entity.projectile.EntityEnderGunBullet;
import com.theslarfab.tmnmod.entity.projectile.EntityEnderSlimeball;
import com.theslarfab.tmnmod.init.TMNBlocks;
import com.theslarfab.tmnmod.init.TMNItems;
import com.theslarfab.tmnmod.tileentity.TileEntityEndWoodChest;
import com.theslarfab.tmnmod.tileentity.TileEntityEnderPiston;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy implements IProxy {

	@Override
	public void registerRenders() {
		// Entity
		RenderingRegistry.registerEntityRenderingHandler(EntityKangaroo.class,
				new RenderKangaroo(new ModelKangaroo(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLonghorn.class,
				new RenderLonghorn(new ModelLonghorn(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZebra.class, new RenderZebra(new ModelZebra(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderSlime.class,
				new RenderEnderSlime(new ModelEnderSlime(0), new ModelEnderSlime(1), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderGunBullet.class,
				new RenderEnderBullet(new ModelEnderBullet(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderSlimeball.class,
				new RenderSnowball(TMNItems.ender_slimeball));

		// Block
		ClientProxy.registerBlockRenderers();

		// Item
		MinecraftForgeClient.registerItemRenderer(TMNItems.ender_pistol, new ItemRenderEnderPistol());

		// Item Block
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TMNBlocks.end_wood_chest),
				new ItemRenderBlockEndWoodChest());
		RenderingRegistry.registerBlockHandler(new RenderInvBlockEnderDispenser());

		// TileEntity
		TileEntitySpecialRenderer renderEndWoodChest = new TileEntityEndWoodChestRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndWoodChest.class, renderEndWoodChest);

		TileEntitySpecialRenderer renderEnderPiston = new TileEntityRendererEnderPiston();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderPiston.class, renderEnderPiston);
		GameRegistry.registerTileEntity(TileEntityEnderPiston.class, "enderPiston");

	}

	public static void registerBlockRenderers() {
		RenderingRegistry.registerBlockHandler(new RenderBlockEndFire());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderstoneWire());
		RenderingRegistry.registerBlockHandler(new RenderBlockTSFTable());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderstoneRepeater());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderPiston());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderstoneComparator());
		RenderingRegistry.registerBlockHandler(new RenderBlockEndLever());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderPistonExtension());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderDoublePlant());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderBeacon());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderSlimeBlock());
		RenderingRegistry.registerBlockHandler(new RenderBlockEnderstoneDiode());
	}
}
