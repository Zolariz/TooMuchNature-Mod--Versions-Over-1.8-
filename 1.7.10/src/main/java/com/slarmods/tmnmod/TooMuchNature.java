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

package com.slarmods.tmnmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.slarmods.tmnmod.armor.KangarooArmor;
import com.slarmods.tmnmod.block.BlockCherryDoor;
import com.slarmods.tmnmod.block.BlockCherryFence;
import com.slarmods.tmnmod.block.BlockCherryFenceGate;
import com.slarmods.tmnmod.block.BlockCherryLeaf;
import com.slarmods.tmnmod.block.BlockCherryLog;
import com.slarmods.tmnmod.block.BlockCherrySapling;
import com.slarmods.tmnmod.block.BlockCherrySlab;
import com.slarmods.tmnmod.block.BlockCherryStairs;
import com.slarmods.tmnmod.block.BlockCherryWood;
import com.slarmods.tmnmod.block.BlockCherryGrass;
import com.slarmods.tmnmod.block.BlockCherryCrops;
import com.slarmods.tmnmod.command.server.CommandSummonTMN;
import com.slarmods.tmnmod.crafting.TMNCrafting;
import com.slarmods.tmnmod.entity.EntityHippopotamus;
import com.slarmods.tmnmod.entity.EntityKangaroo;
import com.slarmods.tmnmod.entity.EntityLonghorn;
import com.slarmods.tmnmod.entity.EntityZebra;
import com.slarmods.tmnmod.entity.list.TMNEntityList;
import com.slarmods.tmnmod.item.ItemBlockCherryLeaf;
import com.slarmods.tmnmod.item.ItemBlockCherryLog;
import com.slarmods.tmnmod.item.ItemBlockCherrySapling;
import com.slarmods.tmnmod.item.ItemBlockCherrySlab;
import com.slarmods.tmnmod.item.ItemCherryDoor;
import com.slarmods.tmnmod.item.spawnegg.ItemTMNSpawnEgg;
import com.slarmods.tmnmod.proxy.CommonProxy;
import com.slarmods.tmnmod.world.biome.BiomesTMN;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = TooMuchNature.modid, version = TooMuchNature.version)
public class TooMuchNature {

	public static final Logger logger = LogManager.getLogger(TooMuchNature.modid);

	@Instance(TooMuchNature.modid)
	public static TooMuchNature instance;

	public static CreativeTabs tabTooMuchNatureBlocks;
	public static CreativeTabs tabTooMuchNatureItems;
	public static CreativeTabs tabTooMuchNatureMobs;

	public static ArmorMaterial KangarooArmorMaterial = EnumHelper.addArmorMaterial("KangarooArmorMaterial", 14,
			new int[] { 2, 5, 4, 2 }, 10);

	// Items
	public static Item orange;
	public static Item cherry;
	public static Item raw_kangaroo;
	public static Item cooked_kangaroo;
	public static Item white_cherry;

	public static Item kangaroo_skin;

	public static Item kangaroo_helm;
	public static Item kangaroo_chest;
	public static Item kangaroo_leggings;
	public static Item kangaroo_boots;

	public static int kangaroo_helm_ID;
	public static int kangaroo_chest_ID;
	public static int kangaroo_leggings_ID;
	public static int kangaroo_boots_ID;

	public static Item item_cherry_door;

	public static Item item_spruce_door;
	public static Item item_birch_door;
	public static Item item_jungle_door;
	public static Item item_acacia_door;
	public static Item item_dark_oak_door;

	public static Item tmn_spawn_egg;

	public static Item cherry_seeds;

	// Blocks
	public static Block cherry_log;
	public static Block cherry_leaf;
	public static Block cherry_sapling;

	public static Block cherry_planks;
	public static Block cherry_double_slab;
	public static Block cherry_slab;
	public static Block cherry_stairs;
	public static Block cherry_fence;
	public static Block cherry_fence_gate;
	public static Block cherry_door_block;

	public static Block paeonia_flower;

	public static Block spruce_fence;
	public static Block birch_fence;
	public static Block jungle_fence;
	public static Block acacia_fence;
	public static Block dark_oak_fence;

	public static Block spruce_fence_gate;
	public static Block birch_fence_gate;
	public static Block jungle_fence_gate;
	public static Block acacia_fence_gate;
	public static Block dark_oak_fence_gate;

	public static Block spruce_door;
	public static Block birch_door;
	public static Block jungle_door;
	public static Block acacia_door;
	public static Block dark_oak_door;

	public static Block crops_cherry;

	public static Block cherry_grass;

	public static final String modid = "tmn";
	public static final String version = "Alpha v0.1";

	@SidedProxy(clientSide = "com.slarmods.tmnmod.proxy.ClientProxy", serverSide = "com.slarmods.tmnmod.proxy.CommonProxy")
	public static CommonProxy proxy;

	private int modEntityID;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		// Creative Tabs
		tabTooMuchNatureBlocks = new CreativeTabs("tmnblocks") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(TooMuchNature.cherry_sapling);
			}
		};

		tabTooMuchNatureItems = new CreativeTabs("tmnitems") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return TooMuchNature.cherry;
			}
		};

		tabTooMuchNatureMobs = new CreativeTabs("tmnmobs") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return TooMuchNature.tmn_spawn_egg;
			}
		};

		// Items
		kangaroo_skin = new Item().setUnlocalizedName("kangaroo_skin")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "kangaroo_hide");

		item_cherry_door = new ItemCherryDoor(Material.wood).setUnlocalizedName("cherry_door")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_door");

		// Blocks
		cherry_log = new BlockCherryLog(Material.wood).setBlockName("log_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks);
		cherry_leaf = new BlockCherryLeaf(Material.leaves).setBlockName("cherry_leaf")
				.setCreativeTab(tabTooMuchNatureBlocks).setBlockTextureName(TooMuchNature.modid + ":" + "leaves");
		cherry_sapling = new BlockCherrySapling().setBlockName("cherry_sapling")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "sapling").setStepSound(Block.soundTypeGrass);

		cherry_planks = new BlockCherryWood(Material.wood).setBlockName("cherry_planks")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);

		cherry_double_slab = new BlockCherrySlab(Material.wood, true).setBlockName("double_cherry_slab")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);

		cherry_slab = new BlockCherrySlab(Material.wood, false).setBlockName("cherry_slab")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);

		cherry_fence = new BlockCherryFence(TooMuchNature.modid + ":" + "planks_cherry", Material.wood)
				.setHardness(2.0F).setResistance(5.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setStepSound(Block.soundTypeWood).setBlockName("cherry_fence");

		cherry_fence_gate = new BlockCherryFenceGate().setHardness(2.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypeWood).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockName("cherry_fence_gate").setBlockTextureName(TooMuchNature.modid + ":" + "planks");

		cherry_door_block = new BlockCherryDoor(Material.wood).setBlockName("door_cherry")
				.setStepSound(Block.soundTypeWood).setHardness(3.0F);

		Block blockWood = new BlockCherryWood(Material.wood).setHardness(2.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("wood").setBlockTextureName("planks");
		cherry_stairs = new BlockCherryStairs(blockWood, 0).setBlockName("cherry_stairs")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks");

		crops_cherry = new BlockCherryCrops().setBlockName("cherries").setStepSound(Block.soundTypeGrass);

		cherry_grass = new BlockCherryGrass().setBlockName("cherry_flower_grass")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks).setStepSound(Block.soundTypeGrass);

		// Seeds
		cherry_seeds = new ItemSeeds(crops_cherry, Blocks.farmland).setUnlocalizedName("seeds_cherry")
				.setTextureName(TooMuchNature.modid + ":" + "seeds_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems);

		// Food
		orange = new ItemFood(4, 0.5F, false).setUnlocalizedName("orange")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems).setTextureName(TooMuchNature.modid + ":orange");
		cherry = new ItemFood(2, 0.4F, false).setUnlocalizedName("cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems).setTextureName(TooMuchNature.modid + ":cherry");
		raw_kangaroo = new ItemFood(5, 0.5F, true).setUnlocalizedName("raw_kangaroo")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":kangaroo_meat_raw");
		cooked_kangaroo = new ItemFood(12, 0.8F, true).setUnlocalizedName("cooked_kangaroo")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":kangaroo_meat_cooked");
		white_cherry = new ItemFood(2, 0.3F, false).setUnlocalizedName("white_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":cherry_white");

		// Armor
		kangaroo_helm = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 0)
				.setUnlocalizedName("kangaroo_helmet");
		kangaroo_chest = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 1)
				.setUnlocalizedName("kangaroo_chestplate");
		kangaroo_leggings = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 2)
				.setUnlocalizedName("kangaroo_leggings");
		kangaroo_boots = new KangarooArmor(KangarooArmorMaterial, kangaroo_helm_ID, 3)
				.setUnlocalizedName("kangaroo_boots");

		// Spawn Eggs
		tmn_spawn_egg = new ItemTMNSpawnEgg().setUnlocalizedName("tmn_spawn_egg");

		// Registers
		// Items
		GameRegistry.registerItem(orange, orange.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cherry, cherry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(raw_kangaroo, raw_kangaroo.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cooked_kangaroo, cooked_kangaroo.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(white_cherry, white_cherry.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(kangaroo_skin, kangaroo_skin.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(kangaroo_helm, kangaroo_helm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_chest, kangaroo_chest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_leggings, kangaroo_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_boots, kangaroo_boots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(item_cherry_door, item_cherry_door.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(tmn_spawn_egg, tmn_spawn_egg.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(cherry_seeds, cherry_seeds.getUnlocalizedName().substring(5));

		// Blocks
		GameRegistry.registerBlock(cherry_log, ItemBlockCherryLog.class, cherry_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_leaf, ItemBlockCherryLeaf.class,
				cherry_leaf.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_sapling, ItemBlockCherrySapling.class,
				cherry_sapling.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(cherry_planks, cherry_planks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_double_slab, ItemBlockCherrySlab.class,
				cherry_double_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_slab, ItemBlockCherrySlab.class,
				cherry_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_fence, cherry_fence.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_fence_gate, cherry_fence_gate.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_door_block, cherry_door_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_stairs, cherry_stairs.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(crops_cherry, crops_cherry.getUnlocalizedName());

		GameRegistry.registerBlock(cherry_grass, cherry_grass.getUnlocalizedName().substring(5));

		// Smelting
		GameRegistry.addSmelting(TooMuchNature.raw_kangaroo, new ItemStack(TooMuchNature.cooked_kangaroo, 1), 5);

		// Biomes
		BiomesTMN.init();

		// Entities
		EntityRegistry.registerModEntity(EntityKangaroo.class, "kangaroo", ++modEntityID, TooMuchNature.instance, 80, 3,
				false);
		EntityRegistry.registerModEntity(EntityLonghorn.class, "texas_longhorn", ++modEntityID, TooMuchNature.instance,
				80, 3, false);

		EntityRegistry.registerModEntity(EntityZebra.class, "zebra", ++modEntityID, TooMuchNature.instance, 80, 3,
				false);

		EntityRegistry.registerModEntity(EntityHippopotamus.class, "hippo", ++modEntityID, TooMuchNature.instance, 80,
				3, false);

		// Spawn Eggs
		TMNEntityList.addMapping(EntityKangaroo.class, "kangaroo", 0x000000, 0xFFFFFF);
		TMNEntityList.addMapping(EntityLonghorn.class, "texas_longhorn", 0xEB7900, 0xADADAD);
		TMNEntityList.addMapping(EntityZebra.class, "zebra", 0xFFFFFF, 0x212121);
		TMNEntityList.addMapping(EntityHippopotamus.class, "hippo", 0xBB9FC4, 0x8E7B94);
		TMNEntityList.addMapping(EntitySheep.class, "buffalo", 0x000000, 0xFFFFFF);
		TMNEntityList.addMapping(EntityPig.class, "bear", 0x000000, 0xFFFFFF);
		TMNEntityList.addMapping(EntityCow.class, "electrical_eel", 0x000000, 0xFFFFFF);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
		TMNCrafting.register();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Entity Spawning
		EntityRegistry.addSpawn(EntityLonghorn.class, 10, 3, 9, EnumCreatureType.creature, BiomeGenBase.plains,
				BiomeGenBase.forest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomesTMN.cherryForest);

		EntityRegistry.addSpawn(EntityZebra.class, 7, 3, 5, EnumCreatureType.creature, BiomeGenBase.savanna,
				BiomeGenBase.savannaPlateau, BiomesTMN.cherryForest);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		// Commands
		event.registerServerCommand(new CommandSummonTMN());
	}

	@EventHandler
	public void serverStarted(FMLServerStartedEvent event) {

	}
}