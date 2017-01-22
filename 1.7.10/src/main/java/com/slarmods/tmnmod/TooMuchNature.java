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

package com.slarmods.tmnmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.slarmods.tmnmod.block.TMNBlocks;
import com.slarmods.tmnmod.command.server.CommandSummonTMN;
import com.slarmods.tmnmod.crafting.TMNCrafting;
import com.slarmods.tmnmod.creativetabs.TabTMNBlocks;
import com.slarmods.tmnmod.creativetabs.TabTMNDecoBlocks;
import com.slarmods.tmnmod.creativetabs.TabTMNEnderstone;
import com.slarmods.tmnmod.creativetabs.TabTMNItems;
import com.slarmods.tmnmod.creativetabs.TabTMNWeapons;
import com.slarmods.tmnmod.entity.EntityHippopotamus;
import com.slarmods.tmnmod.entity.EntityKangaroo;
import com.slarmods.tmnmod.entity.EntityLonghorn;
import com.slarmods.tmnmod.entity.EntityZebra;
import com.slarmods.tmnmod.entity.list.TMNEntityList;
import com.slarmods.tmnmod.entity.projectile.EntityEnderGunBullet;
import com.slarmods.tmnmod.gui.GuiRegistry;
import com.slarmods.tmnmod.handler.GuiHandler;
import com.slarmods.tmnmod.item.TMNItems;
import com.slarmods.tmnmod.proxy.CommonProxy;
import com.slarmods.tmnmod.world.biome.BiomesTMN;
import com.slarmods.tmnmod.world.biome.EnderBiomes;
import com.slarmods.tmnmod.world.gen.TMNWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;

@Mod(modid = TooMuchNature.modid, version = TooMuchNature.version)
public class TooMuchNature {

	public static final CreativeTabs tabTooMuchNatureBlocks = new TabTMNBlocks("tmnblocks");
	public static final CreativeTabs tabTooMuchNatureDecoBlocks = new TabTMNDecoBlocks("tmndecoblocks");
	public static final CreativeTabs tabTooMuchNatureItems = new TabTMNItems("tmnitems");
	public static final CreativeTabs tabTooMuchNatureMisc = new TabTMNWeapons("tmnmisc");
	public static final CreativeTabs tabEnderstone = new TabTMNEnderstone("tmnenderstone");

	public static final Logger logger = LogManager.getLogger(TooMuchNature.modid);

	@Instance(TooMuchNature.modid)
	public static TooMuchNature instance;

	/** Armor Materials */
	public static final ArmorMaterial KangarooArmorMaterial = EnumHelper.addArmorMaterial("KangarooArmorMaterial", 14,
			new int[] { 2, 5, 4, 2 }, 10);

	/** Tool Materials */
	public static final ToolMaterial ENDERALD = EnumHelper.addToolMaterial("ENDERALD", 3, 1000, 15.0F, 4.0F, 30);

	// GUI IDs
	public static final int guiIDEnderWorkbench = GuiRegistry.getNextAvailableGuiID();

	public static final String modid = "tmn";
	public static final String version = "v1.0-b1";

	@SidedProxy(clientSide = "com.slarmods.tmnmod.proxy.ClientProxy", serverSide = "com.slarmods.tmnmod.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TMNBlocks.init();
		TMNItems.init();

		// GUI Handlers
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		// Smelting Registers
		GameRegistry.addSmelting(TMNItems.raw_kangaroo, new ItemStack(TMNItems.cooked_kangaroo, 1), 5);

		// Biome Registers
		BiomesTMN.init();
		EnderBiomes.init();

		// Entity Registers
		int modEntityID = 0;
		EntityRegistry.registerModEntity(EntityKangaroo.class, "kangaroo", ++modEntityID, this.instance, 80, 3, false);
		EntityRegistry.registerModEntity(EntityLonghorn.class, "texas_longhorn", ++modEntityID, this.instance, 80, 3,
				false);
		EntityRegistry.registerModEntity(EntityZebra.class, "zebra", ++modEntityID, this.instance, 80, 3, false);
		EntityRegistry.registerModEntity(EntityHippopotamus.class, "hippo", ++modEntityID, this.instance, 80, 3, false);
		EntityRegistry.registerModEntity(EntityEnderGunBullet.class, "ender_gun_bullet", ++modEntityID, this.instance,
				80, 3, false);

		// Spawn Egg Registers
		TMNEntityList.addMapping(EntityKangaroo.class, "kangaroo", 0x558299, 0x997256);
		TMNEntityList.addMapping(EntityLonghorn.class, "texas_longhorn", 0xEB7900, 0xADADAD);
		TMNEntityList.addMapping(EntityZebra.class, "zebra", 0xFFFFFF, 0x212121);
		TMNEntityList.addMapping(EntityHippopotamus.class, "hippo", 0xBB9FC4, 0x8E7B94);
		TMNEntityList.addMapping(EntityEnderGunBullet.class, "ender_bullet");

		// WorldGen Registers
		GameRegistry.registerWorldGenerator(new TMNWorldGen(), 0);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Proxy
		proxy.registerRenders();

		// Recipes
		TMNCrafting.register();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Entity Spawning
		EntityRegistry.addSpawn(EntityLonghorn.class, 6, 3, 4, EnumCreatureType.creature, BiomeGenBase.plains);

		EntityRegistry.addSpawn(EntityZebra.class, 7, 3, 5, EnumCreatureType.creature, BiomeGenBase.savanna,
				BiomeGenBase.savannaPlateau);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		// Server Command Registers
		event.registerServerCommand(new CommandSummonTMN());
	}
}
