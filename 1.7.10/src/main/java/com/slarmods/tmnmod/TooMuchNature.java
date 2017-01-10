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
import com.slarmods.tmnmod.block.BlockEndDirt;
import com.slarmods.tmnmod.block.BlockEndFire;
import com.slarmods.tmnmod.block.BlockEndGrass;
import com.slarmods.tmnmod.block.BlockEndObsidian;
import com.slarmods.tmnmod.block.BlockEndStoneBrick;
import com.slarmods.tmnmod.block.BlockEndStoneBrickStairs;
import com.slarmods.tmnmod.block.BlockEndStoneSlab;
import com.slarmods.tmnmod.block.BlockEndWood;
import com.slarmods.tmnmod.block.BlockEndWoodChest;
import com.slarmods.tmnmod.block.BlockEndWoodTable;
import com.slarmods.tmnmod.block.BlockEnderWaterDynamic;
import com.slarmods.tmnmod.block.BlockEnderWaterStatic;
import com.slarmods.tmnmod.block.BlockEnderaldOre;
import com.slarmods.tmnmod.block.BlockEnderstoneRepeater;
import com.slarmods.tmnmod.block.BlockEnderstoneWire;
import com.slarmods.tmnmod.block.BlockLowerEndPortal;
import com.slarmods.tmnmod.block.BlockMossyEndStoneBrickStairs;
import com.slarmods.tmnmod.block.BlockSmoothEndStone;
import com.slarmods.tmnmod.block.BlockCherryGrass;
import com.slarmods.tmnmod.block.BlockCherryCrops;
import com.slarmods.tmnmod.command.server.CommandSummonTMN;
import com.slarmods.tmnmod.crafting.TMNCrafting;
import com.slarmods.tmnmod.creativetabs.TMNCreativeTabs;
import com.slarmods.tmnmod.entity.EntityHippopotamus;
import com.slarmods.tmnmod.entity.EntityKangaroo;
import com.slarmods.tmnmod.entity.EntityLonghorn;
import com.slarmods.tmnmod.entity.EntityZebra;
import com.slarmods.tmnmod.entity.list.TMNEntityList;
import com.slarmods.tmnmod.entity.projectile.EntityEnderGunBullet;
import com.slarmods.tmnmod.item.ItemAcaciaDoor;
import com.slarmods.tmnmod.item.ItemBirchDoor;
import com.slarmods.tmnmod.item.ItemBlockCherryLeaf;
import com.slarmods.tmnmod.item.ItemBlockCherryLog;
import com.slarmods.tmnmod.item.ItemBlockCherryPlanks;
import com.slarmods.tmnmod.item.ItemBlockCherrySapling;
import com.slarmods.tmnmod.item.ItemBlockCherrySlab;
import com.slarmods.tmnmod.item.ItemBlockEndStoneBrick;
import com.slarmods.tmnmod.item.ItemBlockEndStoneSlab;
import com.slarmods.tmnmod.item.ItemBlockEndWoodPlanks;
import com.slarmods.tmnmod.item.ItemCherryDoor;
import com.slarmods.tmnmod.item.ItemDarkOakDoor;
import com.slarmods.tmnmod.item.ItemEndWoodTable;
import com.slarmods.tmnmod.item.ItemEnderGun;
import com.slarmods.tmnmod.item.ItemEnderstone;
import com.slarmods.tmnmod.item.ItemFlintAndEndstone;
import com.slarmods.tmnmod.item.ItemJungleDoor;
import com.slarmods.tmnmod.item.ItemSpruceDoor;
import com.slarmods.tmnmod.item.ItemTMNBucket;
import com.slarmods.tmnmod.item.spawnegg.ItemTMNSpawnEgg;
import com.slarmods.tmnmod.proxy.CommonProxy;
import com.slarmods.tmnmod.tileentity.TileEntityEndWoodChest;
import com.slarmods.tmnmod.tileentity.TileEntityEndWoodTable;
import com.slarmods.tmnmod.world.DimensionIDs;
import com.slarmods.tmnmod.world.WorldProviderEnderlands;
import com.slarmods.tmnmod.world.biome.BiomesTMN;
import com.slarmods.tmnmod.world.biome.EnderBiomes;
import com.slarmods.tmnmod.world.gen.TMNWorldGen;
import com.slarmods.tmnmod.world.teleporter.EnderlandsDimensionTeleporter;

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
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.world.BlockEvent;

@Mod(modid = TooMuchNature.modid, version = TooMuchNature.version)
public class TooMuchNature {

	public static final Logger logger = LogManager.getLogger(TooMuchNature.modid);

	@Instance(TooMuchNature.modid)
	public static TooMuchNature instance;

	/** Creative Tabs */
	public static CreativeTabs tabTooMuchNatureBlocks;
	public static CreativeTabs tabTooMuchNatureDecoBlocks;
	public static CreativeTabs tabTooMuchNatureItems;
	public static CreativeTabs tabTooMuchNatureMobs;
	public static CreativeTabs tabTooMuchNatureWeapons;

	/** Armor Materials */
	public static ArmorMaterial KangarooArmorMaterial = EnumHelper.addArmorMaterial("KangarooArmorMaterial", 14,
			new int[] { 2, 5, 4, 2 }, 10);

	/** Blocks */
	// Food Items
	public static Item orange;
	public static Item cherry;
	public static Item raw_kangaroo;
	public static Item cooked_kangaroo;
	public static Item white_cherry;

	// Mob Drop Items
	public static Item kangaroo_skin;

	// Functional Items
	public static Item flint_and_endstone;
	public static Item tmn_spawn_egg;

	// Basic Items 1
	public static Item ruby;
	public static Item sapphire;
	public static Item titanium_ingot;
	public static Item platinum_ingot;
	public static Item enderald;

	// Fluid Items
	public static Item ender_water_bucket;

	// Door Items
	public static Item item_cherry_door;
	public static Item item_spruce_door;
	public static Item item_birch_door;
	public static Item item_jungle_door;
	public static Item item_acacia_door;
	public static Item item_dark_oak_door;
	public static Item item_ender_door;

	// Crop Seeds
	public static Item cherry_seeds;

	// Circuit Item
	public static Item enderstone_dust;
	public static Item enderstone_repeater;
	public static Item enderstone_comparator;

	public static Item enderald_bucket;

	// Armor Item
	public static Item kangaroo_helm;
	public static Item kangaroo_chest;
	public static Item kangaroo_leggings;
	public static Item kangaroo_boots;

	// Armor ID
	public static int kangaroo_helm_ID;
	public static int kangaroo_chest_ID;
	public static int kangaroo_leggings_ID;
	public static int kangaroo_boots_ID;

	// Shooting Weapons
	public static Item ender_pistol;

	// Melee Weapons
	public static Item enderald_sword;

	/** Blocks */
	// Ore Blocks
	public static Block enderald_ore;
	public static Block ruby_ore;
	public static Block sapphire_ore;

	// Basic Blocks
	public static Block enderald_block;
	public static Block ruby_block;

	// Tree Blocks
	public static Block cherry_log;
	public static Block cherry_leaf;
	public static Block cherry_sapling;

	// Cherry Wood Blocks
	public static Block cherry_planks;
	public static Block cherry_double_slab;
	public static Block cherry_slab;
	public static Block cherry_stairs;
	public static Block cherry_fence;
	public static Block cherry_fence_gate;
	public static Block cherry_door_block;

	// Fence | Fence Gate Blocks
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

	// Door Blocks
	public static Block spruce_door;
	public static Block birch_door;
	public static Block jungle_door;
	public static Block acacia_door;
	public static Block dark_oak_door;

	// Crop Blocks
	public static Block crops_cherry;

	// Enderlands Dimension Blocks
	public static Block cherry_grass;
	public static Block end_obsidian;
	public static Block end_stone_smooth;
	public static Block end_fire;
	public static Block lower_end_portal;
	public static Block end_grass;
	public static Block end_dirt;
	public static Block ender_water_dynamic;
	public static Block ender_water_static;
	public static Block end_stone_double_slab;
	public static Block end_stone_slab;
	public static Block end_stone_bricks;
	public static Block end_stone_brick_stairs;
	public static Block mossy_end_stone_brick_stairs;
	public static Block end_wood_table;
	public static Block end_wood_planks;

	// Circuit Blocks
	public static Block enderstone_wire;
	public static Block enderstone_block;
	public static Block enderstone_torch;
	public static Block enderstone_repeater_unpowered;
	public static Block enderstone_repeater_powered;

	public static Block end_wood_chest;

	private int modEntityID;
	private int chestBlockID;

	public static final String modid = "tmn";
	public static final String version = "v1.0-b1";

	@SidedProxy(clientSide = "com.slarmods.tmnmod.proxy.ClientProxy", serverSide = "com.slarmods.tmnmod.proxy.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		// Creative Tabs
		tabTooMuchNatureBlocks = new CreativeTabs("tmnblocks") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(TooMuchNature.cherry_log);
			}
		};

		tabTooMuchNatureDecoBlocks = new CreativeTabs("tmndecoblocks") {
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

		tabTooMuchNatureWeapons = new CreativeTabs("tmnweapons") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return TooMuchNature.ender_pistol;
			}
		};

		// Animal Items
		kangaroo_skin = new Item().setUnlocalizedName("kangaroo_skin")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "kangaroo_hide");

		// Door Items
		item_cherry_door = new ItemCherryDoor(Material.wood).setUnlocalizedName("cherry_door")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_spruce_door = new ItemSpruceDoor(Material.wood).setUnlocalizedName("spruce_door")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_birch_door = new ItemBirchDoor(Material.wood).setUnlocalizedName("birch_door")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_jungle_door = new ItemJungleDoor(Material.wood).setUnlocalizedName("jungle_door")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_acacia_door = new ItemAcaciaDoor(Material.wood).setUnlocalizedName("acacia_door")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_door");
		item_dark_oak_door = new ItemDarkOakDoor(Material.wood).setUnlocalizedName("dark_oak_door")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_door");

		// Dimension-Related Items
		flint_and_endstone = new ItemFlintAndEndstone().setUnlocalizedName("flint_and_endstone")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "flint_and_endstone");

		// Items
		ruby = new Item().setUnlocalizedName("ruby").setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName("ruby");

		sapphire = new Item().setUnlocalizedName("sapphire").setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "sapphire");

		titanium_ingot = new Item().setUnlocalizedName("titanium_ingot")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "titanium_ingot");

		platinum_ingot = new Item().setUnlocalizedName("platinum_ingot")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "platinum_ingot");

		enderald = new Item().setUnlocalizedName("enderald").setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "enderald");

		// Circuit Items
		enderstone_dust = new ItemEnderstone().setUnlocalizedName("enderstone_dust")
				.setTextureName(TooMuchNature.modid + ":" + "enderstone_dust");

		// Functional Items
		ender_water_bucket = new ItemTMNBucket(TooMuchNature.ender_water_dynamic)
				.setUnlocalizedName("ender_water_bucket").setTextureName("stick");
		enderald_bucket = new ItemTMNBucket(Blocks.air).setUnlocalizedName("enderald_bucket").setTextureName("bucket");

		// Weapons
		ender_pistol = new ItemEnderGun().setUnlocalizedName("ender_gun").setTextureName(TooMuchNature.modid + ":" + "ender_pistol");

		// Trees
		cherry_log = new BlockCherryLog(Material.wood).setBlockName("log_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "log");
		cherry_leaf = new BlockCherryLeaf(Material.leaves).setBlockName("cherry_leaf")
				.setCreativeTab(tabTooMuchNatureBlocks).setBlockTextureName(TooMuchNature.modid + ":" + "leaves");
		cherry_sapling = new BlockCherrySapling().setBlockName("cherry_sapling")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "sapling").setStepSound(Block.soundTypeGrass);

		// Wood Blocks
		cherry_planks = new BlockCherryWood(Material.wood).setBlockName("cherry_planks")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);
		cherry_double_slab = new BlockCherrySlab(Material.wood, true).setBlockName("double_cherry_slab")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);
		cherry_slab = new BlockCherrySlab(Material.wood, false).setBlockName("cherry_slab")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks").setStepSound(Block.soundTypeWood);
		cherry_fence = new BlockCherryFence(TooMuchNature.modid + ":" + "planks_cherry", Material.wood)
				.setHardness(2.0F).setResistance(5.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setStepSound(Block.soundTypeWood).setBlockName("cherry_fence");
		cherry_fence_gate = new BlockCherryFenceGate().setHardness(2.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypeWood).setCreativeTab(TooMuchNature.tabTooMuchNatureDecoBlocks)
				.setBlockName("cherry_fence_gate").setBlockTextureName(TooMuchNature.modid + ":" + "planks");
		Block blockWood = new BlockCherryWood(Material.wood).setHardness(2.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("wood").setBlockTextureName("planks");
		cherry_stairs = new BlockCherryStairs(blockWood, 0).setBlockName("cherry_stairs")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks");

		// Door Blocks
		cherry_door_block = new BlockCherryDoor(Material.wood).setBlockName("door_cherry")
				.setStepSound(Block.soundTypeWood).setHardness(3.0F)
				.setBlockTextureName(TooMuchNature.modid + ":" + "door_cherry");

		// Crops
		crops_cherry = new BlockCherryCrops().setBlockName("cherries").setStepSound(Block.soundTypeGrass);

		// Dimension-Related Blocks
		cherry_grass = new BlockCherryGrass(Material.grass).setBlockName("cherry_flower_grass").setHardness(0.6F)
				.setStepSound(Block.soundTypeGrass);
		end_obsidian = new BlockEndObsidian(Material.rock).setBlockName("end_obsidian").setHardness(50.0F)
				.setResistance(2000.0F).setStepSound(Block.soundTypePiston)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_obsidian");
		end_stone_smooth = new BlockSmoothEndStone().setBlockName("smooth_end_stone").setHardness(1.5F)
				.setResistance(10.0F).setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_smooth");
		end_fire = new BlockEndFire(Material.fire).setBlockName("end_fire")
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_fire");
		lower_end_portal = new BlockLowerEndPortal().setBlockName("lower_end_portal").setBlockUnbreakable()
				.setLightLevel(0.75F).setStepSound(Block.soundTypeGlass)
				.setBlockTextureName(TooMuchNature.modid + ":" + "lower_end_portal");
		end_grass = new BlockEndGrass(Material.grass).setBlockName("end_grass").setHardness(0.6F)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks).setStepSound(Block.soundTypeGrass)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_grass");
		end_dirt = new BlockEndDirt(Material.ground).setBlockName("end_dirt").setHardness(0.5F)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks).setStepSound(Block.soundTypeGravel)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_dirt");
		end_stone_double_slab = new BlockEndStoneSlab(true).setBlockName("end_stone_double_slab").setHardness(1.5F)
				.setResistance(10.0F).setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_smooth_slab");
		end_stone_slab = new BlockEndStoneSlab(false).setBlockName("end_stone_slab").setHardness(1.5F)
				.setResistance(10.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_smooth_slab");
		end_stone_bricks = new BlockEndStoneBrick().setBlockName("end_stone_brick").setHardness(1.5F)
				.setResistance(10.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_bricks");
		Block blockEndStoneBrick = new BlockEndStoneBrick().setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundTypeStone).setBlockName("stonebrick").setBlockTextureName("end_stone_bricks");
		end_stone_brick_stairs = new BlockEndStoneBrickStairs(blockEndStoneBrick, 0)
				.setBlockName("end_stone_brick_stairs")
				.setBlockTextureName(TooMuchNature.modid + ":" + "end_stone_bricks");
		end_wood_table = new BlockEndWoodTable(Material.wood).setBlockName("end_wood_table")
				.setBlockTextureName(TooMuchNature.modid + ":" + "planks");

		end_wood_planks = new BlockEndWood(Material.wood).setBlockName("end_wood_planks")
				.setStepSound(Block.soundTypeWood).setBlockTextureName(TooMuchNature.modid + ":" + "planks");

		// Blocks
		enderald_block = new BlockCompressed(MapColor.cyanColor).setBlockName("enderald_block").setHardness(5.0F)
				.setResistance(10.0F).setStepSound(Block.soundTypeMetal)
				.setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(modid + ":" + "enderald_block");

		enderald_ore = new BlockEnderaldOre(Material.rock).setBlockName("enderald_ore").setHardness(3.0F)
				.setResistance(5.0F).setCreativeTab(TooMuchNature.tabTooMuchNatureBlocks)
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderald_ore");

		// Liquid Blocks
		ender_water_dynamic = new BlockEnderWaterDynamic(Material.water).setBlockName("ender_water_flow");
		ender_water_static = new BlockEnderWaterStatic(Material.water).setBlockName("ender_water_still");

		// Circuit Blocks
		enderstone_wire = new BlockEnderstoneWire().setBlockName("enderstone_wire").setBlockTextureName("redstone_dust")
				.setHardness(0.0F).setResistance(0.0F);

		enderstone_repeater_unpowered = new BlockEnderstoneRepeater(false).setBlockName("enderstone_repeater_unlit")
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_repeater_off");
		enderstone_repeater_powered = new BlockEnderstoneRepeater(true).setBlockName("enderstone_repeater_lit")
				.setBlockTextureName(TooMuchNature.modid + ":" + "enderstone_repeater_on");

		// Container Blocks
		end_wood_chest = new BlockEndWoodChest(++chestBlockID).setBlockName("end_wood_chest")
				.setStepSound(Block.soundTypeWood).setBlockTextureName(TooMuchNature.modid + ":" + "planks_end_oak");

		// Seeds
		cherry_seeds = new ItemSeeds(crops_cherry, Blocks.farmland).setUnlocalizedName("seeds_cherry")
				.setTextureName(TooMuchNature.modid + ":" + "seeds_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems);

		// Food
		orange = new ItemFood(4, 0.5F, false).setUnlocalizedName("orange")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "orange");
		cherry = new ItemFood(2, 0.4F, false).setUnlocalizedName("cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "cherry");
		raw_kangaroo = new ItemFood(5, 0.5F, true).setUnlocalizedName("raw_kangaroo")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "kangaroo_meat_raw");
		cooked_kangaroo = new ItemFood(12, 0.8F, true).setUnlocalizedName("cooked_kangaroo")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "kangaroo_meat_cooked");
		white_cherry = new ItemFood(2, 0.3F, false).setUnlocalizedName("white_cherry")
				.setCreativeTab(TooMuchNature.tabTooMuchNatureItems)
				.setTextureName(TooMuchNature.modid + ":" + "cherry_white");

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

		// Items Registers
		GameRegistry.registerItem(orange, orange.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cherry, cherry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(raw_kangaroo, raw_kangaroo.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cooked_kangaroo, cooked_kangaroo.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(white_cherry, white_cherry.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(kangaroo_skin, kangaroo_skin.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tmn_spawn_egg, tmn_spawn_egg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flint_and_endstone, flint_and_endstone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby, ruby.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sapphire, sapphire.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_ingot, titanium_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(platinum_ingot, platinum_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(enderald, enderald.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(kangaroo_helm, kangaroo_helm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_chest, kangaroo_chest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_leggings, kangaroo_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(kangaroo_boots, kangaroo_boots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(item_cherry_door, item_cherry_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_spruce_door, item_spruce_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_birch_door, item_birch_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_jungle_door, item_jungle_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_acacia_door, item_acacia_door.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item_dark_oak_door, item_dark_oak_door.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(cherry_seeds, cherry_seeds.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(enderstone_dust, enderstone_dust.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(enderald_bucket, enderald_bucket.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ender_water_bucket, ender_water_bucket.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(ender_pistol, ender_pistol.getUnlocalizedName().substring(5));

		// Block Registers
		GameRegistry.registerBlock(enderald_ore, enderald_ore.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(enderald_block, enderald_block.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(cherry_log, ItemBlockCherryLog.class, cherry_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_leaf, ItemBlockCherryLeaf.class,
				cherry_leaf.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_sapling, ItemBlockCherrySapling.class,
				cherry_sapling.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cherry_planks, ItemBlockCherryPlanks.class,
				cherry_planks.getUnlocalizedName().substring(5));
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
		GameRegistry.registerBlock(end_obsidian, end_obsidian.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_smooth, end_stone_smooth.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_fire, end_fire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(lower_end_portal, lower_end_portal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_grass, end_grass.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_dirt, end_dirt.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_double_slab, ItemBlockEndStoneSlab.class,
				end_stone_double_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_slab, ItemBlockEndStoneSlab.class,
				end_stone_slab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_bricks, ItemBlockEndStoneBrick.class,
				end_stone_bricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_stone_brick_stairs, end_stone_brick_stairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_wood_table, ItemEndWoodTable.class,
				end_wood_table.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_water_dynamic, ender_water_dynamic.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ender_water_static, ender_water_static.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_wood_planks, ItemBlockEndWoodPlanks.class,
				end_wood_planks.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(enderstone_wire, enderstone_wire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(TooMuchNature.enderstone_repeater_unpowered,
				TooMuchNature.enderstone_repeater_unpowered.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(TooMuchNature.enderstone_repeater_powered,
				TooMuchNature.enderstone_repeater_powered.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(end_wood_chest, end_wood_chest.getUnlocalizedName().substring(5));

		// Smelting Registers
		GameRegistry.addSmelting(TooMuchNature.raw_kangaroo, new ItemStack(TooMuchNature.cooked_kangaroo, 1), 5);

		// Biome Registers
		BiomesTMN.init();
		EnderBiomes.init();

		// Entity Registers
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

		// WorldGen Registers
		GameRegistry.registerWorldGenerator(new TMNWorldGen(), 0);

		// Dimension Registers
		/**
		 * DimensionManager.registerDimension(DimensionIDs.ENDERLANDSDIMENSION,
		 * DimensionIDs.ENDERLANDSDIMENSION);
		 * DimensionManager.registerProviderType(DimensionIDs.ENDERLANDSDIMENSION,
		 * WorldProviderEnderlands.class, true);
		 */

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

	@EventHandler
	public void serverStarted(FMLServerStartedEvent event) {

	}
}
